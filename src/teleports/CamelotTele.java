package teleports;

import org.powerbot.script.rt4.ClientContext;
import herbrunner.Task;
import org.powerbot.script.rt4.Component;

public class CamelotTele extends Task<ClientContext> {

    private int plantedHerbID = 8139;
    private int ranarrSeedID = 5295;

    public CamelotTele(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return !ctx.objects.select().id(plantedHerbID).isEmpty() && ctx.inventory.select().id(ranarrSeedID).count(true) == 1;
    }

    @Override
    public void execute() {
        System.out.println("Teleporting to Camelot...");
        Component spellBook = ctx.widgets.component(548,51);
        spellBook.click();
        Component camelotSpell = ctx.widgets.component(218,27);
        camelotSpell.click();
        Component inventory = ctx.widgets.component(548,48);
        inventory.click();
    }
}