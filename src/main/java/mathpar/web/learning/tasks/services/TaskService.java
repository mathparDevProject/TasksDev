package mathpar.web.learning.tasks.services;

import javassist.NotFoundException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import mathpar.web.learning.tasks.dto.SectionResponseDto;
import mathpar.web.learning.tasks.dto.TaskResponseDto;
import mathpar.web.learning.tasks.dto.TaskSectionsResponseDto;
import mathpar.web.learning.tasks.entities.Task;
import mathpar.web.learning.tasks.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TaskService {

    TaskRepository taskRepository;

    public TaskSectionsResponseDto getSectionsForTask(Long taskId) throws NotFoundException {
        Optional<Task> taskWithSections = taskRepository.findByIdFetchSections(taskId);
        return buildDtoFromEntityData(taskWithSections.orElseThrow(
                () -> new NotFoundException(String.format("Could not find task by id: %s", taskId))));
    }

    public List<TaskResponseDto> getTasks() {
        List<Task> allTasks = taskRepository.findAll();
        return allTasks.stream().map(this::buildTaskResponseDto).collect(Collectors.toList());
    }

    private TaskResponseDto buildTaskResponseDto(Task task) {
        return TaskResponseDto.builder()
                .id(task.getId())
                .taskTitle(task.getTaskTitle())
                .build();
    }

    private TaskSectionsResponseDto buildDtoFromEntityData(Task task) {
        List<SectionResponseDto> sections = task.getSectionList()
                .stream()
                .map(section -> SectionResponseDto.builder()
                        .id(section.getId())
                        .task(section.getTask())
                        .answer(section.getAnswer())
                        .hasAnswer(section.getHasAnswer())
                        .tip(section.getTip())
                        .build())
                .collect(Collectors.toList());
        return TaskSectionsResponseDto.builder()
                .id(task.getId())
                .sectionsList(sections)
                .build();
    }

}
