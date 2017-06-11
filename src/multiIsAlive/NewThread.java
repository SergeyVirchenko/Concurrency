package multiIsAlive;

/**
 * Created by Sergey on 05-Jun-17.
 */
public class NewThread implements Runnable {

    Thread t;

    public NewThread(String name) {
        this.t = new Thread(this, name);
        t.start();
        System.out.println(t.getName() + " создан");
    }

    @Override
    public void run() {
        for (int i = 5; i > 0; i--) {
            System.out.println(t.getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(t.getName() + " поток завершен");
    }
}
