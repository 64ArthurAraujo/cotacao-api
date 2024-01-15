package cc.wordview.api.database.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "usuario")
public class Usuario implements Serializable {
        private static final long serialVersionUID = 4555915248916629355L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "email", unique = true)
        private String email;

        @Column(name = "foto")
        private String foto;

        @Column(name = "nome")
        private String nome;

        @Column(name = "senha")
        private String senha;

        @Column(name = "acesso")
        private String acesso;
}
