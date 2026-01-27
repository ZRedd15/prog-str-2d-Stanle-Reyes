import java.util.Scanner;

public class ActividadIfElseTarifa {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Declaracion de variables
        int edad = 0;
        int opcion = 0;
        boolean esEstudiante = false;
        int tarifa = 0;

        //Pedimos los datos
        System.out.println("Ingresa tu edad: ");
        edad = scanner.nextInt();
        System.out.println("¿Eres estudiante?");
        System.out.println("1-si, 2-no");
        opcion = scanner.nextInt();
        esEstudiante = comprobarSiEsEstudiante(opcion);

        //Comrpobamos si entra al programa
        if (edad < 0 || edad > 120){
            System.out.println("edad invalida");
            return; // Termina el programa
        }

        // Imprime los datos
        tarifa = calcularTarifaDelUsuario(edad, esEstudiante);
        System.out.println("Tu edad es : "+edad);
        if (esEstudiante == true){
            System.out.println("Eres un estudiante");
        }else {
            System.out.println("No eres un estudiante");
        }
        System.out.println("Tu tarifa es de: "+tarifa+" pesos");

    }
    /**
     * Calculamos la tarifa que tiene que pagar el usuario
     * @param edad -> Dato ingresado por el usuario
     * @param esEstudiante -> Comprobacion que hicimos antes
     * @return
     */
    public static int calcularTarifaDelUsuario(int edad, boolean esEstudiante){
        if (edad < 12){
            return  50;
        }else if (edad >= 12 && edad <= 17){
            if (esEstudiante == true){
                return 60;
            }else {
                return 80;
            }
        }else{
            if (esEstudiante == true){
                return 90;
            }else {
                return 120;
            }
        }
    }
    /**
     * Comprobamos si es un estudiante
     * @param opcion -> opcion elegida por el usuario
     * @return
     */
    public static boolean comprobarSiEsEstudiante(int opcion){
        if (opcion == 1){
            return true;
        }else {
            return false;
        }
    }
}