package mathpar.web.learning.tasks.repositories;

import mathpar.web.learning.tasks.entities.NoAnswerTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoAnswerTaskRepository extends JpaRepository<NoAnswerTask, Long> {
}
