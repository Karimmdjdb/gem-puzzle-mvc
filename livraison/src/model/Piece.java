package puzzle.model;

public class Piece<T>
{
    private T value;

    public Piece(T value)
    {
        this.value = value;
    }

    public T getValue()
    {
        return this.value;
    }

    public String toString()
    {
        return (this.value != null) ? (" " + value.toString()) : "X";
    }

    public boolean isEmpty()
    {
        return this.value == null;
    }
}