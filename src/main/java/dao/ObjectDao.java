package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import services.HibernateSessionFactory;

import javax.persistence.PersistenceException;
import java.io.Serializable;
import java.util.List;

public class ObjectDao {

    private  SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();

    public void saveObject(Object object) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(object);
            session.getTransaction().commit();
            session.close();
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
    }

    public Object getObject(Class classOfEntity, Serializable primaryKey) { //throws PersistenceException
            Session session = sessionFactory.openSession();
            Object object = session.get(classOfEntity, primaryKey);
            session.close();
            return object;
    }

    public void saveOrUpdateObject(Object object) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.saveOrUpdate(object);
            session.getTransaction().commit();
            session.close();
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
    }

    public void deleteObject(Object object) {
       try {
           Session session = sessionFactory.openSession();
           session.beginTransaction();
           session.delete(object);
           session.getTransaction().commit();
           session.close();
       } catch (PersistenceException e) {
           e.printStackTrace();
       }
    }

    public List selectFromWhere(String...operands){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from EmployeesEntity where firstName = :paramName1 AND secondName = :paramName2" +
                                            " AND position = :paramName3 AND department = :paramName4 ");
        query.setParameter("paramName1", operands[0]);
        query.setParameter("paramName2", operands[1]);
        query.setParameter("paramName3", operands[2]);
        query.setParameter("paramName4", operands[3]);
        List list = query.list();
        session.close();
        return list;

    }

    public void shutdown(){
        HibernateSessionFactory.shutdown();
    }
}
