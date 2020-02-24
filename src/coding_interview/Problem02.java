package coding_interview;

/**
 * singleton
 * A singleton has only one instance which must be created by itself.
 *
 * 懒汉式单例模式：在类加载时不初始化。
 * 饿汉式单例模式：在类加载时就完成了初始化，所以类加载比较慢，但获取对象的速度快。
 */

public class Problem02 {

    public static void main(String[] args) {
        System.out.println(Singleton1.getInstance() == Singleton1.getInstance());
        System.out.println(Singleton2.getInstance() == Singleton2.getInstance());
        System.out.println(Singleton3.getInstance() == Singleton3.getInstance());
        System.out.println(Singleton4.getInstance() == Singleton4.getInstance());
        System.out.println(Singleton5.getInstance() == Singleton5.getInstance());
        System.out.println(Singleton6.INSTANCE == Singleton6.INSTANCE);
        System.out.println(Singleton7.getInstance() == Singleton7.getInstance());
    }

    /**
     * 静态内部类，使用枚举方式，线程安全【推荐】
     */
    public enum Singleton6 {
        INSTANCE;

        public void whateverMethod() {

        }
    }

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

    public static class Singleton3 {

        private static Singleton3 instance3 = null;

        private Singleton3() {
        }

        public static synchronized Singleton3 getInstance() {
            if (instance3 == null)
                instance3 = new Singleton3();
            return instance3;
        }
    }

    /**
     * 单例模式，饿汉式，变种，线程安全
     */
    public static class Singleton4 {
        private static Singleton4 instance = null;

        static {
            instance = new Singleton4();
        }

        private Singleton4() {

        }

        public static Singleton4 getInstance() {
            return instance;
        }
    }

    /**
     * 单例模式，懒汉式，使用静态内部类，线程安全【推荐】
     */
    public static class Singleton5 {
        private Singleton5() {

        }

        public static Singleton5 getInstance() {
            return SingletonHolder.INSTANCE;
        }

        private final static class SingletonHolder {
            private static final Singleton5 INSTANCE = new Singleton5();
        }
    }

    /**
     * 静态内部类，使用双重校验锁，线程安全【推荐】
     */
    public static class Singleton7 {
        private volatile static Singleton7 instance = null;

        private Singleton7() {

        }

        public static Singleton7 getInstance() {
            if (instance == null) {
                synchronized (Singleton7.class) {
                    if (instance == null) {
                        instance = new Singleton7();
                    }
                }
            }

            return instance;
        }
    }
}
