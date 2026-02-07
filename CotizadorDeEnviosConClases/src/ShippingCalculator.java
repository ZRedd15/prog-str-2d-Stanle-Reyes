public class ShippingCalculator {
    private final double IVA = 0.16;
    private final double PRECIO_ESTANDAR = 50;
    private final double PRECIO_EXPRESS = 90;
    private final double PRECIO_ZONA_REMOTA = 0.10;
    double calcularSubtotal(double pesoKg, int distanciaKm, int tipoServicio, boolean esZonaRemota){
        double subtotal = 0;
        if (tipoServicio == 1){
            //Servicio estandar
            subtotal+=PRECIO_ESTANDAR;
            subtotal += 12*pesoKg;
        }else {
            //Servicio express
            subtotal += PRECIO_EXPRESS;
            subtotal = subtotal+(12*pesoKg);
        }
        //Cobro por distancia
        if (distanciaKm<=50){
            subtotal+=20;
        } else if (distanciaKm <= 200) {
            subtotal+=60;
        } else{
            subtotal+=120;
        }
        // Cobro por zona remota
        if (esZonaRemota){
            subtotal = subtotal+(subtotal*PRECIO_ZONA_REMOTA);
        }
        return subtotal;
    }

    double calcularIVA(double subtotal){
        return subtotal * IVA;
    }
    double calcularTotal(double subtotal){
        return subtotal+calcularIVA(subtotal);
    }

    String esUnaZonaRural(boolean esZonaRemota){
        if (esZonaRemota){
            return "Es en una zona remota";
        }else {
            return "No es en una zona remota";
        }
    }
}
