package com.company.model;

import com.company.util.DateFormatOperation;

import java.util.Objects;

public class Message {
    private final int from;
    private final int to;
    private final String messageMaintenance;
    private final long dateWithLong;
    private String dateString;

    public Message(int from, int to, String messageMaintenance, long dateWithLong) {
        this.from = from;
        this.to = to;
        this.messageMaintenance = messageMaintenance;
        this.dateWithLong = dateWithLong;
        this.dateString = DateFormatOperation.dateFormat(dateWithLong);
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public String getMessageMaintenance() {
        return messageMaintenance;
    }

    public long getDate() {
        return dateWithLong;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message message)) return false;
        return getFrom() == message.getFrom() && getTo() == message.getTo() && dateWithLong == message.dateWithLong && getMessageMaintenance().equals(message.getMessageMaintenance());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFrom(), getTo(), getMessageMaintenance(), dateWithLong);
    }

    @Override
    public String toString() {
        return "Message{" +
                "from=" + from +
                ", to=" + to +
                ", content='" + messageMaintenance + '\'' +
                ", date=" + dateWithLong +
                '}';
    }
}
