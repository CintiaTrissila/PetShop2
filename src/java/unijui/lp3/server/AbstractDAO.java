package unijui.lp3.server;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import br.edu.unijui.hibernate.util.HibernateUtil;

public abstract class AbstractDAO {
    
    protected Class<?> clazz;
    private static final ThreadLocal<Session> session = new ThreadLocal<>();
    
    public AbstractDAO(Class<?> clazz) {
        this.clazz = clazz;
    }
    
    public static Session getSession() {
        Session session = (Session) AbstractDAO.session.get();
        
        if (session == null) {
            session = HibernateUtil.getSessionFactory().openSession();
            System.out.println("CRIOU NOVA SESSÃO");
            AbstractDAO.session.set(session);
        }
        
        return session;
    }
    
    protected void begin() {
        getSession().beginTransaction();
    }
    
    protected void commit() {
        getSession().getTransaction().commit();
    }
    
    protected void rollback() {
        try {
            getSession().getTransaction().rollback();
        } catch (HibernateException e) {
            System.out.println("Não foi possível fazer o rollback da transação!");
        }
        
        try {
            getSession().close();
        } catch (HibernateException e) {
            System.out.println("Não foi possível fechar a sessão!");
        }
        
        AbstractDAO.session.set(null);
    }
    
    public static void close() {
        getSession().close();
        AbstractDAO.session.set(null);
    }
    
}