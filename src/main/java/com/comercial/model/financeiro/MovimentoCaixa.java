package com.comercial.model.financeiro;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.comercial.model.autenticacao.Usuario;
@Entity
public class MovimentoCaixa
{

    @Id
    @GeneratedValue
    private long id;
    
    @ManyToOne
    private Caixa caixa;
    
    @Temporal(TemporalType.TIME)
    private Date abertura;
    
    @Temporal(TemporalType.TIME)
    private Date fechamento;
  
    @ManyToOne
    private Usuario usuario;
    
    private BigDecimal saldoInicio;
    
    private BigDecimal saldoFim;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public Caixa getCaixa()
    {
        return caixa;
    }

    public void setCaixa(Caixa caixa)
    {
        this.caixa = caixa;
    }

    public Date getAbertura()
    {
        return abertura;
    }

    public void setAbertura(Date abertura)
    {
        this.abertura = abertura;
    }

    public Date getFechamento()
    {
        return fechamento;
    }

    public void setFechamento(Date fechamento)
    {
        this.fechamento = fechamento;
    }

    public Usuario getUsuario()
    {
        return usuario;
    }

    public void setUsuario(Usuario usuario)
    {
        this.usuario = usuario;
    }

    public BigDecimal getSaldoInicio()
    {
        return saldoInicio;
    }

    public void setSaldoInicio(BigDecimal saldoInicio)
    {
        this.saldoInicio = saldoInicio;
    }

    public BigDecimal getSaldoFim()
    {
        return saldoFim;
    }

    public void setSaldoFim(BigDecimal saldoFim)
    {
        this.saldoFim = saldoFim;
    }
    
    
    
}
