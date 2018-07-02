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
import static util.SearchCaseInsensitive.*;

public class EmployeeDao {

    private SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();

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

    public List searchEmployee(SearchQuery sQuery) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Criteria criteria = session.createCriteria(EmployeesEntity.class);


            if (!sQuery.getFirstName().isEmpty())
                criteria = criteria.add(Restrictions
                        .or(Restrictions.eq("firstName", caseInsensitive(sQuery.getFirstName())),
                            Restrictions.eq("firstName", sQuery.getFirstName())));

            if (!sQuery.getSecondName().isEmpty())
                criteria = criteria.add(Restrictions
                        .or(Restrictions.eq("secondName", caseInsensitive(sQuery.getSecondName())),
                            Restrictions.eq("secondName", sQuery.getSecondName())));

            if (!sQuery.getPosition().isEmpty())
                criteria = criteria.add(Restrictions
                        .or(Restrictions.eq("position", caseInsensitive(sQuery.getPosition())),
                            Restrictions.eq("position", sQuery.getPosition())));

            if (!sQuery.getDepartment().isEmpty())
                criteria = criteria.add(Restrictions
                        .or(Restrictions.eq("department", caseInsensitive(sQuery.getDepartment())),
                            Restrictions.eq("department", sQuery.getDepartment())));


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



