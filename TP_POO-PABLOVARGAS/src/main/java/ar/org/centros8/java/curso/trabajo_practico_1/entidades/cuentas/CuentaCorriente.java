package ar.org.centros8.java.curso.trabajo_practico_1.entidades.cuentas;

import ar.org.centros8.java.curso.trabajo_practico_1.entidades.clientes.Cliente;
import lombok.Getter;
import lombok.ToString;

@Getter

@ToString(callSuper = true)

public class CuentaCorriente extends Cuenta {
    private double giroEnDescubierto;

    public CuentaCorriente(int nroDeCuenta, Cliente clienteAsociado, double giroEnDescubierto) {
        super(nroDeCuenta, clienteAsociado);
        this.giroEnDescubierto = giroEnDescubierto;
    }

    @Override
    /**
     * Este metodo lo que hace es depositar dinero en la cuenta corriente.
     * 
     * @param monto -> Monto a depositar.
     */
    public void depositar(double monto) {
        if (monto > 0) {
        setSaldo(getSaldo() + monto);
     }
    }

    @Override
    /**
     * Este metodo se encarga de sacar dinero de la cuenta corriente.
     * Si no se llega con el saldo, ahi se saca por giroDescubierto con un
     * limite en el descubierto
     * 
     * @param monto -> Monto a extraer.
     */
    public void extraer(double monto) {
        if (getSaldo() + giroEnDescubierto >= monto) {
            setSaldo(getSaldo() - monto);
        } else {
            System.out.println("Supera el límite de descubierto");
        }
    }

    /**
     *  este Método  es para  depositar cheque
     * desde el primer momento Podemos crear el cheque y luego usar el metodo.
     * @param cheque -> Cheque a depositar.
     */
    public void depositarCheque(Cheque cheque) {
        if (cheque != null) {
            depositar(cheque.getMonto());
        }
    }
}
