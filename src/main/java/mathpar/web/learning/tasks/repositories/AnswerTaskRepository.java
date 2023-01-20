package mathpar.web.learning.tasks.repositories;

import mathpar.web.learning.tasks.entities.AnswerTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerTaskRepository extends JpaRepository<AnswerTask, Long> {
}
