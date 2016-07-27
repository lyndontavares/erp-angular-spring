package com.comercial.infra.weather.model;

import javax.xml.bind.annotation.XmlAttribute;

public class Visibility {
    
    private long value;

    @XmlAttribute
    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Visibility{" + "value=" + value + '}';
    }
    
    
}
