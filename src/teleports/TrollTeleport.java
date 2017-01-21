package teleports;

import herbrunner.Task;
import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Component;

public class TrollTeleport extends Task<ClientContext> {
    private int plantedHerbID = 8139;
    private int ranarrSeedID = 5295;

    public TrollTeleport(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return !ctx.objects.select().id(plantedHerbID).isEmpty() && ctx.inventory.select().id(ranarrSeedID).count(true) == 3;
    }

    @Override
    public void execute() {
        System.out.println("Teleporting to Trollheim");
        Component spellBook = ctx.widgets.component(548,51);
        spellBook.click();
        Component trollheimSpell = ctx.widgets.component(218,45);
        trollheimSpell.click();
        Component inventory = ctx.widgets.component(548,48);
        inventory.click();
        Condition.sleep(1000);
    }
}