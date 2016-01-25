/*
setPriority(int newPriority) - Changes the priority of this thread.
join() - Waits for this thread to die, then continues the process
*/

import java.lang.Thread;
import java.lang.Runnable;

class Thrd implements Runnable {
    int i, NUM;
    Thread thread;
    String nume;
    Thrd(int i, int num, String nume_thread) {
        this.i = i;
        this.NUM = num;
        this.nume = nume_thread;
    }

    public void run() {
        System.out.println("Metoda run pentru " + nume);

        try {
            for (int k = 0; k < NUM; ++k) {
                System.out.print(i + " ");
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + nume + " interrupted.");
        }
        System.out.println("Thread " + nume + " exiting.");
    }

    public void executa() {
        System.out.println("Executa " + nume);
        if (null == thread) {
            thread = new Thread(this, nume);
            thread.start();
        }
    }
}

class exemplul_3 {
    public static void main(String[] args) {

        int NUM = 10;
        Thrd firul1 = new Thrd(1, NUM, "Firul 1");
        Thread t1 = new Thread(firul1);
        // prioritatea variaza intre 1 si 10
        t1.setPriority(Thread.MIN_PRIORITY);

        Thrd firul2 = new Thrd(2, NUM, "Firul 2");
        Thread t2 = new Thread(firul2);
        // prioritatile nu pot fi fortate
        t2.setPriority(Thread.MAX_PRIORITY);
        
        t1.start();
        t2.start();

        try {
        // observati care thread se termina primul
          t2.join(); t1.join(); 
        }
        catch(InterruptedException e) { 
          System.out.println("A thread was interrupted.");
        }

        // spre deosebire exemplele anterioare, mesajul urmator 
        // este afisat chiar la finalul thread-ului principal 
        System.out.print("\n main() over \n");
    }
}