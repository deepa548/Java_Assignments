module com.example.deepak_comp228lab4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.deepak_comp228lab4 to javafx.fxml;
    exports com.example.deepak_comp228lab4;
}