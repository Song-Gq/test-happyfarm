package test;

import foobar.animal.animal_base.Chicken;
import foobar.animal.color.Black;
import foobar.animal.color.Green;
import foobar.animal.factory.ChickenFactory;
import foobar.plant.consumable.effect.*;
import foobar.plant.consumable.item.ShiF;
import foobar.plant.consumable.item.ShiP;

/**
 * @Author Zhang Dongya
 */
public class BridgeTest {

    public static void main(String[] args){
        System.out.println("====Test1 of Bridge Pattern====");
        BonusEffect effectF=new SDLBaseEffect();// base effect of fertilizer
        BonusEffect effectP=new JKLBaseEffect();// base effect of pesticide

        BonusEffect effect1=new DamageHealth();//three bonus effect
        BonusEffect effect2=new AddN();
        BonusEffect effect3=new Anamnesis();

        ShiF fertilizer=new ShiF("shi dan li", 500, "hhh", effectF);// buy fertilizer
        ShiP pesticide =new ShiP("ShiDanLi", 600, "kill pest", effectP);// buy pesticide

        fertilizer.addEffect(effect1);// add bonus effect fertilizer
        fertilizer.addEffect(effect2);
        fertilizer.act();

        pesticide.addEffect(effect3);//add bonus effect for pesticide
        pesticide.act();

        System.out.println("====Test2 of Bridge Pattern====");
        ChickenFactory chickenFactory=new ChickenFactory();//new a factory
        Chicken chicken=chickenFactory.createAnimal();//create a chicken
        chicken.breed();
        chicken.walk();

        logger.logger.println("the color of the chicken is "+chicken.getColor());//to see the color
        chicken.setColor(new Black());//change the color and see again.
        logger.logger.println("the color of the chicken is "+chicken.getColor());
        chicken.setColor(new Green());
        logger.logger.println("the color of the chicken is "+chicken.getColor());
    }
}

