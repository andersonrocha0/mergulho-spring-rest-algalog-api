package com.algaworks.algalog.controller;

import com.algaworks.algalog.api.mapper.OcorrenciaMapper;
import com.algaworks.algalog.api.model.OcorrenciaModel;
import com.algaworks.algalog.api.model.input.OcorrenciaInput;
import com.algaworks.algalog.domain.service.BuscarEntregaService;
import com.algaworks.algalog.domain.service.RegistroOcorrenciaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
@AllArgsConstructor
public class OcorrenciaController {


    private RegistroOcorrenciaService registroOcorrenciaService;

    private OcorrenciaMapper ocorrenciaMapper;

    private BuscarEntregaService buscarEntregaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaModel registrar(@PathVariable Long entregaId, @Valid @RequestBody OcorrenciaInput ocorrenciaInput) {
        return ocorrenciaMapper.toModel(registroOcorrenciaService.registrar(entregaId, ocorrenciaInput.getDescricao()));
    }

    @GetMapping
    public List<OcorrenciaModel> listar(@PathVariable Long entregaId) {
        var entrega = buscarEntregaService.buscar(entregaId);

        return ocorrenciaMapper.toCollectionModel(entrega.getOcorrencias());


    }


}
