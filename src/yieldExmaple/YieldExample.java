package yieldExmaple;

/**
 * Created by Sergey on 05-Jun-17.
 */
public class YieldExample {

    public static void main(String[] args) {
        // анонимный класс
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.println("Поток 1 " + i);
                Thread.yield();
            }
            System.out.println("завершение 1");
        }).start(); // запуск потока
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.println("Поток 2 " + i);
            }
            System.out.println("завершение 2");
        }).start();
    }
}
