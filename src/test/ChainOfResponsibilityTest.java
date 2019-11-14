package test;

import foobar.people.Farmer;
import foobar.people.types.JobCategory;
import foobar.plant.consumable.effect.Anamnesis;
import foobar.plant.consumable.item.ShiF;
import foobar.plant.farm.Tile;
import foobar.plant.plant_entity.BasePlant;
import foobar.plant.plant_entity.SeedBag;
import foobar.plant.plant_profile.PlantProfileManager;
import foobar.plant.seed.CottonSeedsFactory;
import foobar.tool.agriculture_tool.WeedTool;
import foobar.tool.toolkit.ToolKit;

/**
 * @Author Zhang Dongya
 */
public class ChainOfResponsibilityTest {
    public static void main(String[] args){
        Farmer farmer=Farmer.getFarmer("Farmer");

        farmer.employFarmhand("aa", 1000, JobCategory.AGRICULTURE);//employ the farmhand and add to the chain
        farmer.employFarmhand("bb", 1200, JobCategory.MAINTENANCE);
        farmer.employFarmhand("cc", 1100, JobCategory.BUILDING);

        WeedTool tool = new WeedTool();
        BasePlant obj = new BasePlant(PlantProfileManager.getInstance().getPlantProfile("Cotton"),"hello");
        farmer.replaceWeedTool(tool);

        ToolKit tk = new ToolKit();//new tool and object
        tk.setFertilizer(new ShiF("SHit",7,"All shit",new Anamnesis()));
        CottonSeedsFactory factory=new CottonSeedsFactory();
        SeedBag seedBag=factory.produceSeeds();
        Tile tile=new Tile();
        tile.plow();
        seedBag.plantAt(tile);
        tk.setMyStrategy(1);

        farmer.releaseAgricultureWork(tk, tile);//release work to the chain,the farmhand matches with the work will handle it
        farmer.releaseRepairWork(tool);//========this test has something wrong
        farmer.releaseBuildingWork(tool, obj);//=====this test has something wrong
    }

}
