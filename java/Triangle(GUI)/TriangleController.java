package cn.edu.ncu.lzc;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;

public class TriangleController {

    @FXML private TextField tfAx;
    @FXML private TextField tfAy;
    @FXML private TextField tfBx;
    @FXML private TextField tfBy;
    @FXML private TextField tfCx;
    @FXML private TextField tfCy;

    @FXML private Pane drawPane;
    @FXML private Label resultLabel;

    private Polygon p1 = new Polygon();
    private Text tA = new Text();
    private Text tB = new Text();
    private Text tC = new Text();

    private double lastX, lastY;

    @FXML
    public void initialize() {
        drawPane.getChildren().addAll(p1, tA, tB, tC);
        p1.setFill(Color.TRANSPARENT);
        p1.setStroke(Color.BLACK);

        p1.setOnMousePressed(e -> {
            lastX = e.getSceneX();
            lastY = e.getSceneY();
        });

        // move
        p1.setOnMouseDragged(e -> {
            double dx = e.getSceneX() - lastX;
            double dy = e.getSceneY() - lastY;
            
            p1.setTranslateX(p1.getTranslateX() + dx);
            p1.setTranslateY(p1.getTranslateY() + dy);
            tA.setTranslateX(tA.getTranslateX() + dx);
            tA.setTranslateY(tA.getTranslateY() + dy);
            tB.setTranslateX(tB.getTranslateX() + dx);
            tB.setTranslateY(tB.getTranslateY() + dy);
            tC.setTranslateX(tC.getTranslateX() + dx);
            tC.setTranslateY(tC.getTranslateY() + dy);

            lastX = e.getSceneX();
            lastY = e.getSceneY();
        });
    }

    @FXML
    public void onShow() {
        // init
        p1.setTranslateX(0); p1.setTranslateY(0);
        tA.setTranslateX(0); tA.setTranslateY(0);
        tB.setTranslateX(0); tB.setTranslateY(0);
        tC.setTranslateX(0); tC.setTranslateY(0);

        double x1 = Double.parseDouble(tfAx.getText());
        double y1 = Double.parseDouble(tfAy.getText());
        double x2 = Double.parseDouble(tfBx.getText());
        double y2 = Double.parseDouble(tfBy.getText());
        double x3 = Double.parseDouble(tfCx.getText());
        double y3 = Double.parseDouble(tfCy.getText());

        // cal
        double ab = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
        double bc = Math.sqrt((x2-x3)*(x2-x3) + (y2-y3)*(y2-y3));
        double ca = Math.sqrt((x3-x1)*(x3-x1) + (y3-y1)*(y3-y1));
        double c = ab + bc + ca; 
        double p = c / 2;
        double s = Math.sqrt(p * (p-ab) * (p-bc) * (p-ca));

        double jiaoA = Math.acos((ca*ca + ab*ab - bc*bc)/(2*ca*ab)) * 180 / Math.PI;
        double jiaoB = Math.acos((ab*ab + bc*bc - ca*ca)/(2*ab*bc)) * 180 / Math.PI;
        double jiaoC = Math.acos((bc*bc + ca*ca - ab*ab)/(2*bc*ca)) * 180 / Math.PI;

        p1.getPoints().clear();
        p1.getPoints().addAll(x1, y1, x2, y2, x3, y3);

        tA.setX(x1); tA.setY(y1); tA.setText(String.format(" ∠A=%.1f°", jiaoA));
        tB.setX(x2); tB.setY(y2); tB.setText(String.format(" ∠B=%.1f°", jiaoB));
        tC.setX(x3); tC.setY(y3); tC.setText(String.format(" ∠C=%.1f°", jiaoC));
        
        resultLabel.setText("面积: " + String.format("%.2f", s) + "  周长: " + String.format("%.2f", c));
    }

    @FXML
    public void onExit() {
        System.exit(0);
    }
}
