package com.comercial.model.notify;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.comercial.model.autenticacao.Usuario;
import com.comercial.model.notify.enums.Evento;
import com.comercial.model.notify.enums.Situacao;

@Entity
public class Notificacao
{
    @Id
    @GeneratedValue
    private long id;

    @Temporal(TemporalType.TIME)
    private Date dataEnvio;

    @Enumerated(EnumType.STRING)
    private Evento evento;

    @Enumerated(EnumType.STRING)
    private Situacao situacao;

    @ManyToOne
    private Usuario destinatario;

    public Evento getEvento()
    {
        return evento;
    }

    public void setEvento(Evento evento)
    {
        this.evento = evento;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public Date getDataEnvio()
    {
        return dataEnvio;
    }

    public void setDataEnvio(Date dataEnvio)
    {
        this.dataEnvio = dataEnvio;
    }

    public Notificacao()
    {
    }

    public Situacao getSituacao()
    {
        return situacao;
    }

    public void setSituacao(Situacao situacao)
    {
        this.situacao = situacao;
    }

    public Notificacao(long id, Date dataEnvio, Evento evento, Situacao situacao, Usuario destinatario)
    {
        super();
        this.id = id;
        this.dataEnvio = dataEnvio;
        this.evento = evento;
        this.situacao = situacao;
        this.destinatario = destinatario;
    }

    @Override
    public String toString()
    {
        return "Notificacao [id=" + id + ", dataEnvio=" + dataEnvio + ", evento=" + evento + ", situacao=" + situacao
                + ", destinatario=" + destinatario + "]";
    }

    public Usuario getDestinatario()
    {
        return destinatario;
    }

    public void setDestinatario(Usuario destinatario)
    {
        this.destinatario = destinatario;
    }

}
