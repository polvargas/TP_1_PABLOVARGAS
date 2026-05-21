package ar.org.centros8.java.curso.trabajo_practico_1.entidades.cuentas;

import ar.org.centros8.java.curso.trabajo_practico_1.entidades.clientes.Cliente;
import lombok.Getter;
import lombok.ToString;

@Getter

@ToString
public abstract class Cuenta {
    private int nroDeCuenta;
    private Cliente clienteAsociado;
    private double saldo;

    public Cuenta(int nroDeCuenta, Cliente clienteAsociado) {
        this.nroDeCuenta = nroDeCuenta;
        this.clienteAsociado = clienteAsociado;
    }



    public abstract void depositar(double monto);
    public abstract void extraer(double monto);

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
