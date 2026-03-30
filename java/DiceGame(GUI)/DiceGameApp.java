package cn.edu.ncu.lzc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class DiceGameApp extends Application{

    @Override
    public void start(Stage arg0) throws Exception {
        new FXMLLoader();
        BorderPane root = FXMLLoader.load(getClass().getResource("Test.fxml"));
        Scene s = new Scene(root, 800,600);
        arg0.setScene(s);
        arg0.show();
    }

    public static void main(String[] args){
        launch(args);
    }

}
