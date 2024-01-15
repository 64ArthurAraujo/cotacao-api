package cc.wordview.api.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cc.wordview.api.database.entity.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
        Optional<Usuario> findByEmail(String email);
}
