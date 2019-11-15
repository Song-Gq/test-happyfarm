package test;

import foobar.plant.plant_profile.BasePlantProfile;
import foobar.plant.plant_profile.PlantProfileManager;
import foobar.plant.test.MainTest;
import foobar.product.drop_list.ProductDropList;


/**
 * @description test code for flyweight design pattern
 * @author hyl
 */

public class FlyweightTest {

    public static void main(String[] args) {
		//test for Flyweight (Success)
		System.out.println("============= start test flyweight! =============");
		String packName=new MainTest().getClass().getPackage().getName();
		BasePlantProfile pro1=PlantProfileManager.getInstance().getPlantProfile("Cotton");
		assert (pro1!=null):"测试1来自:"+packName+":无法通过反射获取Profile";

		PlantProfileManager.getInstance().addPlantProfile("豌豆射手",100,100,new ProductDropList());
		BasePlantProfile pro2=PlantProfileManager.getInstance().getPlantProfile("豌豆射手");

		assert (pro2!=null):"测试1来自:"+packName+":无法获取动态建立的Profile";

		BasePlantProfile pro3=PlantProfileManager.getInstance().getPlantProfile("豌豆射手");

		assert (pro3==pro2):"测试1来自:"+packName+":获取的不是同一个实例";
		System.out.println("========== Successfully test flyweight! ===========");
    }
}
