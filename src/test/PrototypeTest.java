package test;

import foobar.plant.plant_entity.BasePlant;
import foobar.plant.plant_profile.PlantProfileManager;
import foobar.tool.agriculture_tool.WeedTool;
import logger.*;

public class PrototypeTest {

    public static void main(String[] args) {
        WeedTool weedTool = new WeedTool();
        //应为1
        logger.println(weedTool.getState());
        for (int i = 1; i <= 101; i++) {
            BasePlant basePlant = new BasePlant(
                    PlantProfileManager.getInstance().getPlantProfile("Cotton"),
                    "Hello");
            weedTool.visit(basePlant);

        }
        //应为0
        logger.println(weedTool.getState());
        weedTool = (WeedTool)weedTool.replaceByNewOne();
        //应为1
        logger.println(weedTool.getState());
    }
}
