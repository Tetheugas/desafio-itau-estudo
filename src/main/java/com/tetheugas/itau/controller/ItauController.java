package com.tetheugas.itau.controller;

import com.tetheugas.itau.model.TransacaoDTO;
import com.tetheugas.itau.service.ItauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ItauController {

    @Autowired
    private ItauService itauService;

    @PostMapping(value = "/transacao", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public TransacaoDTO transacao(@RequestBody Double valor) {

        return itauService.save(valor);
    }
}
