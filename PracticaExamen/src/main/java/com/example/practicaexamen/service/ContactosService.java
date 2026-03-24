package com.example.practicaexamen.service;

import com.example.practicaexamen.contactos.Contactos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

public class ContactosService {
    private ObservableList<Contactos> listaDeContactos = FXCollections.observableArrayList();

    public void addContacto(String nombre, String telefono, String parentesco){
            validatePerson(nombre,telefono);
            String nombreNoComa = nombre.replace(",", "");
            String telefonoNoComa = telefono.replace(",", "");
            Contactos nuevo = new Contactos(nombreNoComa, telefonoNoComa, parentesco);
            listaDeContactos.add(nuevo);
    }

    public void updatePerson(int index, String nombre, String telefono, String parentesco) {
        if (index < 0 || index >= listaDeContactos.size()) {
            throw new IllegalArgumentException("Seleccione un contacto válido de la lista para actualizar.");
        }
        validatePerson(nombre, telefono);
        Contactos contactoActualizado = new Contactos(nombre, telefono, parentesco);
        listaDeContactos.set(index, contactoActualizado);
    }

    public void deletContacto(int index) {
        if (index >= 0 && index < listaDeContactos.size()) {
            listaDeContactos.remove(index);
        } else {
            throw new IllegalArgumentException("Por favor, selecciona un contacto de la lista para eliminar.");
        }
    }

    public void validatePerson(String nombre, String telefono){
        if (nombre.isBlank() || nombre.isEmpty() || nombre.length()<3 ) {
            throw new IllegalArgumentException("El nombre no cumple con lo necesario");
        }
        try {
            if (!(telefono == null || telefono.trim().length() == 10)) {
                throw new IllegalArgumentException("El telefono de telefono ingresado no es valido");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("El telefono debe ser numerico");
        }
    }

    public boolean isDuplicate(String nombreNuevo){
        for (Contactos contacto : listaDeContactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombreNuevo.trim())) {
                return true;
            }
        }
        return false;
    }

    public Contactos buscarPorNombre(String nombre) {
        for (Contactos contacto : listaDeContactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre.trim())) {
                return contacto;
            }
        }
        return null;
    }

    public ObservableList<Contactos> obtenerLista() {
        return listaDeContactos;
    }
}
