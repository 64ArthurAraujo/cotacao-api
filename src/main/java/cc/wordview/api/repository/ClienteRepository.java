package cc.wordview.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cc.wordview.api.database.entity.Cliente;
import java.util.Optional;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
        Optional<Cliente> findByCnpjCpf(String cnpjCpf);
}
