package com.luv2code.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {

	private String filePath = "fortune-data.txt";
	private List<String> fortunes = new ArrayList<String>();
	private Random rand = new Random();
	private int y;
	
	public FileFortuneService() {
		System.out.println("DEBUG --> Inside FileFortuneService: No-Args Constructor ");
		
	}
	
	// Bean Init method
	@PostConstruct
	public void loadFortunesFile(){
		System.out.println("DEBUG --> Inside FileFortuneService Post Constructor");
		File fortuneFile = new File(filePath);
		System.out.println("DEBUG --> Reading fortunes from file: " + fortuneFile);
		System.out.println("DEBUG --> File exists: " + fortuneFile.exists());
		
		try(BufferedReader br = new BufferedReader(new FileReader(fortuneFile))){
			String line;

			while ((line = br.readLine()) != null) {
				fortunes.add(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace(); 
			System.out.println("DEBUG --> Could not read the file"+fortuneFile.toString());
		}
	}
	
	
	@Override
	public String getFortune() {
		System.out.println("DEBUG --> Inside FileFortuneService.getFortune() ");
		y = rand.nextInt(fortunes.size());
		return fortunes.get(y);
	}

}
