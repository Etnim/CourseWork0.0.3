package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Forum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  String title;
    private  LocalDate creationDate;
    private String description;

    @OneToMany(mappedBy = "forum", cascade = CascadeType.ALL)
    private List<Comment> commentList;

    public Forum(String title) {
        this.title = title;
        this.creationDate = LocalDate.now();
    }

}
