package cc.wordview.api.test.api.controller.mockentity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class MockUsuario extends MockEntity {
        private String nome;
        private String email;
        private String senha;

        public MockUsuario(String email, String senha) {
                setEmail(email);
                setSenha(senha);
        }
}
