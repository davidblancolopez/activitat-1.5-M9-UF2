package activitat.pkg1.pkg5.m9.uf2;

import java.util.concurrent.locks.*;
import java.util.concurrent.Semaphore;

public class Activitat15M9UF2 {

    float saldo = 2000;


    public static void main(String[] args) {

        final Activitat15M9UF2 example = new Activitat15M9UF2();

        final Semaphore semaphore = new Semaphore(1);

        final Runnable r = new Runnable() {

            public void run() {

                while (true) {

                    try {

                        semaphore.acquire();

                        //Sección crítica a proteger
                        example.printSomething();

                        Thread.sleep(1000);

                        semaphore.release();

                    } catch (Exception ex) {

                        System.out.println(" — Interrupted…");

                        ex.printStackTrace();

                    }

                }

            }

        };

        new Thread(r).start();

        new Thread(r).start();

    }

    public void printSomething() {

        System.out.println("Saldo actual: " + saldo );

    }

    public void ingressar(float diners) {
        sendWait();
        float aux;
        aux = llegirSaldo();
        aux = aux + diners;
        saldo = aux;
        guardarSaldo(saldo);
        sendSignal();
    }

    public void treure(float diners) {
        sendWait();
        float aux;
        aux = llegirSaldo();
        aux = aux - diners;
        saldo = aux;
        guardarSaldo(saldo);
        sendSignal();
    }

    public float llegirSaldo(){  
        return saldo;
    }
    
    public void guardarSaldo(float saldoActualitzat){
        saldo = saldoActualitzat;
    }
    
    
}
