package simpleSync;

/**
 * Created by Sergey on 09-Jun-17.
 */
public class Caller implements Runnable {
    String msg;
    CallMe target;
    Thread t;

    public Caller(CallMe targ, String s, int priority) {
        target = targ;
        msg = s;
        t = new Thread(this);
        t.setPriority(priority);
        t.start();
    }

    @Override
    public void run() {

        target.call(msg);
    }
}
