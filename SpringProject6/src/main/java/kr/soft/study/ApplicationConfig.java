package kr.soft.study;


import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

	@Bean 
	public Pencil pencil() {
		Pencil pencil = new Pencil6BWithEraser();
		
		return pencil;
	}
	
	
	
}
