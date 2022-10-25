package finding.concretes;

import finding.abstracts.LikedUserFind;
import model.Like;
import model.User;
import java.util.List;
import java.util.stream.Collectors;

import static constants.findingConstants.FindingLayerConstants.serviceLike;
import static constants.findingConstants.FindingLayerConstants.serviceUser;

public class LikedUserFindManager implements LikedUserFind {

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
}
