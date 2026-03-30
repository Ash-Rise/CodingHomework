package cn.edu.ncu.lzc;

import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TestController {
    private static final double VIEW_W = 140;
    private static final double VIEW_H = 140;
    private static final double START_X = 50;
    private static final double START_Y = 45;
    private static final double STEP_X = 190;
    private static final double STEP_Y = 185;

    private final DiceGame game = new DiceGame();

    @FXML
    private HBox hBox;
    @FXML
    private ImageView die1Image;
    @FXML
    private ImageView die2Image;
    @FXML
    private Label statusLabel;
    @FXML
    private TextArea recordArea;

    @FXML
    public void initialize() {
        statusLabel.setText("双骰子游戏：点击掷骰子开始");
        recordArea.clear();
    }

    @FXML
    public void rollButtonListener() {
        String result = game.play();
        int die1 = game.getFirst();
        int die2 = game.getSecond();

        hBox.setVisible(true);
        die1Image.setViewport(faceViewport(die1));
        die2Image.setViewport(faceViewport(die2));

        recordArea.appendText(die1 + "+" + die2 + "=" + game.getPoints() + System.lineSeparator());

        if ("WIN".equals(result)) {
            statusLabel.setText("结果：WIN");
        } else if ("LOSE".equals(result)) {
            statusLabel.setText("结果：LOSE");
        } else {
            statusLabel.setText("结果：GOON");
        }
    }

    @FXML
    public void exitButtonListener() {
        Stage stage = (Stage) hBox.getScene().getWindow();
        stage.close();
    }

    private Rectangle2D faceViewport(int value) {
        int index = Math.max(1, Math.min(6, value)) - 1;
        int col = index % 3;
        int row = index / 3;
        double x = START_X + col * STEP_X;
        double y = START_Y + row * STEP_Y;
        return new Rectangle2D(x, y, VIEW_W, VIEW_H);
    }
}
