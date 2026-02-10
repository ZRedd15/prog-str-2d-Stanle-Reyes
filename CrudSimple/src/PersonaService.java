import java.util.Scanner;

public class PersonaService {
    Scanner scanner = new Scanner(System.in);
    ValidarValor validarValor = new ValidarValor();
    private Persona[] personas = new Persona[20];

    public void alta(Persona[] personas) {
        int id = validarValor.validarId(scanner, "Ingresa el nuevo ID: ", personas);
        int idLibre = -1;
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] == null) {
                idLibre = i;
                break;
            }
        }
        if (idLibre == -1) {
            System.out.println("El arreglo esta lleno");
            return;
        }
        while (true) {
            boolean duplicado = false;
            for (Persona persona : personas) {
                if (persona != null && persona.getId() == id) {
                    duplicado = true;
                    break;
                }
            }
            if (duplicado) {
                System.out.println("El id "+id+" ya existe");
                return;
            } else {
                String nombre = validarValor.validarNombre(scanner, "Ingresa el nombre: ");
                personas[idLibre] = new Persona(id, nombre);
                System.out.println("La persona se registro correctamente");
                break;
            }
        }
    }
    void buscarIndicePorId(Persona[] personas) {
        boolean idEncontrado = false;
        int id = validarValor.validarId(scanner, "Ingresa el ID a buscar: ", personas);

        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null && personas[i].getId() == id) {
                System.out.println(personas[i]);
                idEncontrado = true;
                break;
            }
        }
        if (!idEncontrado){
            System.out.println("No se encontro ese ID");
        }
    }
    void BajaPorID(Persona[] personas){
        boolean idEncontrado = false;
        int id = validarValor.validarId(scanner, "Ingresa el ID a para dar de baja: ", personas);
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null && personas[i].getId() == id) {
                personas[i] = null;
                System.out.println("La baja fue exitosa");
                idEncontrado = true;
                break;
            }
        }
        if (!idEncontrado){
            System.out.println("No se encontro ese ID");
        }
    }
    void listaDeActivas(Persona [] personas){
        boolean idEncontrado = false;
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null) {
                System.out.println(personas[i]);
                idEncontrado = true;
            }
        }
        if (!idEncontrado){
            System.out.println("No hay Id registradas");
        }

    }
    void actualizarNombre(Persona [] personas){
        int id = validarValor.validarId(scanner, "Ingresa el ID a actualizar: ", personas);
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null && personas[i].getId() == id && personas[i].isActiva()) {
                String nombre = validarValor.validarNombre(scanner, "Ingresa el nuevo nombre: ");
                personas[i].setNombre(nombre);
                System.out.println("El nombre se actualizo correctamente");
                return;
            }
        }
        System.out.println("No se encontro la id o esta desactivada");
    }

}