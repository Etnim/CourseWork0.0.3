package fxControllers;

import hibernateControllers.HibernateControllers;
import hibernateControllers.UserHibernate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.*;

import javax.persistence.EntityManagerFactory;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainPage implements Initializable {
    private final ObservableList<DriverTable> driverData = FXCollections.observableArrayList();
    private final ObservableList<ManagerTable> managerData = FXCollections.observableArrayList();
    @FXML
    public Tab truckTub;
    @FXML
    public Tab cargoTub;
    @FXML
    public Tab tripTub;

    //Cargo
    @FXML
    public Tab forumTub;
    @FXML
    public Button profileBut;
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


    //Truck
    @FXML
    public Button cargoReset;
    @FXML
    public Button deleteCargo;
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


    //Checkpoint
    @FXML
    public Button updateTruck;
    @FXML
    public ListView<Truck> truckListField;
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
    @FXML
    public Button forumBut;


    @FXML
    public Tab managerTub;
    @FXML
    public TableView<ManagerTable> managerTableView;
    @FXML
    public TableColumn<ManagerTable, Integer> mColId;
    @FXML
    public TableColumn<ManagerTable, String> mColLog;
    @FXML
    public TableColumn<ManagerTable, String> mColName;
    @FXML
    public TableColumn<ManagerTable, String> mColSurname;
    @FXML
    public TableColumn<ManagerTable, String> mColEmail;
    @FXML
    public TableColumn<ManagerTable, Boolean> mColIsAdmin;
    @FXML
    public TableColumn<ManagerTable, String> mColPhone;


    @FXML
    public Tab driverTub;
    @FXML
    public TableView<DriverTable> driverTableView;
    @FXML
    public TableColumn<DriverTable, Integer> dColId;
    @FXML
    public TableColumn<DriverTable, String> dColLog;
    @FXML
    public TableColumn<DriverTable, String> dColName;
    @FXML
    public TableColumn<DriverTable, String> dColSurname;
    @FXML
    public TableColumn<DriverTable, String> dColEmail;
    @FXML
    public TableColumn<DriverTable, LocalDate> dColBirth;
    @FXML
    public TableColumn<DriverTable, String> dColLicense;
    @FXML
    public TableColumn<DriverTable, String> dColCertificate;
    private EntityManagerFactory emf;
    private UserHibernate userHibernate;
    private HibernateControllers hibControllers;
    private User loggedUser;

    public void addCargo() {
        Cargo cargo;
        if (cargoDescription.getText().length() == 0) {
            cargo = new Cargo(Integer.parseInt(cargoWeight.getText()), Integer.parseInt(cargoVolume.getText()), Integer.parseInt(cargoPrice.getText()), cargoTitle.getText(), cargoType.getSelectionModel().getSelectedItem());
        } else {
            cargo = new Cargo(Integer.parseInt(cargoWeight.getText()), Integer.parseInt(cargoVolume.getText()), Integer.parseInt(cargoPrice.getText()), cargoTitle.getText(), cargoType.getSelectionModel().getSelectedItem(), cargoDescription.getText());
        }
        hibControllers.create(cargo);
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
        hibControllers.update(cargo);
        int index = cargoListField.getSelectionModel().getSelectedIndex();
        cargoListField.getItems().set(index, cargo);
        cargoListField.refresh();

        tripCargoList.getItems().set(index, cargo);
        tripCargoList.refresh();
    }

    public void deleteCargo() {
        int index = cargoListField.getSelectionModel().getSelectedIndex();
        cargoListField.getItems().remove(index);
        hibControllers.delete(cargoListField.getSelectionModel().getSelectedItem());

        tripCargoList.getItems().remove(index);
    }


    public void addTruck() {
        Truck truck = new Truck(Integer.parseInt(truckManufactureYear.getText()), Integer.parseInt(truckLoadCapacity.getText()), Integer.parseInt(truckWeight.getText()), truckBrand.getSelectionModel().getSelectedItem(), Double.parseDouble(truckOdometer.getText()), Double.parseDouble(truckFuelTankCapacity.getText()), truckModel.getText());
        hibControllers.create(truck);
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
        hibControllers.delete(truckListField.getSelectionModel().getSelectedItem());

        tripTruckList.getItems().remove(index);
    }

    public void updateTruck(ActionEvent actionEvent) {
        Truck truck = new Truck(Integer.parseInt(truckManufactureYear.getText()), Integer.parseInt(truckLoadCapacity.getText()), Integer.parseInt(truckWeight.getText()), truckBrand.getSelectionModel().getSelectedItem(), Double.parseDouble(truckOdometer.getText()), Double.parseDouble(truckFuelTankCapacity.getText()), truckModel.getText());
        int index = truckListField.getSelectionModel().getSelectedIndex();
        hibControllers.update(truck);

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
        hibControllers.create(checkPoint);
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
        hibControllers.update(checkPoint);
        int index = checkpointListField.getSelectionModel().getSelectedIndex();
        checkpointListField.getItems().set(index, checkPoint);
        checkpointListField.refresh();

        tripCheckList.getItems().set(index, checkPoint);
        tripCheckList.refresh();
    }

    public void checkpointDelete() {
        int index = checkpointListField.getSelectionModel().getSelectedIndex();
        checkpointListField.getItems().remove(index);

        hibControllers.delete(checkpointListField.getSelectionModel().getSelectedItem());

        tripCheckList.getItems().remove(index);
    }


    public void addTrip(ActionEvent actionEvent) {
        Trip trip = new Trip(tripTitle.getText(), startPointTitle.getText(), Integer.parseInt(startLn.getText()), Integer.parseInt(startLat.getText()), endPointTitle.getText(), Integer.parseInt(endLn.getText()), Integer.parseInt(endLat.getText()), tripCheckList.getSelectionModel().getSelectedItems(), tripCargoList.getSelectionModel().getSelectedItem(), tripTruckList.getSelectionModel().getSelectedItem());

        hibControllers.create(trip);
        tripListField.getItems().add(trip);
    }

    public void deleteTrip(ActionEvent actionEvent) {

        int index = tripListField.getSelectionModel().getSelectedIndex();
        tripListField.getItems().remove(index);

        hibControllers.delete(tripListField.getSelectionModel().getSelectedItem());
    }

    public void resetTrip(ActionEvent actionEvent) {

    }

    public void updateTrip(ActionEvent actionEvent) {
        Trip trip = new Trip(tripTitle.getText(), startPointTitle.getText(), Integer.parseInt(startLn.getText()), Integer.parseInt(startLat.getText()), endPointTitle.getText(), Integer.parseInt(endLn.getText()), Integer.parseInt(endLat.getText()), tripCheckList.getSelectionModel().getSelectedItems(), tripCargoList.getSelectionModel().getSelectedItem(), tripTruckList.getSelectionModel().getSelectedItem());

        hibControllers.update(trip);
        int index = tripListField.getSelectionModel().getSelectedIndex();
        tripListField.getItems().set(index, trip);
        tripListField.refresh();
    }


    public void openForum(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainPage.class.getResource("../view/forum-window.fxml"));
        Parent parent = fxmlLoader.load();

        Scene scene = new Scene(parent);

        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("../styles/login" + ".css")).toExternalForm());
        Stage stage = (Stage) forumBut.getScene().getWindow();
        stage.setTitle("Registration form");
        stage.setScene(scene);
        stage.show();
    }

    public void openProfile(ActionEvent actionEvent) {
    }

    public void setInfo(User user) {
        this.loggedUser = user;
    }

    public void setData(EntityManagerFactory emf) {
        this.emf = emf;
        this.userHibernate = new UserHibernate(emf);
        this.hibControllers = new HibernateControllers(emf);

        cargoListField.getItems().addAll(hibControllers.getAllrecords(Cargo.class));
        checkpointListField.getItems().addAll(hibControllers.getAllrecords(CheckPoint.class));
        truckListField.getItems().addAll(hibControllers.getAllrecords(Truck.class));
        tripListField.getItems().addAll(hibControllers.getAllrecords(Trip.class));

        tripCargoList.getItems().addAll(hibControllers.getAllrecords(Cargo.class));
        tripCheckList.getItems().addAll(hibControllers.getAllrecords(CheckPoint.class));
        tripTruckList.getItems().addAll(hibControllers.getAllrecords(Truck.class));
        tripManagerList.getItems().addAll(userHibernate.getAllManagers());
        tripDriverList.getItems().addAll(userHibernate.getAllDrivers());

        LoadDriverData();
        LoadManagerData();
    }

    private void LoadDriverData() {
        List<Driver> driverList = userHibernate.getAllDrivers();

        for (Driver d : driverList) {
            DriverTable driverTable = new DriverTable();
            driverTable.setColId(d.getId());
            driverTable.setColName(d.getName());
            driverTable.setColSurname(d.getSurname());
            driverTable.setColLog(d.getLogin());
            driverTable.setColEmail(d.getEmail());
            driverTable.setColBirth(d.getBirthDate().toString());
            driverTable.setColCertificate(d.getMedCertificateNum());
            driverTable.setColLicense(d.getDriveLicenseNum());
            driverData.add(driverTable);
        }
        driverTableView.setItems(driverData);
    }

    private void LoadManagerData() {
        List<Manager> managerList = userHibernate.getAllManagers();

        for (Manager m : managerList) {
            ManagerTable managerTable = new ManagerTable();
            managerTable.setColId(m.getId());
            managerTable.setColName(m.getName());
            managerTable.setColSurname(m.getSurname());
            managerTable.setColLog(m.getLogin());
            managerTable.setColEmail(m.getEmail());
            managerTable.setColIsAdmin(m.isAdmin());
            managerTable.setColPhone(m.getPhoneNum());
            managerData.add(managerTable);
        }

        managerTableView.setItems(managerData);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.cargoType.getItems().setAll(Arrays.asList(CargoType.values()));
        this.truckBrand.getItems().setAll(Arrays.asList(TruckBrand.values()));


        driverTableView.setEditable(true);
        dColId.setCellValueFactory(new PropertyValueFactory<>("colId"));
        dColLog.setCellValueFactory(new PropertyValueFactory<>("colLog"));
        dColName.setCellValueFactory(new PropertyValueFactory<>("colName"));
        dColSurname.setCellValueFactory(new PropertyValueFactory<>("colSurname"));
        dColEmail.setCellValueFactory(new PropertyValueFactory<>("colEmail"));
        dColBirth.setCellValueFactory(new PropertyValueFactory<>("colBirth"));
        dColLicense.setCellValueFactory(new PropertyValueFactory<>("colLicense"));
        dColCertificate.setCellValueFactory(new PropertyValueFactory<>("colCertificate"));


        managerTableView.setEditable(true);
        mColId.setCellValueFactory(new PropertyValueFactory<>("colId"));
        mColLog.setCellValueFactory(new PropertyValueFactory<>("colLog"));
        mColName.setCellValueFactory(new PropertyValueFactory<>("colName"));
        mColSurname.setCellValueFactory(new PropertyValueFactory<>("colSurname"));
        mColEmail.setCellValueFactory(new PropertyValueFactory<>("colEmail"));
        mColIsAdmin.setCellValueFactory(new PropertyValueFactory<>("colIsAdmin"));
        mColPhone.setCellValueFactory(new PropertyValueFactory<>("colPhone"));
    }
}


