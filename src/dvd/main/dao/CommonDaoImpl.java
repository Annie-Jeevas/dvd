package dvd.main.dao;

import lombok.extern.java.Log;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by anya on 07.09.2017.
 */
@Log
@Repository
public class CommonDaoImpl<T> implements CommonDao<T> {

    private Class<T> entityClass;

    private EntityManager em = Persistence.createEntityManagerFactory(
            "dvdPU").createEntityManager();

    public CommonDaoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
        log.info(this.getClass().toString() + entityClass + " was created");
    }

    public void add(T entity) {
        em.persist(entity);
        log.info(entity.toString() + " was added");
    }

    public void delete(long id) {
        em.remove(get(id));
        log.info(entityClass + " id=" + id + " was deleted");
    }

    public T get(long id) {
        T entity = em.find(entityClass, id);
        log.info(entityClass + " id=" + id + " was found");
        return entity;
    }

    public void update(T entity) {
        em.merge(entity);
        log.info(entityClass + " " + entity + " was updated");
    }

    public List<T> getAll() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        List<T> result = em.createQuery(cq).getResultList();
        log.info(result.size() + " " + entityClass + "was found");
        return result;
    }
}
