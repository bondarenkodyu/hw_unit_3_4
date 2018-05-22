package dao.entities.mysqlImpl;

import dao.DaoAbstractFactory;
import dao.entities.QuestionDao;
import dao.entities.QuizDao;
import dao.entities.UserDao;
import dao.entities.postgreImpl.PostgreSqlQuizDaoImpl;

public class MySqlDaoFactory implements DaoAbstractFactory {
    @Override
    public QuizDao createQuizDao() {
        return new MySqlQuizDaoImpl();
    }

    @Override
    public UserDao createUserDao() {
        return new MySqlUserDao();
    }

    @Override
    public QuestionDao createQuestionDao() {
        return null;
    }
}
