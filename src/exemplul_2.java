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




class exemplul_2 {
    public static void main(String[] args) {

        int NUM = 10;
        Thrd firul1 = new Thrd(1, NUM, "Firul 1");
        firul1.executa();

        Thrd firul2 = new Thrd(2, NUM, "Firul 2");
        firul2.executa();

        System.out.print("\n main() over \n");
    }
}