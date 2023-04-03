package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.Forum;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity

public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
    private LocalDate dateCreated;
    private LocalDate dateModified;
    @OneToMany(mappedBy = "parentComment", cascade = CascadeType.ALL)
    private List<Comment> replies;
    @ManyToOne
    private Comment parentComment;

    @ManyToOne
    private Forum forum;

    public Comment(String text) {

        this.text = text;
        this.dateCreated = LocalDate.now();
    }
}

