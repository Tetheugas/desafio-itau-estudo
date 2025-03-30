package com.tetheugas.itau.service;

import com.tetheugas.itau.model.TransacaoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

@Service
public class ItauService {
    private final Map<String, TransacaoDTO> data = new HashMap<>();

    public TransacaoDTO save(Double valor) {
        if (valor < 0) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Erro, o valor é menor que 0!");
        }

        ZoneId zoneId = ZoneId.of("America/Sao_Paulo"); // Fuso horário de Brasília
        OffsetDateTime now = OffsetDateTime.now(zoneId); // Usando OffsetDateTime

        TransacaoDTO transacao = new TransacaoDTO(valor, now);
        data.put(now.toString(), transacao);
        return transacao;
    }

    public void delete() {
        data.clear();
    }
}
