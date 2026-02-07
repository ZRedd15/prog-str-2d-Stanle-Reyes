import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ImputValidator imputDataValidator = new ImputValidator();
        ShippingCalculator shippingCalculator = new ShippingCalculator();

        double pesoKg = imputDataValidator.leerDoubleEnRango(sc, "Ingresa el peso del envio (kilogramos): ", 0.1, 50);
        int distanciaKm = imputDataValidator.leerIntEnRango(sc, "Ingresa la distancia a recorrer (kilometros): ", 1, 2000);
        int tipoServicio = imputDataValidator.leerIntEnRango(sc, "Ingresa el tipo de servicio: 1) Estándar  2) Express", 1, 2);
        boolean esZonaRemota = imputDataValidator.leerBoolean(sc, "¿Es zona remota? (true/false): ");
        double subtotal = shippingCalculator.calcularSubtotal(pesoKg,distanciaKm, tipoServicio, esZonaRemota);

        System.out.println("El peso es de :"+pesoKg);
        System.out.println("La distancia es: "+distanciaKm);
        System.out.println("Elegiste el servicio numero "+tipoServicio);
        System.out.println(shippingCalculator.esUnaZonaRural(esZonaRemota));
        System.out.println("\nEl subtotal es de: "+subtotal);
        System.out.println("El iva calculado es de: "+shippingCalculator.calcularIVA(subtotal));
        System.out.println("El precio final es de: "+shippingCalculator.calcularTotal(subtotal));

    }
}