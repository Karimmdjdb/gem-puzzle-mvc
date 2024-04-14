package puzzle.util;

 /**
 * Interface pour les écouteurs du modèle.
 */
public interface Listener
{
    /**
     * Méthode appelée lorsqu'un modèle est mis à jour.
     *
     * @param source L'objet source de la mise à jour.
     */
    public void modelUpdated(Object source);
}