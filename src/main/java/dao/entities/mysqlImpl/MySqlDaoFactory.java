package dao.entities.mysqlImpl;

import dao.DaoAbstractFactory;
import dao.entities.QuestionDao;
import dao.entities.QuizDao;
import dao.entities.UserDao;
import dao.entities.postgreImpl.PostgreSqlQuizDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MySqlDaoFactory implements DaoAbstractFactory {

    @Autowired
    private MySqlQuizDaoImpl mySqlQuizDao;

    @Autowired
    private MySqlUserDao userDao;


    @Override
    public QuizDao createQuizDao() {
        return mySqlQuizDao;
    }

    @Override
    public UserDao createUserDao() {
        return userDao;
    }

    @Override
    public QuestionDao createQuestionDao() {
        return null;
    }
}
