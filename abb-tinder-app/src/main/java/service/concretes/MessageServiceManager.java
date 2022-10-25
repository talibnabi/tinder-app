package service.concretes;

import model.Message;
import service.abstracts.MessageService;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import static constants.serviceConstants.ServiceLayerConstants.messageDAOManager;

public class MessageServiceManager implements MessageService {

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
