package sia.pastebincopy.db.repository;

import org.springframework.data.repository.CrudRepository;
import sia.pastebincopy.db.model.Code;

public interface CodeRepository extends CrudRepository<Code, Integer> {
    Code findByUuid(String uuid);
}
