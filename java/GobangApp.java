package cn.edu.ncu.lzc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GobangApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Gobang.fxml"));
        primaryStage.setTitle("五子棋");
        primaryStage.setScene(new Scene(root, 750, 650));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}