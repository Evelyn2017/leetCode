package coding_interview;

/**
 * singleton
 * A singleton has only one instance which must be created by itself.
 */

public class Problem02 {

    public static class Singleton1 {

        private final static Singleton1 instance1 = new Singleton1();

        private Singleton1() {
        }

        public static Singleton1 getInstance() {
            return instance1;
        }
    }

    public static class Singleton2 {

        private static Singleton2 instance2 = null;

        private Singleton2() {
        }

        public static Singleton2 getInstance() {
            if (instance2 == null)
                instance2 = new Singleton2();
            return instance2;
        }
    }
}
