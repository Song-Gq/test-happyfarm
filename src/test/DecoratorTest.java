package test;

import foobar.plant.plant_entity.BasePlant;
import foobar.plant.plant_profile.PlantProfileManager;
import foobar.tool.Tool;
import foobar.tool.agriculture_tool.WeedDecorator;
import foobar.tool.agriculture_tool.WeedTool;

public class DecoratorTest {

    public static void main(String[] args) {

        // plant
        BasePlant basePlant = new BasePlant(PlantProfileManager.getInstance().getPlantProfile("Cotton"),"hello");

        // tool without decorator
        Tool tool = new WeedTool();
        tool.visit(basePlant);

        // tool with concrete decorator
        Tool decoratedTool = new WeedDecorator(new WeedTool());
        decoratedTool.visit(basePlant);
    }
}
