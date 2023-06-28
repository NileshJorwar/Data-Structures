package src.lowes;

public class SingletonLazyWithSynchronized {
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            SingletonLazySync obj1 = SingletonLazySync.getInstance();
            System.out.println(obj1.hashCode());

        });
        Thread t2 = new Thread(() -> {
            SingletonLazySync obj2 = SingletonLazySync.getInstance();
            System.out.println(obj2.hashCode());
        });

        t1.start();
        t2.start();

    }
}

class SingletonLazySync {
    //    static Singleton obj = new Singleton();//eager
    static SingletonLazySync obj;

    private SingletonLazySync() {
        System.out.println("Instance");
    }

    public static SingletonLazySync getInstance() {
        if (obj == null) {

            synchronized (SingletonLazySync.class) {
                if (obj == null)
                    obj = new SingletonLazySync();
            }
        }
        return obj;
    }
}
