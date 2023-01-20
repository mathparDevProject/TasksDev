package mathpar.web.learning.tasks.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "sections")
public class Section {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "TASK", nullable = false, columnDefinition = "TEXT")
    String task;

    @Column(name = "ANSWER", columnDefinition = "TEXT")
    String answer;

    @Column(name = "LATEX", columnDefinition = "TEXT")
    String latex;

    @Column(name = "LEGACY_SECTION_ID")
    Integer legacySectionId;

    @ManyToOne
    @JoinColumn(name = "TASK_ID", nullable = false)
    Task parentTask;

    @Column(name = "HAS_ANSWER", columnDefinition = "bit default true")
    Boolean hasAnswer;

    @Column(name = "TIP", columnDefinition = "TEXT")
    String tip;

}
