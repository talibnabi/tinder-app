package com.company.service.concretes;

import com.company.model.Message;
import com.company.service.abstracts.ChatService;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import static com.company.constants.service.ServiceLayerConstants.messageDAOManager;

public class ChatServiceManager implements ChatService {

    @Override
    public void insertMessage(int _from, int _to, String messageMaintenance, long time) {
        Message message = new Message(_from, _to, messageMaintenance, time);
        messageDAOManager.insertMessage(message);
    }

    @Override
    public List<Message> getAllDirectMessage(int firstSide, int secondSide) throws SQLException {
        return messageDAOManager
                .getAllMessage()
                .stream()
                .filter(message -> message.getFrom() == firstSide || message.getFrom() == secondSide)
                .filter(message -> message.getTo() == firstSide || message.getTo() == secondSide)
                .collect(Collectors.toList());
    }
}
