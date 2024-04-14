package puzzle.util;

/**
 * Une classe abstraite représentant un modèle de base pour les jeux de taquin.
 */

public abstract class AbstractModel implements Model
{
    private java.util.List<Listener> listeners = new java.util.ArrayList<Listener>();
    
    /**
      * Ajoute un écouteur à ce modèle.
      *
      * @param e L'écouteur à ajouter.
      */
    @Override
    public void addListener(Listener e)
    {
        listeners.add(e);
    }

    /**
     * Supprime un écouteur de ce modèle.
     *
     * @param e L'écouteur à supprimer.
     */
    @Override
    public void removeListener(Listener e)
    {
        listeners.remove(e);
    }

    /**
     * Notifie tous les écouteurs enregistrés lorsque le modèle est mis à jour.
     */
    public void fireChangement()
    {
        for(Listener e : listeners)
        {
            e.modelUpdated(this);
        }
    }
}