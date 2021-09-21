import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class VehicleProfileUIController {
    public VehicleProfileUIController() throws IOException {
    }

    public void openAudiProfileOnAction(ActionEvent actionEvent) throws IOException {

        loadUi("AudiProfile.fxml");


    }

    public void openBmwProfileOnAction(ActionEvent actionEvent) throws IOException {
        loadUi("BmwProfile.fxml");

    }
    private void loadUi(String location) throws IOException {
//        URL resource = getClass().getResource(location + ".fxml");
//        Parent load = FXMLLoader.load(resource);
//        Scene scene = new Scene(load);
//        Stage stage = new Stage();
//        stage.setScene(scene);
//        stage.show();
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource(location + ".fxml"))));
        stage.show();

    }



}
