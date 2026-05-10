package cn.edu.ncu.lzc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ColorChallengeApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane root = FXMLLoader.load(getClass().getResource("ColorChallenge.fxml"));
        Scene scene = new Scene(root, 520, 420);
        stage.setTitle("颜色大挑战");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
