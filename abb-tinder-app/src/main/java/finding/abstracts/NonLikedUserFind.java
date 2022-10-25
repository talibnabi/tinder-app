package finding.abstracts;

import model.User;

import java.util.List;

public interface NonLikedUserFind extends Find<Integer> {
    List<Integer> getUser(int id);
}
