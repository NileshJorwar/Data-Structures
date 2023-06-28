package src.lowes;

public class SingletonEager {
    public static void main(String[] args) {
        SingletonClass obj1 = SingletonClass.getInstance();
        SingletonClass obj2 = SingletonClass.getInstance();
        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());
    }
}

class SingletonClass {
    static SingletonClass obj = new SingletonClass(); // eager initialization where object is created during class loading
    // can be memory issue if object is very big; hence lazy initialization
    private SingletonClass() {
    }

    public static SingletonClass getInstance() {
        return obj;
    }
}
