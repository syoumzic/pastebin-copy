package sia.pastebincopy.db.repository;

import org.springframework.data.repository.CrudRepository;
import sia.pastebincopy.db.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}
