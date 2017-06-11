package simpleSync;

/**
 * Created by Sergey on 09-Jun-17.
 */
public class UnreachableCallMe {

    void call(String msg) {
        System.out.print("[" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("]");
    }
}
