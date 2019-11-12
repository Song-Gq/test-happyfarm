package test;

import foobar.plant.consumable.factory.JinKeLaFactory;
import foobar.plant.consumable.item.Fertilizer;
import foobar.plant.farm.Field;
import foobar.plant.farm.Plantable;
import foobar.plant.farm.Tile;

public class CompositeTest {

    public static void main(String[] args) {
        // new a field and a tile
        Plantable field = new Field();
        Plantable tile = new Tile();

        // add the tile to the field
        ((Field) field).reclamation(tile);

        // plow the whole field
        field.plow();

        // plow the tile by Field.getChild()
        ((Field) field).getchild(0).plow();

        // get fertilizer factory
        JinKeLaFactory factory = new JinKeLaFactory();

        // fertilize the whole field
        field.addFertilizer(factory.getFertilizer());

        // fertilize the tile
        tile.addFertilizer(factory.getFertilizer());

        // remove the tile from the field
        ((Field) field).abandon(tile);

        // then plow or fertilize
        tile.plow();
        tile.addFertilizer(factory.getFertilizer());
        field.plow();
        field.addFertilizer(factory.getFertilizer());



        // add the tile and a new tile to the field
        ((Field) field).reclamation(tile);
        ((Field) field).reclamation(new Tile());

        field.plow();
        field.addFertilizer(factory.getFertilizer());

        // remove the first tile
        ((Field) field).abandon(tile);
        ((Field) field).getchild(0).plow();



        // add field to the field
        ((Field) field).reclamation(new Field());
        field.plow();
        field.addFertilizer(factory.getFertilizer());

        // add tile to the child field
        ((Field) ((Field) field).getchild(1))
            .reclamation(new Tile());
        field.plow();
        field.addFertilizer(factory.getFertilizer());
    }
}
