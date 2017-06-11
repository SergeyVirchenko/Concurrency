package multiIsAlive;

/**
 * Created by Sergey on 05-Jun-17.
 */
public class ThreadDemo {

    public static void main(String[] args) {
        NewThread t1 = new NewThread("Один");
        NewThread t2 = new NewThread("Два");
        NewThread t3 = new NewThread("Три");

        System.out.println(t1.t.getName() + " жив? " + t1.t.isAlive());
        System.out.println(t2.t.getName() + " жив? " + t2.t.isAlive());
        System.out.println(t3.t.getName() + " жив? " + t3.t.isAlive());

        try {
            t1.t.join();
            t2.t.join();
            t3.t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(t1.t.getName() + " жив? " + t1.t.isAlive());
        System.out.println(t2.t.getName() + " жив? " + t2.t.isAlive());
        System.out.println(t3.t.getName() + " жив? " + t3.t.isAlive());

        System.out.println("Главный поток завершен");
    }
}
