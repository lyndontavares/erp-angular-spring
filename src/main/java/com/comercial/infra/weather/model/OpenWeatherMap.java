package com.comercial.infra.weather.model;

 
import javax.xml.bind.annotation.XmlRootElement;

 
@XmlRootElement(name="current")
public class OpenWeatherMap {
   
     
    private City city;
    
    private Temperature temperature;
    
    private Humidity humidity;
    
    private Pressure pressure;
    
    private Wind wind;
    
    private Clouds clouds;
    
    private Visibility visibility;
    
    private Precipitation precipitation;
    
    private Weather weather;
    
    private LastUpdate lastUpdate;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public Humidity getHumidity() {
        return humidity;
    }

    public void setHumidity(Humidity humidity) {
        this.humidity = humidity;
    }

    public Pressure getPressure() {
        return pressure;
    }

    public void setPressure(Pressure pressure) {
        this.pressure = pressure;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    public Precipitation getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(Precipitation precipitation) {
        this.precipitation = precipitation;
    }

    public LastUpdate getLastupdate() {
        return lastUpdate;
    }

    public void setLastupdate(LastUpdate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public LastUpdate getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LastUpdate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    
    
    @Override
    public String toString() {
        return "OpenWeatherMap{" + "city=" + city + ", temperature=" + temperature + ", humidity=" + humidity + ", pressure=" + pressure + ", wind=" + wind + ", clouds=" + clouds + ", visibility=" + visibility + ", precipitation=" + precipitation + ", weather=" + weather + ", lastupdate=" + lastUpdate + '}';
    }
    
    
    
}
