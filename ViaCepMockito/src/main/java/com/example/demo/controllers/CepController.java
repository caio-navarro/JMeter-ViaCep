package com.example.demo.controllers;

import com.example.demo.application.CepApplication;
import com.example.demo.domain.Cep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CepController {
    private final CepApplication cepApplication;

    @Autowired
    public CepController(CepApplication cepApplication) {
        this.cepApplication = cepApplication;
    }

    @GetMapping("/cep/{cep}")
    public Cep getCep(@PathVariable String cep) {
        return this.cepApplication.getCep(cep);
    }
}
