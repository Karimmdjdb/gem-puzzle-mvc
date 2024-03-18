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

    // accesseur pour le nombre de lignes
    public int getRows()
    {
        return n;
    }

    // accesseur pour le nombre de colonnes
    public int getCols()
    {
        return m;
    }

    // Accesseur de la grille
    public Piece[][] getGrid()
    {
        return this.grid;
    }

    //Vérifie si la cellule d'identifiant (i,j) est adjacente à la case vide
    public boolean cellIsNextToEmpty(int i, int j)
    {
        if(i-1 >= 0)
        {
            if(grid[i-1][j].isEmpty()) return true;
        }
        if(j+1 < this.m)
        {
            if(grid[i][j+1].isEmpty()) return true;
        }
        if(i+1 < this.n)
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

    //échange la cellule d'identifiant id avec la case vide si elle y est adjacente
    public void switchCell(int id)
    {
        int cell_i = id / this.m;
        int cell_j = id % this.m;
        if(cellIsNextToEmpty(cell_i, cell_j))
        {
            int empty_i = this.getEmptyPos()[0];
            int empty_j = this.getEmptyPos()[1];
            Piece temp = grid[cell_i][cell_j];
            grid[cell_i][cell_j] = grid[empty_i][empty_j];
            grid[empty_i][empty_j] = temp;
            this.fireChangement();
        }
    }
}
