package herbrunner;

import org.powerbot.script.ClientAccessor;
import org.powerbot.script.rt4.ClientContext;

/**
 * Created by ahlin_000 on 1/17/2017.
 */
public abstract class Task<C extends ClientContext> extends ClientAccessor<C>{
    public Task(C ctx){
        super(ctx);
    }

    public abstract boolean activate();
    public abstract void execute();
}
