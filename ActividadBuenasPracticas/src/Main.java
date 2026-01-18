import java.util.Scanner;
public class Main{
    public static void main(String[]a){
        //Declaracion de variables
        int numeroIngresado = pedirNumero();
        int sumaFinal = sumarHastaN(numeroIngresado);
        System.out.println("La suma de 1 hasta "+numeroIngresado+" es: "+sumaFinal);
    }

    //En esta clase se pide al usuario un numero
    public static int pedirNumero() {
        Scanner sc = new Scanner(System.in);
        int numeroIngresado = 0;
        do {
            System.out.print("Introduce un número entero positivo: ");
            numeroIngresado = sc.nextInt();
            if (numeroIngresado < 0){
                System.out.println("El numero ingresado no es valido, intenta otro");
            }
        }while (numeroIngresado < 0);
        return numeroIngresado;
    }

    //Aqui se suman los numeros de 1 hasta el numero ingresado
    public static int sumarHastaN(int numero) {
        int suma = 0;
        for (int i = 1; i <= numero; i++) {
            suma += i;
        }
        return suma;
    }
}