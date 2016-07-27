package com.comercial.infra.weather.model;

import java.util.Date;
import javax.xml.bind.annotation.XmlAttribute;

public class LastUpdate {
 
    private Date value ;

    @XmlAttribute
    public Date getValue() {
        return value;
    }

    public void setValue(Date value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "LastUpdate{" + "value=" + value + '}';
    }
    
    
    
}
