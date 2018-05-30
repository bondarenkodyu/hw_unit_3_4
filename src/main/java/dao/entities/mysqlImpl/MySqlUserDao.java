package dao.entities.mysqlImpl;

import dao.Entity;
import dao.Vendor;
import dao.entities.UserDao;
import org.springframework.stereotype.Component;

@Component
public class MySqlUserDao extends UserDao {
    public MySqlUserDao() {
        super(Vendor.MYSQL, Entity.USER);
    }
}
