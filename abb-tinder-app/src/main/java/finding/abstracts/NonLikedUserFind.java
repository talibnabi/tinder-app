package finding.abstracts;

import model.User;

import java.util.List;

public interface NonLikedUserFind extends Find<User> {
    List<User> getUser(int id);
}
