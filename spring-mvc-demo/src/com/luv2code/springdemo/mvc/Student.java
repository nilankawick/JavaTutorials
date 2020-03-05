package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;
import java.util.Map;

public class Student {
	
	private String firstName;
	private String lastName;
	private String country;
	private Map<String,String> countryOptions = new LinkedHashMap<String,String>();
	private String nationality;
	private String favouriteLanguage;
	private String favouriteCodingLanguage;
	private Map<String,String> favouriteCodingLanguageOptions = new LinkedHashMap<String,String>();
	private String[] preferredOS;
	
	public Student(){
	//populate country options
		this.countryOptions.put("BRZ", "Brazil");
		this.countryOptions.put("UK", "United Kingdom");
		this.countryOptions.put("USA", "United States of America");
		this.countryOptions.put("UAE", "United Arab Erimates");
		this.countryOptions.put("SL", "Sri Lanka");
		
		this.favouriteCodingLanguageOptions.put("Java", "Java");
		this.favouriteCodingLanguageOptions.put("PHP", "PHP");
		this.favouriteCodingLanguageOptions.put(".NET", ".NET");
		this.favouriteCodingLanguageOptions.put("Python", "Python");
		this.favouriteCodingLanguageOptions.put("Ruby", "Ruby");
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Map<String, String> getCountryOptions() {
		return countryOptions;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public void setFavouriteLanguage(String favouriteLanguage) {
		this.favouriteLanguage = favouriteLanguage;
	}

	public String getFavouriteLanguage() {
		return favouriteLanguage;
	}

	
	
	public String getFavouriteCodingLanguage() {
		return favouriteCodingLanguage;
	}

	public void setFavouriteCodingLanguage(String favouriteCodingLanguage) {
		this.favouriteCodingLanguage = favouriteCodingLanguage;
	}

	public Map<String, String> getFavouriteCodingLanguageOptions() {
		return favouriteCodingLanguageOptions;
	}

	public String[] getPreferredOS() {
		return preferredOS;
	}

	public void setPreferredOS(String[] preferredOS) {
		this.preferredOS = preferredOS;
	}

	/*
	public void setFavouriteCodingLanguageOptions(Map<String, String> favouriteCodingLanguageOptions) {
		this.favouriteCodingLanguageOptions = favouriteCodingLanguageOptions;
	}
	*/
	
	
	

}
