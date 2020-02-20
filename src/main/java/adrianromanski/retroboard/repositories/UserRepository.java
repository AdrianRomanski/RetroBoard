package adrianromanski.retroboard.repositories;

import adrianromanski.retroboard.model.User;

public interface UserRepository {

    User findByUsername(String username);
}
