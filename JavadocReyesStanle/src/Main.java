import java.util.Scanner;

public class Main {
    public static double VALOR_DE_PI = 3.1416;
    public static double PESO_BAJO = 18.5;
    public static double PESO_MEDIO = 25;
    public static double PESO_ALTO = 30;
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Calcular IMC");
            System.out.println("2. Calcular area de un rectángulo");
            System.out.println("3. Convertir °C a °F");
            System.out.println("4. calcular area de un circulo");
            System.out.println("Pulsa cualquier otro numero para salir");
            System.out.print("Ingresa tu respuesta: ");
            opcion = scanner.nextInt();

            if (opcion == 1){//Calcular imc
                double pesoKG = obtenerDouble(scanner, "Ingresa el peso en kilogramos");
                double alturaM = obtenerDouble(scanner, "Ingresa la altura en metros: ");
                double imc = calcularImc(pesoKG, alturaM);
                System.out.println("\n*******Tu imc es: "+imc+" *******");
                System.out.println("******* "+obtenerClasificacion(imc)+" *******");
            }
            else if (opcion == 2){//Calcular area de un rectangulo
                double base = obtenerDouble(scanner, "Ingresa la base del rectangulo: ");
                double altura = obtenerDouble(scanner, "Ingresa la altura: ");
                double area = calcularAreaRectangulo(base, altura);
                System.out.println("\n******* El area de el rectangulo es: "+area+" *******");
            }
            else if (opcion == 3) {//Cambiar grados Celcius a Fahrenheit
                double celcius = obtenerDouble(scanner, "Ingresa los grados celcius: ");
                double fahrenheit = conversionDeGrados(celcius);
                System.out.println("\n*******"+celcius+" grados celcius equivalen a "+fahrenheit+" grados fahrenheit *******");
            }
            else if (opcion == 4) {//Calcular el area de un circulo
                double radio = obtenerDouble(scanner, "Ingresa el radio del circulo: ");
                double area = areaCirculo(radio);
                System.out.println("\n******* El area del circulo es: "+area+" *******");
            }
            else{//Mensaje de despedida
                System.out.println("\n******* Hasta la proxima *******");
                }
        }while (opcion > 0 && opcion < 5);
        scanner.close();

    }
    /**
     * Este metodo lo usamos para pedir diferentes datos Double
     * @param sc -> Nombre del Scanner en este metodo
     * @param mensaje -> Mensaje enviado al usuario
     * @return
     */
    public static double obtenerDouble(Scanner sc, String mensaje){
        System.out.println(mensaje);
        return sc.nextDouble();
    }
    /**
     * Metodos usados para calcular el imc de una persona
     * @param pesoKG
     * @param alturaM
     * @return
     */
    public static double calcularImc(double pesoKG, double alturaM) {
        return pesoKG / (alturaM * alturaM);
    }
    public static String obtenerClasificacion(double imc){
        if(imc<PESO_BAJO) return "Bajo peso";
        else if(imc<PESO_MEDIO) return "Peso medio";
        else if(imc<PESO_ALTO) return "Sobre peso";
        else return "Obesidad";
    }

    /**
     * Calculamos el area de un rectangulo
     * @param base -> Dato pedido anteriormente en el metodo obtenerDouble()
     * @param altura -> Dato pedido anteriormente en el metodo obtenerDouble()
     * @return
     */
    public static double calcularAreaRectangulo(double base, double altura){
        return base*altura;
    }

    /**
     * Convertimos grados celcius a fahrenheit utilizando la formula
     * @param celcius -> dato ingresado por el usuario
     * @return
     */
    public static double conversionDeGrados(double celcius){
        return (celcius * 1.8)+32;
    }

    /**
     * Calculamos el area de un circulo
     * @param radio -> dato ingresado por el usuario
     * @return
     */
    public static double areaCirculo(double radio){
        return VALOR_DE_PI*(radio*radio);
    }
}
