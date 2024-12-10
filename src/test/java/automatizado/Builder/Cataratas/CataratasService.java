package com.cataratas.api.service;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CataratasService {

    private static final Logger logger = LoggerFactory
            .getLogger(CataratasService.class);

    public void ingresso(int tipo) throws InterruptedException {
        // Simula o processo de compra com base no tipo de ingresso.
        logger
                .info("Iniciando processo de compra para tipo: {}", tipo);

        if (tipo < 1 || tipo > 8) {
            throw new IllegalArgumentException("Tipo de ingresso inválido");
        }

        // Lógica para comprar o ingresso (simulada)
        logger
                .info("Pesquisa iniciada para o tipo de ingresso: {}", tipo);

        // Simulando um delay de processamento
        Thread
                .sleep(2000);
        logger
                .info("Compra do ingresso tipo {} realizada com sucesso!", tipo);
    }
}
