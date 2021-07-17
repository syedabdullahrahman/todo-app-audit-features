package abdullah.todomanagement.repository;

import abdullah.todomanagement.model.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TodoRepository extends CrudRepository<Todo, Long>, RevisionRepository<Todo, Long, Long> {
	List<Todo> findByUserName(String user);
}
