package com.comercial.web.controller.grafico;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comercial.model.grafico.GraficoJson;

@RestController
@RequestMapping("/api")
public class PessoaGraficoController
{

    @Autowired
    private EntityManager em;
 

    @RequestMapping("/grafico/pessoa/categoria")
    @SuppressWarnings("unchecked")
    public GraficoJson pessoasPorCategoria()
    {
        List<String> labels = new ArrayList<>();
        List<String> series = new ArrayList<>();
        List<Object> data = new ArrayList<>();
        GraficoJson dadosJson = new GraficoJson();
        labels.add("2015");
        List<Object[]> dadosObj = em.createNativeQuery(
                "select r.pessoa_role, count( p.id ) from pessoa p, role r where r.pessoa_id = p.id group by  r.pessoa_role")
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

    @RequestMapping("/grafico/pessoa/fisicojuridica")
    @SuppressWarnings("unchecked")
    public GraficoJson pessoasFisicoJuridica()
    {
        List<String> labels = new ArrayList<>();
        List<String> series = new ArrayList<>();
        List<Object> data = new ArrayList<>();
        GraficoJson dadosJson = new GraficoJson();
        labels.add("2015");
        List<Object[]> dadosObj = em
                .createNativeQuery("select p.tipo_pessoa, count( p.id ) from pessoa p  group by p.tipo_pessoa")
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
 

}
