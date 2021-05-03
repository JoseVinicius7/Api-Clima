package com.hackerrank.weather.controller.form;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.hackerrank.weather.model.Weather;

public class WeatherForm {

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

	public Weather converter() {

		return new Weather(dateRecorded, city, state, lat, lon, temperature);
	}
}
