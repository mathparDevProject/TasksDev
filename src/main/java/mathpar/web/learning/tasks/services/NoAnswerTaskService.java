package mathpar.web.learning.tasks.services;

import mathpar.web.learning.tasks.entities.NoAnswerTask;
import mathpar.web.learning.tasks.repositories.NoAnswerTaskRepository;
import mathpar.web.learning.tasks.utils.SecurityUtils;
import mathpar.web.learning.tasks.utils.exceptions.BadRequestException;
import org.springframework.stereotype.Service;

@Service
public class NoAnswerTaskService {
    private final NoAnswerTaskRepository noAnswerTaskRepository;

    public NoAnswerTaskService(NoAnswerTaskRepository noAnswerTaskRepository) {
        this.noAnswerTaskRepository = noAnswerTaskRepository;
    }

    public NoAnswerTask getNoAnswerTask(long lectureId){
        return noAnswerTaskRepository.findById(lectureId).orElseThrow(BadRequestException::new);
    }

    public NoAnswerTask createNoAnswerTaskFromTemplate(long sourceId, long accountId){
        var template = noAnswerTaskRepository.findById(sourceId).orElseThrow(BadRequestException::new);
        return noAnswerTaskRepository.save(new NoAnswerTask(template, accountId));
    }

    public NoAnswerTask createNewNoAnswerTask(String text){
        var authorId = SecurityUtils.getCurrentlyAuthenticatedAccountId();
        return noAnswerTaskRepository.save(new NoAnswerTask(text, authorId));
    }
}
