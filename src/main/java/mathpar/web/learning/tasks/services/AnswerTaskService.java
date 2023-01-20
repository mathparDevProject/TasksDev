package mathpar.web.learning.tasks.services;

import mathpar.web.learning.tasks.entities.AnswerTask;
import mathpar.web.learning.tasks.repositories.AnswerTaskRepository;
import mathpar.web.learning.tasks.utils.SecurityUtils;
import mathpar.web.learning.tasks.utils.exceptions.BadRequestException;
import org.springframework.stereotype.Service;

@Service
public class AnswerTaskService {
    private final AnswerTaskRepository answerTaskRepository;

    public AnswerTaskService(AnswerTaskRepository answerTaskRepository) {
        this.answerTaskRepository = answerTaskRepository;
    }

    public AnswerTask getTask(long id){
        return answerTaskRepository.findById(id).orElseThrow(BadRequestException::new);
    }

    public AnswerTask createTaskFromTemplate(long sourceId, long accountId){
        var source = answerTaskRepository.findById(sourceId).orElseThrow();
        return answerTaskRepository.save(new AnswerTask(source, accountId));
    }

    public AnswerTask updateTask(String condition, String answer){
        var userId = SecurityUtils.getCurrentlyAuthenticatedAccountId();
        return answerTaskRepository.save(new AnswerTask(condition, answer, userId));
    }
}
