package test;

import foobar.building.BuildingDirector;
import foobar.building.Farm;
import foobar.building.Pasture;
import foobar.building.StoreHouse;
import foobar.building.builder.FarmBuilder;
import foobar.building.builder.PastureBuilder;
import foobar.building.builder.StoreHouseBuilder;
import foobar.plant.plant_entity.*;

/**
 * @description test code for "builder" design pattern
 * @author cys
 */

public class BuilderTest {
	
	public static void main(String[] args) {
		//test 1 for plant (exception)
		//create a director
		QuailtyDirector director = new QuailtyDirector();
		
		//create constructor
		ConcretePrefixConstructor lConstructor = new LegendaryConstructor();
		//QuailtyConstructor tConstructor = new TrashConstructor();
		
		//set constructor
		director.setConstructor(lConstructor);
		
		//execute construction (exception, lConstructor.result has no constructor， result = null)
		//director.construct();
		//System.out.println(pre.All());
		
		//try another construction
		//director.setConstructor(tConstructor);
		//pre = director.construct();
		//System.out.println(pre.All());
		
		
		//test 2 for building (Success)
		//create a director
        BuildingDirector bDirector = new BuildingDirector();
        
        //create 3 builders
        FarmBuilder farmBuilder = new FarmBuilder("myfarm", 1, 1, 1);
        
        PastureBuilder pastureBuilder = new PastureBuilder("mypasture", 1, 1, 1);
        
        StoreHouseBuilder storeHouseBuilder = new StoreHouseBuilder("mystorehouse", 1, 1, 1);

        //execute
        bDirector.Build(farmBuilder);
        Farm farm = (Farm) farmBuilder.GetBuilding();
        
        bDirector.Build(pastureBuilder);
        Pasture pasture = (Pasture) pastureBuilder.GetBuilding();
        
        bDirector.Build(storeHouseBuilder);
        StoreHouse storeHouse = (StoreHouse) storeHouseBuilder.GetBuilding();
	}
	
}
