package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton penButton;

    @FXML
    private RadioButton eraserButton;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();

        // Kiểm tra giới hạn pane (dùng getWidth/getHeight thay vì getBoundsInParent)
        if (x < 0 || y < 0
                || x > drawingAreaPane.getWidth()
                || y > drawingAreaPane.getHeight()) {
            return;
        }

        Circle newCircle = new Circle(x, y, 4);

        if (penButton.isSelected()) {
            newCircle.setFill(Color.BLACK);
            drawingAreaPane.getChildren().add(newCircle);
        } else if (eraserButton.isSelected()) {
            newCircle.setFill(Color.WHITE);
            drawingAreaPane.getChildren().add(newCircle);
        }
    }
}
