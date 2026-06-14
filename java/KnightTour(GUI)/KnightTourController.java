package cn.edu.ncu.lzc;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KnightTourController {
    boolean [][] vis = new boolean[10][10];
    int dx[] = {-2, -1, 1, 2, 2, 1, -1, -2};
    int dy[] = {1, 2, 2, 1, -1, -2, -2, -1};
    int[][] path = new int[65][2];
    boolean ok = false;

    @FXML
    private Pane boardPane;
    private Image knightImg;

    @FXML
    public void initialize() {
        knightImg = new Image(getClass().getResource("knight.png").toExternalForm());

        for (int row = 1; row <= 8; row++) {
            for (int col = 1; col <= 8; col++) {
                Rectangle r = new Rectangle((col - 1) * 50, (row - 1) * 50, 50, 50);
                r.setFill((row + col) % 2 == 0 ? Color.WHITE : Color.DARKGRAY);
                boardPane.getChildren().add(r);
            }
        }

        ImageView startMark = new ImageView(knightImg);
        startMark.setFitWidth(40);
        startMark.setFitHeight(40);
        startMark.setX(5);
        startMark.setY(5);
        boardPane.getChildren().add(startMark);
    }

    @FXML
    public void startTour() {
        initialize();
        dfs(1, 1, 1);
    }

    @FXML
    public void exitApp() {
        System.exit(0);
    }

    public void disp() {
        javafx.application.Platform.runLater(() -> {
            double s = 50.0;
            Timeline timeline = new Timeline();

            for (int i = 2; i <= 64; i++) {
                final int idx = i;
                KeyFrame kf = new KeyFrame(Duration.millis((i - 2) * 300), e -> {
                    int cx = path[idx][0];
                    int cy = path[idx][1];

                    ImageView iv = new ImageView(knightImg);
                    iv.setFitWidth(40);
                    iv.setFitHeight(40);
                    iv.setX((cy - 1) * s + 5);
                    iv.setY((cx - 1) * s + 5);
                    boardPane.getChildren().add(iv);
                });
                timeline.getKeyFrames().add(kf);
            }
            timeline.play();
        });
    }

    public boolean check(int x, int y) {
        return x >= 1 && x <= 8 && y >= 1 && y <= 8;
    }

    public int getDegree(int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            int tx = x + dx[i], ty = y + dy[i];
            if (check(tx, ty) && !vis[tx][ty]) {
                cnt++;
            }
        }
        return cnt;
    }

    public void dfs(int x, int y, int cnt) {
        path[cnt][0] = x;
        path[cnt][1] = y;
        
        if (cnt == 64) {
            disp();
            ok = true;
            return;
        }

        vis[x][y] = true;

        List<int[]> nxt = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            int tx = x + dx[i], ty = y + dy[i];
            if (check(tx, ty) && !vis[tx][ty]) {
                nxt.add(new int[]{tx, ty, getDegree(tx, ty)});
            }
        }
        Collections.sort(nxt, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[2] - b[2];
            }
        });

        for (int[] move : nxt) {
            dfs(move[0], move[1], cnt + 1);
            if(ok) return;
        }

        vis[x][y] = false;
    }
}
