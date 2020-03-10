import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
//import javafx.scene.layout.Border;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
//import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.beans.value.ChangeListener;
//import javafx.beans.value.ObservableValue;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class UserInput extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        getStartScreen(primaryStage);
    }

    public void getStartScreen(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        VBox startScreen = new VBox(10);
        Text startText = new Text();
        startText.setText("Welcome to the Invention Studio! Click START to proceed.");
        startText.setFont(new Font("Arial", 25));
        Button startButton = new Button();
        startButton.setText("Start!");

        Stage configurationStage = new Stage();
        startButton.setOnMouseClicked(event -> {
            primaryStage.hide();
            getConfigurationStage(configurationStage);
        });
        // sets up welcome screen
        startScreen.getChildren().addAll(startText, startButton);
        pane.setCenter(startScreen);
        startScreen.setAlignment(Pos.CENTER);
        Scene scene = new Scene(pane, 1000, 800);
        primaryStage.setTitle("Laser Cutter Data Collection");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void getConfigurationStage(Stage stage) {
        Label enterName = new Label("Enter Material Name: ");
        TextField name = new TextField();
        ComboBox<String> pickMode = new ComboBox<>();
        Label chooseMode = new Label("Are you cutting or engraving?");
        pickMode.getItems().addAll("Cutting", "Engraving");

        //Button enterButton = new Button();
        //enterButton.setText("Enter");

        Label enterPasses = new Label("Number of Passes: ");
        TextField passAmount = new TextField();
        Label enterSpeed = new Label("Enter Speed: ");
        TextField speedAmount = new TextField();
        Label enterPower = new Label("Enter Power: ");
        TextField powerAmount = new TextField();

        //Button enterSkill = new Button();
        //enterSkill.setText("Enter");


        Button startButton = new Button();
        startButton.setText("Next");
        startButton.setOnMouseClicked(event -> {
            String materialName = name.getCharacters().toString();
            String passValue = passAmount.getCharacters().toString();
            String speedValue = speedAmount.getCharacters().toString();
            String powerValue = powerAmount.getCharacters().toString();
            String modeType = pickMode.getValue();
            if (materialName.length() == 0 || materialName.trim().equals("")) {
                Alert invalidName = new Alert(Alert.AlertType.ERROR);
                invalidName.setTitle("Error");
                invalidName.setHeaderText("Invalid Material");
                invalidName.setContentText("Please enter a material!");
                invalidName.showAndWait();
            } else if (modeType == null) {
                Alert invalidName = new Alert(Alert.AlertType.ERROR);
                invalidName.setTitle("Error");
                invalidName.setHeaderText("Invalid Mode");
                invalidName.setContentText("Please choose an option!");
                invalidName.showAndWait();
            } else if (passValue.length() == 0 || passValue.trim().equals("")) {
                Alert invalidName = new Alert(Alert.AlertType.ERROR);
                invalidName.setTitle("Error");
                invalidName.setHeaderText("Invalid Pass Value");
                invalidName.setContentText("Please enter the pass amount!");
                invalidName.showAndWait();
            } else if (speedValue.length() == 0 || speedValue.trim().equals("")) {
                Alert invalidName = new Alert(Alert.AlertType.ERROR);
                invalidName.setTitle("Error");
                invalidName.setHeaderText("Invalid Speed Value");
                invalidName.setContentText("Please enter the speed amount!");
                invalidName.showAndWait();
            } else if (powerValue.length() == 0 || powerValue.trim().equals("")) {
                Alert invalidName = new Alert(Alert.AlertType.ERROR);
                invalidName.setTitle("Error");
                invalidName.setHeaderText("Invalid Power Value");
                invalidName.setContentText("Please enter the power amount!");
                invalidName.showAndWait();
            } else {
                System.out.println("Material: " + materialName + " Mode: " + modeType + " Passes: " + passValue
                        + " Speed: " + speedValue + " Power: " + powerValue);
                Stage materialScreenStage = new Stage();
                stage.hide();
                getExitScreen(materialScreenStage);
            }
        });
        HBox nameAlign = new HBox();
        nameAlign.setAlignment(Pos.CENTER);
        nameAlign.getChildren().addAll(enterName, name);
        HBox difficultyAlign = new HBox();
        difficultyAlign.setAlignment(Pos.CENTER);
        difficultyAlign.getChildren().addAll(chooseMode, pickMode);

        HBox skillAlign = new HBox();
        skillAlign.setAlignment(Pos.CENTER);
        skillAlign.getChildren().addAll(enterPasses, passAmount, enterSpeed, speedAmount,
                enterPower, powerAmount);

        VBox verticalAlign = new VBox();
        verticalAlign.setAlignment(Pos.CENTER);
        verticalAlign.setSpacing(10);
        verticalAlign.getChildren().addAll(nameAlign, difficultyAlign, skillAlign, startButton);
        Scene scene = new Scene(verticalAlign, 1000, 800);
        stage.setTitle("Configuration Screen");
        stage.setScene(scene);
        stage.show();
    }
    public void getExitScreen(Stage stage) {
        BorderPane pane = new BorderPane();
        VBox startScreen = new VBox(10);
        Label stats = new Label("Thank you for helping better the Studio!");
        stats.setFont(new Font("Arial", 25));
        Button startButton = new Button();
        startButton.setText("Exit");

        startScreen.getChildren().addAll(stats, startButton);

        startScreen.setAlignment(Pos.CENTER);
        startButton.setOnMouseClicked(event -> {
            Stage newStage = new Stage();
            stage.hide();
            getStartScreen(newStage);
        });

        Scene scene = new Scene(startScreen, 1000, 800);
        stage.setTitle("Exit Screen");
        stage.setScene(scene);
        stage.show();

    }


    public static void main(String[] args) throws FileNotFoundException {
        //File writeFile = new File("DataCollection.txt");
        //PrintWriter textFile = new PrintWriter(writeFile);
        launch(args);

    }
}