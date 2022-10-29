package com.company.repository.concretes;

import com.company.model.Like;
import com.company.repository.abstracts.LikeDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.company.constants.dao.LikeDAOManagerQueries.*;
import static com.company.util.DBOperation.connection;

public class LikeDAOManager implements LikeDAO {
    @Override
    public void insertLike(Like like) {
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(insertLikeQuery);
            ps.setInt(1, like.getUserFrom());
            ps.setInt(2, like.getUserTo());
            ps.setBoolean(3, like.isLike());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Something went wrong during inserting like", e);

        }
    }

    @Override
    public Like getLikeByID(int likeID) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(getLikeByIDQuery + likeID);
        ResultSet resultSet = statement.executeQuery();
        int _from = 0;
        int _to = 0;
        boolean liked = false;
        while (resultSet.next()) {
            _from = resultSet.getInt("_from");
            _to = resultSet.getInt("_to");
            liked = resultSet.getBoolean("liked");
        }
        return new Like(_from, _to, liked);
    }

    @Override
    public List<Like> getAllLike() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(getAllLikeQuery);
        ResultSet resultSet = statement.executeQuery();
        List<Like> likeArrayList = new ArrayList<>();
        while (resultSet.next()) {
            likeArrayList.add(new Like(
                    resultSet.getInt("_from"),
                    resultSet.getInt("_to"),
                    resultSet.getBoolean("liked")
            ));
        }
        return likeArrayList;
    }
}
