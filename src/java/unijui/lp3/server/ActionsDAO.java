package unijui.lp3.server;

import java.util.List;

public interface ActionsDAO<T> {
    
    public void insert(T obj);
    public void delete(T obj);
    public void update(T obj);
    public List<T> list();
    
}
