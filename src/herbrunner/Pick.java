package herbrunner;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;

/**
 * Created by ahlin_000 on 1/17/2017.
 */
public class Pick extends Task<ClientContext> {

    private int[] herbPatchID = {8143, 18826};
    private int compostID = 6034;

    public Pick (ClientContext ctx){
        super(ctx);
    }

    @Override
    public boolean activate(){
        return !ctx.objects.select().id(herbPatchID).isEmpty() && ctx.inventory.select().id(compostID).count() == 1 && ctx.inventory.select().count() < 28;
    }

    @Override
    public void execute(){
        System.out.println("Picking");
        GameObject grownHerbs = ctx.objects.select().nearest().id(herbPatchID).poll();
        if (grownHerbs.inViewport()){
            grownHerbs.interact("Pick");
        }
        else{
            ctx.camera.turnTo(grownHerbs);
            ctx.movement.step(grownHerbs);
            grownHerbs.click();
        }
    }
}
