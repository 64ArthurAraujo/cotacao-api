package cc.wordview.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cc.wordview.api.database.entity.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long>  {
        
}
