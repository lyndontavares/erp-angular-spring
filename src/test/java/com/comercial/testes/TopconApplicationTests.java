package com.comercial.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.comercial.ApplicationInicialization;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.ValidationResult;
import net.objecthunter.exp4j.function.Function;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationInicialization.class)
@WebAppConfiguration
public class TopconApplicationTests {

	@Test
	public void contextLoads() {
		expressionOne();
		expressionTwo();
		expressionThree();
		expressionFour();
	}

	
	@Test
	public void expressionFour() {
		
		Function dobraQtde = new Function("dobraQtde",0){

			@Override
			public double apply(double... args) {
				//repo.findById(1).iterator().next().getOrdemAtualizacao() ;
				//@SuppressWarnings("unchecked")
				//List<Object> query = em.createNamedQuery("select quantidade from api_formula").getResultList();
				//return Long.valueOf( query.iterator().next().toString() ) * 2;
				return 0;
			}
			
			
		};
		
		double result = new ExpressionBuilder("reaj(1)")
		        .function(dobraQtde)
		        .build()
		        .evaluate();
		System.out.println(result);
	}

	@Test
	public void expressionOne(){
		
		Function avg = new Function("avg", 4) {

		    @Override
		    public double apply(double... args) {
		        double sum = 0;
		        for (double arg : args) {
		            sum += arg;
		        }
		        return sum / args.length;
		    }
		};
		
		double result = new ExpressionBuilder("avg(1,2,3,4)")
		        .function(avg)
		        .build()
		        .evaluate();

		double expected = 2.5d;
		assertEquals(expected, result, 0d);

	}
	
	@Test
	public void expressionTwo(){
		
		Function count = new Function("count", 1) {

		    @Override
		    public double apply(double... args) {
		      return 0;  
		    }
		};
		
		
		double result = new ExpressionBuilder("count(0) + 2")
		        .function(count)
		        .build()
		        .evaluate();
		//System.out.println(result);
		double expected = 10d;
		assertEquals(expected, result, 0d);
		
		
	}
	
	@Test
	public void expressionThree(){
		
		Expression e = new ExpressionBuilder("x")
		        .variable("x")
		        .build();

		ValidationResult res = e.validate();
		assertFalse(res.isValid());
		assertEquals(1, res.getErrors().size());

		e.setVariable("x",1d);
		res = e.validate();
		assertTrue(res.isValid());
	}	
	
}
