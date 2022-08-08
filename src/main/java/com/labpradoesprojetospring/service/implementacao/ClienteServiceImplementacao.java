package com.labpradoesprojetospring.service.implementacao;

import com.labpradoesprojetospring.model.Cliente;
import com.labpradoesprojetospring.service.ClienteService;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImplementacao  implements ClienteService {
    @Override
    public Iterable<Cliente> buscarTodos() {
        return null;
    }

    @Override
    public Cliente buscaPorId(Long id) {
        return null;
    }

    @Override
    public void inserir(Cliente cliente) {

    }

    @Override
    public void atualizar(Long id, Cliente cliente) {

    }

    @Override
    public void deletar(Long id) {

    }
}
