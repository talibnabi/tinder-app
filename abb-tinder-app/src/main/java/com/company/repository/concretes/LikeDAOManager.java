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
