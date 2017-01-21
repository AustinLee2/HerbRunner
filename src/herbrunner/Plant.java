package herbrunner;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Game;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.Item;

public class Plant extends Task<ClientContext> {

    //18821 trollheim weed1
    private int[] emptyPatchIDS = {8136,8132,18818};
    private int bucketID = 1925;
    private int ranarrSeedID = 5295;

    public Plant(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return !ctx.objects.select().id(emptyPatchIDS).isEmpty()
                && !ctx.inventory.select().id(ranarrSeedID).isEmpty() && !ctx.inventory.select().id(bucketID).isEmpty();
    }

    @Override
    public void execute() {
        System.out.println("Planting");
        Item ranarrSeed = ctx.inventory.select().id(ranarrSeedID).poll();
        GameObject emptyPatch = ctx.objects.select().id(emptyPatchIDS).nearest().poll();
        /*if(emptyPatch.inViewport()){
            ranarrSeed.interact("Use");
            emptyPatch.interact("Use");
        }
        else{
            ctx.camera.turnTo(emptyPatch);
            ctx.movement.step(emptyPatch);
        }*/
        ctx.camera.turnTo(emptyPatch);
        ctx.movement.step(emptyPatch);
        ranarrSeed.interact("Use");
        emptyPatch.interact("Use");
        Condition.sleep(2000);
    }
}