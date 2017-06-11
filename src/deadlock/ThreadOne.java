package deadlock;

/**
 * Created by Sergey on 09-Jun-17.
 */
public class ThreadOne extends Thread {
    Thread t2;

    public ThreadOne() {
        super("ThreadOne");
        System.out.println("MyThreadOne create");
    }

    public void run() {
        System.out.println("MyThreadOne start");
        try {
            sleep(1000);
        } catch (Exception e) {

        }
        try {
            System.out.println("MyThreadOne waiting MyThreadTwo finish…");
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("MyThreadOne finished");
    }

    public void setThread2(Thread t) {
        this.t2 = t;
    }
}
