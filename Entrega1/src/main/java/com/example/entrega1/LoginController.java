package com.example.entrega1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {

    @FXML
    private TextField usuarioTexto;

    @FXML
    private PasswordField contrasenaTexto;

    @FXML
    private TextField nuevousuarioTexto;

    @FXML
    private PasswordField nuevacontrasenaTexto;

    @FXML
    private Button loginButton;

    @FXML
    private Button signupButton;

    private DAO conn;

    public LoginController() throws SQLException {
        conn = new DAO("jdbc:postgresql://localhost:5432/postgres", "postgres", "khanonline7");
    }

    @FXML
    void login(ActionEvent event) {
        String username = usuarioTexto.getText();
        String password = contrasenaTexto.getText();
        try {
            if (conn.authenticate(username, password)) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("servicios.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) loginButton.getScene().getWindow();
                stage.setScene(scene);
            } else {
                showAlert("Error", "Usuario o contraseña incorrectos.");
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            showAlert("Error", "No se pudo autenticar.");
        }
    }
    @FXML
    void signup(ActionEvent event) {
        String username = nuevousuarioTexto.getText();
        String password = nuevacontrasenaTexto.getText();
        try {
            if (conn.checkUsername(username)) {
                showAlert("Error", "El nombre de usuario ya existe.");
            } else {
                conn.createUser(username, password);
                showAlert("Success", "Usuario creado exitosamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Error", "No se pudo crear el usuario.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    void initialize() {
        // Optional: initialize any UI components or variables here
    }

    public void close() throws SQLException {
        conn.close();
    }
}
