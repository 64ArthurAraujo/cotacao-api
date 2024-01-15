package cc.wordview.api.service.interf;

import cc.wordview.api.database.entity.Usuario;

public interface UsuarioServiceInterface extends CrudService<Usuario> {
        Usuario getByEmail(String email) throws Exception;
}
