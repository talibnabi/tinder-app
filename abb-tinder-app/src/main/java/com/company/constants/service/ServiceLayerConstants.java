package com.company.constants.service;

import com.company.repository.concretes.LikeDAOManager;
import com.company.repository.concretes.MessageDAOManager;

public class ServiceLayerConstants {
    public static final MessageDAOManager messageDAOManager = new MessageDAOManager();
    public static final LikeDAOManager likeDAOManager = new LikeDAOManager();
}
