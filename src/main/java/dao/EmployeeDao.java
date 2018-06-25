package dao;

import dao.entity.EmployeesEntity;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import services.HibernateSessionFactory;
import web.model.SearchQuery;
import javax.persistence.PersistenceException;
import java.io.Serializable;
import java.util.List;

public class EmployeeDao {

    private SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
    private boolean isFirst = true;

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

    public List searchEmployee(SearchQuery searchQuery) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Criteria criteria = session.createCriteria(EmployeesEntity.class);


            if (!searchQuery.getFirstName().isEmpty())
                criteria = criteria.add(Restrictions.eq("firstName", searchQuery.getFirstName()));
            if (!searchQuery.getSecondName().isEmpty())
                criteria = criteria.add(Restrictions.eq("secondName", searchQuery.getSecondName()));
            if (!searchQuery.getPosition().isEmpty())
                criteria = criteria.add(Restrictions.eq("position", searchQuery.getPosition()));
            if (!searchQuery.getDepartment().isEmpty())
                criteria = criteria.add(Restrictions.eq("department", searchQuery.getDepartment()));

            List list = criteria.list();
            session.getTransaction().commit();
            session.close();
            return list;
        } catch (NullPointerException e){
            return null;
        }
    }


    public void shutdown(){
        HibernateSessionFactory.shutdown();
    }
}



