package cc.wordview.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.wordview.api.database.entity.Usuario;
import cc.wordview.api.repository.UsuarioRepository;
import cc.wordview.api.service.interf.UsuarioServiceInterface;
import cc.wordview.api.service.util.HashedPassword;

@Service
public class UsuarioService implements UsuarioServiceInterface {

        @Autowired
        private UsuarioRepository repository;

        @Override
        public Usuario insert(Usuario entity) throws Exception { 
                Optional<Usuario> usuarioComMesmoEmail = repository.findByEmail(entity.getEmail());
                
                if (usuarioComMesmoEmail.isPresent()) {
                        throw new Exception("O Email já está em uso.");
                }

                String senhaHash = new HashedPassword(entity).getValue();
                entity.setSenha(senhaHash);
                
                return repository.save(entity);
        }

        @Override
        public Usuario getByEmail(String email) throws Exception {
                Optional<Usuario> usuario = repository.findByEmail(email);
                
                if (!usuario.isPresent()) {
                        throw new Exception("Nenhum usuario encontrado com o email especificado.");
                } else return usuario.get();
        }
        
}
