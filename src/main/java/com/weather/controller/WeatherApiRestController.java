package com.weather.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import com.weather.controller.form.AtualizacaoWeatherForm;
import com.weather.controller.form.WeatherForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.weather.controller.dto.WeatherDto;
import com.weather.model.Weather;
import com.weather.service.WeatherService;

@RestController
@RequestMapping("/weather")
public class WeatherApiRestController {
	
	@Autowired
	private WeatherService weatherService;
	
	@PostMapping
	@Transactional
	public ResponseEntity<WeatherDto> cadastrar(@RequestBody @Valid WeatherForm form, UriComponentsBuilder uriBuilder) {
		Weather weather = weatherService.save(form);
		
		URI uri = uriBuilder.path("/weather/{id}").buildAndExpand(weather.getId()).toUri();
		return ResponseEntity.created(uri).body(new WeatherDto(weather));
		
	}
	
	@GetMapping
	public List<Weather> FindAll() {

		return weatherService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<WeatherDto> detalhar(@PathVariable Integer id) {
		
		Weather weather = weatherService.findById(id);

		return ResponseEntity.ok(new WeatherDto(weather));

	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<WeatherDto> atualizar(@PathVariable Integer id, @RequestBody @Valid AtualizacaoWeatherForm form) {
		Weather weather = weatherService.update(id, form);
		
		return ResponseEntity.ok(new WeatherDto(weather));
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Integer id) {
		weatherService.delete(id);
		
		return ResponseEntity.noContent().build();
	}
}
