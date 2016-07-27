
package com.comercial.infra.weather;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.comercial.infra.weather.model.OpenWeatherMap;

public class TesteTempo {

	public static RestTemplate restTemplate = new RestTemplate();

	public static void main(String[] args) {

		ResponseEntity<OpenWeatherMap> tempo = restTemplate.getForEntity(
				"http://api.openweathermap.org/data/2.5/weather?q=Foz do Iguacu&mode=xml&units=metric&appid=bd82977b86bf27fb59a04b61b657fb6f", OpenWeatherMap.class);

		System.out.println("Ex.01");
		System.out.println( tempo );
		System.out.println( tempo.getBody().getCity().getName() );
		System.out.println( tempo.getBody().getTemperature().getValue() );
		System.out.println( tempo.getBody().getWeather().getIcon());


	}

}
