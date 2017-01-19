package herbrunner;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.*;
/**
 * Created by ahlin_000 on 1/17/2017.
 */
public class Clear extends Task<ClientContext>{

    private int[] deadHerbPatch = {8147,8148,8149};
    private int compostID = 6034;

    public Clear(ClientContext ctx){
        super(ctx);

    }
    @Override
    public boolean activate(){
        return !ctx.objects.select().id(deadHerbPatch).isEmpty() && ctx.inventory.select().id(compostID).count() == 1;
    }

    @Override
    public void execute(){
        System.out.println("Clearing");
        GameObject deadPatch = ctx.objects.select().id(deadHerbPatch).nearest().poll();
        if (deadPatch.inViewport()){
            deadPatch.interact("Clear");
        }
        else{
            ctx.camera.turnTo(deadPatch);
            ctx.movement.step(deadPatch);
        }
        Condition.sleep(2000);
    }

}
