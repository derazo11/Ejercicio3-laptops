package com.example.Ejercicio1;

import com.example.Ejercicio1.entities.Laptop;
import com.example.Ejercicio1.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Ejercicio1Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Ejercicio1Application.class, args);

		LaptopRepository laptopRepository = context.getBean(LaptopRepository.class);

		Laptop laptop1 = new Laptop(null,650.00,"Asus","K55U");
		Laptop laptop2 = new Laptop(null,750.00,"Dell","Prueba");


		System.out.println(laptopRepository.save(laptop1));
		System.out.println(laptopRepository.save(laptop2));
	}

}
