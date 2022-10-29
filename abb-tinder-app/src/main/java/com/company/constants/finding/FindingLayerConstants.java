package com.company.constants.finding;

import com.company.service.concretes.LikeServiceManager;
import com.company.service.concretes.UserServiceManager;

public class FindingLayerConstants {
    public static final UserServiceManager serviceUser = new UserServiceManager();

    public static final LikeServiceManager serviceLike = new LikeServiceManager();
}
