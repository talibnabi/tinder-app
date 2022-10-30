package com.company.service.abstracts;

import com.company.model.Message;

import java.sql.SQLException;
import java.util.List;

public interface ChatService {
    void insertMessage(int _from, int _to, String messageMaintenance, long time);

    List<Message> getAllDirectMessage(int firstSide, int secondSide) throws SQLException;
}
