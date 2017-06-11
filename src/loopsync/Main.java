package loopsync;

/**
 * Created by Sergey on 09-Jun-17.
 */
public class Main {
    public static void main(String[] args) {
        SimpleThread thread = new SimpleThread();
        thread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.setNeedStop(true);
    }
}
