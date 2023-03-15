module com.example.entrega1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.entrega1 to javafx.fxml;
    exports com.example.entrega1;
    exports Controller;
    opens Controller to javafx.fxml;
}