public class GradeService {
    ImputValidator imputValidator = new ImputValidator();
    private final int NUMERO_DE_PARCIALES = 3;

    double promedioDeParciales(double parcial1, double parcial2, double parcial3) {
        return (parcial1 + parcial2 + parcial3) / NUMERO_DE_PARCIALES;
    }
    double calcularFinal(double promedio, int asistencia) {
        return (promedio * 0.7) + (asistencia * 0.3);
    }
    void imprimirReporte (String nombreAlumno,double parcial1,double parcial2,double parcial3,double promedio,
                          int asistencias,boolean entregaProyecto,double calificacionFinal){
        String mensajeDeEstado = imputValidator.determinarEstado(asistencias, entregaProyecto, calificacionFinal);
        if (mensajeDeEstado.equals("APROBADO")){
            System.out.println("Felicidades has aprobaste");
            System.out.println("Nombre del alumno: "+nombreAlumno);
            System.out.println("Calificacion del parcial 1: "+parcial1);
            System.out.println("Calificacion del parcial 2: "+parcial2);
            System.out.println("Calificacion del parcial 3: "+parcial3);
            System.out.println("El promedio final fue de: "+promedio);
            System.out.println("Tiene "+asistencias+" asistencias");
            if (entregaProyecto){
                System.out.println("Si entrego el proyecto");
            }else {
                System.out.println("No entrego el proyecto");
            }
            System.out.println("Promedio final: "+calificacionFinal);
        }else {
            System.out.println(mensajeDeEstado);
        }
    }
}
