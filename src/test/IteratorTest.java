package test;

import foobar.plant.plant_entity.BasePlant;
import foobar.product.BaseFactory;
import foobar.product.FactoryProducer;
import foobar.product.drop_list.ProductDropList;
import foobar.product.drop_list.ProductDropListIterator;
import foobar.product.product_interface.BaseProduct;
import javafx.util.Pair;
import logger.logger;

public class IteratorTest {
    public static void main(String[] args) {
        BaseFactory farmfactory = FactoryProducer.getFactory("Farm");
        BaseFactory pasturefactory = FactoryProducer.getFactory("Pasture");
        BaseProduct animal1 = pasturefactory.getAnimal("ChickenMeat");
        BaseProduct animal2 = pasturefactory.getAnimal("FishMeat");
        BaseProduct animal3 = pasturefactory.getAnimal("FrogMeat");
        BaseProduct animal4 = pasturefactory.getAnimal("Mutton");
        BaseProduct animal5 = pasturefactory.getAnimal("Pork");
        BaseProduct animal6 = pasturefactory.getAnimal("Wool");
        BaseProduct animal7 = pasturefactory.getAnimal("Egg");
        BaseProduct plant1 = farmfactory.getPlant("AngleCotton");
        BaseProduct plant2 = farmfactory.getPlant("DemonCotton");
        BaseProduct plant3 = farmfactory.getPlant("BattleMelon");
        ProductDropList list=new ProductDropList();
//        list.addProduct(animal1,1);
//        list.addProduct(plant2,2);
//        list.addProduct(plant1,2);
        ProductDropListIterator it=list.getIterator();
        while(it.hasNext())
        {
            BaseProduct plant=(BaseProduct) it.next();
            System.out.println(plant.getname());
        }

//        logger.println(animal1.getname());
//        logger.println(animal2.getname());
//        logger.println(animal3.getname());
//        logger.println(animal4.getname());
//        logger.println(animal5.getname());
//        logger.println(animal6.getname());
//        logger.println(animal7.getname());
//        logger.println(plant1.getname());
//        logger.println(plant2.getname());
//        logger.println(plant3.getname());

    }
}
