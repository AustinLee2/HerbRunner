package herbrunner;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Npc;

public class Note extends Task<ClientContext> {

    private int grimyRanarrID = 207;
    private int plantedHerbID = 8139;
    private int[] emptyPatchIDS = {8136,8132,18818};

    public Note(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return /*!ctx.inventory.select().id(grimyRanarrID).isEmpty() || */ctx.inventory.select().count() == 28/* && !ctx.objects.select().id(plantedHerbID).isEmpty()*/
                && ctx.objects.select().id(emptyPatchIDS).isEmpty();
    }

    @Override
    public void execute() {
        System.out.println("Nothing...");
        Npc toolLep = ctx.npcs.select().name("Tool Leprechaun").nearest().poll();
        if (toolLep.inViewport()){
            ctx.inventory.select().id(grimyRanarrID).poll().interact("Use");
            toolLep.interact("Use");
        }
        else{
            ctx.camera.turnTo(toolLep);
            ctx.movement.step(toolLep);
        }
        Condition.sleep(2000);
    }
}