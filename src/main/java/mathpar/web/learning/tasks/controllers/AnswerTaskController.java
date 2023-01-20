package mathpar.web.learning.tasks.controllers;

import io.swagger.annotations.Api;
import mathpar.web.learning.tasks.entities.AnswerTask;
import mathpar.web.learning.tasks.services.AnswerTaskService;
import mathpar.web.learning.tasks.utils.PublicApi;
import mathpar.web.learning.tasks.utils.SecurityUtils;
import mathpar.web.learning.tasks.utils.dto.payload.CreateAnswerTaskPayload;
import mathpar.web.learning.tasks.utils.dto.payload.CreateNewAnswerTaskPayload;
import org.springframework.web.bind.annotation.*;

@PublicApi
@RestController
@Api(tags = "AnswerTask")
public class AnswerTaskController {
//    private final AnswerTaskService answerTaskService;
//
//    public AnswerTaskController(AnswerTaskService answerTaskService) {
//        this.answerTaskService = answerTaskService;
//    }
//
//    @GetMapping("/answer-task")
//    public AnswerTask getAnswerTask(@RequestParam("id") long id){
//        return answerTaskService.getTask(id);
//    }
//
//    @PostMapping("/answer-task")
//    public AnswerTask createAnswerTask(@RequestBody CreateAnswerTaskPayload payload){
//        var accountId = SecurityUtils.getCurrentlyAuthenticatedAccountId();
//        return answerTaskService.createTaskFromTemplate(payload.getSourceId(), accountId);
//    }
//
//    @PutMapping("/answer-task/new")
//    public AnswerTask createNewAnswerTask(@RequestBody CreateNewAnswerTaskPayload payload){
//        return answerTaskService.updateTask(payload.getText(), payload.getAnswer());
//    }
}
