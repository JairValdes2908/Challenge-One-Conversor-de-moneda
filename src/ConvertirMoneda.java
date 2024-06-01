import java.util.Scanner;

public class ConvertirMoneda {

    public static void convertir(String monedaInicial, String monedaFinal, ConsultarMoneda consulta, Scanner lectura){
        double cantidad;
        double cantidadConvertida;

        Monedas monedas = consulta.buscarMonedas(monedaInicial, monedaFinal);
        System.out.println("La Tasa de cambio del dia de hoy es:\n1 "+ monedaInicial+" = "+monedas.conversion_rate()+" "+monedaFinal);
        System.out.println("Ingresa la cantidad " + monedaInicial);
        cantidad = Double.parseDouble(lectura.nextLine());
        cantidadConvertida = cantidad * monedas.conversion_rate();
        System.out.println(cantidad+" "+monedaInicial +" = " +cantidadConvertida + " " + monedas.target_code());

    }
    public static void  convertirOtraMoneda(ConsultarMoneda consulta, Scanner lectura){
        System.out.println("Ingrese el codigo de la moneda inicial:");
        String monedaInicial = lectura.nextLine().toUpperCase();
        System.out.println("Ingrese la moneda a convertir:");
        String monedaFinal = lectura.nextLine().toUpperCase();
        convertir(monedaInicial, monedaFinal, consulta, lectura);
    }
}
