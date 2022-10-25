package finding.abstracts;

import model.User;

import java.util.List;

public interface LikedUserFind extends Find<User> {
    List<User> getUser(int id);
}
