package deadlock;

/**
 * Created by Sergey on 12-Jun-17.
 */
public class Deadlock {
    static class Friend {
        private final String name;

        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public synchronized void bow(Friend bower) {
            System.out.format("%s: %s" + "  has bowed to me!%n", this.name, bower.getName());
            bower.bowBack(this);
        }

        public synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s" + " has bowed back to me!%n", this.name, bower.getName());
        }
    }

    public static void main(String[] args) {
        final Friend alice = new Friend("Alice");
        final Friend bob = new Friend("Bob");
        new Thread(() -> alice.bow(bob)).start();
//        new Thread(() -> bob.bow(alice)).start();
    }
}
