package service.abstracts;

import model.Like;

import java.util.List;
import java.util.Set;

public interface LikeService {
    void insertLike(int _from, int _to, boolean liked);

    List<Like> getAllLike();

    Set<Like> getAllSigned(int _from);

    Set<Like> getAllLikedUser(int _from);
}
