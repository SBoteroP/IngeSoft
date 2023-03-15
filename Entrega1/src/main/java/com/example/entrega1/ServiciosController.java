package com.example.entrega1;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ServiciosController implements Initializable {

    @FXML
    private TableView<Service> tableID;

    @FXML
    private TableColumn<Service, String> nombreServicio;

    @FXML
    private TableColumn<Service, String> nombreProveedor;

    @FXML
    private TableColumn<Service, Double> costo;

    private PostgresConnection connection;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            connection =  new PostgresConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "khanonline7");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        nombreServicio.setCellValueFactory(cellData -> cellData.getValue().serviceNameProperty());
        nombreProveedor.setCellValueFactory(cellData -> cellData.getValue().providerProperty());
        costo.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
    }

    @FXML
    void verServicios() {
        try {
            List<Service> servicios = connection.getServices();
            tableID.getItems().setAll(servicios);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
