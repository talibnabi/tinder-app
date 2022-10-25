package finding.concretes;

import finding.abstracts.LikedUserFind;
import model.Like;
import model.User;

import java.util.List;
import java.util.stream.Collectors;

import static constants.findingConstants.FindingLayerConstants.serviceLike;
import static constants.findingConstants.FindingLayerConstants.serviceUser;

public class LikedUserFindManager implements LikedUserFind {
    private static final LikedUserFindManager likedUserFindManager = new LikedUserFindManager();

    @Override
    public List<User> getUser(int id) {
        return serviceUser
                .getAllUser()
                .stream()
                .filter(user -> serviceUser.findUserIdByEmail(user.getEmail()) != id)
                .map(user -> serviceUser.findUserIdByEmail(user.getEmail()))
                .filter(idX -> serviceLike.getAllLikedUser(id).stream()
                        .map(Like::getUserTo)
                        .collect(Collectors.toSet())
                        .contains(id))
                .map(serviceUser::getUserByID)
                .collect(Collectors.toList());
    }

    public static List<User> getLikedUser(int id) {
        return likedUserFindManager.getUser(id);
    }
}
