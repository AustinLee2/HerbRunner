package walks;

import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import herbrunner.Task;
import org.powerbot.script.rt4.LocalPath;

public class CamelotWalk extends Task<ClientContext> {

    private int ranarrSeedID = 5295;

    public CamelotWalk(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.inventory.select().id(ranarrSeedID).count(true) == 1 && ctx.npcs.select().name("Tool Leprechaun").isEmpty();
    }

    @Override
    public void execute() {
        if (ctx.movement.energyLevel() >= 15){
            ctx.movement.running(true);
        }
        System.out.println("Walking to Camelot patch...");
        LocalPath camelotPath2 = ctx.movement.findPath(new Tile(2808,3464,0));
        if (!camelotPath2.valid()) {
            LocalPath camelotPath1 = ctx.movement.findPath(new Tile(2793, 3469, 0));
            camelotPath1.traverse();
            System.out.println("Camelotpath1: " + camelotPath1.valid());
        }
        camelotPath2.traverse();
        System.out.println("Camelotpath2: " + camelotPath2.valid());
    }
}