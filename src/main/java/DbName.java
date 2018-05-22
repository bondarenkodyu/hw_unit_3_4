import connection.ConnectionUtil;
import dao.Entity;
import dao.Operation;
import dao.Vendor;
import xml.StatementsProvider;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class DbName {

    public static void main(String[] args) throws SQLException {
        String s = "select 1";
        Connection conn = ConnectionUtil.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(s);
        while(rs.next()){
            System.out.println(rs.getString(1));
        }
        ConnectionUtil.close(conn);
//
//        Map<Operation, String> map =  StatementsProvider.getProvider().getStatements(Vendor.POSTGRESQL, Entity.QUIZ);
//
//        System.out.println();

    }
}
