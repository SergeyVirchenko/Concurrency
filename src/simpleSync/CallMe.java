package simpleSync;

/**
 * Created by Sergey on 09-Jun-17.
 */
public class CallMe {

    private UnreachableCallMe unreachableCallMe;

    CallMe() {
        unreachableCallMe = new UnreachableCallMe();
    }

    void call(String msg) {
        synchronized (unreachableCallMe) {
            unreachableCallMe.call(msg);
        }
    }
}
