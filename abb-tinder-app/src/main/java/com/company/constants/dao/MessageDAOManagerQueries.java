package com.company.constants.dao;

public class MessageDAOManagerQueries {
    public static String insertMessageQuery = "insert into messages (_from, _to, message_maintenance, time) values (?,?,?,?)";
    public static String getMessageByIDQuery = "select * from messages where id = ";
    public static String getAllMessageQuery = "select * from messages";
}
