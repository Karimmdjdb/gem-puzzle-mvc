package puzzle.util;

/**
 * Interface qui déclare les deux méthodes d'un modéle écoutable
 **/

public interface Model
{
    // méthode pour ajouter un écouteur
    public void addListener(Listener e);

    // méthode pour supprimer unn écouteur
    public void removeListener(Listener e);
}