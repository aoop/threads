import java.lang.Thread;

class Thrd extends Thread {
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

class exemplul_0 {
    public static void main(String[] args) {

        int NUM = 10;
        Thrd Ob1 = new Thrd(1, NUM);
        Thrd Ob2 = new Thrd(2, NUM);
        Ob1.start();
        Ob2.start();
        for (int k = 0; k < NUM; k++) 
        {
          System.out.print("0 ");
        }

    System.out.print("\n main() over \n");
    }
}