module com.example.loginanddashboard {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.loginanddashboard to javafx.fxml;
    exports com.example.loginanddashboard;
}