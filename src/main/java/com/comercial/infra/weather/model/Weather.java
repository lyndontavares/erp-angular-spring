package com.comercial.infra.weather.model;

import javax.xml.bind.annotation.XmlAttribute;

public class Weather {
   
    private long number;
    
    private String value;
    
    private String icon;


    @XmlAttribute
    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    @XmlAttribute 
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @XmlAttribute
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "Weather{" + "number=" + number + ", value=" + value + ", icon=" + icon + '}';
    }
    
    public Weather(){
    	
    }
    
    
}
