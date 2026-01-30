import java.util.Random;
import java.util.Scanner;
public class Main {
    public static int fueraDeRango = 0;
    public static int noNumerico = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int max = 100;
        int min = 1;
        int secreto = random.nextInt(100)+1;
        int intentos = 0;
        int limiteIntentos = 7;
        boolean gano = false;

        System.out.println("Adivina el numero entre (1-100)");
        while (intentos < limiteIntentos){
            int numero = obtenerNumeroValido(sc, "Intento: "+(intentos+1), min, max);
            intentos++;
            if (numero == secreto){
                System.out.println("Ganaste en el intento"+intentos+", ¡Felicidades!");
                System.out.println("Ingresaste "+noNumerico+" caracteres no numericos");
                System.out.println("Ingresaste "+fueraDeRango+" numeros fuera del rango");
                gano = true;
                break;
            }else if(numero>secreto){
                System.out.println("El numero secreto es menor a "+numero);
            }else {
                System.out.println("El numero secreto es mayor a "+numero);
            }
        }
        if (!gano){
            System.out.println("¡Perdiste!, el numero secreto era: "+secreto);
            System.out.println("Ingresaste "+noNumerico+" caracteres no numericos");
            System.out.println("Ingresaste "+fueraDeRango+" numeros fuera del rango");
        }
    }
    public static int obtenerNumeroValido(Scanner sc, String mensaje, int min, int max){
        int valor;
        while (true){
            System.out.println(mensaje);
            if(sc.hasNextInt()){
                // Es un dato numerico
                valor = sc.nextInt();
                if (valor >= min && valor <= max) {
                    return valor;
                }
                    System.out.println("El valor ingresado esta fuera del rango (1-100)");
                fueraDeRango ++;
            }else{
                noNumerico++;
                System.out.println("El dato ingresado no es numerico");
                sc.next(); // Para limpir el token que ingreso el usuario
            }
        }
    }
}