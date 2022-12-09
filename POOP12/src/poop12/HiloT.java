package poop12;

public class HiloT extends Thread{

    public HiloT(String name) {
        super(name);
    }
    public void run(){
        for (int i=0;i<10;i++){
            System.out.println("Iteracion " + (i+1) +" de " + getName());
        }
        System.out.println("Finalizado");
    }
}