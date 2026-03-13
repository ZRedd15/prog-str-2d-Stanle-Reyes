package com.example.demolistview.controllers;

import com.example.demolistview.services.PersonServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;

public class AppController {
    @FXML
    private ListView<String> listView;
    @FXML
    private Label lblMsg;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtEdad;

    @FXML
    private final ObservableList<String> data = FXCollections.observableArrayList();

    private PersonServices service = new PersonServices();

    @FXML
    public void initialize(){ //Se ejecuta al inicio en cuanto se cargue el controller
        //Inicializar ListView
        listView.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) ->{
            loadDataToForm(newValue);
                }
        );
        listView.setItems(data);
        loadFromFile();
    }

    @FXML
    public void onAddPerson() throws IOException {
        try {
            String name = txtName.getText();
            String email = txtEmail.getText();
            String edad = txtEdad.getText();
            service.addPerson(name,email,edad);
            loadFromFile();
            lblMsg.setText("Persona agregada con exito ");
            lblMsg.setStyle("-fx-text-fill: green");
            txtName.clear();
            txtEmail.clear();
            txtEdad.clear();
        }catch (IOException e){
            lblMsg.setText("Hubo un error ");
            lblMsg.setStyle("-fx-text-fill: red");
        }catch (IllegalArgumentException ex){
            lblMsg.setText(ex.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }

    @FXML
    public void onUpdate(){
        int index = listView.getSelectionModel().getSelectedIndex();
        String name = txtName.getText();
        String email = txtEmail.getText();
        String edad = txtEdad.getText();
        try{
            service.updatePerson(index, name, email, edad);
            service.validatePerson(name, email, edad);
            loadFromFile();
            lblMsg.setText("Persona agregada con exito ");
            lblMsg.setStyle("-fx-text-fill: green");
            txtName.clear();
            txtEmail.clear();
            txtEdad.clear();
        }catch (IOException e){
            lblMsg.setText("Hubo un error ");
            lblMsg.setStyle("-fx-text-fill: red");
        }catch (IllegalArgumentException ex){
            lblMsg.setText(ex.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }

    private void loadFromFile(){
        try{
            List<String> items = service.loadDataForList();
            data.setAll(items);
            lblMsg.setText("Datos cargados Exitosamente ");
            lblMsg.setStyle("-fx-text-fill: green");
        }catch (IOException e){
            lblMsg.setText(e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }

    private void loadDataToForm(String item){
        if (item == null || item.isBlank()){
            return;
        }
        String[] parts = item.split("-");
        txtName.setText(parts[0]); //Corresponde a la parte del nombre
        txtEmail.setText(parts[1]); //Corresponde a la parte del email
        txtEdad.setText(parts[2]); //Corresponde a la parte de
    }

}
