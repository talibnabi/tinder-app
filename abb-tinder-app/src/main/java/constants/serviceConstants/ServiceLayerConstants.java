package constants.serviceConstants;

import repository.concretes.LikeDAOManager;
import repository.concretes.MessageDAOManager;

public class ServiceLayerConstants {
    public static final MessageDAOManager messageDAOManager = new MessageDAOManager();
    public static final LikeDAOManager likeDAOManager = new LikeDAOManager();
}
