package herbrunner;

import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.rt4.ClientContext;
import teleports.ArdyTele;
import teleports.CamelotTele;
import teleports.PhastyTeleport;
import teleports.TrollTeleport;
import walks.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Script.Manifest(name="AArbRunnerV2", description = "Runs herbs")
/**
 * Created by ahlin_000 on 1/17/2017.
 */
public class HerbRunnerV2 extends PollingScript<ClientContext> {
    private List<Task> taskList = new ArrayList<Task>();

    @Override
    public void start(){
        taskList.addAll(Arrays.asList(new FaladorWalk(ctx),new PhastyWalk(ctx)/*new Retrieve(ctx)*/, new Clear(ctx), new Pick(ctx), new Compost(ctx), new Plant(ctx), new Retrieve(ctx), new Note(ctx),
                new PhastyTeleport(ctx), new TrollTeleport(ctx), new TrollWalk(ctx), new ArdyTele(ctx), new ArdyWalk(ctx), new CamelotTele(ctx), new CamelotWalk(ctx), new CamelotEnd(ctx)));
    }

    @Override
    public void poll(){
        for (Task t: taskList){
            System.out.println("Thinking...");
            if (t.activate() && ctx.players.local().animation() == -1){
                t.execute();
            }
        }
    }

    @Override
    public void stop(){
        System.out.print("Script stopped");
    }
}
