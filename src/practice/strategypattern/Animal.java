package src.practice.strategypattern;

public class Animal {
    String name;
    int height;
    int weight;

    public Flys flyingType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String tryingToFly(){
        return flyingType.fly();
    }

    public void setFlyingAbility(Flys newFlyingType){
        flyingType = newFlyingType;
    }
}
