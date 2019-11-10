package test;

import foobar.tool.agriculture_tool.WeedTool;
import foobar.tool.building_tool.DigTool;

/**
 * Template Method Design Pattern Test Use Case
 * @author Leepaangsang
 * @version 2019/11/7
 */
public class TemplateMethodTest {
    public static void main(String[] args){
        //Create template method tool object
        DigTool digTool = new DigTool();
        WeedTool weedTool = new WeedTool();


        digTool = (DigTool) digTool.replaceByNewOne();
        weedTool = (WeedTool) weedTool.replaceByNewOne();
    }
}
