package com.comercial.infra.weather.model;

import javax.xml.bind.annotation.XmlAttribute;

public class Precipitation {
    
    private String value;
    
    private String mode;
    
    @XmlAttribute
    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    @XmlAttribute
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Precipitation{" + "value=" + value + ", mode=" + mode + '}';
    }
    
    
    
}
