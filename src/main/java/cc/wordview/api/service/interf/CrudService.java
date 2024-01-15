package cc.wordview.api.service.interf;

public interface CrudService<T> {
        T getById(Long id) throws Exception;

        T insert (T entity) throws Exception;

        T update (T entity) throws Exception;

        void deleteById(Long id);
}
