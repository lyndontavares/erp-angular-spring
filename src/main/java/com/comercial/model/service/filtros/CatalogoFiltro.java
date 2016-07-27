package com.comercial.model.service.filtros;

import java.util.List;

import com.comercial.model.commons.SubGrupo;
import com.comercial.model.commons.Unidade;
import com.comercial.model.service.filtrowraper.Filtro;
import com.comercial.model.service.filtrowraper.FiltroWrapper;

public class CatalogoFiltro extends FiltroWrapper
{

    @Override
    public void setFiltros(List<Filtro> filtros)
    {

        for (Filtro filtro : filtros)
        {
            switch (filtro.getParametro().toLowerCase())
            {
                case "unidade":
                {
                    filtro.setValor((Object) new Unidade((int) filtro.getValor()));
                    break;
                }

                case "subgrupo":
                {
                    filtro.setValor((Object) new SubGrupo((int) filtro.getValor()));
                    break;
                }
                default:
                    break;
            }
        }

        this.filtros = filtros;
    }

}
