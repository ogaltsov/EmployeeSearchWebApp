package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import services.HibernateSessionFactory;
import web.model.News;

import java.util.List;

public class NewsDao {
    private SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();

    public List<News> getLatestNews(){
        Session session = sessionFactory.openSession();
        Query<News> query = session.createQuery("from News order by date", News.class).setMaxResults(5);//max 5 news in latest news in main page
        List<News> list = query.list();
        session.close();
        return list;
    }
}
