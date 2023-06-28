package src.lowes;

public class SingletonPractice {
    public static void main(String[] args) {
//        Single single1 = Single.getInstance();
//        Single single2 = Single.getInstance();
//        System.out.println(single2.hashCode());
//        System.out.println(single1.hashCode());

        Thread thread = new Thread(() ->
        {
            Single single3 = Single.getInstance();
            System.out.println(single3.hashCode());
        });

        Thread thread2 = new Thread(() ->
        {
            Single single4 = Single.getInstance();
            System.out.println(single4.hashCode());
        });

        thread.start();
        thread2.start();


        Abc obj = Abc.INSTANCE;
        Abc obj2 = Abc.INSTANCE;
        obj.i = 10;
        System.out.println("Singleton using enum");
        obj.show();
        System.out.println(obj.hashCode());
        System.out.println(obj2.hashCode());
    }
}

class Single {

    private static Single obj;

    private Single() {
        System.out.println("Instance");
    }

    static Single getInstance() {
        if (obj == null)
            synchronized (Single.class) {
                if (obj == null)
                    obj = new Single(); //lazy
            }
        return obj;
    }
}

//Singleton Using enum class
enum Abc{
    //by default private constructor()
    INSTANCE;
    //INSTANCE above defines below method
//    public static Abc getInstance(){
//
//    }
    int i;
    public void show(){
        System.out.println(i);
    }

    //If used in deserialization with enum, usually when readObject() is called , gives us new object but we can use
    // readResolve() to get the same object
}