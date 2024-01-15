package cc.wordview.api.request;

import lombok.Getter;
import lombok.Setter;
import cc.wordview.api.database.entity.Produto;

import static java.util.Objects.isNull;

@Getter
@Setter
public class ProdutoUpdateRequest {
        public Long id;
        public String fornecedor; 
        public String foto;
        public String nome; 
        public String codigo;
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

                Produto produto = new Produto(id, fornecedor, foto, nome, codigo, descricao,
                                unidadeMedida, tamanho, peso, largura, quantidade, valor,
                                markup, valor, status);

                return produto;
        }

        public void validate() throws Exception {
                if (isNull(id)) {
                        throw new Exception("'id' não pode ser nulo.");
                }
        }
}
