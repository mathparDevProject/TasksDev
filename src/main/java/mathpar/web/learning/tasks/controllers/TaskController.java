package mathpar.web.learning.tasks.controllers;

import io.swagger.annotations.Api;
import javassist.NotFoundException;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import mathpar.web.learning.tasks.dto.TaskResponseDto;
import mathpar.web.learning.tasks.dto.TaskSectionsResponseDto;
import mathpar.web.learning.tasks.services.TaskService;
import mathpar.web.learning.tasks.utils.PublicApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static java.lang.String.format;

@PublicApi
@RestController
@Api(tags = "Task")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TaskController {

    TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks/{taskId}")
    public ResponseEntity<TaskSectionsResponseDto> getTaskWithSections(@PathVariable Long taskId) {
        try {
            return ResponseEntity.ok(taskService.getSectionsForTask(taskId));
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, format("Task was not found by id %s", taskId), e);
        }
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskResponseDto>> getTasks() {
        return ResponseEntity.ok(taskService.getTasks());
    }

}
