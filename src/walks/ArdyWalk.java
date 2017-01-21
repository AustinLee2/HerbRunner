package walks;

import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import herbrunner.Task;
import org.powerbot.script.rt4.LocalPath;

public class ArdyWalk extends Task<ClientContext> {

    private int ranarrSeedID = 5295;

    public ArdyWalk(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.inventory.select().id(ranarrSeedID).count(true) == 2 && ctx.npcs.select().name("Tool Leprechaun").isEmpty();
    }

    @Override
    public void execute() {
        if (ctx.movement.energyLevel() >= 15){
            ctx.movement.running(true);
        }
        System.out.println("Walking to Ardougne patch...");
        LocalPath ardyPath1 = ctx.movement.findPath(new Tile(2637,3339,0));
        if (!ardyPath1.valid()){
            LocalPath ardyPath0 = ctx.movement.findPath(new Tile(2652, 3317, 0));
            ardyPath0.traverse();
        }

        System.out.println("Ardypath1: " + ardyPath1.valid());
        LocalPath ardyPath2 = ctx.movement.findPath(new Tile(2663,3376,0));
        if (!ardyPath2.valid()) {
            ardyPath1.traverse();
            System.out.println("executing");
        }
        System.out.println("Ardypath2: " + ardyPath2.valid());
        ardyPath2.traverse();
    }
}