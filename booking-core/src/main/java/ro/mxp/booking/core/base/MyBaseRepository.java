package ro.mxp.booking.core.base;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface MyBaseRepository<T, ID extends Serializable> extends Repository<T, Integer> {

    <S extends T> S save(S entity);
    T findOne(ID id);
    List<T> findAll();
    void delete(ID id);

}
