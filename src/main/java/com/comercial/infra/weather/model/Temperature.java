/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comercial.infra.weather.model;

import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author lyndon-pc
 */
public class Temperature {

    private double value;
    
    private double min;
    
    private double max ;
    
    private String unit;

    @XmlAttribute
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @XmlAttribute
    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    @XmlAttribute
    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
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
        return "Temperature{" + "value=" + value + ", min=" + min + ", max=" + max + ", unit=" + unit + '}';
    }
    
    
}
