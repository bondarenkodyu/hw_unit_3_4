package dao.entities;

import connection.ConnectionUtil;
import dao.Entity;
import dao.Operation;
import dao.Vendor;
import logging.Log;
import model.Question;
import utils.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class QuestionDao extends AbstractEntity {

    public QuestionDao(Vendor vendor, Entity entity) {
        super(vendor, entity);
    }

    public void create(Question question, int parent_id) {
        try (Connection connection = ConnectionUtil.getConnection()){
            Log.writeInfo("Creating is running...");
            PreparedStatement ps = connection.prepareStatement(getStatements().get(Operation.CREATE));
            ps.setString(1, question.getBody());
            ps.setBoolean(2, question.isRight());
            ps.setLong(3, parent_id);
            JdbcUtils.transactionExecution(connection, ps);
            Log.writeInfo("Creating finished.");
        } catch (SQLException e) {
            Log.writeError(String.format("Creating error. Question id={%s}"));
        }
    }

    public void createAll(List<Question> list, int parent_id) {
        try (Connection connection = ConnectionUtil.getConnection()){
            Log.writeInfo("Creating is running...");
            PreparedStatement ps = connection.prepareStatement(getStatements().get(Operation.CREATE));
            for (Question question : list){
                ps.setString(1, question.getBody());
                ps.setBoolean(2, question.isRight());
                ps.setLong(3, parent_id);
                ps.addBatch();
            }
            JdbcUtils.transactionExecution(connection, ps);
            Log.writeInfo("Creating finished.");
        } catch (SQLException e) {
            Log.writeError(String.format("Creating error. Question id={%s}"));
        }
    }

    public Collection<Question> getAll(int parent_id) {
        Collection<Question> questions = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection()){
            Log.writeInfo("Start of data extracting...");
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(getStatements().get(Operation.READ_ALL));
            while (rs.next()){
                questions.add(new Question(rs.getInt(1),
                                           rs.getString(2),
                                           rs.getBoolean(3))
                );
            }
            Log.writeInfo("Data extracting finished.");
        } catch (SQLException e) {
            Log.writeError(e,"Loading error.");
        }
        return questions;
    }


    public void update(Question question) {
        try (Connection connection = ConnectionUtil.getConnection()){
            Log.writeInfo("Updating is running...");
            PreparedStatement ps = connection.prepareStatement(getStatements().get(Operation.UPDATE));
            ps.setLong(1, Long.valueOf(question.getBody()));
            ps.setBoolean(2, Boolean.valueOf(question.isRight()));
            ps.setLong(3, Long.valueOf(question.getId()));
            JdbcUtils.transactionExecution(connection, ps);
            Log.writeInfo("Updating finished");
        } catch (SQLException e) {
            Log.writeError(String.format("Updating error. Question : {%s}", question));
        }
    }

}
