package dao;

import dao.entities.QuestionDao;
import dao.entities.QuizDao;
import dao.entities.UserDao;

public interface DaoAbstractFactory {

    QuizDao createQuizDao();
    UserDao createUserDao();
    QuestionDao createQuestionDao();

}
