package com.comercial.infra.weather.model;

import javax.xml.bind.annotation.XmlAttribute;


public class Sun {
    
    private String rise;
    
    private String set;

   @XmlAttribute
    public String getRise() {
        return rise;
    }

    public void setRise(String rise) {
        this.rise = rise;
    }

   @XmlAttribute 
   public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }

    @Override
    public String toString() {
        return "Sun{" + "rise=" + rise + ", set=" + set + '}';
    }
    
    
    
}
