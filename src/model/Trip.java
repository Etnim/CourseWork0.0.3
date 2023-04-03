package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity

public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tripTitle;
    private String startPoint;
    private long startLn;
    private long startLat;
    private String endPoint;
    private long endLn;
    private long endLat;
    private Status status;
    private LocalDate dateCreated;
    private LocalDate dateUpdated;
    @OneToOne(mappedBy = "trip")
    private Cargo cargo;
    @OneToOne(mappedBy = "trip")
    private Truck truck;
    @OneToOne(mappedBy = "trip")
    private Driver driver;
    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
    private List<Manager> managers;
    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
    private List<CheckPoint> checkPointList;


    public Trip(String title, String startPoint, long startLn, long startLat, String endPoint, long endLn, long endLat, List<CheckPoint> checkPointList, Cargo cargo, Truck truck) {
        this.tripTitle = title;
        this.startPoint = startPoint;
        this.startLn = startLn;
        this.startLat = startLat;
        this.endPoint = endPoint;
        this.endLn = endLn;
        this.endLat = endLat;
        this.checkPointList = checkPointList;
        this.cargo = cargo;
        this.truck = truck;
        this.status = Status.UNSIGNED;
    }

    public Trip(String startPoint, long startLn, long startLat, String endPoint, long endLn, long endLat, List<CheckPoint> checkPointList, Truck truck, List<Manager> managers, Cargo cargo, Driver driver) {
        this.startPoint = startPoint;
        this.startLn = startLn;
        this.startLat = startLat;
        this.endPoint = endPoint;
        this.endLn = endLn;
        this.endLat = endLat;
        this.checkPointList = checkPointList;
        this.truck = truck;
        this.cargo = cargo;
        this.driver = driver;
        this.managers = managers;
        this.status = Status.SIGNED;
    }

    public String toString()
    {
        return this.tripTitle + " " + this.id;
    }

}
