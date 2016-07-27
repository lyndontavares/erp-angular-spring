package com.comercial;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.comercial.application.CarregarDadosIniciais;
import com.comercial.infra.security.JwtFilter;

@SpringBootApplication
public class ApplicationInicialization {

	@Autowired
	 CarregarDadosIniciais carregarDados; 
	
 
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ConfigurableApplicationContext app = SpringApplication.run(ApplicationInicialization.class, args);
	}
	
	@PostConstruct
	public void init() {
		
		carregarDados.init();	

	}
	
	
	@Bean
    public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtFilter());
        registrationBean.addUrlPatterns("/apiX/*");
        return registrationBean;
	}
	
	
}
