package dao;

import dao.entity.EmployeesEntity;
import dao.util.QueryConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import services.HibernateSessionFactory;
import web.model.Employee;
import web.model.SearchQuery;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import java.io.Serializable;
import java.util.List;

public class ObjectDao {

    private  SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
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

    public List selectFromWhere(SearchQuery searchQuery){
        Session session = sessionFactory.openSession();
        boolean isFirst = true;

        QueryConstructor cnst = new QueryConstructor();
        cnst =  cnst.select(QueryConstructor.ALLFIELDS)
                            .from("employee");

        if(searchQuery.getFirstName() != null){
            cnst = cnst.where("firstName",QueryConstructor.EQUALS,searchQuery.getFirstName());
            isFirst = false;
        }

        if(searchQuery.getSecondName() != null){
            if(isFirst){
                cnst = cnst.where("secondName",QueryConstructor.EQUALS,searchQuery.getSecondName());
                isFirst = false;
            }
            else cnst = cnst.and("secondName",QueryConstructor.EQUALS,searchQuery.getSecondName());
        }

        if(searchQuery.getPosition() != null){
            if(isFirst){
                cnst = cnst.where("position",QueryConstructor.EQUALS,searchQuery.getPosition());
                isFirst = false;
            }
            else cnst = cnst.and("position",QueryConstructor.EQUALS,searchQuery.getPosition());
        }

        if(searchQuery.getDepartment() != null){
            if(isFirst){
                cnst = cnst.where("department",QueryConstructor.EQUALS,searchQuery.getDepartment());
                isFirst = false;
            }
            else cnst = cnst.and("department",QueryConstructor.EQUALS,searchQuery.getDepartment());
        }

        String queryString = cnst.end();


        Query query = session.createQuery(queryString);
        List list = query.list();
        session.close();
        return list;

    }

    public void shutdown(){
        HibernateSessionFactory.shutdown();
    }
}
