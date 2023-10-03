package com.weather.controller.form;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.weather.model.Weather;
import com.weather.repository.WeatherRepository;

public class AtualizacaoWeatherForm {
	
	@Temporal(TemporalType.DATE)
	private Date dateRecorded;

	private Float lat;
	private Float lon;
	private String city;
	private String state;

	private Double temperature;

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

	public void setDateRecorded(Date dateRecorded) {
		this.dateRecorded = dateRecorded;
	}

	public void setLat(Float lat) {
		this.lat = lat;
	}

	public void setLon(Float lon) {
		this.lon = lon;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public Weather atualizar(Integer id, WeatherRepository weatherRepository) {
		Weather weather = weatherRepository.getOne(id);
		this.dateRecorded = weather.getDateRecorded();
		weather.setLat(this.lat); 
		weather.setLon(this.lon); 
		weather.setCity(this.city); 
		weather.setState(this.state);
		weather.setTemperature(this.temperature); 
		
		return weather;
	
	}


}
