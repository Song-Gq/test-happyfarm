package test;

import foobar.plant.farm.Field;
import foobar.plant.farm.Tile;
import foobar.plant.plant_entity.BasePlant;
import foobar.plant.plant_profile.BasePlantProfile;
import foobar.plant.plant_profile.PlantProfileManager;
import foobar.tool.agriculture_tool.*;
import foobar.tool.building_tool.DigTool;

/**
 * Visitor Design Pattern Test Use Case.
 *  Visitor should be one to multiple.
 *  Acceptor should be multiple to one.
 * @author Leepaangsang
 * @version 2019/11/12
 */
public class VisitorTest {
    public static void main(String[] args){
        //Create receiver
        BasePlant basePlant = new BasePlant(PlantProfileManager.getInstance().getPlantProfile("Cotton"),"1st");
        Field field = new Field();
        Tile tile = new Tile();
        field.reclamation(tile);

        //Test WeedTool Visitor
        System.out.println("-------------------------------------Test WeedTool Visitor--------------------------------------");
        WeedTool weedTool = new WeedTool();
        basePlant.accept(weedTool);
        //field.accept(weedTool);
        //tile.accept(weedTool);

        //Test WaterTool Visitor
        System.out.println("-------------------------------------Test WaterTool Visitor-------------------------------------");
        WaterTool waterTool = new WaterTool();
        basePlant.accept(waterTool);
        //field.accept(waterTool);
        //tile.accept(waterTool);

        //Test PesticideTool Visitor
        System.out.println("-------------------------------------Test PesticideTool Visitor---------------------------------");
        PesticideTool pesticideTool = new PesticideTool();
        basePlant.accept(pesticideTool);
        //field.accept(pesticideTool);
        //tile.accept(pesticideTool);

        //Test BaseDecorator Visitor(It should be abstract class or
        // it's visitor should be override correctly.And now it is redundancy)
        System.out.println("-------------------------------------Test BaseDecorator Visitor---------------------------------");
        BaseDecorator baseDecorator = new BaseDecorator();
        basePlant.accept(baseDecorator);
        field.accept(baseDecorator);
        tile.accept(baseDecorator);

        //Test WeedDecorator
        System.out.println("-------------------------------------Test WeedDecorator Visitor---------------------------------");
        WeedDecorator weedDecorator = new WeedDecorator(weedTool);
        basePlant.accept(weedDecorator);
        //field.accept(weedDecorator);
        //tile.accept(weedDecorator);

        //Test FertilizationTool Visitor(Exception)
        System.out.println("-------------------------------------Test FertilizationTool Visitor-----------------------------");
        FertilizationTool fertilizationTool = new FertilizationTool();
        //basePlant.accept(fertilizationTool);
        field.accept(fertilizationTool);
        tile.accept(fertilizationTool);

        //Test DigTool Visitor(It is not meet the description)
        System.out.println("-------------------------------------Test DigTool Visitor---------------------------------------");
        DigTool digTool = new DigTool();
        basePlant.accept(digTool);
        field.accept(digTool);
        tile.accept(digTool);
    }
}
