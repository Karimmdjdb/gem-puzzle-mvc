package puzzle.util;

/**
 * Interface qui déclare la méthode d'un écouteur de Modéle
 **/
public interface Listener
{
    // Méthode qui sera appelée lors de la mise à jour du Modéle
    public void modelUpdated(Object source);
}