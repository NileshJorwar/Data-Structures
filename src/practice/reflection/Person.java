package src.practice.reflection;

public class Person {
    private final String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }

    public static void printAge(){
        System.out.println("public static");
    }

    private static void printName(){
        System.out.println("private static");
    }
    @Override
    public String toString() {
        return "Person: " + this.name + ", " + this.age;
    }
}
