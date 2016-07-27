package com.comercial.infra.weather;

public class Tempo{
	
	private final String URL_ICON = "http://openweathermap.org/img/w/";
	private final String URL_ICON_EXT = ".png";
	
	private String cidade;
	private double temperatura;
	private String icon;
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public double getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}
	public String getIcon() {
		return URL_ICON + icon + URL_ICON_EXT;
		//return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	public Tempo(){
	}
	
	public Tempo(String cidade, double temperatura, String icon) {
		super();
		this.cidade = cidade;
		this.temperatura = temperatura;
		this.icon = icon;
	}
	
	
	
}

