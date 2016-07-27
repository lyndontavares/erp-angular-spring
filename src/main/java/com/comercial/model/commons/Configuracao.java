package com.comercial.model.commons;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.comercial.model.autenticacao.views.View;
import com.comercial.model.commons.enums.Moeda;
import com.comercial.model.commons.enums.TipoProfile;
import com.comercial.model.notify.TemplateTexto;
import com.comercial.model.notify.enums.Destino;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Configuracao
{

    @Id
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private TipoProfile profile;

    @Column(nullable = false, length = 100)
    private String chaveRegistroDaAplicacao;

    @Enumerated(EnumType.STRING)
    private Moeda moedaPrincipal;

    private boolean permitirDescontoFatura;

    private boolean permitirVendaAcimaLimite;

    private boolean permitirEstoqueNegativo;

    private boolean enviarEmailEstoqueZerado;

    private boolean enviarEmailVendaClienteSemCredido;

    private boolean permitirFecharJanelaComEscape;

    private boolean permitirFecharJanelaComCliqueForaRegiao;

    private boolean enviarEmailAposAdicionarPessoa;

    private boolean enviarEmailAposAdicionarFatura;

    private boolean enviarEmailAposAdicionarPedido;

    private boolean enviarEmailAposDeletarPessoa;

    private boolean enviarEmailAposDeletarFatura;

    private boolean enviarEmailAposDeletarPedido;
    
    private boolean  permitirFecharJanelaModalComEscape;
    
    private boolean permitirFecharJanelaModalClicandoFora;
    
    private boolean permitirAnimacaojanelaModal;
    
    private boolean enviarEmailSegunda;
    private boolean enviarEmailTerca;
    private boolean enviarEmailQuarta;
    private boolean enviarEmailQuinta;
    private boolean enviarEmailSexta;
    private boolean enviarEmailSabado;
    private boolean enviarEmailDomingo;
 
    private String horarioEnvioEmail;

    @JsonView(View.class)
    @ManyToOne
    private Pessoa gerente;

    @Embedded
    @JsonView(View.class)
    private Empresa empresa;

    @Embedded
    @JsonView(View.class)
    private ServidorEmail servidorEmail;

    @ManyToOne
    @JsonView(View.class)
    private TemplateTexto templateAdicionarPessoa;

    @ManyToOne
    @JsonView(View.class)
    private TemplateTexto templateEditarPessoa;

    @ManyToOne
    @JsonView(View.class)
    private TemplateTexto templateDeletarPessoa;

    @ManyToOne
    @JsonView(View.class)
    private TemplateTexto templateAdicionarFatura;

    @ManyToOne
    @JsonView(View.class)
    private TemplateTexto templateEditarFatura;

    @ManyToOne
    @JsonView(View.class)
    private TemplateTexto templateDeletarFatura;

    @ManyToOne
    @JsonView(View.class)
    private TemplateTexto templateAdicionarPedido;

    @ManyToOne
    @JsonView(View.class)
    private TemplateTexto templateEditarPedido;

    @ManyToOne
    @JsonView(View.class)
    private TemplateTexto templateDeletarPedido;

    @Enumerated(EnumType.STRING)
    private Destino notifacaoPessoa;

    @Enumerated(EnumType.STRING)
    private Destino notifacaoFatura;

    @Enumerated(EnumType.STRING)
    private Destino notifacaoPedido;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public TipoProfile getProfile()
    {
        return profile;
    }

    public void setProfile(TipoProfile profile)
    {
        this.profile = profile;
    }

    public String getChaveRegistroDaAplicacao()
    {
        return chaveRegistroDaAplicacao;
    }

    public void setChaveRegistroDaAplicacao(String chaveRegistroDaAplicacao)
    {
        this.chaveRegistroDaAplicacao = chaveRegistroDaAplicacao;
    }

    public Moeda getMoedaPrincipal()
    {
        return moedaPrincipal;
    }

    public void setMoedaPrincipal(Moeda moedaPrincipal)
    {
        this.moedaPrincipal = moedaPrincipal;
    }

    public boolean isPermitirDescontoFatura()
    {
        return permitirDescontoFatura;
    }

    public void setPermitirDescontoFatura(boolean permitirDescontoFatura)
    {
        this.permitirDescontoFatura = permitirDescontoFatura;
    }

    public boolean isPermitirVendaAcimaLimite()
    {
        return permitirVendaAcimaLimite;
    }

    public void setPermitirVendaAcimaLimite(boolean permitirVendaAcimaLimite)
    {
        this.permitirVendaAcimaLimite = permitirVendaAcimaLimite;
    }

    public boolean isPermitirEstoqueNegativo()
    {
        return permitirEstoqueNegativo;
    }

    public void setPermitirEstoqueNegativo(boolean permitirEstoqueNegativo)
    {
        this.permitirEstoqueNegativo = permitirEstoqueNegativo;
    }

    public boolean isEnviarEmailEstoqueZerado()
    {
        return enviarEmailEstoqueZerado;
    }

    public void setEnviarEmailEstoqueZerado(boolean enviarEmailEstoqueZerado)
    {
        this.enviarEmailEstoqueZerado = enviarEmailEstoqueZerado;
    }

    public boolean isEnviarEmailVendaClienteSemCredido()
    {
        return enviarEmailVendaClienteSemCredido;
    }

    public void setEnviarEmailVendaClienteSemCredido(boolean enviarEmailVendaClienteSemCredido)
    {
        this.enviarEmailVendaClienteSemCredido = enviarEmailVendaClienteSemCredido;
    }

    public boolean isPermitirFecharJanelaComEscape()
    {
        return permitirFecharJanelaComEscape;
    }

    public void setPermitirFecharJanelaComEscape(boolean permitirFecharJanelaComEscape)
    {
        this.permitirFecharJanelaComEscape = permitirFecharJanelaComEscape;
    }

    public boolean isPermitirFecharJanelaComCliqueForaRegiao()
    {
        return permitirFecharJanelaComCliqueForaRegiao;
    }

    public void setPermitirFecharJanelaComCliqueForaRegiao(boolean permitirFecharJanelaComCliqueForaRegiao)
    {
        this.permitirFecharJanelaComCliqueForaRegiao = permitirFecharJanelaComCliqueForaRegiao;
    }

    public boolean isEnviarEmailAposAdicionarPessoa()
    {
        return enviarEmailAposAdicionarPessoa;
    }

    public void setEnviarEmailAposAdicionarPessoa(boolean enviarEmailAposAdicionarPessoa)
    {
        this.enviarEmailAposAdicionarPessoa = enviarEmailAposAdicionarPessoa;
    }

    public boolean isEnviarEmailAposAdicionarFatura()
    {
        return enviarEmailAposAdicionarFatura;
    }

    public void setEnviarEmailAposAdicionarFatura(boolean enviarEmailAposAdicionarFatura)
    {
        this.enviarEmailAposAdicionarFatura = enviarEmailAposAdicionarFatura;
    }

    public boolean isEnviarEmailAposAdicionarPedido()
    {
        return enviarEmailAposAdicionarPedido;
    }

    public void setEnviarEmailAposAdicionarPedido(boolean enviarEmailAposAdicionarPedido)
    {
        this.enviarEmailAposAdicionarPedido = enviarEmailAposAdicionarPedido;
    }

    public boolean isEnviarEmailAposDeletarPessoa()
    {
        return enviarEmailAposDeletarPessoa;
    }

    public void setEnviarEmailAposDeletarPessoa(boolean enviarEmailAposDeletarPessoa)
    {
        this.enviarEmailAposDeletarPessoa = enviarEmailAposDeletarPessoa;
    }

    public boolean isEnviarEmailAposDeletarFatura()
    {
        return enviarEmailAposDeletarFatura;
    }

    public void setEnviarEmailAposDeletarFatura(boolean enviarEmailAposDeletarFatura)
    {
        this.enviarEmailAposDeletarFatura = enviarEmailAposDeletarFatura;
    }

    public boolean isEnviarEmailAposDeletarPedido()
    {
        return enviarEmailAposDeletarPedido;
    }

    public void setEnviarEmailAposDeletarPedido(boolean enviarEmailAposDeletarPedido)
    {
        this.enviarEmailAposDeletarPedido = enviarEmailAposDeletarPedido;
    }

    public Pessoa getGerente()
    {
        return gerente;
    }

    public void setGerente(Pessoa gerente)
    {
        this.gerente = gerente;
    }

    public Empresa getEmpresa()
    {
        return empresa;
    }

    public void setEmpresa(Empresa empresa)
    {
        this.empresa = empresa;
    }

    public ServidorEmail getServidorEmail()
    {
        return servidorEmail;
    }

    public void setServidorEmail(ServidorEmail servidorEmail)
    {
        this.servidorEmail = servidorEmail;
    }

    public TemplateTexto getTemplateAdicionarPessoa()
    {
        return templateAdicionarPessoa;
    }

    public void setTemplateAdicionarPessoa(TemplateTexto templateAdicionarPessoa)
    {
        this.templateAdicionarPessoa = templateAdicionarPessoa;
    }

    public TemplateTexto getTemplateEditarPessoa()
    {
        return templateEditarPessoa;
    }

    public void setTemplateEditarPessoa(TemplateTexto templateEditarPessoa)
    {
        this.templateEditarPessoa = templateEditarPessoa;
    }

    public TemplateTexto getTemplateDeletarPessoa()
    {
        return templateDeletarPessoa;
    }

    public void setTemplateDeletarPessoa(TemplateTexto templateDeletarPessoa)
    {
        this.templateDeletarPessoa = templateDeletarPessoa;
    }

    public TemplateTexto getTemplateAdicionarFatura()
    {
        return templateAdicionarFatura;
    }

    public void setTemplateAdicionarFatura(TemplateTexto templateAdicionarFatura)
    {
        this.templateAdicionarFatura = templateAdicionarFatura;
    }

    public TemplateTexto getTemplateEditarFatura()
    {
        return templateEditarFatura;
    }

    public void setTemplateEditarFatura(TemplateTexto templateEditarFatura)
    {
        this.templateEditarFatura = templateEditarFatura;
    }

    public TemplateTexto getTemplateDeletarFatura()
    {
        return templateDeletarFatura;
    }

    public void setTemplateDeletarFatura(TemplateTexto templateDeletarFatura)
    {
        this.templateDeletarFatura = templateDeletarFatura;
    }

    public TemplateTexto getTemplateAdicionarPedido()
    {
        return templateAdicionarPedido;
    }

    public void setTemplateAdicionarPedido(TemplateTexto templateAdicionarPedido)
    {
        this.templateAdicionarPedido = templateAdicionarPedido;
    }

    public TemplateTexto getTemplateEditarPedido()
    {
        return templateEditarPedido;
    }

    public void setTemplateEditarPedido(TemplateTexto templateEditarPedido)
    {
        this.templateEditarPedido = templateEditarPedido;
    }

    public TemplateTexto getTemplateDeletarPedido()
    {
        return templateDeletarPedido;
    }

    public void setTemplateDeletarPedido(TemplateTexto templateDeletarPedido)
    {
        this.templateDeletarPedido = templateDeletarPedido;
    }

    public Destino getNotifacaoPessoa()
    {
        return notifacaoPessoa;
    }

    public void setNotifacaoPessoa(Destino notifacaoPessoa)
    {
        this.notifacaoPessoa = notifacaoPessoa;
    }

    public Destino getNotifacaoFatura()
    {
        return notifacaoFatura;
    }

    public void setNotifacaoFatura(Destino notifacaoFatura)
    {
        this.notifacaoFatura = notifacaoFatura;
    }

    public Destino getNotifacaoPedido()
    {
        return notifacaoPedido;
    }

    public void setNotifacaoPedido(Destino notifacaoPedido)
    {
        this.notifacaoPedido = notifacaoPedido;
    }

    public boolean isPermitirFecharJanelaModalComEscape()
    {
        return permitirFecharJanelaModalComEscape;
    }

    public void setPermitirFecharJanelaModalComEscape(boolean permitirFecharJanelaModalComEscape)
    {
        this.permitirFecharJanelaModalComEscape = permitirFecharJanelaModalComEscape;
    }

    public boolean isPermitirFecharJanelaModalClicandoFora()
    {
        return permitirFecharJanelaModalClicandoFora;
    }

    public void setPermitirFecharJanelaModalClicandoFora(boolean permitirFecharJanelaModalClicandoFora)
    {
        this.permitirFecharJanelaModalClicandoFora = permitirFecharJanelaModalClicandoFora;
    }

    public boolean isPermitirAnimacaojanelaModal()
    {
        return permitirAnimacaojanelaModal;
    }

    public void setPermitirAnimacaojanelaModal(boolean permitirAnimacaojanelaModal)
    {
        this.permitirAnimacaojanelaModal = permitirAnimacaojanelaModal;
    }

    public boolean isEnviarEmailSegunda()
    {
        return enviarEmailSegunda;
    }

    public void setEnviarEmailSegunda(boolean enviarEmailSegunda)
    {
        this.enviarEmailSegunda = enviarEmailSegunda;
    }

    public boolean isEnviarEmailTerca()
    {
        return enviarEmailTerca;
    }

    public void setEnviarEmailTerca(boolean enviarEmailTerca)
    {
        this.enviarEmailTerca = enviarEmailTerca;
    }

    public boolean isEnviarEmailQuarta()
    {
        return enviarEmailQuarta;
    }

    public void setEnviarEmailQuarta(boolean enviarEmailQuarta)
    {
        this.enviarEmailQuarta = enviarEmailQuarta;
    }

    public boolean isEnviarEmailQuinta()
    {
        return enviarEmailQuinta;
    }

    public void setEnviarEmailQuinta(boolean enviarEmailQuinta)
    {
        this.enviarEmailQuinta = enviarEmailQuinta;
    }

    public boolean isEnviarEmailSexta()
    {
        return enviarEmailSexta;
    }

    public void setEnviarEmailSexta(boolean enviarEmailSexta)
    {
        this.enviarEmailSexta = enviarEmailSexta;
    }

    public boolean isEnviarEmailSabado()
    {
        return enviarEmailSabado;
    }

    public void setEnviarEmailSabado(boolean enviarEmailSabado)
    {
        this.enviarEmailSabado = enviarEmailSabado;
    }

    public boolean isEnviarEmailDomingo()
    {
        return enviarEmailDomingo;
    }

    public void setEnviarEmailDomingo(boolean enviarEmailDomingo)
    {
        this.enviarEmailDomingo = enviarEmailDomingo;
    }

    public String getHorarioEnvioEmail()
    {
        return horarioEnvioEmail;
    }

    public void setHorarioEnvioEmail(String horarioEnvioEmail)
    {
        this.horarioEnvioEmail = horarioEnvioEmail;
    }

    

 

}
