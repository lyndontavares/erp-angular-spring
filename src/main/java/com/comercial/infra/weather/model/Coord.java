package com.comercial.infra.weather.model;

import javax.xml.bind.annotation.XmlAttribute;

public class Coord {
  
    private double lon;
    
    private double lat;

    @XmlAttribute
    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

   @XmlAttribute
    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "Coord{" + "lon=" + lon + ", lat=" + lat + '}';
    }
    
    
    
}
