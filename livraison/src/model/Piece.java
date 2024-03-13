package puzzle.model;

public class Piece
{
    private int value;

    public Piece(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return this.value;
    }

    public String toString()
    {
        return (this.value != -1) ? ""+value : " ";
    }

    public boolean isEmpty()
    {
        return this.value == -1;
    }
}