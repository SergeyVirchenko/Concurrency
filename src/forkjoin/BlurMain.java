package forkjoin;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

/**
 * Created by Sergey on 12-Jun-17.
 */
public class BlurMain {
    public static void main(String[] args) throws InterruptedException {
        int[] src = new int[200000];
        int[] dst = new int[200000];
        Random r = new Random();
        for (int i = 0; i < src.length; i++) {
            src[i] = r.nextInt(10);
        }

        ForkBlur fb = new ForkBlur(src, 0, src.length, dst);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(fb);
        print(src);
        print(dst);
    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 1920; j++) {
                System.out.print(arr[i]);
            }
            System.out.println();
        }
    }
}
