package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity

public class Trip implements Serializable {
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
    private LocalDate dateCreated;
    private LocalDate dateUpdated;

    @OneToOne(mappedBy = "tripC", cascade = CascadeType.ALL,orphanRemoval = true)
    private Cargo cargo;
    @OneToOne(mappedBy = "tripT", cascade = CascadeType.ALL,orphanRemoval = true)
    private Truck truck;
    @OneToOne(mappedBy = "tripD", cascade = CascadeType.ALL,orphanRemoval = true)
    private Driver driver;
    @OneToMany(mappedBy = "tripM", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Manager> managers;
    @OneToMany(mappedBy = "tripCh", cascade = CascadeType.ALL,orphanRemoval = true)
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
        this.dateCreated = LocalDate.now();
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
        this.dateCreated = LocalDate.now();
    }

    public String toString()
    {
        return this.tripTitle + " " + this.id;
    }

}
