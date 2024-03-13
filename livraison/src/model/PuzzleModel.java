package puzzle.model;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe qui définit le Modéle d'un jeu puzzle à glissiéres
 **/

public class PuzzleModel extends puzzle.util.AbstractModel
{
    // Attributs
    private int n,m;
    private Piece[][] grid;

    // Constructeur
    public PuzzleModel(int n, int m)
    {
        this.n = n;
        this.m = m;
        List<Integer> values = new ArrayList<>();
        for(int i=-1; i<n*m-1; i++)
        {
            values.add(i);
        }
    
        Collections.shuffle(values); // Mélange les valeurs d'une liste

        grid =  new Piece[n][m];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                grid[i][j] = new Piece(values.get(m*i+j));
            }
        }
    }

    // Accesseur de la grille
    public Piece[][] getGrid()
    {
        return this.grid;
    }

    //Vérifie si la cellule est adjacente à la case vide
    public boolean cellIsNextToEmpty(int id)
    {
        int i = id / this.m;
        int j = id % this.m;

        if(i-1 >= 0)
        {
            if(grid[i-1][j].isEmpty()) return true;
        }
        if(j+1 <= this.m)
        {
            if(grid[i][j+1].isEmpty()) return true;
        }
        if(i+1 <= this.n)
        {
            if(grid[i+1][j].isEmpty()) return true;
        }
        if(j-1 >= 0)
        {
            if(grid[i][j-1].isEmpty()) return true;
        }

        return false;
    }
    
    //retourne la position de la case vide
    public int[] getEmptyPos()
    {
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(grid[i][j].isEmpty()) return new int []{i,j};
            }
        }
        return null;
    }
}
