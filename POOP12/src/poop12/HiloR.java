package poop12;

public class HiloR implements Runnable {

    @Override
    public void run() {
        for (int i=0;i<10;i++){
            System.out.println("Iteracion " + (i+1) +" de " + Thread.currentThread().getName());
        }
        System.out.println("Finaliza " + Thread.currentThread().getName());
    }
    
}
