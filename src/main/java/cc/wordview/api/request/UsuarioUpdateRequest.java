package cc.wordview.api.request;

import static java.util.Objects.isNull;

import cc.wordview.api.database.entity.Usuario;

public class UsuarioUpdateRequest {
        public Long id;
        public String nome;
        public String email;
        public String foto;

        public Usuario toEntity() throws Exception {
                this.validate();

                Usuario usuario = new Usuario();

                usuario.setNome(nome);
                usuario.setEmail(email);
                usuario.setFoto(foto);
                
                return usuario;
        }

        public void validate() throws Exception {
                if (isNull(id)) {
                        throw new Exception("'id' não pode ser nulo.");
                }
        }
}
