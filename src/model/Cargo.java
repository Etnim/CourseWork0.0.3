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
public class Cargo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int weight;
    private int volume;
    private int price;
    private String title;
    private CargoType cargoType;
    private LocalDate dateCreated;
    private LocalDate dateUpdated;
    private String description;

    @OneToOne()
    @JoinColumn(name="tripC_id")
    private Trip tripC;


    public Cargo(int weight, int volume, int price, String title, CargoType cargoType, String description) {
        this.weight = weight;
        this.volume = volume;
        this.price = price;
        this.title = title;
        this.cargoType = cargoType;
        this.description = description;
    }


    public Cargo(int weight, int volume, int price, String title, CargoType cargoType) {
        this.weight = weight;
        this.volume = volume;
        this.price = price;
        this.title = title;
        this.cargoType = cargoType;
        this.dateCreated = LocalDate.now();
    }


    public String toString()
    {
        return this.title + " " + this.id;
    }
}
