//Activity - T505

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SimpleCalculator extends Application {

   private TextField num1Field;
   private TextField num2Field;
   private Label resultLabel;

   @Override
    public void start(Stage primaryStage) {
      num1Field = new TextField();
      num2Field = new TextField();
      resultLabel = new Label();
   
      Button addButton = createButton("+", (num1, num2) -> num1 + num2);
      Button subtractButton = createButton("-", (num1, num2) -> num1 - num2);
      Button multiplyButton = createButton("*", (num1, num2) -> num1 * num2);
      Button divideButton = createButton("/", 
         (num1, num2) -> {
            if (num2 == 0) {
               resultLabel.setText("Error: Division by zero");
               return Double.NaN;
            }
            return num1 / num2;
         });
   
      VBox root = new VBox(10);
      root.setPadding(new Insets(20));
      root.setAlignment(Pos.CENTER);
      root.getChildren().addAll(num1Field, num2Field, addButton, subtractButton, multiplyButton, divideButton, resultLabel);
   
      Scene scene = new Scene(root, 300, 300);
   
      primaryStage.setScene(scene);
      primaryStage.setTitle("Simple Calculator");
      primaryStage.show();
   }

   private Button createButton(String text, Operation operation) {
      Button button = new Button(text);
      button.setOnAction(
         event -> {
            try {
               double num1 = Double.parseDouble(num1Field.getText());
               double num2 = Double.parseDouble(num2Field.getText());
               double result = operation.apply(num1, num2);
               resultLabel.setText("\n" + result);
            } catch (NumberFormatException e) {
               resultLabel.setText("Error: Invalid input");
            }
         });
      return button;
   }

   @FunctionalInterface
    private interface Operation {
      double apply(double num1, double num2);
   }

   public static void main(String[] args) {
      launch(args);
   }
}