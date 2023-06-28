package src.lowes;

public class SingletonLazy {
    public static void main(String[] args) {
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();
        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());
    }
}

class Singleton {
    //    static Singleton obj = new Singleton();//eager
    static Singleton obj;

    private Singleton() {
        System.out.println("Instance");
    }

    public static Singleton getInstance() {
        if (obj == null) // the problem above is this would work only for single-threaded application, what-if we have multithreaded application where multiple threads when tried calling getInstance() at the same time, would see obj=null and create a new instance and defeats the purpose of singleton class.

            obj = new Singleton();

        return obj;
    }
}
