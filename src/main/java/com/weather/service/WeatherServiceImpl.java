package com.weather.service;

import java.util.List;
import java.util.Optional;

import com.weather.controller.form.AtualizacaoWeatherForm;
import com.weather.controller.form.WeatherForm;
import com.weather.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weather.exception.WeatherNotFoundException;
import com.weather.model.Weather;

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
