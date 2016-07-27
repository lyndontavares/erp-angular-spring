package com.comercial.infra.agendador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableAsync
@EnableScheduling
public class AgendarTarefas
{
    // private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    // cron = "0 15 9-17 * * MON-FRI"
    // 0 15 -> toda hora, primeiros 15 min
    // 9-17 -> de 9h as 17h
    // MON-FRI -> de segunda a sexta
 
    @Autowired
    TarefaService tarefaService;
    
    @Scheduled(fixedDelay = 1000 * 60 * 60) // a cada hora
    public void reportCurrentTime()
    {
        
        tarefaService.enviarTarefas();

    }

}
