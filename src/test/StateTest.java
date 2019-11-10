package test;

import foobar.animal.animal_base.*;
import foobar.animal.factory.*;

public class StateTest{
    public static void main(String[] args) {
        //测试状态模式
        //先创建各种动物的工厂，然后生产对应的动物
        ChickenFactory cf = new ChickenFactory();
        Chicken chicken = cf.createAnimal();
        FishFactory fishF = new FishFactory();
        Fish fish = fishF.createAnimal();
        FrogFactory frogF = new FrogFactory();
        Frog frog = frogF.createAnimal();
        PigFactory pigF = new PigFactory();
        Pig pig = pigF.createAnimal();
        SheepFactory sheepF = new SheepFactory();
        Sheep sheep = sheepF.createAnimal();

        //正式测试各种动物的各种动作状态
        chicken.walk();
        pig.walk();
        frog.sleep();
        fish.sleep();

        //尝试收获状态
        chicken.produceWithoutDeath();
        chicken.eat();
        chicken.eat();
        chicken.produceWithoutDeath();

        //测试饥饿状态
        chicken.setHungry();
        chicken.setHungry();
        chicken.setHungry();
    }
}