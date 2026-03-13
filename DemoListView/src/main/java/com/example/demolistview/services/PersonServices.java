package com.example.demolistview.services;

import com.example.demolistview.repositores.PersonFileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonServices {
    private final PersonFileRepository repo = new PersonFileRepository();

    public List<String> loadDataForList() throws IOException {
        List<String> lines = repo.readAllLines(); //Recupera las lineas de archivo
        List<String> result = new ArrayList<>();//Listado de resultado con el formato deseado
        for (String line : lines){
            if (line==null || line.isBlank()) continue; //Ignora las lineas nulas

            String[] parts = line.split(",", -1);
            String name = parts[0].trim(); // Obtiee el nombre del arreglo
            String correo = parts[1].trim(); //Obtiene el correo del arreglo
            String edad = parts[2].trim(); //Obtiene la edad
            result.add(name+" - "+correo+" - "+edad);//Se agrega a la lista de resultados con el formato
        }
        return result;
    }

    public void addPerson(String nombre, String email, String edad) throws IOException {
        validatePerson(nombre,email,edad);
        String nameNoComan = nombre.replace(",", "");
        String emailNoComan = email.replace(",", "");
        String edadNoComan = edad.replace(",", "");

        repo.appendNewLine(nameNoComan+","+emailNoComan+","+edadNoComan);
    }
    public void updatePerson(int index, String name, String email, String edad) throws IOException {
        List<String> lines = getAllCleanLines();
        if (index == -1){
            throw new IllegalArgumentException("El indice recibido es invalido");
        }
        lines.set(index,name+","+email+","+edad);
        repo.appendAllLines(lines);
    }

    private List<String> getAllCleanLines() throws IOException {
        List<String> lines = repo.readAllLines();
        List<String> cleanLines = new ArrayList<>();
        for(String line : lines){
            if (line != null && !line.isBlank()){
                cleanLines.add(line);
            }
        }
        return cleanLines;
    }

    public void validatePerson(String nombre, String email, String edad){
        if (nombre.isBlank() || nombre.isEmpty() || nombre.length()<3 ) {
            throw new IllegalArgumentException("El nombre no cumple con los estandares");
        }
        String em = (email==null) ? "" : email.trim();
        if (em.isBlank() || !em.contains("@") || !em.contains(".")){
            throw new IllegalArgumentException("El email no es valido");
        }
        try {
            int numEdad = Integer.parseInt(edad.trim());
            if (!(numEdad >=18)){
                throw new IllegalArgumentException("Solo se aceptan mayores de 18");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("La edad debe ser numerica");
        }
    }
}
