package com.comercial.infra.weather.model;

import javax.xml.bind.annotation.XmlAttribute;

public class Pressure {
   
    private String value;
    
    private String unit;

    @XmlAttribute
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @XmlAttribute
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Pressure{" + "value=" + value + ", unit=" + unit + '}';
    }
    
    
}
