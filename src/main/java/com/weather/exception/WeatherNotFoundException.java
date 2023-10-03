package com.weather.exception;

public class WeatherNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public WeatherNotFoundException(String message) {
		super(message);
	}

}
