package com.algaworks.algalog.domain.service;

import com.algaworks.algalog.domain.model.Ocorrencia;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class RegistroOcorrenciaService {

    private BuscarEntregaService buscarEntregaService;

    @Transactional
    public Ocorrencia registrar(Long entregaId, String descricao) {
        var entrega = buscarEntregaService.buscar(entregaId);

        return entrega.adicionarOcorrencia(descricao);
    }

}
