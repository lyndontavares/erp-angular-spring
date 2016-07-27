package com.comercial.web.controller.relatorio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

@RestController
@RequestMapping("/api")
public class PessoaRelatorioController
{

    @RequestMapping(value = "repo1", method = RequestMethod.GET)
    @ResponseBody
    public void getRpt1(HttpServletResponse response) throws JRException, IOException {
      InputStream jasperStream = this.getClass().getResourceAsStream("/jasperreports/repo1.jasper");
      Map<String,Object> params = new HashMap<>();
      JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
      JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JREmptyDataSource());

      response.setContentType("application/x-pdf");
      response.setHeader("Content-disposition", "inline; filename=repo1.pdf");

      final OutputStream outStream = response.getOutputStream();
      JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
    }
    
    
    
/*  @RequestMapping(value = "/api/reports/pdf", method = RequestMethod.GET) 
    public @ResponseBody byte[] getOpenedEventsInPdf(HttpServletResponse response) {
        response.setHeader("Content-Disposition", "inline; filename=file.pdf");
        response.setContentType("application/pdf");
        // get file in bytearray from my custom service in backend
        byte[] file = jasperReportsService.getOpenedEventsReport(ReportFormat.PDF);
        return file;
    }
    
    $scope.getPdf = function(){
        $http.get('/api/reports/pdf', {responseType: 'arraybuffer'})
        .success(function (data) {
          var file = new Blob([data], {type: 'application/pdf'});
          var fileURL = URL.createObjectURL(file);
          window.open(fileURL);
        });
      }
    
    <a ng-click="getPdf()">Show PDF</a>
 */   
}
