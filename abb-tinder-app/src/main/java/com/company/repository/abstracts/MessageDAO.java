package com.company.repository.abstracts;

import com.company.model.Message;

import java.sql.SQLException;
import java.util.List;

public interface MessageDAO extends DAO<Message> {
    void insertMessage(Message message);

    Message getMessageByID(int messageID) throws SQLException;

    List<Message> getAllMessage() throws SQLException;
}
