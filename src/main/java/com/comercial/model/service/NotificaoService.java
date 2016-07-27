package com.comercial.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercial.model.notify.Notificacao;
import com.comercial.model.repository.NotificacaoRepository;
import com.comercial.model.service.filtrowraper.FiltroServiceGenerico;

@Service
public class NotificaoService extends FiltroServiceGenerico<Notificacao>
{

    @Autowired
    NotificacaoRepository notificacaoRepository;

    public Iterable<Notificacao> notificacaoes()
    {
        return notificacaoRepository.findAll();
    };
    
    public Iterable<Notificacao> notificacaoesPorUsuario(long id)
    {
        return notificacaoRepository.findByDestinatarioId(id);
    };

    public NotificaoService()
    {
        super(Notificacao.class);
    }

}
