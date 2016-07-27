package com.comercial.web.controller.grafico;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comercial.model.grafico.GraficoJson;
import com.comercial.model.repository.ArtefatoRepository;
import com.comercial.model.sqldinamico.Artefato;

@RestController
@RequestMapping("/api")
public class GraficoDinamicoController
{

    @Autowired
    private EntityManager em;

    @Autowired
    private ArtefatoRepository artefatoRepository;

    
    @RequestMapping("/grafico/{id}")
    @SuppressWarnings("unchecked")
    public GraficoJson graficoPorId(@PathVariable final long id)
    {
        Artefato artefato = artefatoRepository.findOne(id);
        
        if (artefato != null)
        {
            List<String> labels = new ArrayList<>();
            List<String> series = new ArrayList<>();
            List<Object> data = new ArrayList<>();
            GraficoJson dadosJson = new GraficoJson();
            labels.add("");
            List<Object[]> dadosObj = em
                    .createNativeQuery(artefato.getScript())
                    .getResultList();
            for (Object[] d : dadosObj)
            {
                series.add((String) d[0] + " Qtde: " + (BigInteger) d[1]);
                data.add(((Object) d[1]));
            }

            dadosJson.setLabels(labels);
            dadosJson.setSeries(series);
            dadosJson.setData(data);

            System.out.println(dadosJson);

            return dadosJson;
        }
        else
        {
            return null;
        }

    }

}
