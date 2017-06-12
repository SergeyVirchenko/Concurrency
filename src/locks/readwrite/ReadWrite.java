package locks.readwrite;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static java.lang.Thread.sleep;

/**
 * Created by Sergey on 12-Jun-17.
 */
public class ReadWrite {
    ExecutorService executor = Executors.newFixedThreadPool(2);
    Map<String, String> map = new HashMap<>();
    ReadWriteLock lock = new ReentrantReadWriteLock();

    private void log(String s) {
        System.out.println(s + " " + Thread.currentThread().getName());
    }

    Runnable readTask = () -> {
        while (true) {
            lock.readLock().lock();
            log("read lock");
            try {
//                System.out.println(map.get("foo"));
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.readLock().unlock();
                log("read unlock");
            }
        }
    };


    private void startWriting() {
        executor.submit(() ->
        {
            while (true) {
                lock.writeLock().lock();
                log("write lock");
                try {
                    sleep(1);
                    map.put("foo", "bar");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.writeLock().unlock();
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
        ReadWrite rw = new ReadWrite();
        rw.runAll();
    }
}
