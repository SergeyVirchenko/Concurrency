package simpleSync;

/**
 * Created by Sergey on 09-Jun-17.
 */
public class CallMeMain {
    public static void main(String[] args) {
        CallMe callMe = new CallMe();
        Caller caller1 = new Caller(callMe, "Добро пожаловать", 10);
        Caller caller2 = new Caller(callMe, "в мир", 7);
        Caller caller3 = new Caller(callMe, "многопоточности", 1);

        try {
            caller1.t.join();
            caller2.t.join();
            caller3.t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
