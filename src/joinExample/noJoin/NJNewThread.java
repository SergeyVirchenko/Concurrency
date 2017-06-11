package joinExample.noJoin;

/**
 * Created by Sergey on 05-Jun-17.
 */
public class NJNewThread implements Runnable {

    Thread t;

    public NJNewThread() {
        this.t = new Thread(this, "Дочерний поток");
        t.start();
        System.out.println("Дочерний поток создан");
    }

    @Override
    public void run() {
        for (int i = 5; i > 0; i--) {
            System.out.println("Дочерний поток " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Дочерний поток завершен");
    }
}
