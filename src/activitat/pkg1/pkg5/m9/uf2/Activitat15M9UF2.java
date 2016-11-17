package activitat.pkg1.pkg5.m9.uf2;

import java.util.concurrent.locks.*;
import java.util.concurrent.Semaphore;

public class Activitat15M9UF2 {

    public static float saldo = 2000;

    public static void main(String[] args) {

        //Declaració del semafor
        final Semaphore semaphore = new Semaphore(1, true);

        /**
         * Creem el primer run que serà per fer els ingressos al compte.
         */
        final Runnable runIngres = new Runnable() {

            /**
             * Aquest run executara el metode ingressar.
             * Es bloqueja l'acces al semafor amb acquire i es permet amb release.
             */
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

        /**
         * Creem el segón run que serà per a fer les extraccions de diners del
         * compte.
         */
        final Runnable runTreure = new Runnable() {
            /**
             * Aquest run executara el metode treure.
             * Es bloqueja l'acces al semafor amb acquire i es permet amb release.
             */
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

        /**
         * Aquest bucle serveix per a crear els 2 fils (Ingressar, treure),
         * cadascún s'executara 5 vegades i es podra veure com actua el semafor.
         */
        for (int i = 0; i < 5; i++) {
            new Thread(runIngres).start();
            new Thread(runTreure).start();
        }

    }

    /**
     * Aquest metode s'encarrega d'ingressar els diners al compte. Agafa el
     * saldo actual i el introdueix a la variable aux, a aquesta variable se li
     * sumen els diners que es volen ingressar y al final es guarda al saldo el
     * valor de aux.
     *
     * @param diners
     */
    public static void ingressar(float diners) {
        float aux, saldo;
        aux = llegirSaldo();
        aux += diners;
        saldo = aux;
        guardarSaldo(saldo);
    }

    /**
     * Aquest metode s'encarrega d'extreure els diners del compte. Agafa el
     * saldo actual i el introdueix a la variable aux, a aquesta variable se li
     * resten els diners que es volen extreure y al final es guarda al saldo el
     * valor de aux.
     *
     * @param diners
     */
    public static void treure(float diners) {

        float aux;
        aux = llegirSaldo();
        aux = aux - diners;
        saldo = aux;
        guardarSaldo(saldo);

    }

    /**
     *Aquest metode retorna el valor actual de saldo.
     * @return
     */
    public static float llegirSaldo() {
        return saldo;
    }

    /**
     * Aquest metode modifica el valor de saldo per el valor que se li passa per parametre.
     * @param saldoActualitzat 
     */
    public static void guardarSaldo(float saldoActualitzat) {
        saldo = saldoActualitzat;
    }

}
