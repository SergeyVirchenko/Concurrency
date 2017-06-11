package loopsync;

/**
 * Created by Sergey on 09-Jun-17.
 */
public class SimpleThread extends Thread {

    private boolean needStop = false;

    public void setNeedStop(boolean needStop) {
        this.needStop = needStop;
    }

    @Override
    public void run() {
        while (!needStop) {
            System.out.println("loop");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
