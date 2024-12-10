package com.cataratas.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cataratas.api.service.CataratasService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/cataratas")
public class CataratasController {

    private static final Logger logger = LoggerFactory
            .getLogger(CataratasController.class);

    @Autowired
    private CataratasService cataratasService;

    @PostMapping("/ingresso")
    public String comprarIngresso(@RequestParam("tipo") int tipo) {
        logger
                .info("Iniciando processo de compra para o tipo: {}", tipo);
        try {
            cataratasService
                    .ingresso(tipo);
            return "Compra realizada com sucesso!";
        } catch (Exception e) {
            logger
                    .error("Erro ao realizar compra: {}", e
                            .getMessage());
            return "Erro na compra: " + e
                    .getMessage();
        }
    }
}
