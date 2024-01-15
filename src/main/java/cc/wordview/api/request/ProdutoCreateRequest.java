package cc.wordview.api.request;

import lombok.Getter;
import lombok.Setter;
import cc.wordview.api.database.entity.Produto;

import static java.util.Objects.isNull;

@Getter
@Setter
public class ProdutoCreateRequest {
        public String fornecedor; // not null
        public String foto;
        public String nome; // not null
        public String codigo; // not null
        public String descricao;
        public String unidadeMedida;
        public String tamanho;
        public Double peso;
        public Double largura;
        public Long quantidade;
        public Double valor;
        public String markup;
        public Double valorTotal;
        public boolean status;

        public Produto toEntity() throws Exception {
                this.validate();

                Produto produto = new Produto(null, fornecedor, foto, nome, codigo, descricao,
                                unidadeMedida, tamanho, peso, largura, quantidade, valor,
                                markup, valor, status);

                return produto;
        }

        public void validate() throws Exception {
                if (fornecedor.isEmpty() || isNull(fornecedor)) {
                        throw new Exception("'fornecedor' é obrigatório.");
                }

                if (nome.isEmpty() || isNull(nome)) {
                        throw new Exception("'nome' é obrigatório.");
                }

                if (codigo.isEmpty() || isNull(codigo)) {
                        throw new Exception("'codigo' é obrigatório.");
                }
        }
}
