package com.comercial.model.financeiro;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.comercial.model.commons.Fatura;
import com.comercial.model.commons.Pessoa;
import com.comercial.model.commons.PlanoConta;
import com.comercial.model.commons.enums.Moeda;
import com.comercial.model.financeiro.enums.TipoTitulo;
import com.comercial.model.financeiro.enums.TituloSituacao;

@Entity
public class Titulo
{

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Fatura fatura;

    @ManyToOne
    private PlanoConta planoConta;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataVencimento;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataQuitacao;

    @ManyToOne
    private Pessoa pessoa;

    private BigDecimal valorPrincipal;

    private BigDecimal valorAdicional;

    @Enumerated(EnumType.STRING)
    private TituloSituacao situacao;

    @Enumerated(EnumType.STRING)
    private TipoTitulo tipoTitulo;

    private String numeroDocumento;

    @ManyToOne
    private MovimentoCaixa movimentoCaixa;

    @Enumerated(EnumType.STRING)
    private Moeda moeda;
    
    public String getNumeroDocumento()
    {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento)
    {
        this.numeroDocumento = numeroDocumento;
    }

    public MovimentoCaixa getMovimentoCaixa()
    {
        return movimentoCaixa;
    }

    public void setMovimentoCaixa(MovimentoCaixa movimentoCaixa)
    {
        this.movimentoCaixa = movimentoCaixa;
    }

    public Moeda getMoeda()
    {
        return moeda;
    }

    public void setMoeda(Moeda moeda)
    {
        this.moeda = moeda;
    }



    public PlanoConta getPlanoConta()
    {
        return planoConta;
    }

    public void setPlanoConta(PlanoConta planoConta)
    {
        this.planoConta = planoConta;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public Fatura getFatura()
    {
        return fatura;
    }

    public void setFatura(Fatura fatura)
    {
        this.fatura = fatura;
    }

    public Date getDataVencimento()
    {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento)
    {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataQuitacao()
    {
        return dataQuitacao;
    }

    public void setDataQuitacao(Date dataQuitacao)
    {
        this.dataQuitacao = dataQuitacao;
    }

    public Pessoa getPessoa()
    {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa)
    {
        this.pessoa = pessoa;
    }

    public BigDecimal getValorPrincipal()
    {
        return valorPrincipal;
    }

    public void setValorPrincipal(BigDecimal valorPrincipal)
    {
        this.valorPrincipal = valorPrincipal;
    }

    public BigDecimal getValorAdicional()
    {
        return valorAdicional;
    }

    public void setValorAdicional(BigDecimal valorAdicional)
    {
        this.valorAdicional = valorAdicional;
    }

    public TituloSituacao getSituacao()
    {
        return situacao;
    }

    public void setSituacao(TituloSituacao situacao)
    {
        this.situacao = situacao;
    }

    public Titulo()
    {
    };

    public Titulo(long id, Fatura fatura, PlanoConta planoConta, Date dataVencimento, Date dataQuitacao, Pessoa pessoa,
            BigDecimal valorPrincipal, BigDecimal valorAdicional, TituloSituacao situacao)
    {
        super();
        this.id = id;
        this.fatura = fatura;
        this.planoConta = planoConta;
        this.dataVencimento = dataVencimento;
        this.dataQuitacao = dataQuitacao;
        this.pessoa = pessoa;
        this.valorPrincipal = valorPrincipal;
        this.valorAdicional = valorAdicional;
        this.situacao = situacao;
    }

    public TipoTitulo getTipoTitulo()
    {
        return tipoTitulo;
    }

    public void setTipoTitulo(TipoTitulo tipoTitulo)
    {
        this.tipoTitulo = tipoTitulo;
    }

}
