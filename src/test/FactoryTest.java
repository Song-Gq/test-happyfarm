package test;

import foobar.animal.animal_base.*;
import foobar.animal.factory.*;
import foobar.plant.farm.Field;
import foobar.plant.farm.Plantable;
import foobar.plant.farm.Tile;
import foobar.plant.plant_entity.Planter;
import foobar.plant.plant_entity.SeedBag;
import foobar.plant.seed.CottonSeedsFactory;
import foobar.plant.seed.MelonSeedsFactory;
import foobar.plant.test.MainTest;

/**
 * @description test code for Factory design pattern
 * @author hyl
 */

public class FactoryTest {

    public static void main(String[] args) {

		System.out.println("============= start test factory! =============");
		//test for Seed Factory (Success)
		//Connton seed
		CottonSeedsFactory cottonSeedsFactory=new CottonSeedsFactory();
		SeedBag seedBag1 = cottonSeedsFactory.produceSeeds();
		System.out.println("成功使用"+cottonSeedsFactory.toString()+"生产出了"+seedBag1.getName()+"种子包");

		//Melon seed
		MelonSeedsFactory melonSeedsFactory=new MelonSeedsFactory();
		SeedBag seedBag2=melonSeedsFactory.produceSeeds();
		System.out.println("成功使用"+melonSeedsFactory.toString()+"生产出了"+seedBag2.getName()+"种子包");


		//test for Animal Factory (Success)
		ChickenFactory chickenFactory=new ChickenFactory();
		Chicken chicken= chickenFactory.createAnimal();
		System.out.println("成功使用"+chickenFactory.toString()+"创建了动物"+chicken.toString());

		FishFactory fishF=new FishFactory();
		Fish fish = fishF.createAnimal();
		System.out.println("成功使用"+fishF.toString()+"创建了动物"+fish.toString());

		FrogFactory frogF=new FrogFactory();
		Frog frog = frogF.createAnimal();
		System.out.println("成功使用"+frogF.toString()+"创建了动物"+frog.toString());

		PigFactory pigF=new PigFactory();
		Pig pig = pigF.createAnimal();
		System.out.println("成功使用"+pigF.toString()+"创建了动物"+pig.toString());

		SheepFactory sheepF=new SheepFactory();
		Sheep sheep = sheepF.createAnimal();
		System.out.println("成功使用"+sheepF.toString()+"创建了动物"+sheep.toString());

		System.out.println("========== Successfully test factory! ===========");
    }
}
