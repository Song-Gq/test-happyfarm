package test;

import foobar.building.*;
import foobar.building.builder.FarmBuilder;
import foobar.building.builder.PastureBuilder;
import foobar.building.builder.StoreHouseBuilder;
import foobar.plant.farm.Field;
import foobar.plant.farm.Plantable;
import foobar.plant.farm.Tile;
import foobar.plant.plant_entity.Planter;
import foobar.plant.plant_entity.SeedBag;
import foobar.plant.seed.CottonSeedsFactory;
import foobar.plant.seed.MelonSeedsFactory;
import foobar.product.product_interface.BaseProduct;

import java.util.ArrayList;

public class FacadeTest {

    public static void main(String[] args) {

        BuildingDirector director = new BuildingDirector();
        // create a pasture
        PastureBuilder pastureBuilder = new PastureBuilder("mypasture", 1, 1, 1);
        director.Build(pastureBuilder);
        Pasture pasture = (Pasture) pastureBuilder.GetBuilding();
        // create a store house
        StoreHouseBuilder storeHouseBuilder = new StoreHouseBuilder("mystorehouse", 1, 1, 1);
        director.Build(storeHouseBuilder);
        StoreHouse storeHouse = (StoreHouse) storeHouseBuilder.GetBuilding();

        // add animals
        pasture.addAnimal("Chicken");
        pasture.addAnimal("Frog");
        pasture.addAnimal("Fish");
        pasture.addAnimal("Sheep");
        pasture.addAnimal("Pig");
        pasture.eat();
        pasture.eat();
        pasture.eat();
        pasture.eat();
        pasture.breed();
        pasture.show();

        // produce and add them into store house
        pasture.produceWithoutDeath().forEach(i->storeHouse.addAnimal(i));
        pasture.produceWithDeath().forEach(i->storeHouse.addAnimal(i));
        storeHouse.show();
    }
}
