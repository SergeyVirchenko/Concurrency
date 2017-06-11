package MultiThread;

/**
 * Created by Sergey on 05-Jun-17.
 */
public class ThreadDemo {

    public static void main(String[] args) {
        new NewThread("Один");
        new NewThread("Два");
        new NewThread("Три");
        for (int i = 5; i > 0; i--) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Главный поток завершен");
    }
}
