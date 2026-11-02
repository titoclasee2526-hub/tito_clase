package es.iescanarias.tito;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CuentaCorriente {
    private static Lock objetoLock = new ReentrantLock();


    private int balance;

    public int obtenerBalance() {
        return balance;
    }

    public /*synchronized*/ void deposito(int cantidad) {
         objetoLock.lock();
        int nuevoBalance = balance + cantidad;
        balance = nuevoBalance;
        try {
            Thread.sleep(5);
        } catch (InterruptedException ex) { }
        finally {objetoLock.unlock();} //Libera el lock
    }

}
