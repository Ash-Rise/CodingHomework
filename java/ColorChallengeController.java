package cn.edu.ncu.lzc;

import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class ColorChallengeController {
    @FXML
    private GridPane boardPane;
    @FXML
    private Label levelLabel;
    @FXML
    private Label tipLabel;

    private Random random = new Random();

    private int rows = 3;
    private int cols = 4;
    private int total = rows * cols;

    private int level = 1;
    private int answerIndex = 0;

    @FXML
    public void initialize() {
        nextRound();
    }

    private void nextRound() {
        boardPane.getChildren().clear();

        int diff = 60 - (level - 1) * 4;
        if (diff < 6) {
            diff = 6;
        }

        int r = 40 + random.nextInt(176);
        int g = 40 + random.nextInt(176);
        int b = 40 + random.nextInt(176);

        int channel = random.nextInt(3);
        int sign = random.nextBoolean() ? 1 : -1;

        int r2 = r;
        int g2 = g;
        int b2 = b;

        if (channel == 0) {
            r2 = limit(r + sign * diff);
        } else if (channel == 1) {
            g2 = limit(g + sign * diff);
        } else {
            b2 = limit(b + sign * diff);
        }

        Color baseColor = Color.rgb(r, g, b);
        Color specialColor = Color.rgb(r2, g2, b2);

        answerIndex = random.nextInt(total);

        int index = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Circle c = new Circle(34);
                c.setStroke(Color.GRAY);

                if (index == answerIndex) {
                    c.setFill(specialColor);
                } else {
                    c.setFill(baseColor);
                }

                int clickIndex = index;
                c.setOnMouseClicked(e -> check(clickIndex));

                boardPane.add(c, col, row);
                index++;
            }
        }

        levelLabel.setText("第 " + level + " 关");
        tipLabel.setText("找出颜色不同的圆（diff: " + diff + "）");
    }

    private void check(int clickIndex) {
        if (clickIndex == answerIndex) {
            level++;
            tipLabel.setText("恭喜你, 答对了!");
            nextRound();
        } else {
            level = 1;
            nextRound();
            tipLabel.setText("胜败乃兵家常事, 大侠请重新来过");
        }
    }

    private int limit(int x) {
        if (x < 0) {
            return 0;
        }
        if (x > 255) {
            return 255;
        }
        return x;
    }
}
