package fxControllers;

import hibernateControllers.UserHibernate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.User;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class LoginPage {
    @FXML
    public AnchorPane anchor;
    @FXML
    public TextField login;
    @FXML
    public PasswordField password;
    @FXML
    public Button signInBut;
    @FXML
    public Button loginBut;
    @FXML
    public Button forgotBut;
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TransportSystem2");
    private UserHibernate userHibernate;

    public void setData(EntityManagerFactory emf) {
        this.entityManagerFactory = emf;
        this.userHibernate = new UserHibernate(emf);
    }

    public void logIn() throws IOException, SQLException {
        setData(entityManagerFactory);

        User user = userHibernate.validateUser(login.getText(), password.getText());
        if (user != null) {
            FXMLLoader fxmlLoader = new FXMLLoader(LoginPage.class.getResource("../view/main-window.fxml"));

            Parent parent = fxmlLoader.load();

            MainPage mainpage = fxmlLoader.getController();
            mainpage.setData(entityManagerFactory);
            mainpage.setInfo(user);

            Scene scene = new Scene(parent);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("../styles/mainPage.css")).toExternalForm());

            Stage stage = (Stage) loginBut.getScene().getWindow();
            stage.setTitle("CompanyName");
            stage.setScene(scene);
            stage.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("");
            alert.setHeaderText("");
            alert.setContentText("Wrong login or password, please try again");
            alert.showAndWait();
            login.setText("");
            password.setText("");
        }
    }


    public void signUp(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginPage.class.getResource("../view/register-window.fxml"));
        Parent parent = fxmlLoader.load();
        RegisterPage registerPage = fxmlLoader.getController();
        registerPage.setData(entityManagerFactory);

        Scene scene = new Scene(parent);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("../styles/registerPage.css")).toExternalForm());
        Stage stage = (Stage) loginBut.getScene().getWindow();
        stage.setTitle("Registration form");
        stage.setScene(scene);
        stage.show();
    }


}
