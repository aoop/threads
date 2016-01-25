import java.lang.Thread;
import java.lang.Runnable;

class Thrd implements Runnable {
    int i, NUM;
    Thrd(int i, int num) {
        this.i = i;
        this.NUM = num;
    }

    public void run() {
        for (int k = 0; k < NUM; ++k) 
          {
            System.out.print(i + " ");
          }
    }
}

class exemplul_1 {
    public static void main(String[] args) {

        int NUM = 10;
        Thrd Ob1 = new Thrd(1, NUM);
        Thrd Ob2 = new Thrd(2, NUM);
        Thread t1 = new Thread(Ob1);
        Thread t2 = new Thread(Ob2);
        t1.start();
        t2.start();
        for (int k = 0; k < NUM; k++) 
        {
          System.out.print("0 ");
        }

    System.out.print("\n main() over \n");
    }
}