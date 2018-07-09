package dao;

import model.Employee;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import services.HibernateSessionFactory;
import model.SearchQuery;
import javax.persistence.PersistenceException;
import java.io.Serializable;
import java.util.List;
import static util.SearchCaseInsensitive.*;

public class EmployeeDao {

    private SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();

    public void saveObject(Employee employee) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
            session.close();
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
    }

    public Employee getEmployee(Serializable primaryKey) { //throws PersistenceException
        Session session = sessionFactory.openSession();
        Employee employee = session.get(Employee.class, primaryKey);
        session.close();
        return employee;
    }

    public void saveOrUpdateEmployee(Employee employee) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.saveOrUpdate(employee);
            session.getTransaction().commit();
            session.close();
        } catch (PersistenceException e) {
            e.printStackTrace();

        }
    }

    public void deleteEmployee(Employee employee) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(employee);
            session.getTransaction().commit();
            session.close();
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> searchEmployee(SearchQuery sQuery) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Employee.class);


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


            List<Employee> list = criteria.list();
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



