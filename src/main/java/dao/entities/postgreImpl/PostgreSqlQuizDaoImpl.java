package dao.entities.postgreImpl;


import dao.Entity;
import dao.entities.QuizDao;
import dao.Vendor;

public class PostgreSqlQuizDaoImpl extends QuizDao {

    public PostgreSqlQuizDaoImpl() {
        super(Vendor.POSTGRESQL, Entity.QUIZ);
    }
}
