package dvd.main.dao;

import java.util.List;

/**
 * Created by anya on 07.09.2017.
 */
public interface CommonDao<T> {
    public void add(T entity);

    public void delete(long id);

    public T get(long id);

    public void update(T entity);

    public List<T> getAll();
}
