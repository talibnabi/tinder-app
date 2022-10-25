package constants.findingConstants;

import service.concretes.LikeServiceManager;
import service.concretes.UserServiceManager;

public class FindingLayerConstants {
    public static final UserServiceManager serviceUser = new UserServiceManager();

    public static final LikeServiceManager serviceLike = new LikeServiceManager();
}
