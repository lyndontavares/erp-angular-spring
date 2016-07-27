package com.comercial.model.sqldinamico;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.comercial.model.sqldinamico.enums.TipoArtefato;

@Entity
public class Artefato
{

    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true, nullable = false, length = 100)
    private String nome;

    private String script;

    private String versao;

    @Enumerated(EnumType.STRING)
    private TipoArtefato tipoArtefato;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getScript()
    {
        return script;
    }

    public void setScript(String script)
    {
        this.script = script;
    }

    public String getVersao()
    {
        return versao;
    }

    public void setVersao(String versao)
    {
        this.versao = versao;
    }

    public TipoArtefato getTipoArtefato()
    {
        return tipoArtefato;
    }

    public void setTipoArtefato(TipoArtefato tipoArtefato)
    {
        this.tipoArtefato = tipoArtefato;
    }

    public Artefato(long id, String nome, String script)
    {
        super();
        this.id = id;
        this.nome = nome;
        this.script = script;
    }

    public Artefato(long id, String nome, String script, String versao, TipoArtefato tipoArtefato)
    {
        super();
        this.id = id;
        this.nome = nome;
        this.script = script;
        this.versao = versao;
        this.tipoArtefato = tipoArtefato;
    }

    public Artefato()
    {
    }

}
