package puzzle.model;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Classe qui définit le Modéle d'un jeu puzzle à glissiéres
 **/

public class PuzzleModel extends puzzle.util.AbstractModel
{
    // Attributs
    private int n,m;
    private Piece[][] grid;
    private int coup = 0;

    // Constructeur
    public PuzzleModel(int n, int m)
    {
        this.n = n;
        this.m = m;
        List<Integer> values = new ArrayList<>();
        for(int i=1; i<=n*m; i++)
        {
            values.add(i);
        }

        grid =  new Piece[n][m];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(m*i+j != n*m-1) grid[i][j] = new Piece(values.get(m*i+j));
                else grid[i][j] = new Piece(null);
            }
        }
    }

    public void scramble()
    {
        ArrayList<int[]> nextToEmpty = new ArrayList<>();
        int i = getEmptyPos()[0],  j = getEmptyPos()[1];
        for(int a = -1; a < 2 ; a++)
        {
            for(int b = -1; b < 2; b++)
            {
                if(a == b) continue;
                else
                {
                    if(i+a >= 0 && i+a < n && j+b >= 0 && j+b < m)
                    {
                        nextToEmpty.add(new int[]{i+a, j+b});
                    }
                }
            }
        }
        Random r = new Random();
        int newPos = r.nextInt(nextToEmpty.size());
        switchCell(nextToEmpty.get(newPos)[0], nextToEmpty.get(newPos)[1]);
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

    //échange la cellule d'index id avec la case vide si elle y est adjacente
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

    //échange la cellule de coordonnées cell_i et cell_j avec la case vide si elle y est adjacente
    public void switchCell(int cell_i, int cell_j)
    {
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

    public void incrementeCoup()
    {
        coup++;
    }

    public int getCoup()
    {
        return coup;
    }
}
