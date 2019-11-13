package test;

import foobar.animal.animal_base.Animal;
import foobar.building.StoreHouse;
import foobar.plant.farm.Field;
import foobar.plant.farm.Plantable;
import foobar.plant.farm.Tile;
import foobar.plant.plant_entity.Planter;
import foobar.plant.plant_entity.SeedBag;
import foobar.plant.seed.MelonSeedsFactory;
import foobar.product.BaseFactory;
import foobar.product.FactoryProducer;
import foobar.product.Test;
import foobar.product.adapter.Adapter;
import foobar.product.product_interface.Barnmethods;
import foobar.product.product_interface.BaseProduct;
import foobar.product.proxy.AnimalProxy;
import foobar.product.proxy.PlantProxy;
import foobar.tool.building_tool.DigProxy;
import foobar.tool.building_tool.DigTool;

import javax.imageio.plugins.tiff.TIFFDirectory;

public class ProxyTest {

    public static void main(String[] args) {
        //Test 1 for Plant
        System.out.println("====================TEST 1====================");
        Plantable field = new Field();
        Plantable tile = new Tile();
        ((Field) field).reclamation(tile);
        MelonSeedsFactory factory = new MelonSeedsFactory();
        SeedBag seedBag = factory.produceSeeds();
        Planter planter = new Planter(seedBag, ((Tile) ((Field)field).getchild(0)));
        //应该输出植物种植成功
        planter.plantAt(tile);
        System.out.println();

        //Test 2 for Product
        System.out.println("====================TEST 2====================");
        BaseFactory baseFactory1 = FactoryProducer.getFactory("Farm");
        BaseFactory baseFactory2 = FactoryProducer.getFactory("Pasture");

        BaseProduct animal = baseFactory2.getAnimal("Egg");
        BaseProduct plant = baseFactory1.getPlant("AngleCotton");

        StoreHouse storeHouse = new StoreHouse();
        AnimalProxy animalProxy = new AnimalProxy(storeHouse);
        PlantProxy plantProxy = new PlantProxy(storeHouse);
        animalProxy.addAnimal(animal);
        plantProxy.addPlant(plant);
        //应该有一个Egg和一个AngelCotton
        storeHouse.show();
        System.out.println();



        //Test 3 for Tool
        System.out.println("====================TEST 3====================");
        DigTool digTool = new DigTool();
        DigProxy digProxy = new DigProxy(digTool);
        //最后应该是由DigProxy来完成
        for (int i = 1; i <= 102; i++) {
            Object object = new Object();
            digProxy.visit(object);
        }

    }
}
