package herbrunner;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;

/**
 * Created by ahlin_000 on 1/17/2017.
 */
public class Compost extends Task<ClientContext> {

    private int compostID = 6034;
    public boolean composted;
    private int[] emptyPatchIDS = {8136,8132,18818};

    public Compost(ClientContext ctx){
        super(ctx);
        composted = false;
    }

    @Override
    public boolean activate(){
        return !ctx.objects.select().id(emptyPatchIDS).isEmpty() && ctx.inventory.select().id(compostID).count() == 1;
    }

    @Override
    public void execute(){
        System.out.println("Composting");
        GameObject emptyPatch = ctx.objects.select().id(emptyPatchIDS).nearest().poll();
        if (emptyPatch.inViewport()){
            ctx.inventory.select().id(6034).poll().interact("Use");
            ctx.objects.select().id(emptyPatchIDS).nearest().poll().interact("Use");
            composted = true;
        }
        else {
            ctx.camera.turnTo(emptyPatch);
            ctx.movement.step(emptyPatch);
        }
        Condition.sleep(500);
    }
}
