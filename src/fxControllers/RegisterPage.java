package fxControllers;

import hibernateControllers.UserHibernate;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.persistence.EntityManagerFactory;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

import model.Driver;
import model.Manager;
import model.User;

public class RegisterPage implements Initializable {
    @FXML
    public TextField login;
    @FXML
    public TextField name;
    @FXML
    public TextField surname;
    @FXML
    public TextField email;
    @FXML
    public PasswordField password;
    @FXML
    public PasswordField repeatPas;
    @FXML
    public DatePicker birthDate;
    @FXML
    public TextField phoneNum;
    @FXML
    public TextField expYear;
    @FXML
    public TextField medCertificate;
    @FXML
    public TextField driverLicence;
    @FXML
    public Button registerUser;
    @FXML
    public Button returnToPrev;
    @FXML
    public RadioButton radioD;
    @FXML
    public ToggleGroup userType;
    @FXML
    public RadioButton radioM;
    @FXML
    public CheckBox isAdmin;
    @FXML
    public Label experience;

    private EntityManagerFactory emf;
    private UserHibernate userHibernate;
    public void setData(EntityManagerFactory emf){
        this.emf = emf;
        this.userHibernate = new UserHibernate(emf);
    }
    public void registerUser() throws IOException, SQLException {

        if (Objects.equals(password.getText(), repeatPas.getText())) {

            if (radioD.isSelected()) {
                Driver driver = new Driver(login.getText(), password.getText(), name.getText(), surname.getText(), email.getText(), birthDate.getValue(), Integer.parseInt(expYear.getText()), medCertificate.getText(), driverLicence.getText());
                userHibernate.createDiver(driver);
            } else {
                Manager manager = new Manager(login.getText(), password.getText(), name.getText(), surname.getText(), email.getText(), birthDate.getValue(), isAdmin.isSelected(), phoneNum.getText());
                userHibernate.createManager(manager);

            }
            returnToPrev();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("");
            alert.setHeaderText("");
            alert.setContentText("Passwords are different, try one more time");
            alert.showAndWait();

            repeatPas.setText("");
            password.setText("");
        }


    }

    public void returnToPrev() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginPage.class.getResource("../view/login-window.fxml"));

        Scene loginWindow = new Scene(fxmlLoader.load());
        loginWindow.getStylesheets().add(Objects.requireNonNull(getClass().getResource("../styles/login.css")).toExternalForm());

        Stage stage = (Stage) returnToPrev.getScene().getWindow();
        stage.setTitle("CompanyName");
        stage.setScene(loginWindow);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        radioD.setSelected(true);
        isAdmin.setVisible(false);
        DisableFields();
    }

    public void DisableFields() {
        if (radioD.isSelected()) {
            radioM.setSelected(false);
            medCertificate.setDisable(false);
            expYear.setDisable(false);
            driverLicence.setDisable(false);
            phoneNum.setDisable(true);
        } else {
            experience.setDisable(true);
            radioM.setSelected(true);
            medCertificate.setDisable(true);
            expYear.setDisable(true);
            driverLicence.setDisable(true);
            phoneNum.setDisable(false);
        }
    }
}
