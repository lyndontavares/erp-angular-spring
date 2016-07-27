package com.comercial.model.service.filtros;

import java.util.List;

import com.comercial.model.commons.Cidade;
import com.comercial.model.commons.enums.PessoaRole;
import com.comercial.model.commons.enums.PessoaSituacao;
import com.comercial.model.commons.enums.Sexo;
import com.comercial.model.commons.enums.SimNao;
import com.comercial.model.commons.enums.TipoPessoa;
import com.comercial.model.service.filtrowraper.Filtro;
import com.comercial.model.service.filtrowraper.FiltroWrapper;

public class PessoaFiltro extends FiltroWrapper
{

    @Override
    public void setFiltros(List<Filtro> filtros)
    {

        for (Filtro filtro : filtros)
        {
            switch (filtro.getParametro().toLowerCase())
            {
                case "situacao":
                {
                    filtro.setValor((Object) PessoaSituacao.valueOf((String) filtro.getValor()));
                    break;
                }

                case "sexo":
                {
                    filtro.setValor((Object) Sexo.valueOf((String) filtro.getValor()));
                    break;
                }

                case "credito":
                {
                    filtro.setValor((Object) SimNao.valueOf((String) filtro.getValor()));
                    break;
                }
                case "tipopessoa":
                {
                    filtro.setValor((Object) TipoPessoa.valueOf((String) filtro.getValor()));
                    break;
                }
                case "cidade":
                {
                    filtro.setValor((Object)  new Cidade( (int) filtro.getValor(), null ));
                    break;
                }       
                case "roles.pessoarole":
                {
                    filtro.setValor((Object) PessoaRole.valueOf((String) filtro.getValor()));
                    break;
                }
                default:
                    break;
            }
        }

        this.filtros = filtros;
    }

}
