package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorPessoa {

    @GetMapping("/teste")
    public String teste(){
        return "teste";
    }
}
