package github.com.PERS23.Boids;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private final int MIN_TICK_DURATION = 30;

    private Environment mEnvironment = new Environment();

    @FXML private Pane root;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        root.setOnMousePressed(action -> {
            if (action.isPrimaryButtonDown()) {
                mEnvironment.addBoid(action.getX(), action.getY(), root);
            } else if (action.isSecondaryButtonDown()) {
                mEnvironment.addObstacle(action.getX(), action.getY(), root);
            }
        });

        root.widthProperty().addListener(((observable, oldValue, newValue) -> {
            mEnvironment.setContainerWidth((Double) newValue);
        }));

        root.heightProperty().addListener(((observable, oldValue, newValue) -> {
            mEnvironment.setContainerHeight((Double) newValue);
        }));

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(MIN_TICK_DURATION), action -> {
            mEnvironment.update();
        }));

        timeline.play();
    }
}
