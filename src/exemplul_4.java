/*
synchronize(){}
    Synchronized methods enable a simple strategy for preventing thread interference 
    and memory consistency errors: if an object is visible to more than one thread, 
    all reads or writes to that object's variables are done through synchronized methods.
*/

import java.lang.Thread;
import java.lang.Runnable;

class Thrd implements Runnable {
    int i;
    Thread thread;
    String nume;
    static int common_resource = 0;
    Thrd(int i, int num, String nume_thread) {
        this.i = i;
        this.nume = nume_thread;
    }

    // functie nesincronizata
    public void function_handling_common_resource1()
    {
        for (int k = 0; k < 5; ++k)
            System.out.println("Unsyc 1 " + k);
    }


    public synchronized void function_handling_common_resource2()
    {
        for (int k = 0; k < 5; ++k) 
            System.out.println("Sync funct " + k);
    }   

    public void function_handling_common_resource3()
    {
        // threadul pune lock pe intregul obiect
        synchronized(Thrd.class){
            for (int k = 0; k < 5; ++k) 
                System.out.println("Sync obj " + k);
        }
    }

    public void function_handling_common_resource4()
    {
        final Object randomObject = new Object();
        // threadul pune lock pe un obiect oarecare
        synchronized(randomObject){
            for (int k = 0; k < 5; ++k) 
                System.out.println("Unsyc 4 " + k);
        }
    }


    public void run() {
        System.out.println("Metoda run pentru " + nume);

        
        // fara sincronizare println se executa in paralel
        // imediat ce threadul este prioritizat de catre OS
        function_handling_common_resource1();
        function_handling_common_resource4();
        
        // urmatoarele functii sunt implementate cu sincronizare
        function_handling_common_resource2();
        function_handling_common_resource3();

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

class exemplul_4 {
    public static void main(String[] args) {

        int NUM = 4;
        Thrd firul1 = new Thrd(1, NUM, "Firul 1");
        Thread t1 = new Thread(firul1);
     
        Thrd firul2 = new Thrd(2, NUM, "Firul 2");
        Thread t2 = new Thread(firul2);
        
        t1.start();
        t2.start();
        
        try {
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