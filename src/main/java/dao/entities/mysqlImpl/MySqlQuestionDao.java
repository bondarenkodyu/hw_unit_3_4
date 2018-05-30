package dao.entities.mysqlImpl;

import dao.Entity;
import dao.Vendor;
import dao.entities.QuestionDao;
import org.springframework.stereotype.Component;

@Component
public class MySqlQuestionDao extends QuestionDao {

    public MySqlQuestionDao() {
        super(Vendor.MYSQL, Entity.QUESTION);
    }
}
