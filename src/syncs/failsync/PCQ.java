package syncs.failsync;

/**
 * Created by Sergey on 05-Jun-17.
 */
public class PCQ {
    public static void main(String[] args) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);
    }
}
