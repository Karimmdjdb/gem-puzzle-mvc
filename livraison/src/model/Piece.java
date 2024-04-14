package puzzle.model;

/**
 * Classe représentant une pièce dans un jeu de taquin.
 *
 * @param <T> Le type de valeur stockée dans la pièce.
 */
public class Piece<T>
{
    private T value;


    /**
     * Constructeur pour créer une pièce avec une valeur donnée.
     *
     * @param value La valeur de la pièce.
     */
    public Piece(T value)
    {
        this.value = value;
    }


    /**
     * Récupère la valeur de la pièce.
     *
     * @return La valeur de la pièce.
     */
    public T getValue()
    {
        return this.value;
    }


     /**
     * Représentation textuelle de la pièce.
     *
     * @return Une chaîne de caractères représentant la valeur de la pièce.
     */
    public String toString()
    {
        return (this.value != null) ? (" " + value.toString()) : "X";
    }


    /**
     * Vérifie si la pièce est vide (sans valeur).
     *
     * @return true si la pièce est vide, sinon false.
     */
    public boolean isEmpty()
    {
        return this.value == null;
    }
}