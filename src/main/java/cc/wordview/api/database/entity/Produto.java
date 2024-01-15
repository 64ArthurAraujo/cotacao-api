package cc.wordview.api.database.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "produtos")
public class Produto implements Serializable {
        private static final long serialVersionUID = 4555915248916629355L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "fornecedor")
        private String fornecedor;

        @Column(name = "foto")
        private String foto;

        @Column(name = "nome")
        private String nome;

        @Column(name = "codigo")
        private String codigo;

        @Column(name = "descricao")
        private String descricao;

        @Column(name = "unidade_de_medida")
        private String unidadeDeMedida;

        @Column(name = "tamanho")
        private String tamanho;

        @Column(name = "peso")
        private Double peso;

        @Column(name = "largura")
        private Double largura;

        @Column(name = "quantidade")
        private Long quantidade;

        @Column(name = "valor")
        private Double valor;

        @Column(name = "markup")
        private String markup;

        @Column(name = "valor_total")
        private Double valorTotal;

        @Column(name = "status")
        private boolean status;
}
