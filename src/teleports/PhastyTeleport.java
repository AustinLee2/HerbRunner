package teleports;
import herbrunner.Task;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Item;

public class PhastyTeleport extends Task<ClientContext> {

    private int plantedHerbID = 8139;
    private int ranarrSeedID = 5295;
    private int emptyEctoID = 4252;
    //trollheim 18822 herb1
    //cammy 8139 herb1
    //clean ranaar 257

    public PhastyTeleport(ClientContext ctx){
        super(ctx);
    }
    
    @Override
    public boolean activate(){
        return !ctx.objects.select().id(plantedHerbID).isEmpty() && ctx.inventory.select().id(ranarrSeedID).count(true) == 4;
    }
    
    @Override
    public void execute(){
        System.out.println("Teleporting to Phastymays...");
        Item ectophial = ctx.inventory.select().id(4251).poll();
        ectophial.interact("Empty");
    }
}