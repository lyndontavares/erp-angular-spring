
package com.comercial.web.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;

@RestController
@RequestMapping(value = "/api")
public class FotoController
{
    private static final String EXT_NAME = "png";
    private static final String DEFAULT_PHOTO = "profile-default.png";

    @Value("${profile.foto.dir}")
    private String fotoDir;

    @Value("${profile.foto.resize-width}")
    private int fotoWidth;

    @Value("${profile.foto.resize-height}")
    private int fotoHeight;

    @Autowired
    private MultipartResolver multipartResolver;

    @RequestMapping(value = "/profile/{id}", method = GET)
    public HttpEntity<byte[]> pegarFoto(@PathVariable Long id, WebRequest request) throws IOException
    {
        File photoFile = new File(fotoDir, id + "." + EXT_NAME);
        if (!photoFile.exists())
        {
            photoFile = new File(fotoDir, DEFAULT_PHOTO);
        }

        if (request.checkNotModified(photoFile.lastModified()))
        {
            return null; // return 304 code
        }

        byte[] photo = Files.readAllBytes(Paths.get(photoFile.getPath()));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        headers.setContentLength(photo.length);
        headers.setLastModified(photoFile.lastModified());
        return new HttpEntity<byte[]>(photo, headers);
    }

    @RequestMapping(value = "/profile/{id}", method = POST)
    public void uploadFoto(@PathVariable Long id, HttpServletRequest request) throws IOException
    {
        MultipartHttpServletRequest multipartRequest = multipartResolver.resolveMultipart(request);

        MultipartFile file = multipartRequest.getFile("file");
        File uploadFile = File.createTempFile("profile-", id.toString());
        file.transferTo(uploadFile);

        BufferedImage originalImage = ImageIO.read(uploadFile);
        BufferedImage resizedImage = scaleImage(originalImage, fotoWidth, fotoHeight);

        File photoFile = new File(fotoDir, id + "." + EXT_NAME);
        ImageIO.write(resizedImage, EXT_NAME, photoFile);
    }

    private static BufferedImage scaleImage(BufferedImage image, int width, int height) throws IOException
    {
        int type = image.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : image.getType();
        int imageWidth = image.getWidth();
        int imageHeight = image.getHeight();

        double scaleX = (double) width / imageWidth;
        double scaleY = (double) height / imageHeight;
        AffineTransform scaleTransform = AffineTransform.getScaleInstance(scaleX, scaleY);
        AffineTransformOp bilinearScaleOp = new AffineTransformOp(scaleTransform, AffineTransformOp.TYPE_BILINEAR);

        image = bilinearScaleOp.filter(image, new BufferedImage(width, height, type));
        return image.getSubimage(0, (height - width) / 2, width, width);
    }
}
