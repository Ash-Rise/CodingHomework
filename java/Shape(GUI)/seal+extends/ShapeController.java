package cn.edu.ncu.lzc.shape1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import java.util.ArrayList;
import java.util.Collections;

public class ShapeController {

    @FXML
    private Pane canvas;

    @FXML
    private Label totalLabel;
    
    @FXML
    private Label areaLabel;

    @FXML
    private Label perimeterLabel;

    private String currentShape = null;
    private double[] xArr = new double[2];
    private double[] yArr = new double[2];
    private int clickCount = 0;

    private ArrayList<Shape> shapeList = new ArrayList<>();

    @FXML
    void selectCircle(ActionEvent event) {
        currentShape = "圆形";
        clickCount = 0;
    }

    @FXML
    void selectRectangle(ActionEvent event) {
        currentShape = "方形";
        clickCount = 0;
    }

    @FXML
    void selectHexagon(ActionEvent event) {
        currentShape = "六边形";
        clickCount = 0;
    }

    @FXML
    void selectTriangle(ActionEvent event) {
        currentShape = "三角形";
        clickCount = 0;
    }

    @FXML
    void clearCanvas(ActionEvent event) {
        canvas.getChildren().clear();
        clickCount = 0;
        shapeList.clear();
        areaLabel.setText("面积：");
        perimeterLabel.setText("周长：");
        totalLabel.setText("总面积：");
    }

    @FXML
    void doSortAndTotal(ActionEvent event) {
        Collections.sort(shapeList, (a, b) -> Double.compare(b.getArea(), a.getArea()));

        areaLabel.setText("面积：");
        perimeterLabel.setText("周长：");
        double totalArea = 0;

        for (int i = 0; i < shapeList.size(); i++) {
            Shape s = shapeList.get(i);
            totalArea = totalArea + s.getArea();

            String name;
            if (s instanceof Circle) name = "圆形";
            else if (s instanceof Rectangle) name = "方形";
            else if (s instanceof Hexagon) name = "六边形";
            else name = "三角形";

            areaLabel.setText(areaLabel.getText() + "\n" + (i + 1) + "." + name + " " + String.format("%.2f", s.getArea()));
            perimeterLabel.setText(perimeterLabel.getText() + "\n" + (i + 1) + "." + name + " " + String.format("%.2f", s.getPerimeter()));
        }
        totalLabel.setText("总面积：" + String.format("%.2f", totalArea));
    }

    @FXML
    public void initialize() {
        canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                onCanvasClick(me.getX(), me.getY());
            }
        });
    }

    private void onCanvasClick(double x, double y) {
        xArr[clickCount] = x;
        yArr[clickCount] = y;
        clickCount = clickCount + 1;
        if (clickCount == 2) {
            drawShape();
            clickCount = 0;
        }
    }

    private javafx.scene.shape.Circle drawCircleShape(double x, double y, double r) {
        javafx.scene.shape.Circle c = new javafx.scene.shape.Circle(x, y, r);

        c.setFill(null);
        c.setStroke(Color.BLUE);
        c.setStrokeWidth(2);
        return c;
    }

    private javafx.scene.shape.Rectangle drawRectShape(double x, double y, double w, double h) {
        javafx.scene.shape.Rectangle r = new javafx.scene.shape.Rectangle(x, y, w, h);

        r.setFill(null);
        r.setStroke(Color.GREEN);
        r.setStrokeWidth(2);
        return r;
    }

    private javafx.scene.shape.Polygon drawHexagonPolygon(double x, double y, double side, double startAngle) {
        javafx.scene.shape.Polygon poly = new javafx.scene.shape.Polygon();

        for (int i = 0; i < 6; i++) {
            double a = startAngle + i * Math.PI / 3;
            poly.getPoints().addAll(x + side * Math.cos(a), y + side * Math.sin(a));
        }

        poly.setFill(null);
        poly.setStroke(Color.ORANGE);
        poly.setStrokeWidth(2);
        return poly;
    }

    private javafx.scene.shape.Polygon drawTrianglePolygon(double x, double y, double side, double startAngle) {
        javafx.scene.shape.Polygon poly = new javafx.scene.shape.Polygon();

        for (int i = 0; i < 3; i++) {
            double a = startAngle + i * 2 * Math.PI / 3;
            poly.getPoints().addAll(x + side * Math.cos(a), y + side * Math.sin(a));
        }

        poly.setFill(null);
        poly.setStroke(Color.PURPLE);
        poly.setStrokeWidth(2);
        return poly;
    }

    private void appendResult(String name, double area, double perimeter) {
        areaLabel.setText(areaLabel.getText() + "\n" + name + " " + String.format("%.2f", area));
        perimeterLabel.setText(perimeterLabel.getText() + "\n" + name + " " + String.format("%.2f", perimeter));
    }

    private double distance(double x1, double y1, double x2, double y2) {
        double dx = x1 - x2, dy = y1 - y2;
        return Math.sqrt(dx * dx + dy * dy);
    }

    private void drawShape() {
        double x1 = xArr[0], y1 = yArr[0], x2 = xArr[1], y2 = yArr[1];

        if (currentShape.equals("圆形")) {
            double r = distance(x1, y1, x2, y2);
            canvas.getChildren().add(drawCircleShape(x1, y1, r));

            Circle c = new Circle();
            c.setX(x1);
            c.setY(y1);
            c.setR(r);
            shapeList.add(c);
            appendResult("圆形", c.getArea(), c.getPerimeter());
        } 
        else if (currentShape.equals("方形")) {
            double w = Math.abs(x1 - x2), h = Math.abs(y1 - y2);
            canvas.getChildren().add(drawRectShape(Math.min(x1, x2), Math.min(y1, y2), w, h));

            Rectangle r = new Rectangle();
            r.setX(Math.min(x1, x2));
            r.setY(Math.min(y1, y2)); r.setW(w); r.setH(h);
            shapeList.add(r);
            appendResult("方形", r.getArea(), r.getPerimeter());
        }
        else if (currentShape.equals("六边形")) {
            double side = distance(x1, y1, x2, y2);
            double angle = Math.atan2(y2 - y1, x2 - x1);
            canvas.getChildren().add(drawHexagonPolygon(x1, y1, side, angle));

            Hexagon h = new Hexagon();
            h.setX(x1);
            h.setY(y1);
            h.setSide(side);
            shapeList.add(h);
            appendResult("六边形", h.getArea(), h.getPerimeter());
        }
        else {
            double side = distance(x1, y1, x2, y2);
            double angle = Math.atan2(y2 - y1, x2 - x1);
            canvas.getChildren().add(drawTrianglePolygon(x1, y1, side, angle));

            Triangle t = new Triangle();
            t.setX(x1);
            t.setY(y1);
            t.setSide(side);
            shapeList.add(t);
            appendResult("三角形", t.getArea(), t.getPerimeter());
        }
    }
}
