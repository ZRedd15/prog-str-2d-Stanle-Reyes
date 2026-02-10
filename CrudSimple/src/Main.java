import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PersonaService personaService = new PersonaService();
        Persona[] personas = new Persona[20];

        int opcion = 0;
        do {
            System.out.println("Menu");
            System.out.println("1) Alta");
            System.out.println("2) Buscar por ID");
            System.out.println("3) Baja lógica por ID");
            System.out.println("4) Listar activas");
            System.out.println("5) Actualizar nombre por ID (solo activas)");
            System.out.println("0) Salir");
            System.out.print("\nIngresa una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion){
                case 1:
                    personaService.alta(personas);
                    break;
                case 2:
                    personaService.buscarIndicePorId(personas);
                    break;
                case 3:
                    personaService.BajaPorID(personas);
                    break;
                case 4:
                    personaService.listaDeActivas(personas);
                    break;
                case 5:
                    personaService.actualizarNombre(personas);
                    break;
                case 0:
                    System.out.println("Nos vemos!");
                    break;
                default:
                    System.out.println("Opcion fuera de rango");
                    break;
            }
        }while (opcion != 0);
    }
}