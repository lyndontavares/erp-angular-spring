package com.comercial.model.commons;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.comercial.model.autenticacao.views.View;
import com.comercial.model.commons.enums.FaturaSituacao;
import com.comercial.model.commons.enums.FaturaTipo;
import com.comercial.model.commons.enums.Moeda;
import com.comercial.model.commons.enums.PessoaRole;
import com.comercial.model.commons.enums.TipoPagamento;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Fatura
{

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Filial fillial;

    @Enumerated(EnumType.STRING)
    private FaturaTipo tipo;

    @Enumerated(EnumType.STRING)
    private FaturaSituacao situacao;

    @Enumerated(EnumType.STRING)
    private TipoPagamento pagamento;

    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    @ManyToOne
    private Pessoa pessoa;

    @Enumerated(EnumType.STRING)
    private PessoaRole pessoaRole;

    @Enumerated(EnumType.STRING)
    private Moeda moeda;

    private BigDecimal valorFaturaReal;

    private BigDecimal valorFaturaGuarani;

    private BigDecimal valorFaturaOutraMoeda;

    private BigDecimal valorIvaReal;

    private BigDecimal valorIvaGuarani;

    private BigDecimal valorIvaOutraMoeda;

    private String observacao;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "fatura")
    @JsonView(View.class)
    private List<ItemFatura> itens;

    public Filial getFillial()
    {
        return fillial;
    }

    public void setFillial(Filial fillial)
    {
        this.fillial = fillial;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public FaturaTipo getTipo()
    {
        return tipo;
    }

    public void setTipo(FaturaTipo tipo)
    {
        this.tipo = tipo;
    }

    public FaturaSituacao getSituacao()
    {
        return situacao;
    }

    public void setSituacao(FaturaSituacao situacao)
    {
        this.situacao = situacao;
    }

    public Date getData()
    {
        return data;
    }

    public void setData(Date data)
    {
        this.data = data;
    }

    public Pessoa getPessoa()
    {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa)
    {
        this.pessoa = pessoa;
    }

    public PessoaRole getPessoaRole()
    {
        return pessoaRole;
    }

    public void setPessoaRole(PessoaRole pessoaRole)
    {
        this.pessoaRole = pessoaRole;
    }

    public Moeda getMoeda()
    {
        return moeda;
    }

    public void setMoeda(Moeda moeda)
    {
        this.moeda = moeda;
    }

    public BigDecimal getValorFaturaReal()
    {
        return valorFaturaReal;
    }

    public void setValorFaturaReal(BigDecimal valorFaturaReal)
    {
        this.valorFaturaReal = valorFaturaReal;
    }

    public BigDecimal getValorFaturaGuarani()
    {
        return valorFaturaGuarani;
    }

    public void setValorFaturaGuarani(BigDecimal valorFaturaGuarani)
    {
        this.valorFaturaGuarani = valorFaturaGuarani;
    }

    public BigDecimal getValorFaturaOutraMoeda()
    {
        return valorFaturaOutraMoeda;
    }

    public void setValorFaturaOutraMoeda(BigDecimal valorFaturaOutraMoeda)
    {
        this.valorFaturaOutraMoeda = valorFaturaOutraMoeda;
    }

    public BigDecimal getValorIvaReal()
    {
        return valorIvaReal;
    }

    public void setValorIvaReal(BigDecimal valorIvaReal)
    {
        this.valorIvaReal = valorIvaReal;
    }

    public BigDecimal getValorIvaGuarani()
    {
        return valorIvaGuarani;
    }

    public void setValorIvaGuarani(BigDecimal valorIvaGuarani)
    {
        this.valorIvaGuarani = valorIvaGuarani;
    }

    public BigDecimal getValorIvaOutraMoeda()
    {
        return valorIvaOutraMoeda;
    }

    public void setValorIvaOutraMoeda(BigDecimal valorIvaOutraMoeda)
    {
        this.valorIvaOutraMoeda = valorIvaOutraMoeda;
    }

    public String getObservacao()
    {
        return observacao;
    }

    public void setObservacao(String observacao)
    {
        this.observacao = observacao;
    }

    public List<ItemFatura> getItens()
    {
        return itens;
    }

    public void setItens(List<ItemFatura> itens)
    {
        this.itens = itens;
    }

    public TipoPagamento getPagamento()
    {
        return pagamento;
    }

    public void setPagamento(TipoPagamento pagamento)
    {
        this.pagamento = pagamento;
    }

    public Fatura()
    {
    };

    public Fatura(long id, Filial fillial, FaturaTipo tipo, FaturaSituacao situacao, TipoPagamento pagamento, Date data,
            Pessoa pessoa, PessoaRole pessoaRole, Moeda moeda, BigDecimal valorFaturaReal,
            BigDecimal valorFaturaGuarani, BigDecimal valorFaturaOutraMoeda, BigDecimal valorIvaReal,
            BigDecimal valorIvaGuarani, BigDecimal valorIvaOutraMoeda, String observacao, List<ItemFatura> itens)
    {
        super();
        this.id = id;
        this.fillial = fillial;
        this.tipo = tipo;
        this.situacao = situacao;
        this.pagamento = pagamento;
        this.data = data;
        this.pessoa = pessoa;
        this.pessoaRole = pessoaRole;
        this.moeda = moeda;
        this.valorFaturaReal = valorFaturaReal;
        this.valorFaturaGuarani = valorFaturaGuarani;
        this.valorFaturaOutraMoeda = valorFaturaOutraMoeda;
        this.valorIvaReal = valorIvaReal;
        this.valorIvaGuarani = valorIvaGuarani;
        this.valorIvaOutraMoeda = valorIvaOutraMoeda;
        this.observacao = observacao;
        this.itens = itens;
    }

}
