package cc.wordview.api.database.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "clientes")
public class Cliente implements Serializable {
        private static final long serialVersionUID = 4555915248916629355L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "nome")
        private String nome;

        @Column(name = "cnpj_cpf")
        private String cnpjCpf;

        @Column(name = "estado")
        private String estado;

        @Column(name = "cidade")
        private String cidade;

        @Column(name = "bairro")
        private String bairro;

        @Column(name = "cep")
        private String cep;

        @Column(name = "quadra")
        private String quadra;

        @Column(name = "lote")
        private String lote;

        @Column(name = "telefone1")
        private String telefone1;

        @Column(name = "telefone2")
        private String telefone2;

        @Column(name = "status")
        private boolean status;
}
