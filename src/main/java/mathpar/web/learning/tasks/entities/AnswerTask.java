package mathpar.web.learning.tasks.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.FetchType.LAZY;

@Deprecated(forRemoval = true)
@Data
@NoArgsConstructor
@Entity(name = "exams")
public class AnswerTask {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    @Column(name = "text")
    public String text;
    @Column(name = "answer")
    public String answer;
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    public Date creationDate;
    @Column(name = "author_id")
    public long authorId;
    @JoinColumn(name = "source_id", referencedColumnName = "id")
    @ManyToOne(fetch = LAZY)
    public AnswerTask source;

    public AnswerTask(AnswerTask source, long authorId) {
        this.source = source;
        this.text = source.getText();
        this.answer = source.getAnswer();
        this.authorId = authorId;
    }

    public AnswerTask(String text, String answer, long authorId) {
        this.text = text;
        this.answer = answer;
        this.authorId = authorId;
    }
}
