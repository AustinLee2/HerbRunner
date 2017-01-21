package walks;

import herbrunner.Task;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.LocalPath;

public class TrollWalk extends Task<ClientContext> {

    private int ranarrSeedID = 5295;
    private int[] herbPatchID = {8143, 18826};

    public TrollWalk(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.inventory.select().id(ranarrSeedID).count(true) == 3 && (ctx.objects.select().id(herbPatchID).isEmpty() || (!ctx.objects.select().id(herbPatchID).nearest().poll().inViewport() || !ctx.npcs.select().name("Tool Leprechaun").poll().inViewport()));

    }

    @Override
    public void execute() {
        if (ctx.movement.energyLevel() >= 15){
            ctx.movement.running(true);
        }
        System.out.println("Walking to Trollheim Patch...");
        LocalPath trollPath1 = ctx.movement.findPath(new Tile(2841,3690,0)/*2854,3684,0)*/);
        System.out.print("Trollpath1: " + trollPath1.valid());
        trollPath1.traverse();
        GameObject entrance = ctx.objects.select().id(3771).nearest().poll();
        entrance.interact("Enter");
        GameObject ladder = ctx.objects.select().id(18834).nearest().poll();
        ctx.camera.turnTo(ladder);
        ctx.movement.step(ladder);
        ladder.interact("Climb-up");
        LocalPath trollPath2 = ctx.movement.findPath(new Tile(2827,3687,0));
        trollPath2.traverse();
        /*GameObject rock = ctx.objects.select().id(3083).nearest().poll();
        ctx.camera.turnTo(rock);
        ctx.movement.step(rock);
        rock.interact("Climb");*/

    }
}