package com.comercial.model.aprovacao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(indexes = { @Index(columnList = "processo_id,faseinicial,fasefinal", unique = true) })
public class Aprovacao
{
    
    @Id
    @GeneratedValue
    private long id;
    
    @ManyToOne
    private Processo processo;
 
    private String faseInicial;
 
    private String faseFinal;
    
    @ManyToOne
    private GrupoAprovacao grupo;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public Processo getProcesso()
    {
        return processo;
    }

    public void setProcesso(Processo processo)
    {
        this.processo = processo;
    }

    public String getFaseInicial()
    {
        return faseInicial;
    }

    public void setFaseInicial(String faseInicial)
    {
        this.faseInicial = faseInicial;
    }

    public String getFaseFinal()
    {
        return faseFinal;
    }

    public void setFaseFinal(String faseFinal)
    {
        this.faseFinal = faseFinal;
    }

    public GrupoAprovacao getGrupo()
    {
        return grupo;
    }

    public void setGrupo(GrupoAprovacao grupo)
    {
        this.grupo = grupo;
    }
    
    
    
    
}
