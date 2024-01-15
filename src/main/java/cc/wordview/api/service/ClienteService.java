package cc.wordview.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.wordview.api.database.entity.Cliente;
import cc.wordview.api.repository.ClienteRepository;
import cc.wordview.api.service.interf.ClienteServiceInterface;

@Service
public class ClienteService implements ClienteServiceInterface {

        @Autowired
        private ClienteRepository repository;

        @Override
        public Cliente getById(Long id) throws Exception { 
                Optional<Cliente> cliente = repository.findById(id);
                
                if (!cliente.isPresent()) {
                        throw new Exception("Nenhum cliente encontrado com o id especificado.");
                }

                return cliente.get();
        }

        @Override
        public Cliente insert(Cliente entity) throws Exception { 
                Optional<Cliente> clienteComMesmoCnpjCpf = repository.findByCnpjCpf(entity.getCnpjCpf());
        
                if (clienteComMesmoCnpjCpf.isPresent()) {
                        throw new Exception("O CNPJ/CPF já está em uso.");
                }

                return repository.save(entity);
        }

        @Override
        public Cliente update(Cliente entity) throws Exception { 
                return repository.save(entity);
        }

        @Override
        public void deleteById(Long id) { 
                repository.deleteById(id);
        }

        @Override
        public Cliente getByCnpjCpf(String cnpjCpf) throws Exception { 
                Optional<Cliente> cliente = repository.findByCnpjCpf(cnpjCpf);
        
                if (!cliente.isPresent()) {
                        throw new Exception("Nenhum cliente encontrado com o CNPJ/CPF especificado.");
                }

                return cliente.get();
        }
        
}
