module com.example.practicaexamen {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.practicaexamen.controllers to javafx.fxml;

    opens com.example.practicaexamen.contactos to javafx.base;

    exports com.example.practicaexamen;
}