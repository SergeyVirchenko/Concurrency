package locks.stampedlock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;

import static java.lang.Thread.sleep;

/**
 * Created by Sergey on 12-Jun-17.
 */
public class Stamped {
    ExecutorService executor = Executors.newFixedThreadPool(2);
    Map<String, String> map = new HashMap<>();
    StampedLock lock = new StampedLock();

    private void log(String s) {
        System.out.println(s + " " + Thread.currentThread().getName());
    }

    Runnable readTask = () -> {
        while (true) {
            long stamp = lock.readLock();
            log("read lock");
            try {
//                System.out.println(map.get("foo"));
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlockRead(stamp);
                log("read unlock");
            }
        }
    };


    private void startWriting() {
        executor.submit(() ->
        {
            while (true) {
                long stamp = lock.writeLock();
                log("write lock");
                try {
                    sleep(1);
                    map.put("foo", "bar");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlockWrite(stamp);
                    log("write unlock");
                }
            }
        });
    }

    private void runAll() {
        startWriting();
        executor.submit(readTask);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }

    public static void main(String[] args) {
        Stamped rw = new Stamped();
        rw.runAll();
    }
}
