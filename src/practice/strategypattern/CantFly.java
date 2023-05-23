package src.practice.strategypattern;

public class CantFly implements Flys {

    @Override
    public String fly() {
        return "Cant fly high";
    }
}
