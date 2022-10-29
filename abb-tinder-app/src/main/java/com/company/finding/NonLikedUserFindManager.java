package com.company.finding;

import com.company.model.Like;

import java.util.List;
import java.util.stream.Collectors;

import static com.company.constants.finding.FindingLayerConstants.serviceLike;
import static com.company.constants.finding.FindingLayerConstants.serviceUser;

public class NonLikedUserFindManager  {


    public static List<Integer> getUser(int id) {
        return serviceUser
                .getAllUser()
                .stream()
                .filter(user -> serviceUser.findUserIdByEmail(user.getEmail()) != id)
                .map(user -> serviceUser.findUserIdByEmail(user.getEmail()))
                .filter(idX -> !serviceLike.getAllSigned(id).stream()
                        .map(Like::getUserTo)
                        .collect(Collectors.toSet())
                        .contains(id))
                .collect(Collectors.toList());
    }

}
