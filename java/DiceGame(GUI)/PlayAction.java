package cn.edu.ncu.lzc;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class PlayAction {
    @FXML
    private HBox hBox;
    @FXML
    private ImageView die1Image;
    @FXML
    private ImageView die2Image;

    @FXML
    public void play(){
        hBox.setVisible(true);
  
    }
}
