package com.example.deepak_comp228lab4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.ScrollPane;

public class StudentInfo extends Application {


    @Override
    public void start(Stage primaryStage) {

        // Create labels for each text field
        Label nameLabel = new Label("Name:");
        Label addressLabel = new Label("Address:");
        Label cityLabel = new Label("City:");
        Label provinceLabel = new Label("Province:");
        Label postalCodeLabel = new Label("Postal Code:");
        Label phoneLabel = new Label("Phone:");
        Label emailLabel = new Label("Email:");
        Label programLabel = new Label("Program:");
        Label courseLabel = new Label("Course:");

        // Create text fields for student information
        TextField nameTextField = new TextField();
        TextField addressTextField = new TextField();
        TextField cityTextField = new TextField();
        TextField provinceTextField = new TextField();
        TextField postalCodeTextField = new TextField();
        TextField phoneTextField = new TextField();
        TextField emailTextField = new TextField();

        // Create a grid pane to organize text fields
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.TOP_LEFT);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        // Add labels and text fields to the grid pane
        gridPane.add(nameLabel, 0, 0);
        gridPane.add(nameTextField, 1, 0);
        gridPane.add(addressLabel, 0, 1);
        gridPane.add(addressTextField, 1, 1);
        gridPane.add(cityLabel, 0, 2);
        gridPane.add(cityTextField, 1, 2);
        gridPane.add(provinceLabel, 0, 3);
        gridPane.add(provinceTextField, 1, 3);
        gridPane.add(postalCodeLabel, 0, 4);
        gridPane.add(postalCodeTextField, 1, 4);
        gridPane.add(phoneLabel, 0, 5);
        gridPane.add(phoneTextField, 1, 5);
        gridPane.add(emailLabel, 0, 6);
        gridPane.add(emailTextField, 1, 6);


        // Create radio buttons for program selection
        RadioButton csRadioButton = new RadioButton("Computer Science");
        RadioButton businessRadioButton = new RadioButton("Business");

        // Add radio buttons to a toggle group
        ToggleGroup programToggleGroup = new ToggleGroup();
        csRadioButton.setToggleGroup(programToggleGroup);
        businessRadioButton.setToggleGroup(programToggleGroup);



        // Create a combo box for program selection
        ComboBox<String> programComboBox = new ComboBox<>();
        ComboBox<String> courseComboBox = new ComboBox<>();
        programComboBox.getItems().addAll("Computer Science", "Business");
        programComboBox.setValue("Computer Science");
        programComboBox.setOnAction(e -> {
            String program = programComboBox.getValue();
        if (program.equals("Computer Science")) {
            courseComboBox.getItems().clear();
            courseComboBox.getItems().addAll("Java Programming", "Data Structures", "Algorithms");
        } else if (program.equals("Business")) {
            courseComboBox.getItems().clear();
            courseComboBox.getItems().addAll("Accounting", "Marketing", "Management");
        }
        courseComboBox.setValue(courseComboBox.getItems().get(0));
        });

        // Create a list view to display selected courses
        ListView<String> selectedCoursesListView = new ListView<>();

        // Create a button to add selected course to list view
        Button addCourseButton = new Button("Add Course");
        addCourseButton.setOnAction(e -> {
            String course = courseComboBox.getValue();
            if (!selectedCoursesListView.getItems().contains(course)) {
                selectedCoursesListView.getItems().add(course);
            }
        });


        // Create a grid pane to organize program and course selection fields
        GridPane programGridPane = new GridPane();
        programGridPane.setAlignment(Pos.CENTER);
        programGridPane.setHgap(10);
        programGridPane.setVgap(10);
        programGridPane.setPadding(new Insets(25, 25, 25, 25));
        programGridPane.add(programLabel, 0, 0);
        programGridPane.add(programComboBox, 1, 0);
        programGridPane.add(courseLabel, 0, 1);
        programGridPane.add(courseComboBox, 1, 1);
        programGridPane.add(addCourseButton, 2, 1);
        programGridPane.add(selectedCoursesListView, 3, 1);

        // Create check boxes for additional information
        CheckBox athleticsCheckBox = new CheckBox("Athletics");
        CheckBox musicCheckBox = new CheckBox("Music");
        CheckBox volunteerCheckBox = new CheckBox("Volunteer");


        // Create an HBox to organize check boxes
        HBox checkBoxHBox = new HBox(10);
        checkBoxHBox.setAlignment(Pos.CENTER);
        checkBoxHBox.getChildren().addAll(athleticsCheckBox, musicCheckBox, volunteerCheckBox);

        // Create a text area to display student information
        TextArea studentInfoTextArea = new TextArea();
        studentInfoTextArea.setEditable(false);
        studentInfoTextArea.setWrapText(true);

        ScrollPane scrollPane = new ScrollPane(studentInfoTextArea);
        scrollPane.setFitToWidth(true); // enable horizontal scrolling
        scrollPane.setFitToHeight(true); // enable vertical scrolling

        //display button
        Button displayButton = new Button("Display");
        displayButton.setOnAction(e -> {
            StringBuilder sb = new StringBuilder();
            sb.append("Student ID: ").append(nameTextField.getText()).append("\n");
            sb.append("First Name: ").append(addressTextField.getText()).append("\n");
            sb.append("Last Name: ").append(cityTextField.getText()).append("\n");
            sb.append("Address: ").append(provinceTextField.getText()).append("\n");
            sb.append("Phone Number: ").append(postalCodeTextField.getText()).append("\n");
            sb.append("Email: ").append(emailTextField.getText()).append("\n");
            sb.append("Program: ").append(programComboBox.getValue()).append("\n");
            sb.append("Courses: ").append(selectedCoursesListView.getItems()).append("\n");
            sb.append("Other Activity: ").append(checkBoxHBox.getChildren().getClass().toString()).append("\n");
            studentInfoTextArea.setText(sb.toString());
        });


        // create Box for TOP Nodes
        VBox TopRightBox = new VBox(10);
        TopRightBox.getChildren().addAll(programGridPane, checkBoxHBox); // add nodes to the HBox

        HBox TopBox = new HBox(10);
        TopBox.setAlignment(Pos.CENTER);
        TopBox.getChildren().addAll(gridPane, TopRightBox);

        // create an VBox for Bottom Nodes

        VBox bottomBox = new VBox(10);
        bottomBox.getChildren().addAll(displayButton, scrollPane); // add nodes to the HBox

        // Create a border pane to organize all components
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(TopBox);
        borderPane.setBottom(bottomBox);
        BorderPane.setAlignment(displayButton, Pos.TOP_CENTER);



        // Create a scene and add it to the stage
        Scene scene = new Scene(borderPane, 900, 700);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Student Information App");
        primaryStage.show();

    }

    public static void main (String[]args){
        launch(args);
    }
}