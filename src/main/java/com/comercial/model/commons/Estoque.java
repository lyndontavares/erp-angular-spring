package com.comercial.model.commons;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.comercial.model.commons.Catalogo;
import com.comercial.model.commons.Marca;
import com.comercial.model.commons.SubGrupo;
import com.comercial.model.commons.enums.Iva;
import com.comercial.model.commons.enums.Moeda;
import com.comercial.model.commons.enums.ProdutoSituacao;

@Entity
public class Estoque
{

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "catalogo_id", unique = true)
    private Catalogo catalogo;

    private String ean;

    @ManyToOne
    private Marca marca;

    @ManyToOne
    private SubGrupo subGrupo;

    @Enumerated(EnumType.STRING)
    private Iva iva;

    private BigDecimal saldo;

    private BigDecimal custo;

    @Enumerated(EnumType.STRING)
    private Moeda moeda;

    private BigDecimal precoVenda;

    private BigDecimal precoMinimo;

    @Enumerated(EnumType.STRING)
    private ProdutoSituacao situacao;

    // Getters and Setters

    public Estoque()
    {
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public Catalogo getCatalogo()
    {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo)
    {
        this.catalogo = catalogo;
    }

    public String getEan()
    {
        return ean;
    }

    public void setEan(String ean)
    {
        this.ean = ean;
    }

    public Marca getMarca()
    {
        return marca;
    }

    public void setMarca(Marca marca)
    {
        this.marca = marca;
    }

    public SubGrupo getSubGrupo()
    {
        return subGrupo;
    }

    public void setSubGrupo(SubGrupo subGrupo)
    {
        this.subGrupo = subGrupo;
    }

    public Iva getIva()
    {
        return iva;
    }

    public void setIva(Iva iva)
    {
        this.iva = iva;
    }

    public BigDecimal getSaldo()
    {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo)
    {
        this.saldo = saldo;
    }

    public BigDecimal getCusto()
    {
        return custo;
    }

    public void setCusto(BigDecimal custo)
    {
        this.custo = custo;
    }

    public Moeda getMoeda()
    {
        return moeda;
    }

    public void setMoeda(Moeda moeda)
    {
        this.moeda = moeda;
    }

    public BigDecimal getPrecoVenda()
    {
        return precoVenda;
    }

    public void setPrecoVenda(BigDecimal precoVenda)
    {
        this.precoVenda = precoVenda;
    }

    public BigDecimal getPrecoMinimo()
    {
        return precoMinimo;
    }

    public void setPrecoMinimo(BigDecimal precoMinimo)
    {
        this.precoMinimo = precoMinimo;
    }

    public ProdutoSituacao getSituacao()
    {
        return situacao;
    }

    public void setSituacao(ProdutoSituacao situacao)
    {
        this.situacao = situacao;
    }
 

    public Estoque(long id, Catalogo catalogo, SubGrupo subGrupo, BigDecimal saldo, Moeda moeda, BigDecimal precoVenda,
            ProdutoSituacao situacao)
    {
        super();
        this.id = id;
        this.catalogo = catalogo;
        this.subGrupo = subGrupo;
        this.saldo = saldo;
        this.moeda = moeda;
        this.precoVenda = precoVenda;
        this.situacao = situacao;
    }

    public Estoque(long id, Catalogo catalogo, String ean, Marca marca, SubGrupo subGrupo, Iva iva, BigDecimal saldo,
            BigDecimal custo, Moeda moeda, BigDecimal precoVenda, BigDecimal precoMinimo, ProdutoSituacao situacao)
    {
        super();
        this.id = id;
        this.catalogo = catalogo;
        this.ean = ean;
        this.marca = marca;
        this.subGrupo = subGrupo;
        this.iva = iva;
        this.saldo = saldo;
        this.custo = custo;
        this.moeda = moeda;
        this.precoVenda = precoVenda;
        this.precoMinimo = precoMinimo;
        this.situacao = situacao;
    }

}
