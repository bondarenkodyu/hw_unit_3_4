package dao.entities.mysqlImpl;

import dao.Entity;
import dao.Vendor;
import dao.entities.QuestionDao;

public class MySqlQuestionDao extends QuestionDao {

    public MySqlQuestionDao() {
        super(Vendor.MYSQL, Entity.QUESTION);
    }
}
