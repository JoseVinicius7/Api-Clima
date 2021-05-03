package com.hackerrank.weather.service;

import java.util.List;

import com.hackerrank.weather.controller.form.AtualizacaoWeatherForm;
import com.hackerrank.weather.controller.form.WeatherForm;
import com.hackerrank.weather.model.Weather;

public interface WeatherService {

	public Weather save(WeatherForm form);

	public Weather findById(Integer id);

	public List<Weather> findAll();

	public Weather update(Integer id, AtualizacaoWeatherForm form);

	public void delete(Integer id);

}
