package cc.wordview.api.response;

import cc.wordview.api.database.entity.Usuario;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class UsuarioSafeResponse {
        public Long id;
        public String foto;
        public String nome;

        public UsuarioSafeResponse(Usuario usuario) {
                setId(usuario.getId());
                setFoto(usuario.getFoto());
                setNome(usuario.getNome());
        }
}
