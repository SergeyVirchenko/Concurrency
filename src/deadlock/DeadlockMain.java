package deadlock;

/**
 * Created by Sergey on 09-Jun-17.
 */
public class DeadlockMain {
    public static void main(String[] args) {
        ThreadOne t1 = new ThreadOne();
        ThreadTwo t2 = new ThreadTwo();

        t1.setThread2(t2);
        t2.setThread1(t1);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
