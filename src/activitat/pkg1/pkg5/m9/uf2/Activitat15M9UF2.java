package activitat.pkg1.pkg5.m9.uf2;

import java.util.concurrent.Semaphore;

public class Activitat15M9UF2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Semaphore semafor = new Semaphore(1, true);
        
        
    }
    

    /*
    public void ingressar(float diners) {
        sendWait();
        float aux;
        aux = llegirSaldo();
        aux = aux + diners;
        saldo = aux;
        guardarSaldo(saldo);
        sendSignal();
    }
    */
    
    /*
    public void treure(float diners) {
        sendWait();
        float aux;
        aux = llegirSaldo();
        aux = aux - diners;
        saldo = aux;
        guardarSaldo(saldo);
        sendSignal();
    }
    */
//    
//    
//import java.util.concurrent.locks.*;
//import java.util.concurrent.Semaphore;
//
//public class SemaphoreExample {
//
//int i = 0;
//
//public static void main (String[] args) {
//
//final SemaphoreExample example = new SemaphoreExample();
//
//final Semaphore semaphore = new Semaphore (1);
//
//final Runnable r = new Runnable () {
//
//public void run () {
//
//while (true) {
//
//try {
//
//semaphore.acquire();
//
////Sección crítica a proteger
//
//example.printSomething ();
//
//Thread.sleep (1000);
//
//semaphore.release();
//
//} catch (Exception ex) {
//
//System.out.println (" — Interrupted…");
//
//ex.printStackTrace ();
//
//}
//
//}
//
//}
//
//};
//
//new Thread (r).start ();
//
//new Thread (r).start ();
//
//new Thread (r).start ();
//
//}
//
//public void printSomething (){
//
//i++;
//
//System.out.println (" — current value of the i :"+ i);
//
//}
//}  


    
}
