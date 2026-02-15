import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Alumno[] alumno = new Alumno[25];
        ProcesoAlumnos procesoAlumnos = new ProcesoAlumnos();
        int opcion = 0;
        do {
            System.out.println("Menu");
            System.out.println("1) Alta alumno");
            System.out.println("2) Buscar por ID (solo activos)");
            System.out.println("3) Actualizar promedio por ID (solo activos)");
            System.out.println("4) Baja lógica por ID");
            System.out.println("5) Listar activos");
            System.out.println("6) Reportes");
            System.out.println("0) Salir");
            System.out.print("Ingresa una opcion: ");
            opcion = sc.nextInt();
            System.out.println("");

            switch (opcion){
                case 1:
                    procesoAlumnos.altaAlumno(alumno);
                    break;
                case 2:
                    procesoAlumnos.buscarId(alumno);
                    break;
                case 3:
                    procesoAlumnos.actualizarPromedio(alumno);
                    break;
                case 4:
                    procesoAlumnos.darDebajaAAlumno(alumno);
                    break;
                case 5:
                    procesoAlumnos.listaActivos(alumno);
                    break;
                case 6:
                    procesoAlumnos.reporte(alumno);
                    break;
                case 0:
                    System.out.println("Hasta la proxima");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }while (opcion != 0);
    }
}