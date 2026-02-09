import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //Declaramos el scanner y las demaas clases
        Scanner scanner = new Scanner(System.in);
        GradeService gradeService = new GradeService();
        ImputValidator imputValidator = new ImputValidator();
        // Comprueba que los valores ingresados esten en los rangos
        String nombreAlumno = imputValidator.leerTextoNoVacio
                (scanner, "Ingresa el nombre del alumno: ");
        double parcial1 = imputValidator.leerDoubleEnRango
                (scanner, "Ingresa la calificacion del primer parcial (0-100):", 0, 100);
        double parcial2 = imputValidator.leerDoubleEnRango
                (scanner, "Ingresa la calificacion del segundo parcial (0-100):", 0, 100);
        double parcial3 = imputValidator.leerDoubleEnRango
                (scanner, "Ingresa la calificacion del tercer parcial (0-100):", 0, 100);
        double promedio = gradeService.promedioDeParciales
                (parcial1, parcial2, parcial3);
        int asistencias = imputValidator.leerIntEnRango
                (scanner, "Ingresa la cantidad de asistencias: (0-100)", 0, 100);
        boolean entregaProyecto = imputValidator.leerBoolean
                (scanner, "¿Entrego proyecto? (true/false)");
        double promedioFinal = gradeService.calcularFinal(promedio, asistencias);

        //Imprimir reporte final
        gradeService.imprimirReporte(nombreAlumno, parcial1, parcial2, parcial3, promedio, asistencias, entregaProyecto, promedioFinal);
    }
}
