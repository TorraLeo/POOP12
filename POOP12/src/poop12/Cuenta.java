package poop12;

public class Cuenta extends Thread {
    public Cuenta(String name) {
        super(name);
        saldo = 0;
        exitos = 0;

    }

    private static double saldo; // static porque se debe de compartir entre todos los hilos
    private static int exitos;

    public static double consultaSaldo() {
        return saldo;
    }

    public synchronized void deposotarDinero(double monto) {
        saldo += monto;
        exitos += 1;
        System.out.println("\n" + getName() + " Depositando..." + monto + " Saldo es:" + saldo + ", exito#" + exitos);
        try {
            sleep(500);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        notifyAll();
    }

    public synchronized void retirarDinero(double monto) {
        if (saldo <= 0) {
            System.out.println(getName() + " debe esperar deposito, " + "Su saldo es: " + saldo);
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            saldo -= monto;
            exitos += 1;
            System.out
                    .println("\n" + getName() + " retiró: " + monto + " Saldo actual: $" + saldo + ", exito#" + exitos);
        }
        notifyAll(); // indica que termina el metodo
    }

    @Override
    public void run() {
        do {
            if (getName().equals("Deposito 1") || getName().equals("Deposito 2"))
                this.deposotarDinero(100); // unicamente de esta instancia se va a ratirar
            else
                this.retirarDinero(50);
        } while (exitos < 50);
    }
}
