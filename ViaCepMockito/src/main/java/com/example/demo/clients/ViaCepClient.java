package com.example.demo.clients;

import com.example.demo.clients.responses.CepResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class ViaCepClient {
    private final RestTemplate restTemplate = new RestTemplate();
    private static final String BASE_URL = "https://viacep.com.br/ws";

    public CepResponse getCep(String cep) {
        String url = String.format("%s/%s/json/", BASE_URL, cep);
        try {
            ResponseEntity<CepResponse> resp = restTemplate.getForEntity(url, CepResponse.class);
            return resp.getBody();
        } catch (RestClientException e) {
            throw new RuntimeException("Failed to call ViaCEP", e);
        }
    }
}
