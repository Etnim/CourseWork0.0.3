package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Truck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int manufactureYear;
    private int loadCapacity;
    private int weight;
    private TruckBrand brand;
    private double odometer;
    private double fuelTankCapacity;
    private String model;
    @OneToOne
    @JoinColumn(name="trip_id")
    private Trip trip;

    public Truck(int manufactureYear, int loadCapacity, int weight, TruckBrand brand, double odometer, double fuelTankCapacity, String model) {
        this.manufactureYear = manufactureYear;
        this.loadCapacity = loadCapacity;
        this.weight = weight;
        this.brand = brand;
        this.odometer = odometer;
        this.fuelTankCapacity = fuelTankCapacity;
        this.model = model;
    }

    public String toString()
    {
        return this.model + " " + this.id;
    }
}
