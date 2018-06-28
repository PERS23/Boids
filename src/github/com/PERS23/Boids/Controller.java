package github.com.PERS23.Boids;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private Environment mEnvironment;

    @FXML private Pane root;

    public Controller() {
        mEnvironment = new Environment();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        root.setOnMouseClicked(action -> {
            mEnvironment.addBoid(action.getX(), action.getY(), root);
        });

        root.widthProperty().addListener(((observable, oldValue, newValue) -> {
            mEnvironment.setContainerWidth((Double) newValue);
        }));

        root.heightProperty().addListener(((observable, oldValue, newValue) -> {
            mEnvironment.setContainerHeight((Double) newValue);
        }));

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(30), action -> {
            mEnvironment.update();
        }));

        timeline.play();
    }
}
