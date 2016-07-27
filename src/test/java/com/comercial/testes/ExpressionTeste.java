package com.comercial.testes;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.udojava.evalex.Expression;

public class ExpressionTeste
{

     
    public static void main (String[] args)
    {

        BigDecimal result = null;

        Expression expression = new Expression("1+1/3");
        result = expression.eval();
        expression.setPrecision(2);
        result = expression.eval();

        result = new Expression("(3.4 + -4.1)/2").eval();

        result = new Expression("SQRT(a^2 + b^2").with("a", "2.4").and("b", "9.253").eval();

        BigDecimal a = new BigDecimal("2.4");
        BigDecimal b = new BigDecimal("9.235");
        result = new Expression("SQRT(a^2 + b^2").with("a", a).and("b", b).eval();

        result = new Expression("2.4/PI").setPrecision(128).setRoundingMode(RoundingMode.UP).eval();

        result = new Expression("random() > 0.5").eval();

        result = new Expression("not(x<7 || sqrt(max(x,9,3,min(4,3))) <= 3))").with("x", "22.9").eval();

        result = new Expression("log10(100)").eval();
        
        
        
    }
}
