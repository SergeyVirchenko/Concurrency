package threadcreation.one;

/**
 * Created by Sergey on 05-Jun-17.
 */
public class RunnableThread implements Runnable {

    @Override
    public void run() {
        System.out.println("Runnable thread " + Thread.currentThread());
    }
}
