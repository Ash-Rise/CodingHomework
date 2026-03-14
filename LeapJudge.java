package cn.edu.ncu.lzc;

import java.util.Scanner;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class LeapJudge extends Application{
    public void start(Stage args) throws Exception{
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        String s;
        in.close();
        boolean isLeap =(year % 4 == 0);
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("闰年检测器");
        if(isLeap) s = "年是闰年!";
        else s = "年不是闰年!"; 
        alert.setHeaderText(year + s);
        alert.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
