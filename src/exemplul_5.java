/*
synchronize(){}
    Synchronized methods enable a simple strategy for preventing thread interference 
    and memory consistency errors: if an object is visible to more than one thread, 
    all reads or writes to that object's variables are done through synchronized methods.
Thread 1  locks A, waits for B
Thread 2  locks B, waits for A
*/

import java.lang.Thread;
import java.lang.Runnable;

class Thrd implements Runnable {

    String name;
    Object L1;
    Object L2;
    Thrd(Object L1, Object L2, String nume) {
        this.L1 = L1;
        this.L2 = L2;
        this.name = nume;
    }

    public void functie() {
        synchronized(L1) {
            System.out.println("Thread " + name + ": Sync L1...");
            try {
                System.out.println("Sleeping a little...");
                Thread.sleep(10);
            } catch (InterruptedException e) {}
            System.out.println("Thread" + name + ": Sync L2...");
            synchronized(L2) {
                System.out.println("Thread" + name + ": Sync L1 & L2...");
            }
        }
    }


    public void run() {

        functie();

    }
}

class exemplul_5 {

    public static Object L1 = new Object();
    public static Object L2 = new Object();

    public static void main(String[] args) {

        Thrd firul1 = new Thrd(L1, L2, "TH1");
        Thread t1 = new Thread(firul1);

        Thrd firul2 = new Thrd(L2, L1, "TH2");
        Thread t2 = new Thread(firul2);

        t1.start();
        t2.start();

        System.out.print("\n main() over \n");
    }
}