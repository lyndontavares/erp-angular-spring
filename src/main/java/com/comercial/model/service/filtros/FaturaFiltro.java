package com.comercial.model.service.filtros;

import java.util.List;

import com.comercial.model.commons.Filial;
import com.comercial.model.commons.enums.FaturaSituacao;
import com.comercial.model.commons.enums.FaturaTipo;
import com.comercial.model.commons.enums.Moeda;
import com.comercial.model.commons.enums.PessoaRole;
import com.comercial.model.commons.enums.TipoPagamento;
import com.comercial.model.service.filtrowraper.Filtro;
import com.comercial.model.service.filtrowraper.FiltroWrapper;

public class FaturaFiltro extends FiltroWrapper
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
                    filtro.setValor((Object) FaturaSituacao.valueOf((String) filtro.getValor()));
                    break;
                }

                case "tipo":
                {
                    filtro.setValor((Object) FaturaTipo.valueOf((String) filtro.getValor()));
                    break;
                }

                case "pagamento":
                {
                    filtro.setValor((Object) TipoPagamento.valueOf((String) filtro.getValor()));
                    break;
                }
                case "moeda":
                {
                    filtro.setValor((Object) Moeda.valueOf((String) filtro.getValor()));
                    break;
                }
                case "pessoarole":
                {
                    filtro.setValor((Object) PessoaRole.valueOf((String) filtro.getValor()));
                    break;
                }
                case "filial":
                {
                    filtro.setValor((Object)  new Filial( (int) filtro.getValor(), null ));
                    break;
                }
                default:
                    break;
            }
        }

        this.filtros = filtros;
    }

}
