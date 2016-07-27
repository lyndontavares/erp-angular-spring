package com.comercial.infra.weather.model;

import javax.xml.bind.annotation.XmlAttribute;

public class Humidity {
    
    private double value;
    
    private String unit;

    @XmlAttribute
    public double getValue() {
        return value;
    }
    
    public void setValue(double value) {
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
        return "Humidity{" + "value=" + value + ", unit=" + unit + '}';
    }
    
    
    
}
