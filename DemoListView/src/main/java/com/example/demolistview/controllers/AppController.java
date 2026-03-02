package com.example.demolistview.controllers;

import com.example.demolistview.services.PersonServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class AppController {
    @FXML
    private ListView listView;
    @FXML
    private Label lblMsg;

    @FXML
    private final ObservableList data = FXCollections.observableArrayList();

    private PersonServices services = new PersonServices();
}
