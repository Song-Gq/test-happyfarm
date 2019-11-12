package test;

import foobar.tool.agriculture_tool.*;
import foobar.tool.building_tool.DigTool;

/**
 * Template Method Design Pattern Test Use Case
 * @author Leepaangsang
 * @version 2019/11/10
 */
public class TemplateMethodTest {
    public static void main(String[] args){
        //Test DigTool
        System.out.println("-------------------------------------Test DigTool--------------------------------------");
        DigTool digTool = new DigTool();
        System.out.println(digTool);
        digTool = (DigTool) digTool.replaceByNewOne();
        System.out.println(digTool);

        //Test WeedTool
        System.out.println("-------------------------------------Test WeedTool--------------------------------------");
        WeedTool weedTool = new WeedTool();
        System.out.println(weedTool);
        weedTool = (WeedTool) weedTool.replaceByNewOne();
        System.out.println(weedTool);

        //Test WaterTool
        System.out.println("-------------------------------------Test WaterTool--------------------------------------");
        WaterTool waterTool = new WaterTool();
        System.out.println(waterTool);
        weedTool = (WeedTool) weedTool.replaceByNewOne();
        System.out.println(waterTool);

        //Test FertilizationTool
        System.out.println("-------------------------------------Test FertilizationTool--------------------------------------");
        FertilizationTool fertilizationTool = new FertilizationTool();
        System.out.println(fertilizationTool);
        fertilizationTool = (FertilizationTool) fertilizationTool.replaceByNewOne();
        System.out.println(fertilizationTool);

        //Test PesticideTool
        System.out.println("-------------------------------------Test PesticideTool--------------------------------------");
        PesticideTool pesticideTool = new PesticideTool();
        System.out.println(pesticideTool);
        pesticideTool = (PesticideTool) pesticideTool.replaceByNewOne();
        System.out.println(pesticideTool);

        //Test BaseDecorator
        System.out.println("-------------------------------------Test BaseDecorator--------------------------------------");
        BaseDecorator baseDecorator = new BaseDecorator();
        System.out.println(baseDecorator);
        baseDecorator = (BaseDecorator) baseDecorator.replaceByNewOne();
        System.out.println(baseDecorator);

        //Test WeedDecorator
        System.out.println("-------------------------------------Test WeedDecorator--------------------------------------");
        WeedDecorator weedDecorator = new WeedDecorator();
        System.out.println(weedDecorator);
        weedDecorator = (WeedDecorator) weedDecorator.replaceByNewOne();
        System.out.println(weedDecorator);

    }
}
