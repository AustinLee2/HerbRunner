package teleports;

import herbrunner.Task;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Component;

public class ArdyTele extends Task<ClientContext> {

    private int plantedHerbID = 18822;
    private int ranarrSeedID = 5295;

    public ArdyTele(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return !ctx.objects.select().id(plantedHerbID).isEmpty() && ctx.inventory.select().id(ranarrSeedID).count(true) == 2;
    }

    @Override
    public void execute() {
        System.out.println("Teleporting to Ardy...");
        Component spellBook = ctx.widgets.component(548,51);
        spellBook.click();
        Component ardySpell = ctx.widgets.component(218,33);
        ardySpell.click();


    }
}