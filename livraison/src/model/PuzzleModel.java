package puzzle.model;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class PuzzleModel extends puzzle.util.AbstractModel
{
    private int n,m;
    private Piece[][] grid;

    public PuzzleModel(int n, int m)
    {
        this.n = n;
        this.m = m;
        List<Integer> values = new ArrayList<>();
        for(int i=0; i<n*m; i++)
        {
            values.add(i);
        }
        Collections.shuffle(values);

        grid =  new Piece[n][m];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                grid[i][j] = new Piece(values.get(m*i+j));
            }
        }
    }

    public Piece[][] getGrid()
    {
        return this.grid;
    }
}
