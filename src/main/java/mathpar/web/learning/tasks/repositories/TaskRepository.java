package mathpar.web.learning.tasks.repositories;

import mathpar.web.learning.tasks.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query(
        "select t " +
        "from Task t " +
        "join fetch t.sectionList " +
        "where t.id = :taskId")
    Optional<Task> findByIdFetchSections(Long taskId);

}
