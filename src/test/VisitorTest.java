package test;

import foobar.plant.plant_entity.BasePlant;
import foobar.plant.plant_profile.BasePlantProfile;
import foobar.plant.plant_profile.PlantProfileManager;
import foobar.tool.agriculture_tool.*;
import foobar.tool.building_tool.DigTool;

/**
 * Visitor Design Pattern Test Use Case
 * @author Leepaangsang
 * @version 2019/11/7
 */
public class VisitorTest {
    public static void main(String[] args){
        //Create receiver
        BasePlant basePlant = new BasePlant(PlantProfileManager.getInstance().getPlantProfile("Cotton"),"1st");

        //Test WeedTool Visitor
        System.out.println("Test WeedTool Visitor");
        WeedTool weedTool = new WeedTool();
        basePlant.accept(weedTool);

        //Test WaterTool Visitor
        System.out.println("Test WaterTool Visitor");
        WaterTool waterTool = new WaterTool();
        basePlant.accept(waterTool);

        //Test PesticideTool Visitor
        System.out.println("Test PesticideTool Visitor");
        PesticideTool pesticideTool = new PesticideTool();
        basePlant.accept(pesticideTool);

        //Test BaseDecorator Visitor(It should be abstract class)
        System.out.println("Test BaseDecorator Visitor");
        BaseDecorator baseDecorator = new BaseDecorator();
        basePlant.accept(baseDecorator);

        //Test WeedDecorator
        System.out.println("Test WeedDecorator Visitor");
        WeedDecorator weedDecorator = new WeedDecorator(weedTool);
        basePlant.accept(weedDecorator);

        //Test FertilizationTool Visitor(Exception)
        System.out.println("Test FertilizationTool Visitor");
        FertilizationTool fertilizationTool = new FertilizationTool();
        //basePlant.accept(fertilizationTool);

        //Test DigTool Visitor()
        System.out.println("Test DigTool Visitor");
        DigTool digTool = new DigTool();
        basePlant.accept(digTool);
    }
}
