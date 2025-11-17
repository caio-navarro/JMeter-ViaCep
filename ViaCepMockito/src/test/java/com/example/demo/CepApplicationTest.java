package com.example.demo;

import com.example.demo.application.CepApplication;
import com.example.demo.clients.ViaCepClient;
import com.example.demo.clients.responses.CepResponse;
import com.example.demo.domain.Cep;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CepApplicationTest {
    @InjectMocks
    CepApplication cepApplication;

    @Mock
    ViaCepClient viaCepClient;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void testarBuscarCep() {
        // Arrange
        CepResponse cepResponse = new CepResponse();
        cepResponse.setCep("00000-000");
        cepResponse.setLogradouro("Rua Exemplo");
        cepResponse.setBairro("Bairro Exemplo");
        cepResponse.setLocalidade("Cidade Exemplo");
        Mockito.when(viaCepClient.getCep("00000000")).thenReturn(cepResponse);

        // Act
        Cep cepReturned = cepApplication.getCep("00000000");

        // Assert
        Assertions.assertEquals(cepResponse.getCep(), cepReturned.getCep());
    }
}
