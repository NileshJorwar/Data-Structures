package src.practice.strategypattern;

public class Dog extends Animal{

    public Dog(){
        super();
        flyingType = new CantFly();
    }
}
