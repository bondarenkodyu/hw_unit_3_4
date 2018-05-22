package dao.entities.postgreImpl;

import dao.entities.QuestionDao;
import dao.entities.QuizDao;
import dao.DaoAbstractFactory;
import dao.entities.UserDao;

public class PostgreSqlDaoFactory implements DaoAbstractFactory {
    @Override
    public QuizDao createQuizDao() {
        return new PostgreSqlQuizDaoImpl();
    }

    @Override
    public UserDao createUserDao() {
        return null;
    }

    @Override
    public QuestionDao createQuestionDao() {
        return null;
    }
}
