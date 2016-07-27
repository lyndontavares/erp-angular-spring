package com.comercial.infra.weather.model;

import javax.xml.bind.annotation.XmlAttribute;

public class City {
  
  
  private long id;
  
  private String name;
  
  private Coord coord;
  
  private String country;
  
  private Sun sun;

    
    @XmlAttribute
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

   @XmlAttribute
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Sun getSun() {
        return sun;
    }

    public void setSun(Sun sun) {
        this.sun = sun;
    }

    @Override
    public String toString() {
        return "City{" + "id=" + id + ", name=" + name + ", coord=" + coord + ", country=" + country + ", sun=" + sun + '}';
    }

    
  
}
