package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CheckPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int duration;
    private LocalDate dateArrived;
    @ManyToOne
    @JoinColumn(name="trip_id")
    private Trip trip;

    public CheckPoint(int duration, LocalDate dateArrived, String title) {
        this.duration = duration;
        this.dateArrived = dateArrived;
        this.title = title;
    }

    public CheckPoint( int duration, String title) {
        this.title = title;
        this.duration = duration;
        this.dateArrived = LocalDate.now();
    }

    public String toString()
    {
        return this.title + " " + this.id;
    }
}
