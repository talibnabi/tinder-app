package repository.abstracts;

import model.Like;


import java.sql.SQLException;
import java.util.List;

public interface LikeDAO extends DAO<Like> {
    void insertLike(Like like);

    Like getLikeByID(int likeID) throws SQLException;

    List<Like> getAllLike() throws SQLException;
}
