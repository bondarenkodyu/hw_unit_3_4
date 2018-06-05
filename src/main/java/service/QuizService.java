package service;

import connection.HibernateUtil;
import model.Quiz;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import org.hibernate.query.Query;
import java.util.*;

@Service
public class QuizService {

    public QuizService() {

    }

    public void add(Quiz quiz){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.update(quiz);
        session.getTransaction().commit();
    }

    public void remove(String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("delete from " + Quiz.class.getName().toLowerCase() + " where name = :name");
        query.setParameter("name", name);
        query.executeUpdate();
        transaction.commit();
    }

    public Collection<Quiz> getAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from " + Quiz.class.getSimpleName());
        return query.list();
    }

    public Quiz get(String name){
        Quiz quiz = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("from " + Quiz.class.getSimpleName() + " where name = :name");
            query.setParameter("name", name);
            quiz = (Quiz) query.uniqueResult();
        } catch (Exception e){
//            throw e;
        }
        return quiz;
    }






}
