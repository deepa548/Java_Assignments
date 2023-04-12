module com.example.deepak_comp228lab5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires ojdbc6;


    opens com.example.deepak_comp228lab5 to javafx.fxml;
    exports com.example.deepak_comp228lab5;
}