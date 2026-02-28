package com.example.loginanddashboard;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PerfilController {
    @FXML
    private Label mensajeUsuario;

    public void setDatosUsuario(String nombre) {
        mensajeUsuario.setText("Bienvenido " + nombre);
    }
}
