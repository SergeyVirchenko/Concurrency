package joinExample.hasJoin;

/**
 * Created by Sergey on 05-Jun-17.
 */
public class HJThreadDemo {

    public static void main(String[] args) {
        HJNewThread hjThread = new HJNewThread();

        try {
            hjThread.t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 5; i > 0; i--) {
            System.out.println("Главный поток " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        System.out.println("Главный поток завершен");
    }
}
