package mathpar.web.learning.tasks.controllers;

import io.swagger.annotations.Api;
import mathpar.web.learning.tasks.entities.NoAnswerTask;
import mathpar.web.learning.tasks.services.NoAnswerTaskService;
import mathpar.web.learning.tasks.utils.PublicApi;
import mathpar.web.learning.tasks.utils.SecurityUtils;
import mathpar.web.learning.tasks.utils.dto.payload.CreateNewNoAnswerTaskPayload;
import mathpar.web.learning.tasks.utils.dto.payload.CreateNoAnswerTaskPayload;
import org.springframework.web.bind.annotation.*;

@Deprecated
@PublicApi
@RestController
@Api(tags = "Lecture")
public class NoAnswerTaskController {
//    private final NoAnswerTaskService noAnswerTaskService;
//
//    public NoAnswerTaskController(NoAnswerTaskService noAnswerTaskService) {
//        this.noAnswerTaskService = noAnswerTaskService;
//    }
//
//    @GetMapping("/no-answer-task")
//    public NoAnswerTask getNoAnswerTask(@RequestParam("id") long id){
//        return noAnswerTaskService.getNoAnswerTask(id);
//    }
//
//    @PostMapping("/no-answer-task")
//    public NoAnswerTask createNoAnswerTask(@RequestBody CreateNoAnswerTaskPayload payload){
//        var accountId = SecurityUtils.getCurrentlyAuthenticatedAccountId();
//        return noAnswerTaskService.createNoAnswerTaskFromTemplate(payload.getTemplateId(), accountId);
//    }
//
//    @PostMapping("/no-answer-task/new")
//    public NoAnswerTask createNewNoAnswerTask(@RequestBody CreateNewNoAnswerTaskPayload payload){
//        var accountId = SecurityUtils.getCurrentlyAuthenticatedAccountId();
//        return noAnswerTaskService.createNewNoAnswerTask(payload.getText(), accountId);
//    }
}
