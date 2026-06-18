package ar.org.centros8.java.curso.trabajo_practico_1.entidades.cuentas;

import ar.org.centros8.java.curso.trabajo_practico_1.entidades.clientes.ClienteEmpresa;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class CuentaConvertibilidad extends CuentaCorriente {

    private double saldoEnDolares;

    public CuentaConvertibilidad(int nroDeCuenta, ClienteEmpresa clienteAsociado, double giroEnDescubierto) {
        super(nroDeCuenta, clienteAsociado, giroEnDescubierto);
        this.saldoEnDolares = 0;
    }

    public void depositarDolares(double monto) {
        if (monto > 0) {
            this.saldoEnDolares = this.saldoEnDolares + monto;
        } else {
            System.out.println("El monto a depositar debe ser mayor a 0");
        }
    }

    public void extraerDolares(double monto) {
        if (monto > 0) {
            if (this.saldoEnDolares >= monto) {
                this.saldoEnDolares = this.saldoEnDolares - monto;
            } else {
                System.out.println("Saldo en dolares insuficiente");
            }
        } else {
            System.out.println("El monto a extraer debe ser mayor a 0");
        }
    }

    public void convertirPesosADolares(double montoEnPesos, double tasaConversion) {
        if (montoEnPesos > 0 && tasaConversion > 0) {
            if (getSaldo() >= montoEnPesos) {
                double dolaresComprados = montoEnPesos / tasaConversion;
                double nuevoSaldoEnPesos = getSaldo() - montoEnPesos;
                double nuevoSaldoEnDolares = this.saldoEnDolares + dolaresComprados;

                setSaldo(nuevoSaldoEnPesos);
                this.saldoEnDolares = nuevoSaldoEnDolares;

                System.out.println("Operacion realizada con exito");
            } else {
                System.out.println("Saldo en pesos insuficiente para realizar la operacion");
            }
        } else {
            System.out.println("El monto y la tasa de conversion deben ser mayores a 0");
        }
    }

    public void convertirDolaresAPesos(double montoEnDolares, double tasaConversion) {
        if (montoEnDolares > 0 && tasaConversion > 0) {
            if (this.saldoEnDolares >= montoEnDolares) {
                double pesosObtenidos = montoEnDolares * tasaConversion;
                double nuevoSaldoEnDolares = this.saldoEnDolares - montoEnDolares;
                double nuevoSaldoEnPesos = getSaldo() + pesosObtenidos;

                this.saldoEnDolares = nuevoSaldoEnDolares;
                setSaldo(nuevoSaldoEnPesos);

                System.out.println("Operacion realizada con exito");
            } else {
                System.out.println("Saldo en dolares insuficiente para realizar la operacion");
            }
        } else {
            System.out.println("El monto y la tasa de conversion deben ser mayores a 0");
        }
    }
}