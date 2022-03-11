package abdullah.todomanagement.repository;

import abdullah.todomanagement.model.Todo;
import abdullah.todomanagement.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long>, RevisionRepository<Tutorial, Long, Long> {
	List<Tutorial> findByTitleIsLike(String title);
}
