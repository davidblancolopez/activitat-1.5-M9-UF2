package activitat.pkg1.pkg5.m9.uf2;

import java.util.concurrent.locks.*;
import java.util.concurrent.Semaphore;

public class Activitat15M9UF2 {

    public static float saldo = 2000;

    public static void main(String[] args) {

        //Declaració del semafor
        final Semaphore semaphore = new Semaphore(1, true);

        final Runnable runIngres = new Runnable() {

            public void run() {
                try {
                    semaphore.acquire();
                    ingressar(50);
                    System.out.println("Saldo actual: " + llegirSaldo());
                    semaphore.release();
                } catch (Exception e) {

                }
            }
        };

        final Runnable runTreure = new Runnable() {

            public void run() {
                try {
                    semaphore.acquire();
                    treure(50);
                    System.out.println(Thread.currentThread().getName() + " " + llegirSaldo());
                    semaphore.release();
                } catch (Exception e) {

                }

            }
        };

        for (int i = 0; i < 5; i++) {
            new Thread(runIngres).start();
            new Thread(runTreure).start();
        }

    }

    public static void ingressar(float diners) {
        float aux, saldo;
        aux = llegirSaldo();
        aux += diners;
        saldo = aux;
        guardarSaldo(saldo);
    }

    public static void treure(float diners) {

        float aux;
        aux = llegirSaldo();
        aux = aux - diners;
        saldo = aux;
        guardarSaldo(saldo);

    }

    public static float llegirSaldo() {
        return saldo;
    }

    public static void guardarSaldo(float saldoActualitzat) {
        saldo = saldoActualitzat;
    }

}
