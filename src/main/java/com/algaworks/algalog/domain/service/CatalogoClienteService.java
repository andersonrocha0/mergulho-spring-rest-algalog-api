package com.algaworks.algalog.domain.service;

import com.algaworks.algalog.domain.exception.NegocioException;
import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class CatalogoClienteService {

    private ClienteRepository clienteRepository;

    @Transactional
    public Cliente salvar(Cliente cliente) {

        boolean emailEmUso = !clienteRepository.findByEmail(cliente.getEmail()).isEmpty();

        if (emailEmUso) {
            throw new NegocioException("Email em uso.");
        }


        return clienteRepository.save(cliente);
    }

    public void excluir(Long clientId) {
        clienteRepository.deleteById(clientId);
    }


    public Cliente buscar(Long clientId) {
        return clienteRepository.findById(clientId).orElseThrow(() -> new NegocioException("Cliente não encontrado"));
    }

}
