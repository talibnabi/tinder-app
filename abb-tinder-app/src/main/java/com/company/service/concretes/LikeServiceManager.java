package com.company.service.concretes;

import com.company.model.Like;
import com.company.service.abstracts.LikeService;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.company.constants.service.ServiceLayerConstants.likeDAOManager;

public class LikeServiceManager implements LikeService {

    @Override
    public void insertLike(int _from, int _to, boolean liked) {
        Like like = new Like(_from, _to, liked);
        likeDAOManager.insertLike(like);
    }

    @Override
    public List<Like> getAllLike() {
        try {
            return likeDAOManager.getAllLike();
        } catch (SQLException e) {
            throw new RuntimeException("Something went wrong during get all like", e);
        }
    }

    @Override
    public Set<Like> getAllSigned(int _from) {
        try {
            return likeDAOManager
                    .getAllLike()
                    .stream()
                    .filter(u -> u.getFrom() == _from)
                    .collect(Collectors.toSet());
        } catch (SQLException e) {
            throw new RuntimeException("Something went wrong during get all signed", e);
        }
    }

    @Override
    public Set<Like> getAllLikedUser(int _from) {
        try {
            return likeDAOManager
                    .getAllLike()
                    .stream()
                    .filter(u -> u.getFrom() == _from)
                    .filter(Like::isLike)
                    .collect(Collectors.toSet());
        } catch (SQLException e) {
            throw new RuntimeException("Something went wrong during get all liked user", e);
        }
    }
}
