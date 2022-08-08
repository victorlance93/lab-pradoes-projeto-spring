package service.implementacao;

import com.labpradoesprojetospring.model.Cliente;
import com.labpradoesprojetospring.model.ClienteRepository;
import com.labpradoesprojetospring.model.Endereco;
import com.labpradoesprojetospring.model.EnderecoRepository;
import service.ClienteService;
import service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImplementacao  implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;
    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscaPorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarCLienteComCep(cliente);
    }



    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if(clienteBd.isPresent()) {
            salvarCLienteComCep(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
    clienteRepository.deleteById(id);
    }

    private void salvarCLienteComCep(Cliente cliente) {
        String cep = cliente.getEndereço().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereço(endereco);
        clienteRepository.save(cliente);
    }
}
