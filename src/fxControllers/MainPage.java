package fxControllers;

import hibernateControllers.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.*;

import javax.persistence.EntityManagerFactory;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainPage implements Initializable {
    @FXML
    public Tab truckTub;
    @FXML
    public Tab cargoTub;
    @FXML
    public Tab tripTub;
    @FXML
    public Tab forumTub;
    @FXML
    public Button profileBut;

    //Cargo

    @FXML
    public TextField cargoWeight;
    @FXML
    public TextField cargoVolume;
    @FXML
    public TextField cargoPrice;
    @FXML
    public TextField cargoTitle;
    @FXML
    public ComboBox<CargoType> cargoType = new ComboBox<>();
    @FXML
    public TextField cargoDescription;
    @FXML
    public Button addCargoBut;
    public ListView<Cargo> cargoListField;
    @FXML
    public Button cargoResetBut;
    @FXML
    public Button updateCargo;
    @FXML
    public Button cargoReset;
    @FXML
    public Button deleteCargo;


    //Truck

    @FXML
    public TextField truckManufactureYear;
    @FXML
    public TextField truckFuelTankCapacity;
    @FXML
    public TextField truckModel;
    @FXML
    public TextField truckOdometer;
    @FXML
    public TextField truckLoadCapacity;
    @FXML
    public TextField truckWeight;
    @FXML
    public ComboBox<TruckBrand> truckBrand;
    @FXML
    public Button addTruck;
    @FXML
    public Button truckResetBut;
    @FXML
    public Button deleteTruck;
    @FXML
    public Button updateTruck;
    @FXML
    public ListView<Truck> truckListField;


    //Checkpoint

    @FXML
    public TextField checkpointTitle;
    @FXML
    public TextField checkpointDur;
    @FXML
    public DatePicker checkpointArrived;
    @FXML
    public Button addCheckpoint;
    @FXML
    public Button resetCheckpoint;
    @FXML
    public Button updateCheckpoint;
    @FXML
    public ListView<CheckPoint> checkpointListField;


    //Trip
    @FXML
    public TextField startPointTitle;
    @FXML
    public TextField endPointTitle;
    @FXML
    public TextField startLn;
    @FXML
    public TextField startLat;
    @FXML
    public TextField endLn;
    @FXML
    public TextField endLat;
    @FXML
    public TextField tripTitle;
    @FXML
    public ListView<Trip> tripListField;
    @FXML
    public Button deleteTrip;
    @FXML
    public Button resetTrip;
    @FXML
    public Button updateTrip;
    @FXML
    public Button addTrip;
    @FXML
    public ListView<Cargo> tripCargoList;
    @FXML
    public ListView<Driver> tripDriverList;
    @FXML
    public ListView<Truck> tripTruckList;
    @FXML
    public ListView<Manager> tripManagerList;
    @FXML
    public ListView<CheckPoint> tripCheckList;
    public Button forumBut;


    private EntityManagerFactory emf;
    private UserHibernate userHibernate;
    private CargoHibernate cargoHibernate;
    private CheckpointHibernate checkpointHibernate;
    private TripHibernate tripHibernate;
    private TruckHibernate truckHibernate;


    private User loggedUser;


    public void setData(EntityManagerFactory emf) {
        this.emf = emf;
        this.userHibernate = new UserHibernate(emf);
        this.cargoHibernate = new CargoHibernate(emf);
        this.checkpointHibernate = new CheckpointHibernate(emf);
        this.truckHibernate = new TruckHibernate(emf);
        this.tripHibernate = new TripHibernate(emf);

        cargoListField.getItems().addAll(cargoHibernate.getAllItems());
        checkpointListField.getItems().addAll(checkpointHibernate.getAllItems());
        truckListField.getItems().addAll(truckHibernate.getAllItems());
        tripListField.getItems().addAll(tripHibernate.getAllItems());

        tripCargoList.getItems().addAll(cargoHibernate.getAllItems());
        tripCheckList.getItems().addAll(checkpointHibernate.getAllItems());
        tripTruckList.getItems().addAll(truckHibernate.getAllItems());
        tripManagerList.getItems().addAll(userHibernate.getAllManagers());
        tripDriverList.getItems().addAll(userHibernate.getAllDrivers());
    }

    public void setInfo(User user) {
        this.loggedUser = user;
    }

    public void addCargo() {
        Cargo cargo;
        if (cargoDescription.getText().length() == 0) {
            cargo = new Cargo(Integer.parseInt(cargoWeight.getText()), Integer.parseInt(cargoVolume.getText()), Integer.parseInt(cargoPrice.getText()), cargoTitle.getText(), cargoType.getSelectionModel().getSelectedItem());
        } else {
            cargo = new Cargo(Integer.parseInt(cargoWeight.getText()), Integer.parseInt(cargoVolume.getText()), Integer.parseInt(cargoPrice.getText()), cargoTitle.getText(), cargoType.getSelectionModel().getSelectedItem(), cargoDescription.getText());
        }
        cargoHibernate.createCargo(cargo);
        cargoListField.getItems().add(cargo);

        tripCargoList.getItems().add(cargo);
    }

    public void resetCargo() {
        cargoWeight.setText("");
        cargoVolume.setText("");
        cargoPrice.setText("");
        cargoTitle.setText("");
    }

    public void updateCargo() {
        Cargo cargo;
        if (cargoDescription.getText().length() == 0) {
            cargo = new Cargo(Integer.parseInt(cargoWeight.getText()), Integer.parseInt(cargoVolume.getText()), Integer.parseInt(cargoPrice.getText()), cargoTitle.getText(), cargoType.getSelectionModel().getSelectedItem());
        } else {
            cargo = new Cargo(Integer.parseInt(cargoWeight.getText()), Integer.parseInt(cargoVolume.getText()), Integer.parseInt(cargoPrice.getText()), cargoTitle.getText(), cargoType.getSelectionModel().getSelectedItem(), cargoDescription.getText());
        }
        cargoHibernate.updateCargo(cargo);
        int index = cargoListField.getSelectionModel().getSelectedIndex();
        cargoListField.getItems().set(index, cargo);
        cargoListField.refresh();

        tripCargoList.getItems().set(index, cargo);
        tripCargoList.refresh();
    }

    public void deleteCargo() {
        int index = cargoListField.getSelectionModel().getSelectedIndex();
        cargoListField.getItems().remove(index);
        cargoHibernate.deleteCargo(cargoListField.getSelectionModel().getSelectedItem());

        tripCargoList.getItems().remove(index);
    }


    public void addTruck() {
        Truck truck = new Truck(Integer.parseInt(truckManufactureYear.getText()), Integer.parseInt(truckLoadCapacity.getText()), Integer.parseInt(truckWeight.getText()), truckBrand.getSelectionModel().getSelectedItem(), Double.parseDouble(truckOdometer.getText()), Double.parseDouble(truckFuelTankCapacity.getText()), truckModel.getText());
        truckHibernate.createTruck(truck);
        truckListField.getItems().add(truck);

        tripTruckList.getItems().add(truck);
    }

    public void resetTruck() {
        truckManufactureYear.setText("");
        truckModel.setText("");
        truckLoadCapacity.setText("");
        truckFuelTankCapacity.setText("");
        truckOdometer.setText("");
        truckWeight.setText("");
    }

    public void deleteTruck(ActionEvent actionEvent) {
        int index = truckListField.getSelectionModel().getSelectedIndex();
        truckListField.getItems().remove(index);
        truckHibernate.deleteTruck(truckListField.getSelectionModel().getSelectedItem());

        tripTruckList.getItems().remove(index);
    }

    public void updateTruck(ActionEvent actionEvent) {
        Truck truck = new Truck(Integer.parseInt(truckManufactureYear.getText()), Integer.parseInt(truckLoadCapacity.getText()), Integer.parseInt(truckWeight.getText()), truckBrand.getSelectionModel().getSelectedItem(), Double.parseDouble(truckOdometer.getText()), Double.parseDouble(truckFuelTankCapacity.getText()), truckModel.getText());
        int index = truckListField.getSelectionModel().getSelectedIndex();
        truckHibernate.updateTruck(truck);

        truckListField.getItems().set(index, truck);
        truckListField.refresh();

        tripTruckList.getItems().set(index, truck);
        tripTruckList.refresh();
    }

    public void addCheckpoint() {
        CheckPoint checkPoint;
        if (checkpointArrived.getValue() == null) {
            checkPoint = new CheckPoint(Integer.parseInt(checkpointDur.getText()), checkpointTitle.getText());

        } else {
            checkPoint = new CheckPoint(Integer.parseInt(checkpointDur.getText()), checkpointArrived.getValue(), checkpointTitle.getText());
        }
        checkpointHibernate.createCheckPoint(checkPoint);
        checkpointListField.getItems().add(checkPoint);

        tripCheckList.getItems().add(checkPoint);
    }

    public void resetCheckpoint(ActionEvent actionEvent) {
        checkpointDur.setText("");
        checkpointTitle.setText("");
        checkpointArrived.setAccessibleText("");
    }

    public void updateCheckpoint(ActionEvent actionEvent) {
        CheckPoint checkPoint;

        if (checkpointArrived.getValue() == null) {
            checkPoint = new CheckPoint(Integer.parseInt(checkpointDur.getText()), checkpointTitle.getText());

        } else {
            checkPoint = new CheckPoint(Integer.parseInt(checkpointDur.getText()), checkpointArrived.getValue(), checkpointTitle.getText());
        }
        checkpointHibernate.updateCheckPoint(checkPoint);
        int index = checkpointListField.getSelectionModel().getSelectedIndex();
        checkpointListField.getItems().set(index, checkPoint);
        checkpointListField.refresh();

        tripCheckList.getItems().set(index, checkPoint);
        tripCheckList.refresh();
    }

    public void checkpointDelete() {
        int index = checkpointListField.getSelectionModel().getSelectedIndex();
        checkpointListField.getItems().remove(index);

        checkpointHibernate.deleteCheckPoint(checkpointListField.getSelectionModel().getSelectedItem());

        tripCheckList.getItems().remove(index);
    }


    public void addTrip(ActionEvent actionEvent) {
        Trip trip = new Trip(tripTitle.getText(), startPointTitle.getText(), Integer.parseInt(startLn.getText()), Integer.parseInt(startLat.getText()), endPointTitle.getText(), Integer.parseInt(endLn.getText()), Integer.parseInt(endLat.getText()), tripCheckList.getSelectionModel().getSelectedItems(), tripCargoList.getSelectionModel().getSelectedItem(), tripTruckList.getSelectionModel().getSelectedItem());

        tripHibernate.createTrip(trip);
        tripListField.getItems().add(trip);
    }

    public void deleteTrip(ActionEvent actionEvent) {

        int index = tripListField.getSelectionModel().getSelectedIndex();
        tripListField.getItems().remove(index);

        tripHibernate.deleteTrip(tripListField.getSelectionModel().getSelectedItem());
    }

    public void resetTrip(ActionEvent actionEvent) {

    }

    public void updateTrip(ActionEvent actionEvent) {
        Trip trip = new Trip(tripTitle.getText(), startPointTitle.getText(), Integer.parseInt(startLn.getText()), Integer.parseInt(startLat.getText()), endPointTitle.getText(), Integer.parseInt(endLn.getText()), Integer.parseInt(endLat.getText()), tripCheckList.getSelectionModel().getSelectedItems(), tripCargoList.getSelectionModel().getSelectedItem(), tripTruckList.getSelectionModel().getSelectedItem());

        tripHibernate.updateTrip(trip);
        int index = tripListField.getSelectionModel().getSelectedIndex();
        tripListField.getItems().set(index, trip);
        tripListField.refresh();
    }

    public void initialize(URL location, ResourceBundle resources) {
        this.cargoType.getItems().setAll(Arrays.asList(CargoType.values()));
        this.truckBrand.getItems().setAll(Arrays.asList(TruckBrand.values()));

    }

    public void openForum(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainPage.class.getResource("../view/forum-window.fxml"));
        Parent parent = fxmlLoader.load();

        Scene scene = new Scene(parent);

        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("../styles/login" +
                ".css")).toExternalForm());
        Stage stage = (Stage) forumBut.getScene().getWindow();
        stage.setTitle("Registration form");
        stage.setScene(scene);
        stage.show();
    }

    public void openProfile(ActionEvent actionEvent) {
    }
}


