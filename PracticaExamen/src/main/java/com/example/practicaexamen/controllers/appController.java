package com.example.practicaexamen.controllers;

import com.example.practicaexamen.contactos.Contactos;
import com.example.practicaexamen.service.ContactosService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;

public class appController {
    @FXML
    private ListView<Contactos> listView;
    @FXML
    private Label lblMsg;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtTelefono;
    @FXML
    private ComboBox parentesco;
    @FXML
    private TextField txtBusqueda;

    @FXML
    private ContactosService logica = new ContactosService();

    @FXML
    public void initialize() {
        String[] opcionesParentesco = {"Padre", "Madre", "Hermano", "Hermana", "Abuelo", "Abuela", "Tío", "Tía"};
        parentesco.getItems().addAll(opcionesParentesco);
        listView.setItems(logica.obtenerLista());
        listView.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldValue, newValue) -> {
                    if (newValue != null) {
                        txtName.setText(newValue.getNombre());
                        txtTelefono.setText(newValue.getTelefono());
                        parentesco.setValue(newValue.getParentesco());
                    }
                }
        );
    }
    @FXML
    public void onSearch(){
        String nombre = txtBusqueda.getText();

        if (nombre == null || nombre.isBlank()) {
            listView.setItems(logica.obtenerLista());
            return;
        }
        Contactos encontrado = logica.buscarPorNombre(nombre);
        if (encontrado != null) {
            ObservableList<Contactos> resultadoUnico = FXCollections.observableArrayList();
            resultadoUnico.add(encontrado);
            listView.setItems(resultadoUnico);
            txtName.setText(encontrado.getNombre());
            txtTelefono.setText(encontrado.getTelefono());
            parentesco.setValue(encontrado.getParentesco());

            lblMsg.setText("Contacto encontrado");
            lblMsg.setStyle("-fx-text-fill: green");
        } else {
            listView.setItems(FXCollections.observableArrayList());
            lblMsg.setText("No se encontro el contacto");
            lblMsg.setStyle("-fx-text-fill: red");
            txtName.clear();
            txtTelefono.clear();
            parentesco.setValue(null);
        }
    }

    @FXML
    public void onAddPerson() {
        try {
            String nombre = txtName.getText();
            String telefono = txtTelefono.getText();
            Object seleccion = parentesco.getValue();
            if (seleccion == null) {
                throw new IllegalArgumentException("Debe seleccionar un parentesco de la lista.");
            }
            String parentescoF = seleccion.toString();
            if (logica.isDuplicate(nombre)) {
                throw new IllegalArgumentException("El nombre ya existe en la lista.");
            }
            logica.addContacto(nombre, telefono, parentescoF);
            lblMsg.setText("Persona agregada con éxito");
            lblMsg.setStyle("-fx-text-fill: green");
            txtName.clear();
            txtTelefono.clear();
            parentesco.setValue(null);
        } catch (IllegalArgumentException e) {
            lblMsg.setText(e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }

    @FXML
    public void onUpdate(){
        int index = listView.getSelectionModel().getSelectedIndex();
        String nombre = txtName.getText();
        String telefono = txtTelefono.getText();
        String parentescoF = parentesco.getSelectionModel().getSelectedItem().toString();
        try{
            logica.updatePerson(index, nombre, telefono, parentescoF);
            logica.validatePerson(nombre, telefono);
            lblMsg.setText("Persona agregada con exito ");
            lblMsg.setStyle("-fx-text-fill: green");
            txtName.clear();
            txtTelefono.clear();
            parentesco.setValue(null);
        } catch (IllegalArgumentException ex){
            lblMsg.setText(ex.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }
    @FXML
    public void onClean(){
        txtName.clear();
        txtTelefono.clear();
        parentesco.setValue(null);
    }

    @FXML
    public void onDelete(){
        int index = listView.getSelectionModel().getSelectedIndex();
        try{
            logica.deletContacto(index);
            lblMsg.setText("Persona eliminada correctamente");
            lblMsg.setStyle("-fx-text-fill: green");
            txtName.clear();
            txtTelefono.clear();
            parentesco.setValue(null);
        }catch (IllegalArgumentException e){
            lblMsg.setText("Hubo un error en el archivo");
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }
}
