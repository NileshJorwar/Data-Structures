package src.practice.strategypattern;

public class Runner {
    public static void main(String[] args) {

        Animal raja = new Dog();
        Animal maiyna = new Bird();

        System.out.println(raja.tryingToFly());
        System.out.println(maiyna.tryingToFly());
    }
}
