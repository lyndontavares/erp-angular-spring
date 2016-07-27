package com.comercial.infra.weather.model;

import javax.xml.bind.annotation.XmlAttribute;

public class Clouds {
  
    private String value;
    
    private String name;

    @XmlAttribute
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @XmlAttribute
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Clouds{" + "value=" + value + ", name=" + name + '}';
    }
    
    
    
}
