package com.weather.service;

import java.util.List;

import com.weather.controller.form.AtualizacaoWeatherForm;
import com.weather.controller.form.WeatherForm;
import com.weather.model.Weather;

public interface WeatherService {

	public Weather save(WeatherForm form);

	public Weather findById(Integer id);

	public List<Weather> findAll();

	public Weather update(Integer id, AtualizacaoWeatherForm form);

	public void delete(Integer id);

}
