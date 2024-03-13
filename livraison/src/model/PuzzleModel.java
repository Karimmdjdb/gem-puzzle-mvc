package puzzle.model;

public class PuzzleModel extends puzzle.util.AbstractModel
{
    private int n,m;
    private int[][] grid;

    public class PuzzleModel(int n, int m)
    {
        this.n = n;
        this.m = m;
    }
}
