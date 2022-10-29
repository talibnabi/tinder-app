package com.company.repository.concretes;

import com.company.model.Message;
import com.company.repository.abstracts.MessageDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.company.constants.dao.MessageDAOManagerQueries.*;
import static com.company.util.DBOperation.connection;

public class MessageDAOManager implements MessageDAO {
    @Override
    public void insertMessage(Message message) {
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(insertMessageQuery);
            ps.setInt(1, message.getFrom());
            ps.setInt(2, message.getTo());
            ps.setString(3, message.getMessageMaintenance());
            ps.setLong(4, message.getDate());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Something went wrong during inserting message", e);
        }
    }

    @Override
    public Message getMessageByID(int messageID) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(getMessageByIDQuery + messageID);
        ResultSet resultSet = statement.executeQuery();
        int _from = 0;
        int _to = 0;
        String message = "";
        long time = 0;
        while (resultSet.next()) {
            _from = resultSet.getInt("_from");
            _to = resultSet.getInt("_to");
            message = resultSet.getString("message_maintenance");
            time = resultSet.getLong("time");
        }
        return new Message(_from, _to, message, time);
    }

    @Override
    public List<Message> getAllMessage() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(getAllMessageQuery);
        ResultSet resultSet = statement.executeQuery();
        List<Message> messageArrayList = new ArrayList<>();
        while (resultSet.next()) {
            messageArrayList.add(new Message(
                    resultSet.getInt("_from"),
                    resultSet.getInt("_to"),
                    resultSet.getString("message_maintenance"),
                    resultSet.getLong("time")
            ));
        }
        return messageArrayList;
    }
}
