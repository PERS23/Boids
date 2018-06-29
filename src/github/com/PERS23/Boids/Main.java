package github.com.PERS23.Boids;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("BoidContainer.fxml"));
        primaryStage.setTitle("B O I D S");
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.getIcons().add(new Image("img/icon.PNG"));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
