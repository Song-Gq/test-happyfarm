package test;

import foobar.plant.consumable.effect.AddN;
import foobar.plant.consumable.effect.Anamnesis;
import foobar.plant.consumable.factory.JinKeLaFactory;
import foobar.plant.consumable.item.Fertilizer;
import foobar.plant.consumable.item.Pesticide;
import foobar.plant.farm.Field;
import foobar.plant.farm.Plantable;
import foobar.plant.farm.Tile;
import foobar.plant.plant_entity.SeedBag;
import foobar.plant.plant_profile.BasePlantProfile;
import foobar.plant.plant_profile.PlantProfileManager;
import foobar.plant.seed.CottonSeedsFactory;
import foobar.plant.test.MainTest;
import foobar.product.drop_list.ProductDropList;


import java.util.ArrayList;

public class MediatorTest {

    public static void main(String[] args) {
        String packName=new MainTest().getClass().getPackage().getName();
        BasePlantProfile pro1=PlantProfileManager.getInstance().getPlantProfile("Cotton");

        PlantProfileManager.getInstance().addPlantProfile("豌豆射手",100,100,new ProductDropList());
        BasePlantProfile pro2=PlantProfileManager.getInstance().getPlantProfile("豌豆射手");
        BasePlantProfile pro3=PlantProfileManager.getInstance().getPlantProfile("豌豆射手");

        Plantable field=new Field();
        Plantable tile=new Tile();

        for(int i=0; i<20; i++){
            ((Field)field).reclamation(new Tile());
        }

        field.plow();

        CottonSeedsFactory factory=new CottonSeedsFactory();
        SeedBag seedBag=factory.produceSeeds();
        seedBag.plantAt((Tile) ((Field) field).getchild(0));


        //测试化肥农药的创建，包含执行逻辑

        JinKeLaFactory Jfactory=new JinKeLaFactory();

        Fertilizer f=Jfactory.getFertilizer();
        Pesticide p=Jfactory.getPesticide();

        ((Tile) ((Field)field).getchild(0)).getPlant().pesticided(p);

        //测试普通农药
        f.setBonusEffect(new Anamnesis());
        field.addFertilizer(f);

        //测试桥接模式，加强农药
        f.addEffect(new AddN());
        field.addFertilizer(f);
    }
}
