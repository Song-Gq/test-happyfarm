import foobar.plant.consumable.factory.*;
import foobar.plant.consumable.item.Pesticide;
import foobar.plant.consumable.item.Fertilizer;

import foobar.product.BaseFactory;
import foobar.product.product_factory.FarmFactory;
import foobar.product.product_factory.PastureFactory;

import foobar.people.actions.*;


/**
 * @description test code for "abstract factory" design pattern
 * @author cys
 */

public class AbstractFactoryTest {
	
    public static void main(String[] args) {
    	//test 1 for plant (Success)
    	//two different factories
    	AbstractConsumableFactory sdlFactory = new ShiDanLiFactory();
    	AbstractConsumableFactory jklFactory = new JinKeLaFactory();
    	
    	Pesticide pes = sdlFactory.getPesticide();
    	Fertilizer fer = sdlFactory.getFertilizer();
    	
    	//should output "ShiP" and "ShiF"
    	System.out.println(pes.getClass().getSimpleName());
    	System.out.println(fer.getClass().getSimpleName());
    	
    	pes = jklFactory.getPesticide();
    	fer = jklFactory.getFertilizer();
    	
    	//should output "JinF" and "JinF"
    	System.out.println(pes.getClass().getSimpleName());
    	System.out.println(fer.getClass().getSimpleName());
    	
    	//test 2 for product (Wrong)
    	BaseFactory farmFactory = new FarmFactory();
    	BaseFactory pastureFactory = new PastureFactory();
    	//can't create objects without specifying their concrete classes,
    	//need at least 2 abstract products
    	//there is only 1 -BaseProduct
    	
    	//test 3 for people (Success)
    	Provider aFactory = new AgricultureWorkFactory();
    	Provider bFactory = new BuildingWorkFactory();
    	Provider repairFactory = new RepairToolFactory();
    	Provider replaceFactory = new ReplaceToolFactory();
    	
    	ActionWrapper aw = aFactory.produce();
    	//should output "AgricultureWork"
    	System.out.println(aw.getClass().getSimpleName());
    	
    	aw = bFactory.produce();
    	//should output "BuildingWork"
    	System.out.println(aw.getClass().getSimpleName());
    	
    	aw = repairFactory.produce();
    	//should output "RepairTool"
    	System.out.println(aw.getClass().getSimpleName());
    	
    	aw = replaceFactory.produce();
    	//should output "ReplaceTool"
    	System.out.println(aw.getClass().getSimpleName());	
    }
    
}
