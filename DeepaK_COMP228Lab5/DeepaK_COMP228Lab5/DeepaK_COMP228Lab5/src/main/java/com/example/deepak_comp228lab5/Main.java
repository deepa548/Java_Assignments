package com.example.deepak_comp228lab5;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.sql.*;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            System.out.println("> Start Program ...");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("> Driver Loaded successfully.");

            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@ 199.212.26.208:1521:SQLD","COMP228_W23_sy_175", "password");
            System.out.println("Database connected successfully.");



            // Create labels for each text field
            Label playerInfo = new Label("Player Information :");
            playerInfo.setStyle("-fx-font-weight: bold");
            Label firstNameLabel = new Label("First Name:");
            Label lastNameLabel = new Label("Last Name:");
            Label addressLabel = new Label("Address:");
            Label provinceLabel = new Label("Province:");
            Label postalCodeLabel = new Label("Postal Code:");
            Label phoneLabel = new Label("Phone:");
            Label gameTitlelabel = new Label("Game Title:");
            Label gameScorelabel = new Label("Game Score:");
            Label datePlayedlabel = new Label("Date Played:");
            Label updatePlayerid = new Label("Update Player ID:");
            Label gameinfo = new Label("Game Information:");
            gameinfo.setStyle("-fx-font-weight: bold");


            // Create text fields for player & Game
            TextField firstNameTextField = new TextField();
            TextField lastNameTextField = new TextField();
            TextField addressTextField = new TextField();
            TextField provinceTextField = new TextField();
            TextField postalCodeTextField = new TextField();
            TextField phoneTextField = new TextField();
            TextField gameTitleTextField = new TextField();
            TextField gameScoreTextField = new TextField();
            TextField datePlayedTextField = new TextField();
            TextField updatePlayeridTexField = new TextField();

            // Create player grid pane to organize text fields
            GridPane playergridPane = new GridPane();
            playergridPane.setAlignment(Pos.TOP_LEFT);
            playergridPane.setHgap(10);
            playergridPane.setVgap(10);
            playergridPane.setPadding(new Insets(25, 25, 25, 25));

            //Buttons
            Button updateButton = new Button("Update");
            Button createPlayer = new Button("Create Player");
            Button displayallPlayers = new Button("Display All Players");


            // Add labels and text fields to the player grid pane
            playergridPane.add(playerInfo, 0, 0);
            playergridPane.add(firstNameLabel, 0, 1);
            playergridPane.add(firstNameTextField, 1, 1);
            playergridPane.add(lastNameLabel, 0, 2);
            playergridPane.add(lastNameTextField, 1, 2);
            playergridPane.add(addressLabel, 0, 3);
            playergridPane.add(addressTextField, 1, 3);
            playergridPane.add(provinceLabel, 0, 4);
            playergridPane.add(provinceTextField, 1, 4);
            playergridPane.add(postalCodeLabel, 0, 5);
            playergridPane.add(postalCodeTextField, 1, 5);
            playergridPane.add(phoneLabel, 0, 6);
            playergridPane.add(phoneTextField, 1, 6);

            // Create game grid pane to organize text fields
            GridPane gamegridPane = new GridPane();
            gamegridPane.setAlignment(Pos.TOP_RIGHT);
            gamegridPane.setHgap(10);
            gamegridPane.setVgap(10);
            gamegridPane.setPadding(new Insets(25, 25, 25, 25));

            //Update PlayerID
            gamegridPane.add(updatePlayerid, 0, 0,1,1);
            gamegridPane.add(updatePlayeridTexField, 1, 0,1,1);
            gamegridPane.add(updateButton, 2, 0,1,1);

            // Add labels and text fields to the player game pane
            gamegridPane.add(gameinfo, 0, 5,1,1);
            gamegridPane.add(gameTitlelabel, 0, 6,1,1);
            gamegridPane.add(gameTitleTextField, 1, 6,1,1);
            gamegridPane.add(gameScorelabel, 0, 7,1,1);
            gamegridPane.add(gameScoreTextField, 1, 7,1,1);
            gamegridPane.add(datePlayedlabel, 0, 8,1,1);
            gamegridPane.add(datePlayedTextField, 1, 8,1,1);

            //Create & Display Button
            gamegridPane.add(createPlayer, 0, 15,1,1);
            gamegridPane.add(displayallPlayers, 1, 15,1,1);

            // Create Player Event on Create player button click
            createPlayer.setOnAction(e -> {
                        // Prepare the SQL statement for inserting game and player data
                        String gameInsertSql = "INSERT INTO Game (game_title) VALUES (?)";
                        String playerInsertSql = "INSERT INTO Player (first_name, last_name, address, province, postal_code, Phone_Number) VALUES (?, ?, ?, ?, ?, ?)";

                try {
                        String generagedGameid[] = { "game_id" };
                        String generatedPlayerid[] = { "player_id" };
                        PreparedStatement gameStmt = connection.prepareStatement(gameInsertSql, generagedGameid);
                        PreparedStatement playerStmt = connection.prepareStatement(playerInsertSql, generatedPlayerid);

                        //Player Table values
                        playerStmt.setString(1, firstNameTextField.getText());
                        playerStmt.setString(2, lastNameTextField.getText());
                        playerStmt.setString(3, addressTextField.getText());
                        playerStmt.setString(4, provinceTextField.getText());
                        playerStmt.setString(5, postalCodeTextField.getText());
                        playerStmt.setString(6, phoneTextField.getText());

                        //Game Table values
                        gameStmt.setString(1, gameTitleTextField.getText());

                        // Execute the SQL statement
                        int newPlayerrows = playerStmt.executeUpdate();
                        ResultSet playerKeys = playerStmt.getGeneratedKeys();

                        int newGamerows = gameStmt.executeUpdate();
                        ResultSet gameKeys = gameStmt.getGeneratedKeys();

                        // Use the generated keys to create a new PlayerAndGame insert it into the database
                        if (gameKeys.next() && playerKeys.next()) {

                            int playerId = playerKeys.getInt(1);;
                            int gameId = gameKeys.getInt(1);;

                            // Insert the newPlayerAndGame object into the database using another prepared statement
                            String playerGameInsertSql = "INSERT INTO PlayerAndGame (game_id, player_id, playing_date, score) VALUES (?, ?, ?, ?)";
                            PreparedStatement playerGameStmt = connection.prepareStatement(playerGameInsertSql, Statement.RETURN_GENERATED_KEYS);

                            playerGameStmt.setInt(1,gameId);
                            playerGameStmt.setInt(2,playerId);
                            playerGameStmt.setString(3,datePlayedTextField.getText());
                            playerGameStmt.setDouble(4,Double.parseDouble(gameScoreTextField.getText()));
                            int newPlayergamerows = playerGameStmt.executeUpdate();
                            playerGameStmt.close();
                            playerStmt.close();
                            gameStmt.close();
                            playerKeys.close();
                            gameKeys.close();
                        }

                          if(newPlayerrows >= 0) {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Success!!");
                            alert.setHeaderText("New Player Created");
                            alert.showAndWait().ifPresent(rs -> {
                                if (rs == ButtonType.OK) {
                                    System.out.println("Pressed OK.");
                                }
                            });
                        }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            });

            // Create Update Event on update button click
            updateButton.setOnAction(e ->{
                try {
                    //Player Table values
                    String firstName = firstNameTextField.getText();
                    String lastName = lastNameTextField.getText();
                    String address = addressTextField.getText();
                    String province = provinceTextField.getText();
                    String postalCode = postalCodeTextField.getText();
                    String phone = phoneTextField.getText();
                    String gameTitle = gameTitleTextField.getText();
                    String datePlayed = datePlayedTextField.getText();
                    String gameScore = gameScoreTextField.getText();
                    String UpdatePlayerid = updatePlayeridTexField.getText();

                    int updatedRows = 0;

                    if (UpdatePlayerid != null && firstName != null){
                        String playerUpdateSql = "UPDATE Player SET first_name = ? WHERE player_id = ?";
                        PreparedStatement PlayerUpdateStmt = connection.prepareStatement(playerUpdateSql);
                        PlayerUpdateStmt.setString(1, firstName);
                        PlayerUpdateStmt.setInt(2, Integer.parseInt(UpdatePlayerid));
                        updatedRows = PlayerUpdateStmt.executeUpdate();
                        PlayerUpdateStmt.close();
                    }
                    if (UpdatePlayerid != null && lastName != null){
                        String playerUpdateSql = "UPDATE Player SET last_name = ? WHERE player_id = ?";
                        PreparedStatement PlayerUpdateStmt = connection.prepareStatement(playerUpdateSql);
                        PlayerUpdateStmt.setString(1, lastName);
                        PlayerUpdateStmt.setInt(2, Integer.parseInt(UpdatePlayerid));
                        updatedRows = PlayerUpdateStmt.executeUpdate();
                        PlayerUpdateStmt.close();
                    }
                    if (UpdatePlayerid != null && address != null){
                        String playerUpdateSql = "UPDATE Player SET address = ? WHERE player_id = ?";
                        PreparedStatement PlayerUpdateStmt = connection.prepareStatement(playerUpdateSql);
                        PlayerUpdateStmt.setString(1, address);
                        PlayerUpdateStmt.setInt(2, Integer.parseInt(UpdatePlayerid));
                        updatedRows = PlayerUpdateStmt.executeUpdate();
                        PlayerUpdateStmt.close();
                    }
                    if (UpdatePlayerid != null && province != null){
                        String playerUpdateSql = "UPDATE Player SET province = ? WHERE player_id = ?";
                        PreparedStatement PlayerUpdateStmt = connection.prepareStatement(playerUpdateSql);
                        PlayerUpdateStmt.setString(1, province);
                        PlayerUpdateStmt.setInt(2, Integer.parseInt(UpdatePlayerid));
                        updatedRows = PlayerUpdateStmt.executeUpdate();
                        PlayerUpdateStmt.close();
                    }
                    if (UpdatePlayerid != null && postalCode != null){
                        String playerUpdateSql = "UPDATE Player SET postal_code = ? WHERE player_id = ?";
                        PreparedStatement PlayerUpdateStmt = connection.prepareStatement(playerUpdateSql);
                        PlayerUpdateStmt.setString(1, postalCode);
                        PlayerUpdateStmt.setInt(2, Integer.parseInt(UpdatePlayerid));
                        updatedRows = PlayerUpdateStmt.executeUpdate();
                        PlayerUpdateStmt.close();
                    }
                    if (UpdatePlayerid != null && phone != null){
                        String playerUpdateSql = "UPDATE Player SET Phone_Number = ? WHERE player_id = ?";
                        PreparedStatement PlayerUpdateStmt = connection.prepareStatement(playerUpdateSql);
                        PlayerUpdateStmt.setString(1, phone);
                        PlayerUpdateStmt.setInt(2, Integer.parseInt(UpdatePlayerid));
                        updatedRows = PlayerUpdateStmt.executeUpdate();
                        PlayerUpdateStmt.close();
                    }
                    if (UpdatePlayerid != null && gameTitle != null){
                        String gameUpdateSql = "UPDATE Game SET game_title = ? WHERE game_id = (select game_id from Playerandgame where player_id= ?)";
                        PreparedStatement gameUpdateStmt = connection.prepareStatement(gameUpdateSql);
                        gameUpdateStmt.setString(1, gameTitle);
                        gameUpdateStmt.setInt(2, Integer.parseInt(UpdatePlayerid));
                        updatedRows = gameUpdateStmt.executeUpdate();
                        gameUpdateStmt.close();
                    }
                    if (UpdatePlayerid != null && datePlayed != null){
                        String playerUpdateSql = "UPDATE Playerandgame SET playing_date = ? WHERE player_id = ?";
                        PreparedStatement PlayerUpdateStmt = connection.prepareStatement(playerUpdateSql);
                        PlayerUpdateStmt.setString(1, datePlayed);
                        PlayerUpdateStmt.setInt(2, Integer.parseInt(UpdatePlayerid));
                        updatedRows = PlayerUpdateStmt.executeUpdate();
                        PlayerUpdateStmt.close();
                    }
                    if (UpdatePlayerid != null && gameScore != null){
                        String playerUpdateSql = "UPDATE Playerandgame SET score = ? WHERE player_id = ?";
                        PreparedStatement PlayerUpdateStmt = connection.prepareStatement(playerUpdateSql);
                        PlayerUpdateStmt.setString(1, gameScore);
                        PlayerUpdateStmt.setInt(2, Integer.parseInt(UpdatePlayerid));
                        updatedRows = PlayerUpdateStmt.executeUpdate();
                        PlayerUpdateStmt.close();
                    }

                    if(updatedRows >= 0) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Update Success!!");
                        alert.setHeaderText("Data Field Updated");
                        alert.showAndWait().ifPresent(rs -> {
                            if (rs == ButtonType.OK) {
                                System.out.println("Pressed OK.");
                            }
                        });
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }});

            displayallPlayers.setOnAction(e ->{
                String displaySql = "SELECT game.game_id, game.game_title, player.player_id, PlayerAndGame.playing_date, PlayerAndGame.score, Player.first_name, Player.last_name, Player.address, Player.postal_code, Player.province, Player.phone_number FROM Game INNER JOIN PlayerAndGame ON Game.game_id = PlayerAndGame.game_id INNER JOIN Player ON PlayerAndGame.player_id = Player.player_id";
                try {
                    PreparedStatement displayQryStmt = connection.prepareStatement(displaySql);
                    ResultSet playerAndGameResults = displayQryStmt.executeQuery();

                    ObservableList<PlayerGameInfo> data = FXCollections.observableArrayList();

                    while (playerAndGameResults.next()) {
                        PlayerGameInfo info = new PlayerGameInfo(
                            playerAndGameResults.getInt("game_id"),
                            playerAndGameResults.getString("game_title"),
                            playerAndGameResults.getInt("player_id"),
                            playerAndGameResults.getDate("playing_date"),
                            playerAndGameResults.getInt("score"),
                            playerAndGameResults.getString("first_name"),
                            playerAndGameResults.getString("last_name"),
                            playerAndGameResults.getString("address"),
                            playerAndGameResults.getString("postal_code"),
                            playerAndGameResults.getString("province"),
                            playerAndGameResults.getString("phone_number"));
                        data.add(info);
                    }

                    displayQryStmt.close();
                    playerAndGameResults.close();

                    // Create table columns
                    TableColumn<PlayerGameInfo, String> col1 = new TableColumn<>("Game ID");
                    col1.setCellValueFactory(new PropertyValueFactory<>("gameId"));
                    TableColumn<PlayerGameInfo, String> col2 = new TableColumn<>("Game Title");
                    col2.setCellValueFactory(new PropertyValueFactory<>("gameTitle"));
                    TableColumn<PlayerGameInfo, String> col3 = new TableColumn<>("Player ID");
                    col3.setCellValueFactory(new PropertyValueFactory<>("playerId"));
                    TableColumn<PlayerGameInfo, String> col4 = new TableColumn<>("Playing Date");
                    col4.setCellValueFactory(new PropertyValueFactory<>("playingDate"));
                    TableColumn<PlayerGameInfo, String> col5 = new TableColumn<>("Score");
                    col5.setCellValueFactory(new PropertyValueFactory<>("score"));
                    TableColumn<PlayerGameInfo, String> col6 = new TableColumn<>("First Name");
                    col6.setCellValueFactory(new PropertyValueFactory<>("firstName"));
                    TableColumn<PlayerGameInfo, String> col7 = new TableColumn<>("Last Name");
                    col7.setCellValueFactory(new PropertyValueFactory<>("lastName"));
                    TableColumn<PlayerGameInfo, String> col8 = new TableColumn<>("Player Address");
                    col8.setCellValueFactory(new PropertyValueFactory<>("address"));
                    TableColumn<PlayerGameInfo, String> col9 = new TableColumn<>("Postal Code");
                    col9.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
                    TableColumn<PlayerGameInfo, String> col10 = new TableColumn<>("Province");
                    col10.setCellValueFactory(new PropertyValueFactory<>("province"));
                    TableColumn<PlayerGameInfo, String> col11 = new TableColumn<>("Phone No");
                    col11.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

                    TableView<PlayerGameInfo> table = new TableView<>();

                    @SuppressWarnings("unchecked")
                    TableColumn<PlayerGameInfo, String>[] columns = new TableColumn[] { col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11 };

                    table.setItems(data);
                    table.getColumns().addAll(columns);
                    //StackPane tableRoot = new StackPane(table);

                    Button exitButton = new Button("Close View");

                    // Create a new Stage object and set it as the parent for the new scene
                    VBox vbox = new VBox();
                    vbox.getChildren().add(table);
                    vbox.getChildren().add(exitButton);

                    Stage secondStage = new Stage();
                    secondStage.setScene(new Scene(vbox, 900, 450));
                    secondStage.setTitle("Player Info APP (c) Deepa K");
                    secondStage.show();

                    // Add an event listener to the exit button to close the second stage when clicked
                    exitButton.setOnAction(event -> {
                        secondStage.close();
                    });

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }});


            // create Box for TOP Nodes
            HBox TopRightBox = new HBox(10);
            TopRightBox.getChildren().addAll(gamegridPane);

            HBox TopBox = new HBox(10);
            TopBox.getChildren().addAll(playergridPane, TopRightBox);

            // Create a border pane to organize all components
            BorderPane borderPane = new BorderPane();
            borderPane.setTop(TopBox);

            // Create a scene and add it to the stage
            Scene scene = new Scene(borderPane, 800, 350);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Player Info APP (c) Deepa K");
            primaryStage.show();

        }

        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Main.launch();
    }

}
