package unijui.lp3.server;

import java.util.List;

public class GenericDAO<T> extends AbstractDAO implements ActionsDAO<T> {

    public GenericDAO(Class<?> clazz) {
        super(clazz);
    }
    
    @Override
    public void insert(T obj) {
        try {
            begin();
            getSession().save(obj);
            commit();
        } catch (Exception e) {
            rollback();
            throw e;
        }
    }

    @Override
    public void delete(T obj) {
        try {
            begin();
            getSession().delete(obj);
            commit();
        } catch (Exception e) {
            rollback();
            throw e;
        }
    }

    @Override
    public List<T> list() {
        try {
            return getSession().createCriteria(clazz).list();
        } catch (Exception e) {
            rollback();
            throw e;
        }
    }

    @Override
    public void update(T obj) {
        try {
            begin();
            getSession().update(obj);
            commit();
        } catch (Exception e) {
            rollback();
            throw e;
        }
    }
    
}