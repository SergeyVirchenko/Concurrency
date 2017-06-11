package joinExample.hasJoin;

/**
 * Created by Sergey on 05-Jun-17.
 */
public class HJNewThread implements Runnable {

    Thread t;

    public HJNewThread() {
        this.t = new Thread(this, "Дочерний поток");
        t.start();
        System.out.println("Дочерний поток создан");
    }

    @Override
    public void run() {
        for (int i = 5; i > 0; i--) {
            System.out.println("Дочерний поток " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Дочерний поток завершен");
    }
}
