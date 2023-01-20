package mathpar.web.learning.tasks.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Deprecated(forRemoval = true)
@Data
@NoArgsConstructor
@Entity(name = "lectures")
public class NoAnswerTask {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "text")
    private String text;
    @Column(name = "author_id")
    private long authorId;
    @Column(name = "creation_date")
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @JoinColumn(name = "source_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private NoAnswerTask source;

    public NoAnswerTask(NoAnswerTask source, long authorId) {
        this.text = source.getText();
        this.authorId = authorId;
        this.source = source;
    }

    public NoAnswerTask(String text, long authorId) {
        this.text = text;
        this.authorId = authorId;
    }
}
