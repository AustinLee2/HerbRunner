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
        System.out.print("Walking to Ardougne patch...");
        LocalPath ardyPath2 = ctx.movement.findPath(new Tile(2663,3376,0));
        if (!ardyPath2.valid()) {
            LocalPath ardyPath1 = ctx.movement.findPath(new Tile(2636, 3358, 0));
            System.out.println("Ardypath1: " + ardyPath1.valid());
            ardyPath1.traverse();
        }
        ardyPath2.traverse();
    }
}