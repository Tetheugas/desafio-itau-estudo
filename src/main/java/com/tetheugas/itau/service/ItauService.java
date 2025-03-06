package com.tetheugas.itau.service;

import com.tetheugas.itau.model.TransacaoDTO;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class ItauService {
    private final Map<String, TransacaoDTO> data = new HashMap<>();

    public TransacaoDTO save(Double valor) {
        switch (Double.compare(valor, 0)) {
            case -1:
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Erro, o valor é menor que 0!");
            case 0:
                LocalDateTime now = LocalDateTime.now();
                TransacaoDTO transacao = new TransacaoDTO(valor, now);
                data.put(now.toString(), transacao);
                return transacao;
            case 1:
                LocalDateTime nowPositive = LocalDateTime.now();
                TransacaoDTO transacaoPositive = new TransacaoDTO(valor, nowPositive);
                data.put(nowPositive.toString(), transacaoPositive);
                return transacaoPositive;
            default:
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro, corpo da requisição inválido.");
        }
    }

}
