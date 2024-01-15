package cc.wordview.api.service.interf;

import cc.wordview.api.database.entity.Cliente;

public interface ClienteServiceInterface extends CrudService<Cliente> {
        Cliente getByCnpjCpf(String cnpjCpf) throws Exception;
}
