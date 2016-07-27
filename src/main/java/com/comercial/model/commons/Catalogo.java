package com.comercial.model.commons;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Catalogo
{

    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true, nullable = false, length = 100)
    private String descricao;

    private String descricaoImpressao;

    private String aplicacao;

    private String linkParaFoto;

    @ManyToOne
    private SubGrupo subgrupo;

    @ManyToOne
    private Unidade unidade;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    public String getAplicacao()
    {
        return aplicacao;
    }

    public void setAplicacao(String aplicacao)
    {
        this.aplicacao = aplicacao;
    }

    public SubGrupo getSubgrupo()
    {
        return subgrupo;
    }

    public void setSubgrupo(SubGrupo subgrupo)
    {
        this.subgrupo = subgrupo;
    }

    public Unidade getUnidade()
    {
        return unidade;
    }

    public void setUnidade(Unidade unidade)
    {
        this.unidade = unidade;
    }

    public String getDescricaoImpressao()
    {
        return descricaoImpressao;
    }

    public void setDescricaoImpressao(String descricaoImpressao)
    {
        this.descricaoImpressao = descricaoImpressao;
    }

    public String getLinkParaFoto()
    {
        return linkParaFoto;
    }

    public void setLinkParaFoto(String linkParaFoto)
    {
        this.linkParaFoto = linkParaFoto;
    }

    public Catalogo()
    {
    };

    public Catalogo(long id, String descricao, String descricaoImpressao, String aplicacao, String linkParaFoto,
            SubGrupo subgrupo, Unidade unidade)
    {
        super();
        this.id = id;
        this.descricao = descricao;
        this.descricaoImpressao = descricaoImpressao;
        this.aplicacao = aplicacao;
        this.linkParaFoto = linkParaFoto;
        this.subgrupo = subgrupo;
        this.unidade = unidade;
    }

}
