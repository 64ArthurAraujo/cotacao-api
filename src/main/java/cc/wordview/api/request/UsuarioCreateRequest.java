package cc.wordview.api.request;

import cc.wordview.api.database.entity.Usuario;

public class UsuarioCreateRequest {
        public String nome;
        public String email;
        public String senha;

        public Usuario toEntity() {
                Usuario usuario = new Usuario();

                usuario.setNome(nome);
                usuario.setEmail(email);
                usuario.setSenha(senha);

                return usuario;
        }
}
