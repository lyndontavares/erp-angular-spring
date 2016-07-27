package com.comercial.testes;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.comercial.ApplicationInicialization;
import com.comercial.model.commons.Pessoa;
import com.comercial.model.commons.enums.PessoaRole;
import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationInicialization.class)
@WebAppConfiguration
public class TesteEasyCriteria {

    @Autowired
    private EntityManager em;
    
	@Test
	public void teste() {
		
	    UaiCriteria<Pessoa> uaiCriteria = UaiCriteriaFactory.createQueryCriteria(em, Pessoa.class);
	    
	    uaiCriteria.innerJoin("roles");  
	    uaiCriteria.andEquals("roles.pessoaRole", (Object) PessoaRole.CLIENTE);
	    
	    
	    System.out.println(">>>RES:");
	    for (Pessoa p : uaiCriteria.getResultList())
        {
            System.out.println(p);
        }
	}

	 
}
