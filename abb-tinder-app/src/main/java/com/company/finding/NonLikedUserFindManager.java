package com.company.finding;

import com.company.model.Like;

import java.util.List;
import java.util.stream.Collectors;

import static com.company.constants.finding.FindingLayerConstants.*;

public class NonLikedUserFindManager {


    public static List<Integer> getUser(int id) {
        return userServiceManager
                .getAllUser()
                .stream()
                .filter(user -> userServiceManager.findUserIdByEmail(user.getEmail()) != id)
                .map(user -> userServiceManager.findUserIdByEmail(user.getEmail()))
                .filter(idX -> !likeServiceManager.getAllSigned(id).stream()
                        .map(Like::getTo)
                        .collect(Collectors.toSet())
                        .contains(idX))
                .collect(Collectors.toList());
    }

}
