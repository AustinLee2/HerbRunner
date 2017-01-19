package walks;

import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import herbrunner.Task;
import org.powerbot.script.rt4.Component;
import org.powerbot.script.rt4.LocalPath;

public class CamelotEnd extends Task<ClientContext> {

    private int ranarrSeedID = 5295;

    public CamelotEnd(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.inventory.select().id(ranarrSeedID).isEmpty();
    }

    @Override
    public void execute() {
        System.out.println("Banking");
        ctx.npcs.select().name("Tool Leprechaun").nearest().poll().interact("Exchange");
        Component inventoryBucket = ctx.widgets.component(126,7);
        inventoryBucket.click();
        Component close = ctx.widgets.component(125,1).component(11);
        close.click();
        LocalPath bankPath = ctx.movement.findPath(new Tile(2810,3440,0));
        bankPath.traverse();
        ctx.bank.open();
        ctx.bank.depositInventory();
    }
}