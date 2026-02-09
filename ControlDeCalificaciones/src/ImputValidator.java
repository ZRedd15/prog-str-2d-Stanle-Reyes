import java.util.Scanner;
public class ImputValidator {
    public double leerDoubleEnRango(Scanner sc, String mensaje, int minimo, int maximo){
        double valor = 0;
        while (true){
            System.out.println(mensaje);
            if (sc.hasNextDouble()){
                valor = sc.nextDouble();
                if (valor >= minimo && valor <= maximo){
                    return valor;
                }else {
                    System.out.println("Estas fuera del rango (0 - 100)");
                }
            }else {
                System.out.println("El valor ingresado es un numero");
                sc.next();
            }
        }
    }
    public int leerIntEnRango(Scanner sc, String mensaje, int minimo, int maximo){
        int valor = 0;
        while (true){
            System.out.println(mensaje);
            if (sc.hasNextInt()){
                valor = sc.nextInt();
                if (valor >= minimo && valor <= maximo){
                    return valor;
                }else {
                    System.out.println("Estas fuera del rango (1 -100)");
                }
            }else {
                System.out.println("el valor ingresado no es un numero");
                sc.next();
            }
        }
    }
    public boolean leerBoolean(Scanner sc, String mensaje){
        boolean valor;
        while (true){
            System.out.println(mensaje);
            if (sc.hasNextBoolean()){
                valor = sc.nextBoolean();
                    return valor;
            }else {
                System.out.println("Ingrese solo: true / false");
                sc.next();
            }
        }
    }
    public String leerTextoNoVacio(Scanner sc, String mensaje){
        String valor = "";
        while (true){
            System.out.println(mensaje);
            valor = sc.nextLine();
            if (!valor.isEmpty()){
                return valor;
            }else {
                System.out.println("El campo no puede quedar vacio");
                sc.next();
            }
        }
    }
    public String determinarEstado(int asistencias, boolean entregaProyecto, double calificacionFinal) {
        String valor;
        if (asistencias < 80){
            valor = "REPROBADO por asistencia";
        } else if (!entregaProyecto) {
            valor =  "REPROBADO por proyecto";
        } else if (calificacionFinal < 70) {
            valor = "REPROBADO por calificacion";
        }else {
            valor = "APROBADO";
        }
        return valor;
    }
}
