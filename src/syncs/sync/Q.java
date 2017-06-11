package syncs.sync;

/**
 * Created by Sergey on 05-Jun-17.
 */
public class Q {
    private int n = 0;
    private boolean valueSet = false;

    synchronized int get() {
        while (!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Получено " + n);
        valueSet = false;
        notify();
        return n;
    }

    synchronized void put(int n) {
        while (valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.n = n;
        valueSet = true;
        System.out.println("Отправелно " + n);
        notify();
    }
}
