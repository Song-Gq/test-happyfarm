package test;

import foobar.plant.*;
import foobar.plant.consumable.effect.Anamnesis;
import foobar.plant.consumable.factory.JinKeLaFactory;
import foobar.plant.consumable.item.Fertilizer;
import foobar.plant.farm.Field;
import foobar.plant.farm.Plantable;
import foobar.plant.farm.Tile;
import foobar.plant.plant_entity.SeedBag;
import foobar.plant.seed.CottonSeedsFactory;

public class ObserverTest {

    public static void main(String[] args) {
        Plantable field = new Field();
        Plantable tile = new Tile();

        ((Field)field).reclamation(tile);
        field.plow();
        CottonSeedsFactory factory = new CottonSeedsFactory();
        SeedBag seedBag = factory.produceSeeds();
        seedBag.plantAt((Tile) ((Field) field).getchild(0));

        JinKeLaFactory jinKeLaFactory = new JinKeLaFactory();
        Fertilizer fertilizer = jinKeLaFactory.getFertilizer();
        fertilizer.setBonusEffect(new Anamnesis());
        //在此处应输出化肥施加被监听到
        field.addFertilizer(fertilizer);
    }
}
