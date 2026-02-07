import java.util.Scanner;
public class ImputValidator {
    public int leerIntEnRango(Scanner scanner, String msg,int min,int max){
        int value;
        while (true){
            System.out.println(msg);
            if (scanner.hasNextInt()){
                value = scanner.nextInt();
                if (value>=min && value <= max){
                    return value;
                }
                System.out.println("El dato esta fuera de rango (1-2000)");
            }else {
                System.out.println("El dato no es numerico");
                scanner.next();
            }
        }
    }

    public double leerDoubleEnRango(Scanner sc, String msg, double min, double max){
        double value;
        while (true){
            System.out.println(msg);
            if (sc.hasNextDouble()){
                value = sc.nextDouble();
                if (value >= min && value <= max){
                    return value;
                }
                System.out.println("Valor fuera de rango");
            }else {
                System.out.println("No es un dato numerico");
                sc.next();
            }
        }
    }
    public boolean leerBoolean(Scanner sc, String msg) {
        while (true) {
            System.out.println(msg);
            if (sc.hasNextBoolean()) {
                return sc.nextBoolean();
            } else {
                System.out.println("El valor ingresado no es boolean (true-false)");
                sc.next();
            }
        }
    }
}