package com.company.constants.finding;

import com.company.service.concretes.LikeServiceManager;
import com.company.service.concretes.UserServiceManager;

public class FindingLayerConstants {
    public static final UserServiceManager userServiceManager = new UserServiceManager();

    public static final LikeServiceManager likeServiceManager = new LikeServiceManager();
}
