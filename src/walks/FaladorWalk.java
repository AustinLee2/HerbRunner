package walks;

import herbrunner.Task;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.LocalPath;

public class FaladorWalk extends Task<ClientContext> {

    private boolean path1walked;
    private boolean path2walked;
    private boolean path3walked;
    private boolean path4walked;
    private int ranarrSeedID = 5295;
    private int[] herbPatchID = {8143, 8147};
    private int[] deadHerbPatch = {8147};
    private int compostID = 6034;

    public FaladorWalk(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.inventory.select().id(ranarrSeedID).count(true) == 5 && ctx.objects.select().id(herbPatchID).isEmpty();
    }

    @Override
    public void execute() {
        System.out.println("Walking to Falador Patch...");
        LocalPath faladorPath2 = ctx.movement.findPath(new Tile(3009,3318, 0));
        if (!faladorPath2.valid()) {
            LocalPath faladorPath = ctx.movement.findPath(new Tile(3006, 3329, 0));
            faladorPath.traverse();
        }
        if (faladorPath2.valid() && !path2walked){
            path1walked = true;
            faladorPath2.traverse();
        }
        System.out.println("FP2: " + faladorPath2.valid());
        LocalPath faladorPath3 = ctx.movement.findPath(new Tile(3031, 3322, 0));
        if (faladorPath3.valid() && !path3walked){
            path2walked = true;
            faladorPath3.traverse();
        }
        System.out.println("FP3: " + faladorPath3.valid());
        LocalPath faladorPath4 = ctx.movement.findPath(new Tile(3044,3320,0));
        if (faladorPath4.valid() && !path4walked){
            path3walked = true;
            faladorPath4.traverse();
        }
        System.out.println("FP4: " + faladorPath4.valid());
        LocalPath faladorPath5 = ctx.movement.findPath(new Tile(3055,3310,0));
        if (faladorPath5.valid()){
            path4walked = true;
            faladorPath5.traverse();
        }
    }
}