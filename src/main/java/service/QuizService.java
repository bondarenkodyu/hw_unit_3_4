package service;

import dao.entities.QuizDao;
import dao.DaoFactory;
import dao.entities.mysqlImpl.MySqlDaoFactory;
import dao.entities.postgreImpl.PostgreSqlDaoFactory;
import model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuizService {

    @Autowired
    private QuizDao quizDao;

    public QuizService() {

    }

    public void add(Quiz quiz){
        quizDao.create(quiz);
    }

    public void remove(String name){
        quizDao.delete(name);
    }

    public Collection<Quiz> getAll(){
        return quizDao.getAll();
    }

    public Optional<Quiz> get(String name) {
        return quizDao.get(name);
    }
}
