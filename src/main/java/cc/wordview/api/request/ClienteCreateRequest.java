package cc.wordview.api.request;

import static java.util.Objects.isNull;

import cc.wordview.api.database.entity.Cliente;

public class ClienteCreateRequest {
        public String nome;
        public String cnpjCpf;
        public String estado;
        public String cidade;
        public String bairro;
        public String cep;
        public String quadra;
        public String lote;
        public String telefone1;
        public String telefone2;
        public boolean status;

        public Cliente toEntity() throws Exception {
                this.validate();

                Cliente cliente = new Cliente(null, nome, cnpjCpf, estado, cidade, bairro, cep,
                                quadra, lote, telefone1, telefone2, status);

                return cliente;
        }

        private void validate() throws Exception {
                if (nome.isEmpty() || isNull(nome)) {
                        throw new Exception("'nome' não pode ser nulo");
                }

                if (cnpjCpf.isEmpty() || isNull(cnpjCpf)) {
                        throw new Exception("'cnpjCpf' não pode ser nulo");
                }
        }

}
