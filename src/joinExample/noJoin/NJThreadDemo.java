package joinExample.noJoin;

/**
 * Created by Sergey on 05-Jun-17.
 */
public class NJThreadDemo {

    public static void main(String[] args) {
        new NJNewThread();
        for (int i = 5; i > 0; i--) {
            System.out.println("Главный поток " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Главный поток завершен");
    }
}
