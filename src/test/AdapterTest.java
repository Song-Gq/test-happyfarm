package test;

import foobar.building.StoreHouse;
import foobar.people.Farmer;
import foobar.people.types.JobCategory;
import foobar.plant.plant_entity.BasePlant;
import foobar.plant.plant_profile.PlantProfileManager;
import foobar.product.farm_product.AngleCotton;
import foobar.product.farm_product.BattleMelon;
import foobar.product.farm_product.DemonCotton;
import foobar.product.pasture_product.ChickenMeat;
import foobar.product.pasture_product.Egg;
import foobar.product.pasture_product.FrogMeat;
import foobar.tool.agriculture_tool.WeedTool;

/**
 * @Author Zhang Dongya
 */
public class AdapterTest {
    public static void main(String[] args){
        System.out.println("====Test1 of Adapter Pattern====");
        StoreHouse storeHouse=new StoreHouse();

        ChickenMeat chickenMeat=new ChickenMeat();//create animal product
        Egg egg=new Egg();
        FrogMeat frogMeat=new FrogMeat();

        AngleCotton angleCotton=new AngleCotton();//create plant product
        BattleMelon battleMelon=new BattleMelon();
        DemonCotton demonCotton=new DemonCotton();

        storeHouse.addAnimal(chickenMeat);//add the animal product to the storehouse
        storeHouse.addAnimal(egg);
        storeHouse.addAnimal(frogMeat);

        storeHouse.addPlant(angleCotton);//add the plant product to the storehouse
        storeHouse.addPlant(battleMelon);
        storeHouse.addPlant(demonCotton);

        System.out.println("====Test2 of Adapter Pattern====");
        Farmer farmer = Farmer.getFarmer("Farmer");  // new a farmer
        farmer.employFarmhand("Tom", 1000, JobCategory.AGRICULTURE);//employ a land

        WeedTool tool = new WeedTool();//new a tool
        BasePlant obj = new BasePlant(PlantProfileManager.getInstance().getPlantProfile("Cotton"),"hello");//new a plant

        farmer.replaceWeedTool(tool);// call adapter undirected
        farmer.releaseAgricultureWork(tool, obj);
    }
}
