//Activity - T504

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Random;

public class NumberGuessingGame extends Application {

   private int randomNumber;
   private int attempts;

   @Override
    public void start(Stage primaryStage) {
        // Generate a random number between 1 and 100
      Random random = new Random();
      randomNumber = random.nextInt(100) + 1;
   
        // Initialize attempts counter
      attempts = 0;
   
        // UI elements
      Label instructionLabel = new Label("Guess the number (between 1 and 100):");
      TextField guessField = new TextField();
      Label resultLabel = new Label();
      Button guessButton = new Button("Guess");
      Label attemptsLabel = new Label("Attempts: 0");
   
        // Event handler for guess button
      guessButton.setOnAction(
         event -> {
            attempts++;
            int guess;
            try {
               guess = Integer.parseInt(guessField.getText());
               if (guess == randomNumber) {
                  resultLabel.setText("Congratulations! You guessed the number.");
               } else if (guess < randomNumber) {
                  resultLabel.setText("Try a higher number.");
               } else {
                  resultLabel.setText("Try a lower number.");
               }
            } catch (NumberFormatException e) {
               resultLabel.setText("Please enter a valid number.");
            }
            attemptsLabel.setText("Attempts: " + attempts);
         });
   
        // Layout
      VBox root = new VBox(10);
      root.setPadding(new Insets(20));
      root.setAlignment(Pos.CENTER);
      root.getChildren().addAll(instructionLabel, guessField, guessButton, resultLabel, attemptsLabel);
   
        // Scene
      Scene scene = new Scene(root, 300, 200);
   
        // Stage
      primaryStage.setScene(scene);
      primaryStage.setTitle("GUESS THE NUMBER");
      primaryStage.show();
   }

   public static void main(String[] args) {
      launch(args);
   }
}