package test;

import foobar.animal.animal_base.*;
import foobar.animal.factory.*;

public class StrategyTest{
    public static void main(String[] args){
        //测试策略模式，即测试不同种类动物之间的动作
        //先创建各种动物的工厂，然后生产对应的动物
        ChickenFactory cf=new ChickenFactory();
        Chicken chicken= cf.createAnimal();
        FishFactory fishF=new FishFactory();
        Fish fish = fishF.createAnimal();
        FrogFactory frogF=new FrogFactory();
        Frog frog = frogF.createAnimal();
        PigFactory pigF=new PigFactory();
        Pig pig = pigF.createAnimal();
        SheepFactory sheepF=new SheepFactory();
        Sheep sheep=sheepF.createAnimal();
        //正式测试各种动物的各种动作状态
        chicken.walk();
        pig.walk();
        fish.walk();  //测试不出来，似乎有点bug
        frog.walk();
        sheep.walk();

        chicken.sleep();
        frog.sleep();
        fish.sleep();
        sheep.sleep();
        pig.sleep();
    }
}
