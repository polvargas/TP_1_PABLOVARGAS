package ar.org.centros8.java.curso.trabajo_practico_1.tests;

import java.time.LocalDate;

import ar.org.centros8.java.curso.trabajo_practico_1.entidades.clientes.Cliente;
import ar.org.centros8.java.curso.trabajo_practico_1.entidades.clientes.ClienteEmpresa;
import ar.org.centros8.java.curso.trabajo_practico_1.entidades.clientes.ClienteIndividual;
import ar.org.centros8.java.curso.trabajo_practico_1.entidades.cuentas.CajaDeAhorro;
import ar.org.centros8.java.curso.trabajo_practico_1.entidades.cuentas.Cheque;
import ar.org.centros8.java.curso.trabajo_practico_1.entidades.cuentas.CuentaConvertibilidad;
import ar.org.centros8.java.curso.trabajo_practico_1.entidades.cuentas.CuentaCorriente;

public class TestTP1 {

    public static void main(String[] args) {

        System.out.println("###################### TEST CLIENTES ######################");

        // SE CREA UN CLIENTE INDIVIDUAL PARA PROBAR CAJA DE AHORRO.
        Cliente clienteIndividual1 = new ClienteIndividual(1, "Braulio", "Pardo", "32744123");
        System.out.println(clienteIndividual1);

        // SE CREA UN CLIENTE EMPRESA PARA PROBAR CUENTA CORRIENTE Y CUENTA CONVERTIBILIDAD.
        ClienteEmpresa clienteEmpresa1 = new ClienteEmpresa(101, "Supermercado Pirulo", "27-40157963-3");
        System.out.println(clienteEmpresa1);

        System.out.println();
        System.out.println("###################### TEST CAJA DE AHORRO ######################");

        // SE CREA UNA CAJA DE AHORRO CON SALDO INICIAL EN 0.
        CajaDeAhorro cajaDeAhorro1 = new CajaDeAhorro(10, clienteIndividual1, 5);
        System.out.println(cajaDeAhorro1);

        // SE DEPOSITA DINERO EN LA CAJA DE AHORRO.
        cajaDeAhorro1.depositar(100000);
        System.out.println(cajaDeAhorro1);

        // SE EXTRAE DINERO DE LA CAJA DE AHORRO.
        cajaDeAhorro1.extraer(50000);
        System.out.println(cajaDeAhorro1);

        // SE COBRA INTERES SOBRE EL SALDO.
        cajaDeAhorro1.cobrarInteres();
        System.out.println(cajaDeAhorro1);

        System.out.println();
        System.out.println("###################### TEST CUENTA CORRIENTE ######################");

        // SE CREA UNA CUENTA CORRIENTE CON GIRO EN DESCUBIERTO DE 10000.
        CuentaCorriente cuentaCorriente1 = new CuentaCorriente(102, clienteEmpresa1, 10000);
        System.out.println(cuentaCorriente1);

        // SE DEPOSITAN 100000 PESOS.
        cuentaCorriente1.depositar(100000);
        System.out.println(cuentaCorriente1);

        // SE EXTRAEN 105000 PESOS.
        // DEBERIA PERMITIRLO PORQUE USA 5000 DEL GIRO EN DESCUBIERTO.
        cuentaCorriente1.extraer(105000);
        System.out.println(cuentaCorriente1);

        // SE INTENTA EXTRAER 10000 PESOS MAS.
        // DEBERIA RECHAZARLO PORQUE SUPERA EL LIMITE DEL DESCUBIERTO.
        cuentaCorriente1.extraer(10000);
        System.out.println(cuentaCorriente1);

        // SE CREA Y SE DEPOSITA UN CHEQUE.
        Cheque cheque1 = new Cheque(10000, "Galicia", LocalDate.of(2026, 4, 17));
        cuentaCorriente1.depositarCheque(cheque1);
        System.out.println(cuentaCorriente1);

        System.out.println();
        System.out.println("###################### TEST CUENTA CONVERTIBILIDAD ######################");

        // SE CREA UNA CUENTA CONVERTIBILIDAD.
        // ES UNA CUENTA CORRIENTE, PERO ADEMAS PUEDE OPERAR EN DOLARES.
        CuentaConvertibilidad cuentaConvertibilidad1 = new CuentaConvertibilidad(201, clienteEmpresa1, 10000);
        System.out.println(cuentaConvertibilidad1);

        // SE DEPOSITAN PESOS USANDO EL METODO HEREDADO DE CUENTA CORRIENTE.
        cuentaConvertibilidad1.depositar(100000);
        System.out.println(cuentaConvertibilidad1);

        // SE DEPOSITAN DOLARES.
        cuentaConvertibilidad1.depositarDolares(100);
        System.out.println(cuentaConvertibilidad1);

        // SE EXTRAEN DOLARES.
        // EN DOLARES NO SE USA GIRO EN DESCUBIERTO.
        cuentaConvertibilidad1.extraerDolares(50);
        System.out.println(cuentaConvertibilidad1);

        // SE DEFINE LA TASA DE CONVERSION.
        // EJEMPLO: 1 DOLAR = 1000 PESOS.
        double tasaConversion = 1000;

        // SE CONVIERTEN PESOS A DOLARES.
        cuentaConvertibilidad1.convertirPesosADolares(20000, tasaConversion);
        System.out.println(cuentaConvertibilidad1);

        // SE CONVIERTEN DOLARES A PESOS.
        cuentaConvertibilidad1.convertirDolaresAPesos(10, tasaConversion);
        System.out.println(cuentaConvertibilidad1);

        System.out.println();
        System.out.println("###################### FIN DEL TEST ######################");
    }
}