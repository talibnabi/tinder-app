package com.company.finding;

import com.company.model.Like;
import com.company.model.User;

import java.util.List;
import java.util.stream.Collectors;

import static com.company.constants.finding.FindingLayerConstants.serviceLike;
import static com.company.constants.finding.FindingLayerConstants.serviceUser;

public class LikedUserFindManager  {


    public static List<User> getUser(int id) {
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
