package com.hackerrank.weather.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackerrank.weather.controller.form.AtualizacaoWeatherForm;
import com.hackerrank.weather.controller.form.WeatherForm;
import com.hackerrank.weather.exception.WeatherNotFoundException;
import com.hackerrank.weather.model.Weather;
import com.hackerrank.weather.repository.WeatherRepository;

@Service
public class WeatherServiceImpl implements WeatherService {

	@Autowired
	WeatherRepository weatherRepository;

	@Override
	public Weather save(WeatherForm form) {

		Weather weather = form.converter();

		return weatherRepository.save(weather);
	}

	@Override
	public List<Weather> findAll() {

		return weatherRepository.findAll();
	}
	
	@Override
	public Weather findById(Integer id) {
		Optional<Weather> weather = weatherRepository.findById(id);
		
		return weather.orElseThrow(() -> new WeatherNotFoundException(id + " não encontrado."));
	}
	
	@Override
	public Weather update(Integer id, AtualizacaoWeatherForm form) {
		Optional<Weather> optional = weatherRepository.findById(id);
		if (!optional.isPresent()) {
			throw new WeatherNotFoundException(+ id + " não encontrada.");
		}
		
		Weather weather = form.atualizar(id, weatherRepository);
		return weather;
	}
	
	
	@Override
	public void delete(Integer id) {
		Optional<Weather> optional = weatherRepository.findById(id);
		if (!optional.isPresent()) {
			throw new WeatherNotFoundException(+ id + " não encontrada.");
		}
		
		weatherRepository.deleteById(id);
		
	}
	
	
	
	
}
