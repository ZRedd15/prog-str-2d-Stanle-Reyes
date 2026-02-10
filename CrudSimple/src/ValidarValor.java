import java.util.Scanner;
public class ValidarValor {
    public int validarId(Scanner sc, String mensaje, Persona[] personas){
        int valor = 0;
        while (true){
            System.out.print(mensaje);
            if (sc.hasNextInt()){
                valor = sc.nextInt();
                if (valor>=0 && valor <20){
                    return valor;
                }else {
                    System.out.println("El id tiene que ser mayor a 0 y menor a 20");
                }
            }else {
                System.out.println("El valor ingresado no es valido");
                sc.next();
            }
        }
    }
    public String validarNombre(Scanner sc, String mensaje){
        while (true){
            System.out.print(mensaje);
            String valor = sc.next();
            if (!valor.isEmpty()){
                return valor;
            }else {
                System.out.print("El campo no puede quedar vacio");
                sc.next();
            }
        }
    }
}
