package com.example.Ejercicio1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello-world")
    public String Saludo(){
        return "Hola Mundo!";
    }
}
