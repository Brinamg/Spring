package com.helloword.hello.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
	
	

	@GetMapping
	
	public String hello1() {
		return "Hallo Genneration!!!";
		
	}
		@GetMapping("/habilidadesMentalidades")
		
		public String HabilidadesMentalidades() {
			return "Persistência \n Atenção aos detalhes \nMentalidade de crescimento";
		}		
			@GetMapping("/ObjetivosDeAprendizagem")
			
			public String ObjetivosDeAprendizagem() {
				return "Entender os conceitos e colocar em prática";
				
	}
}
