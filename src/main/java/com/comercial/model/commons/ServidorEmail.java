package com.comercial.model.commons;

import javax.persistence.Embeddable;

@Embeddable
public class ServidorEmail
{

    private String host;

    private int porta;

    private String emailEnvio;

    private String usuario;

    private String senha;

    public String getHost()
    {
        return host;
    }

    public void setHost(String host)
    {
        this.host = host;
    }

 

    public int getPorta()
    {
        return porta;
    }

    public void setPorta(int porta)
    {
        this.porta = porta;
    }

    public String getEmailEnvio()
    {
        return emailEnvio;
    }

    public void setEmailEnvio(String emailEnvio)
    {
        this.emailEnvio = emailEnvio;
    }

    public String getUsuario()
    {
        return usuario;
    }

    public void setUsuario(String usuario)
    {
        this.usuario = usuario;
    }

    public String getSenha()
    {
        return senha;
    }

    public void setSenha(String senha)
    {
        this.senha = senha;
    }

    public ServidorEmail(String host, int porta, String emailEnvio, String usuario, String senha)
    {
        super();
        this.host = host;
        this.porta = porta;
        this.emailEnvio = emailEnvio;
        this.usuario = usuario;
        this.senha = senha;
    }

    public ServidorEmail()
    {
    }

}
