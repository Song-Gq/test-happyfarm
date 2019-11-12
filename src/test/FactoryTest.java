package test;

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
		//test for Factory (Success)
		String packName=new MainTest().getClass().getPackage().getName();

		Plantable field=new Field();
		Plantable tile=new Tile();
		((Field)field).reclamation(tile);
		assert (((Field)field).getchild(0)==tile):"测试来自"+packName+":加入地块失败";

		//Connton seed
		CottonSeedsFactory factory=new CottonSeedsFactory();
		SeedBag seedBag1=factory.produceSeeds();
		seedBag1.plantAt((Tile) ((Field) field).getchild(0));

		//Melon seed
		MelonSeedsFactory factory2=new MelonSeedsFactory();
		SeedBag seedBag2=factory2.produceSeeds();
		seedBag2.plantAt((Tile) ((Field) field).getchild(0));
		Planter planter=new Planter(seedBag2, (Tile) ((Field) field).getchild(0));
		planter.plantAt(tile);

		System.out.println("========== Successfully test factory! ===========");
    }
}
