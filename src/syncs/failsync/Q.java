package syncs.failsync;

/**
 * Created by Sergey on 05-Jun-17.
 */
public class Q {
    private int n = 0;

    synchronized int get() {
        System.out.println("Получено " + n);
        return n;
    }

    synchronized void put(int n) {
        this.n = n;
        System.out.println("Отправелно " + n);
    }
}
