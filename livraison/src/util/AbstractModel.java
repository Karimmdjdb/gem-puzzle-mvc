package puzzle.util;

public abstract class AbstractModel implements Model
{
    private java.util.List<Listener> listeners;

    public void addListener(Listener e)
    {
        listeners.add(e);
    }

    public void removeListener(Listener e)
    {
        listeners.remove(e);
    }

    public void fireChangement()
    {
        for(Listener e : listeners)
        {
            e.modelUpdated(this);
        }
    }
}