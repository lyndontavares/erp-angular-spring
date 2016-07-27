package com.comercial.model.dashboard;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.comercial.model.autenticacao.GrupoUsuario;
import com.comercial.model.commons.enums.SimNao;

@Entity
public class DashboardUsuario
{

    @Id
    @GeneratedValue
    private long id;
    
    @ManyToOne
    private Dashboard dashboard;
    
    @ManyToOne
    private GrupoUsuario grupo;
 
    @Enumerated(EnumType.STRING)
    private SimNao padrao;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public Dashboard getDashboard()
    {
        return dashboard;
    }

    public void setDashboard(Dashboard dashboard)
    {
        this.dashboard = dashboard;
    }

    public GrupoUsuario getGrupo()
    {
        return grupo;
    }

    public void setGrupo(GrupoUsuario grupo)
    {
        this.grupo = grupo;
    }

    public SimNao getPadrao()
    {
        return padrao;
    }

    public void setPadrao(SimNao padrao)
    {
        this.padrao = padrao;
    }
    
    
    
}
