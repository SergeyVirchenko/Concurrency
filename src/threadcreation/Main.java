package threadcreation;

import threadcreation.one.ExtendedThread;
import threadcreation.one.RunnableThread;
import threadcreation.two.ExtendedThreadWithRun;

/**
 * Created by Sergey on 05-Jun-17.
 */
public class Main {

    public static void main(String[] args) {
        RunnableThread rt = new RunnableThread();
        Thread thread = new Thread(rt);
        ExtendedThreadWithRun extendedThreadWithRun = new ExtendedThreadWithRun();

        extendedThreadWithRun.start();
        thread.start();

        System.out.println("ThreadDemo thread " + Thread.currentThread());

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous thread " + Thread.currentThread());
            }
        }).start();
    }
}
