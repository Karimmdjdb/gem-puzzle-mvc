package puzzle.util;

/**
 * Classe abstraite qui définit les méthodes principales d'un Modéle
 **/

public abstract class AbstractModel implements Model
{
    private java.util.List<Listener> listeners = new java.util.ArrayList<>();
    
    @Override
    public void addListener(Listener e)
    {
        listeners.add(e);
    }

    @Override
    public void removeListener(Listener e)
    {
        listeners.remove(e);
    }

    // Méthode qui signale aux écouteurs que le Modéle a été mis à jour
    public void fireChangement()
    {
        for(Listener e : listeners)
        {
            e.modelUpdated(this);
        }
    }
}