import java.util.Scanner;
public class ActividadSwitchCalculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        double primerNumero = 0;
        double segundoNumero = 0;
        double resultado = 0;

        System.out.println("Menu");
        System.out.println("1- Suma");
        System.out.println("2- Resta");
        System.out.println("3- Multiplicacion");
        System.out.println("4- Division");
        System.out.print("Ingresa tu opcion: ");
        opcion = scanner.nextInt();

        switch (opcion){
            case 1:
                primerNumero = recibirDato(scanner, "Ingresa el primer numero:");
                segundoNumero = recibirDato(scanner, "Ingresa el segundo numero:");
                resultado = sumarNumeros(primerNumero, segundoNumero);
                break;
            case 2:
                primerNumero = recibirDato(scanner, "Ingresa el primer numero:");
                segundoNumero = recibirDato(scanner, "Ingresa el segundo numero:");
                resultado = restarNumeros(primerNumero, segundoNumero);
                break;
            case 3:
                primerNumero = recibirDato(scanner, "Ingresa el primer numero:");
                segundoNumero = recibirDato(scanner, "Ingresa el segundo numero:");
                resultado = MultiplicarNumeros(primerNumero, segundoNumero);
                break;
            case 4:
                primerNumero = recibirDato(scanner, "Ingresa el primer numero:");
                segundoNumero = recibirDato(scanner, "Ingresa el segundo numero:");
                if (segundoNumero == 0){ // Comprobamos que el segundo numero no sea 0
                    System.out.println("No se puede dividir entre 0");
                }else {
                    resultado = dividirNumeros(primerNumero, segundoNumero);
                }
                break;
            default:
                System.out.println("Opcion invalida");
                break;
        }
        //Imprimimos datos
        if (opcion >= 1 && opcion <= 4){
            String opcionElegida = opcionDeUsuario(opcion);
            System.out.println("\nElejiste la operacion "+opcionElegida);
            System.out.println("Tu primer valor es: "+primerNumero);
            System.out.println("Tu segundo numero es: "+segundoNumero);
            if (opcion == 4 && segundoNumero == 0){
                return; // termina el programa sin mostrar el resultado
            }else {
                System.out.println("El resultado es: "+resultado);
            }
        }
    }

    /**
     * Clase usada para solicitar los datos
     * @param sc -> Scanner usado
     * @param mensaje -> Mensaje que le mandamos al usuario
     * @return
     */
    public static double recibirDato(Scanner sc, String mensaje){
        System.out.println(mensaje);
        return sc.nextDouble();
    }

    //Clases usadas para clcular el resultado
    public static double sumarNumeros(double variableA, double variableB){
        return variableA + variableB;
    }

    public static double restarNumeros(double variableA, double variableB){
        return variableA - variableB;
    }

    public static double MultiplicarNumeros(double variableA, double variableB){
        return variableA * variableB;
    }

    public static double dividirNumeros(double variableA, double variableB){
        return variableA / variableB;
    }

    /**
     * Clase usada para saber que opcion eligio el usuario
     * @param opcion
     * @return
     */
    public static String opcionDeUsuario(int opcion) {
        if (opcion == 1) {
            return "Suma";
        }else if (opcion == 2){
            return "Resta";
        }else if (opcion == 3){
            return "Multiplicacion";
        }else {
            return "Division";
        }
    }
}