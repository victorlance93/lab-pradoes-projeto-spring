package service;

import com.labpradoesprojetospring.model.Cliente;
import org.springframework.stereotype.Service;


public interface ClienteService{

    Iterable<Cliente> buscarTodos();

    Cliente buscaPorId(Long id);

    void inserir(Cliente cliente);

    void atualizar(Long id, Cliente cliente);

    void deletar(Long id);
}
