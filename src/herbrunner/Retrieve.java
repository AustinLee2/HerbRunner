package herbrunner;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.*;

/**
 * Created by ahlin_000 on 1/17/2017.
 */
public class Retrieve extends Task<ClientContext> {

    private int compostID = 6034;
    private int ranarrSeedID = 5295;
    private int[] faladorAvoidPath = {8395,7388};

    public Retrieve(ClientContext ctx){
        super(ctx);
    }

    @Override
    public boolean activate(){
        return ctx.inventory.select().id(compostID).isEmpty() && ctx.inventory.select().id(ranarrSeedID).count(true) >= 1 && !ctx.players.local().inMotion() ;
    }

    @Override
    public void execute(){
        System.out.println("Retrieving");
        Npc toolLep = ctx.npcs.select().name("Tool Leprechaun").nearest().poll();
        /*if (toolLep.inViewport()){
            toolLep.interact("Exchange");
            Condition.sleep(1000);
            Component compostLep = ctx.widgets.component(125,11);
            compostLep.click();
            Component inventoryBucket = ctx.widgets.component(126,7);
            inventoryBucket.click();
            Component close = ctx.widgets.component(125,1).component(11);
            System.out.print(close.valid());
            close.click();
        }
        else {
            ctx.camera.turnTo(toolLep);
            ctx.movement.step(toolLep);
        }*/
        ctx.camera.turnTo(toolLep);
        ctx.movement.step(toolLep);
        toolLep.interact("Exchange");
        Condition.sleep(1000);
        Component compostLep = ctx.widgets.component(125,11);
        compostLep.click();
        Component inventoryBucket = ctx.widgets.component(126,7);
        inventoryBucket.click();
        Component close = ctx.widgets.component(125,1).component(11);
        System.out.println("Close widget: " + close.valid());
        close.click();
    }
}
