package ar.org.centros8.java.curso.trabajo_practico_1.entidades.cuentas;

import ar.org.centros8.java.curso.trabajo_practico_1.entidades.clientes.Cliente;
import lombok.Getter;
import lombok.ToString;

@Getter

@ToString(callSuper = true)

public class CajaDeAhorro extends Cuenta {
    private double tasaDeInteres;

    public CajaDeAhorro(int nroDeCuenta, Cliente clienteAsociado, double tasaDeInteres) {
        super(nroDeCuenta, clienteAsociado);
        this.tasaDeInteres = tasaDeInteres;
    }

    @Override //  este metodo es  para depositar
    public void depositar(double monto) {
        if (monto > 0) {
        setSaldo(getSaldo() + monto);
     }
    }

    @Override //  este metodo es para sacar 
    public void extraer(double monto) {
        if (monto > 0 && monto <= getSaldo()) {
            setSaldo(getSaldo() - monto);
        }
    }

    //  este Método  es para cobrar intereses
    public void cobrarInteres() {
        setSaldo (getSaldo() + (getSaldo() * this.tasaDeInteres));
    }
} 
