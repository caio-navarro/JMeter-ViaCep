package com.example.demo.application;

import com.example.demo.clients.ViaCepClient;
import com.example.demo.domain.Cep;
import com.example.demo.clients.responses.CepResponse;
import org.springframework.stereotype.Service;

@Service
public class CepApplication {
    private final ViaCepClient viaCepClient;

    public CepApplication(ViaCepClient viaCepClient) {
        this.viaCepClient = viaCepClient;
    }
    public Cep getCep(String cep) {

        CepResponse resp = this.viaCepClient.getCep(cep);
        if (resp == null) return null;
        return resp.toDomain();
    }
}
