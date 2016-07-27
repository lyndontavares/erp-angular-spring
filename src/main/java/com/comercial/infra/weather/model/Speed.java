package com.comercial.infra.weather.model;

import javax.xml.bind.annotation.XmlAttribute;


class Speed {

    private double value;
    
    private String name;

    @XmlAttribute
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
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
        return "Speed{" + "value=" + value + ", name=" + name + '}';
    }
    
    
    
}
