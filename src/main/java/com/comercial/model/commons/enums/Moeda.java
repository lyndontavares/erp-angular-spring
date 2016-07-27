package com.comercial.model.commons.enums;

public enum Moeda
{

    REAL("R"), GUARANI("G"), DOLAR("D"), PESO("P"), EURO("E"), YEN("Y");

    private static Moeda[] Values = values();

    public static Moeda fromOrdinal(int n)
    {
        return Values[n];
    }

    private String value;

    private Moeda(String value)
    {
        this.setValue(value);
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }
    
    public static String getMascara(Moeda moeda){
        switch (moeda)
        {
            case REAL:
                return "999.999.999,99";
            case GUARANI:
                return "999.999.999.999";
            case DOLAR:
                return "999,999,999.99";
            case PESO:
                return "";
            case EURO:
                return "";
            case YEN:
                return "";
        }
        return null;
       
    }

    public static String getCifrao(Moeda moeda)
    {
        switch (moeda)
        {
            case REAL:
                return "R$";
            case GUARANI:
                return "G";
            case DOLAR:
                return "";
            case PESO:
                return "";
            case EURO:
                return "";
            case YEN:
                return "";
        }
        return null;
    }

    public static Moeda getTipo(String value)
    {
        switch (value)
        {
            case "R":
                return Moeda.REAL;
            case "G":
                return Moeda.GUARANI;
            case "D":
                return Moeda.DOLAR;
            case "P":
                return Moeda.PESO;
            case "E":
                return Moeda.EURO;
            case "Y":
                return Moeda.YEN;
        }
        return null;
    }

}
