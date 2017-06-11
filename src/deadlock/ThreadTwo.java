package deadlock;

/**
 * Created by Sergey on 09-Jun-17.
 */
public class ThreadTwo extends Thread {
    Thread t1;

    public ThreadTwo() {
        super("ThreadTwo");
        System.out.println("ThreadTwo create");
    }

    public void run() {
        System.out.println("ThreadTwo start");
        try {
            sleep(1000);
        } catch (Exception e) {

        }
        try {
            System.out.println("ThreadTwo waiting ThreadOne finish…");
            t1.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("ThreadTwo finished");
    }

    public void setThread1(Thread t) {
        this.t1 = t;
    }
}
