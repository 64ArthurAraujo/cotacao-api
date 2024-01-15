package cc.wordview.api.service.interf;

import cc.wordview.api.database.entity.Usuario;

public interface UsuarioServiceInterface {
        Usuario insert(Usuario entity) throws Exception;

        Usuario getByEmail(String email) throws Exception;
}
