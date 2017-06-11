package syncs.sync;

/**
 * Created by Sergey on 05-Jun-17.
 */
public class Consumer implements Runnable {

    private Q q;

    Consumer(Q q) {
        this.q = q;
        new Thread(this, "syncs.sync.Consumer").start();
    }

    @Override
    public void run() {
        while (true) {
            q.get();
        }
    }
}
