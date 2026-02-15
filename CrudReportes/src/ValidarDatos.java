import java.util.Scanner;
public class ValidarDatos {
    public int comprobarId(Scanner sc, String msj){
        int valor = 0;
        while (true){
            System.out.print(msj);
            if (sc.hasNextInt()){
                valor = sc.nextInt();
                if (valor >= 0 && valor<= 24){
                    return valor;
                }else {
                    System.out.println("El valor esta fuera de rango (0-24)");
                }
            }else {
                System.out.println("Valor no valido");
                sc.next();
            }
        }
    }
    public String comprobarNombre(Scanner sc, String msj){
        String valor = "";
        while (true){
            System.out.print(msj);
            valor = sc.next();
            if (!(valor.isEmpty())){
                return valor;
            }else {
                System.out.println("El campo no puede quedar vacio");
                sc.next();
            }
        }
    }
    public double comprobarPromedio(Scanner sc, String msj){
        double valor = 0;
        while (true){
            System.out.print(msj);
            if (sc.hasNextDouble()){
                valor = sc.nextDouble();
                if (valor >= 0 && valor<=10){
                    return valor;
                }else {
                    System.out.println("El valor esta fuera del rango (0-10)");
                }
            }else {
                System.out.println("Valor no valido");
                sc.next();
            }
        }
    }
}
