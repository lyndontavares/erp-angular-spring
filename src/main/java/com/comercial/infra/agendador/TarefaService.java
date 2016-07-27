package com.comercial.infra.agendador;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.comercial.model.commons.Configuracao;
import com.comercial.model.commons.Pessoa;
import com.comercial.model.commons.enums.TipoProfile;
import com.comercial.model.repository.ConfiguracaoRepository;
import com.comercial.model.repository.NotificacaoRepository;
import com.comercial.model.repository.TemplateTextoRepository;

@Service
public class TarefaService
{
    @Autowired
    private JavaMailSender javaMailService;

    @Autowired
    ConfiguracaoRepository configuracaoRepository;
    
    @Autowired
    NotificacaoRepository notificacaoRepository;

    @Autowired
    TemplateTextoRepository textoRepository;

    public void enviarTarefas()
    {
        Iterable<Configuracao> configs = configuracaoRepository.findFisrt1ByProfile(TipoProfile.ATIVO);
        if (configs != null)
        {

            Configuracao config = configs.iterator().next();

            enviarEmail(config);
            enviarNotificao(config);
        }
    }

    @Async
    public void enviarNotificao(Configuracao config)
    {
    }

    @Async
    public void enviarEmail(Configuracao config)
    {

        if (estaNaHoraDeEnviarEmails(config))
        {

            if ( config.isEnviarEmailAposAdicionarPessoa()  )
            {
                enviarEmails(config);
            }

        }

    }

    private void enviarEmails(Configuracao config)
    {

        Email email = new SimpleEmail();

        try
        {
            email.setDebug(true);
            email.setHostName(config.getServidorEmail().getHost());
            email.setSmtpPort(config.getServidorEmail().getPorta());
            email.setAuthenticator(new DefaultAuthenticator(config.getServidorEmail().getUsuario(),
                    config.getServidorEmail().getSenha()));
            email.setStartTLSEnabled(true);
            email.setFrom(config.getServidorEmail().getEmailEnvio());
            email.setSubject("Teste de email");
            email.setMsg("This is a test mail ... :-)");
            email.addTo("com3rcial3rp@gmail.com");
            email.send();
        }
        catch (EmailException e)
        {

            e.printStackTrace();
        }

    }

    public void enviarEmailRegistro(Pessoa pessoa)
    {

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(pessoa.getEmail());
        mailMessage.setSubject("Registration");
        mailMessage.setText("Hello " + pessoa.getNome() + "\n Your registration is successfull");
        javaMailService.send(mailMessage);

    }

    public void enviarEmailExemplo()
    {

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("com3rcial3rp@gmail.com");
        mailMessage.setReplyTo("com3rcial3rp@gmail.com");
        mailMessage.setFrom("com3rcial3rp@gmail.com");
        mailMessage.setSubject("Lorem ipsum");
        mailMessage.setText("Lorem ipsum dolor sit amet [...]");
        javaMailService.send(mailMessage);

    }

    public void enviarEmailTLS()
    {

        Email email = new SimpleEmail();

        try
        {
            email.setDebug(true);
            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(587);
            email.setAuthenticator(new DefaultAuthenticator("com3rcial3rp@gmail.com", "xpto2016."));
            email.setStartTLSEnabled(true);
            email.setFrom("com3rcial3rp@gmail.com");
            email.setSubject("TestMail");
            email.setMsg("This is a test mail ... :-)");
            email.addTo("com3rcial3rp@gmail.com");
            email.send();
        }
        catch (EmailException e)
        {

            e.printStackTrace();
        }
    }

    public void enviarEmailSSH()
    {

        Email email = new SimpleEmail();

        try
        {
            email.setDebug(true);
            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("com3rcial3rp@gmail.com", "xpto2016."));
            email.setSSLOnConnect(true);
            email.setFrom("com3rcial3rp@gmail.com");
            email.setSubject("TestMail");
            email.setMsg("This is a test mail ... :-)");
            email.addTo("integraldominio@gmail.com");
            email.send();
        }
        catch (EmailException e)
        {

            e.printStackTrace();
        }
    }

    private boolean estaNaHoraDeEnviarEmails(Configuracao config)
    {
        return true;
    }

}
