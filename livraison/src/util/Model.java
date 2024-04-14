package puzzle.util;

/**
 * Interface décrivant un modèle pour mon jeu de taquin.
 */
public interface Model
{   
     /**
     * Ajoute un écouteur à ce modèle.
     *
     * @param e L'écouteur à ajouter.
     */
    public void addListener(Listener e);

     /**
     * Supprime un écouteur de ce modèle.
     *
     * @param e L'écouteur à supprimer.
     */
    public void removeListener(Listener e);
}