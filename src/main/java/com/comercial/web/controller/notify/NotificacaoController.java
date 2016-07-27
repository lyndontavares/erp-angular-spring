package com.comercial.web.controller.notify;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.comercial.model.service.NotificaoService;

@RestController
@RequestMapping("/api")
public class NotificacaoController
{
    
    @Autowired
    private NotificaoService notificacao;

    @RequestMapping("/notificacao")
    public SseEmitter listaNotificacoes( HttpServletRequest request) throws Throwable {
        final SseEmitter emitter = new SseEmitter();
        emitter.send( notificacao.notificacaoes() );
        emitter.complete();
        return emitter;
    }
 
    
    @RequestMapping("/notificacao/{id}")
    public SseEmitter listaNotificacoesPorUsuario( @PathVariable long id,   HttpServletRequest request) throws Throwable {
        final SseEmitter emitter = new SseEmitter();
        emitter.send( notificacao.notificacaoesPorUsuario(id) );
        emitter.complete();
        return emitter;
    }
    
}
