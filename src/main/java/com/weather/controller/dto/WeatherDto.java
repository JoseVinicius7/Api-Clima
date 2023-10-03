package com.weather.controller.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.weather.model.Weather;

public class WeatherDto {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	@Temporal(TemporalType.DATE)
	private Date dateRecorded;

	private Float lat;
	private Float lon;
	private String city;
	private String state;
	
	private Double temperature;

	public WeatherDto(Weather weather) {
		
		this.id = weather.getId();
		this.dateRecorded = weather.getDateRecorded();
		this.lat = weather.getLat();
		this.lon = weather.getLon();
		this.city = weather.getCity();
		this.state = weather.getState();
		this.temperature = weather.getTemperature();

	}


	public Date getDateRecorded() {
		return dateRecorded;
	}

	public Float getLat() {
		return lat;
	}

	public Float getLon() {
		return lon;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public Double getTemperature() {
		return temperature;
	}

	public static List<WeatherDto> converter(List<Weather> weather) {
		return weather.stream().map(WeatherDto::new).collect(Collectors.toList());
	}
}
