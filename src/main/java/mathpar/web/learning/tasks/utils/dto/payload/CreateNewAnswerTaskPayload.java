package mathpar.web.learning.tasks.utils.dto.payload;

import lombok.Data;

@Data
public class CreateNewAnswerTaskPayload {
    private String text;
    private String answer;
}
