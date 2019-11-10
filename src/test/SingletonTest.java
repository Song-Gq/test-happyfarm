package test;

import foobar.plant.plant_profile.*;
import foobar.plant.test.MainTest;
import foobar.product.drop_list.ProductDropList;

public class SingletonTest{
    public static void main(String[] args) {
        //测试单例模式
        System.out.println("plant测试开始......");
        String packName = MainTest.class.getPackage().getName();
        BasePlantProfile pro1 = PlantProfileManager.getInstance().getPlantProfile("Cotton");
        assert (pro1 != null) : "测试1来自:" + packName + ":无法通过反射获取Profile";

        PlantProfileManager.getInstance().addPlantProfile("豌豆射手", 100, 100, new ProductDropList());
        BasePlantProfile pro2 = PlantProfileManager.getInstance().getPlantProfile("豌豆射手");

        assert (pro2 != null) : "测试1来自:" + packName + ":无法获取动态建立的Profile";

        BasePlantProfile pro3 = PlantProfileManager.getInstance().getPlantProfile("豌豆射手");

        assert (pro3 == pro2) : "测试1来自:" + packName + ":获取的不是同一个实例";
    }
}
