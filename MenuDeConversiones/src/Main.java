import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        double resultado = 0;
        int numeroDeConversiones = 0;
        int calcularFahrenheit = 0;
        int calcularCelcius = 0;
        int calcularKilometros = 0;
        int calcularMillas = 0;

        do {
            System.out.println("Menu");
            System.out.println("1) °C a °F ");
            System.out.println("2) °F a °C");
            System.out.println("3) Km a Millas");
            System.out.println("4) Millas a Km");
            System.out.println("5) Salir");
            opcion = obtenerNumeroValido(sc, "Ingresa tu opcion: ");

            switch (opcion){
                case 1:
                    double celcius = obtenerValor(sc, "Ingresa los grados celcius a convertir: ");
                    resultado = convertirCelcius(celcius);
                    System.out.println(celcius+" grados celcius son :"+resultado+" grados fahrenheit\n");
                    numeroDeConversiones ++;
                    calcularFahrenheit ++;
                    break;
                case 2:
                    double fahrenheit = obtenerValor(sc, "Ingresa los grados fahrenheit: ");
                    resultado = convertirFahrenheit(fahrenheit);
                    System.out.println(fahrenheit+" grados fahrenheit son :"+resultado+" grados celcius\n");
                    numeroDeConversiones ++;
                    calcularCelcius ++;
                    break;
                case 3:
                    double kilometros = obtenerValor(sc, "Ingresa los kilometros a convertir: ");
                    resultado = convertirKilometros(kilometros);
                    System.out.println(kilometros+" kilometros son :"+resultado+" millas\n");
                    numeroDeConversiones ++;
                    calcularMillas ++;
                    break;
                case 4:
                    double millas = obtenerValor(sc, "Ingresa las millas a convertir: ");
                    resultado = convertirMillas(millas);
                    System.out.println(millas+" millas son :"+resultado+" kilometros\n");
                    numeroDeConversiones ++;
                    calcularKilometros ++;
                    break;
            }
        }while (opcion != 5);

        System.out.println("\nResumen: ");
        System.out.println("Total de conversiones: "+numeroDeConversiones);
        System.out.println("°C a °F: "+calcularFahrenheit);
        System.out.println("°F a °C: "+calcularCelcius);
        System.out.println("Km a Millas: "+calcularMillas);
        System.out.println("Millas a Km: "+calcularKilometros);
        sc.close();
    }

    //Metodos usados para el codigo
    public static double obtenerValor(Scanner sc, String mensaje){
        while (true){
            System.out.print(mensaje);
            if(sc.hasNextDouble()){
                return sc.nextDouble();
            }else {
                System.out.println("El dato ingresado no es numerico");
                sc.next();
            }
        }
    }
    public static int obtenerNumeroValido(Scanner sc, String mensaje){
        int valor;
        while (true){
            System.out.print(mensaje);
            if(sc.hasNextInt()){
                // Es un dato numerico
                valor = sc.nextInt();
                if (valor >= 1 && valor <= 5) {
                    return valor;
                }
                System.out.println("El valor ingresado esta fuera del rango (1-5)");
            }else{
                System.out.println("El dato ingresado no es numerico");
                sc.next(); // Para limpir el token que ingreso el usuario
            }
        }
    }

    public static double convertirCelcius(double celcius){
        return  (celcius * 9/5) + 32;
    }
    public static double convertirFahrenheit(double fahrenheit){
        return (fahrenheit - 32) * 5/9;
    }
    public static double convertirKilometros(double kilometros){
        return kilometros * 0.62137;
    }
    public static double convertirMillas(double millas){
        return millas * 1609;
    }
}