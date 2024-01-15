package cc.wordview.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.wordview.api.database.entity.Produto;
import cc.wordview.api.repository.ProdutoRepository;
import cc.wordview.api.service.interf.ProdutoServiceInterface;

@Service
public class ProdutoService implements ProdutoServiceInterface {

        @Autowired
        private ProdutoRepository repository;

        @Override
        public Produto getById(Long id) throws Exception { 
                Optional<Produto> produto = repository.findById(id);

                if (!produto.isPresent()) {
                        throw new Exception("Nenhum usuario encontrado com o id especificado.");
                }

                return produto.get();
        }

        @Override
        public Produto insert(Produto entity) throws Exception { 
                return repository.save(entity);
        }

        @Override
        public Produto update(Produto entity) throws Exception { 
                return repository.save(entity);
        }

        @Override
        public void deleteById(Long id) { 
                repository.deleteById(id);
        }
        
}
