package syncs.failsync;

/**
 * Created by Sergey on 05-Jun-17.
 */
public class Producer implements Runnable {

    private Q q;

    Producer(Q q) {
        this.q = q;
        new Thread(this, "syncs.sync.Producer").start();
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            q.put(i++);
        }
    }
}
