package threadcreation.two;

/**
 * Created by Sergey on 05-Jun-17.
 */
public class ExtendedThreadWithRun extends Thread {

    @Override
    public void run() {
        System.out.println("ExtendedThreadWithRun thread " + Thread.currentThread());
    }
}
