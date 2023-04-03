import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class StartApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartApp.class.getResource("view/login-window.fxml"));
        Scene loginWindow = new Scene(fxmlLoader.load());
        loginWindow.getStylesheets().add(Objects.requireNonNull(getClass().getResource("styles/login.css")).toExternalForm());
        stage.setTitle("CompanyName");
        stage.setScene(loginWindow);
        stage.show();
    }
    public static void main(String[] args){launch();}
}