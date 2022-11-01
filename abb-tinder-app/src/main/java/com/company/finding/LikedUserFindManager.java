package com.company.finding;

import com.company.model.Like;
import com.company.model.User;

import java.util.List;
import java.util.stream.Collectors;

import static com.company.constants.finding.FindingLayerConstants.*;

public class LikedUserFindManager  {

    public static List<User> getUser(int id) {
        return userServiceManager
                .getAllUser()
                .stream()
                .filter(user -> userServiceManager.findUserIdByEmail(user.getEmail()) != id)
                .map(user -> userServiceManager.findUserIdByEmail(user.getEmail()))
                .filter(idX -> likeServiceManager.getAllLikedUser(id).stream()
                        .map(Like::getTo)
                        .collect(Collectors.toSet())
                        .contains(idX))
                .map(userServiceManager::getUserByID)
                .collect(Collectors.toList());
    }

}
