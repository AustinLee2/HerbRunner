package walks;

import herbrunner.Task;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.LocalPath;

public class PhastyWalk extends Task<ClientContext> {

    private int emptyEctoID = 4252;
    private int ranarrSeedID = 5295;
    private int[] herbPatchID = {8143, 8147};

    public PhastyWalk(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.inventory.select().id(ranarrSeedID).count(true) == 4 && ctx.npcs.select().name("Tool Leprechaun").isEmpty() && !ctx.players.local().inMotion();
    }

    @Override
    public void execute() {
        if (ctx.movement.energyLevel() >= 15){
            ctx.movement.running(true);
        }
        System.out.println("Walking to Phastymays patch...");
        LocalPath phastyPath4 = ctx.movement.findPath(new Tile(3610,3532,0));
        System.out.println("PhastyPath4: " + phastyPath4.valid());
        if (phastyPath4.valid()){
            phastyPath4.traverse();
        }

    }
}