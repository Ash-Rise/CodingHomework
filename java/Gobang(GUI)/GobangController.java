package cn.edu.ncu.lzc;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class GobangController {

    @FXML private Pane boardPane;
    @FXML private Label statusLabel;

    private int[][] board = new int[19][19];
    private int color = 1;
    private boolean gameOver = false;

    @FXML
    public void onStart() {
        boardPane.getChildren().clear();
        board = new int[19][19];
        color = 1;
        gameOver = false;
        statusLabel.setText("游戏开始");

        for (int i = 0; i < 19; i++) {
            Line hLine = new Line(30, 30 + i * 30, 30 + 18 * 30, 30 + i * 30);
            Line vLine = new Line(30 + i * 30, 30, 30 + i * 30, 30 + 18 * 30);
            boardPane.getChildren().addAll(hLine, vLine);
        }
    }

    @FXML
    public void onExit() {
        System.exit(0);
    }

    @FXML
    public void onBoardClick(MouseEvent e) {
        if (gameOver) return;

        int col = (int) Math.round((e.getX() - 30) / 30.0);
        int row = (int) Math.round((e.getY() - 30) / 30.0);

        if (col >= 0 && col < 19 && row >= 0 && row < 19) { 
            if (board[row][col] == 0) { // empty
                board[row][col] = color;
                
                Circle c = new Circle(30 + col * 30, 30 + row * 30, 12);
                if (color == 1) {
                    c.setFill(Color.BLACK);
                } else {
                    c.setFill(Color.WHITE);
                    c.setStroke(Color.BLACK); 
                }
                boardPane.getChildren().add(c);

                if (checkWin(row, col)) {
                    gameOver = true;
                    if (color == 1) {
                        statusLabel.setText("黑棋胜");
                    } else {
                        statusLabel.setText("白棋胜");
                    }
                } else {
                    color = 3 - color;
                }
            }
        }
    }

    private boolean checkWin(int r, int c) {
        int cur = board[r][c]; 
        
        if (count(r, c, 1, 0, cur) >= 5) return true;  // hor
        if (count(r, c, 0, 1, cur) >= 5) return true;  // ver
        if (count(r, c, 1, 1, cur) >= 5) return true;  // dg
        if (count(r, c, 1, -1, cur) >= 5) return true; // udg
        
        return false;
    }

    private int count(int r, int c, int dr, int dc, int player) {
        int cnt = 1; 
        
        for (int i = 1; i <= 4; i++) {
            int nr = r + dr * i, nc = c + dc * i;
            if (nr >= 0 && nr < 19 && nc >= 0 && nc < 19 && board[nr][nc] == player) cnt++;
            else break;
        }

        // backward
        for (int i = 1; i <= 4; i++) {
            int nr = r - dr * i, nc = c - dc * i;
            if (nr >= 0 && nr < 19 && nc >= 0 && nc < 19 && board[nr][nc] == player) cnt++;
            else break;
        }
        return cnt;
    }
}
