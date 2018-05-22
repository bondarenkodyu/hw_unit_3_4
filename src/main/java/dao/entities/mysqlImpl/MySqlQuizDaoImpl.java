package dao.entities.mysqlImpl;


import dao.Entity;
import dao.Vendor;
import dao.entities.QuizDao;

public class MySqlQuizDaoImpl extends QuizDao {

    public MySqlQuizDaoImpl() {
        super(Vendor.MYSQL, Entity.QUIZ);
    }
}