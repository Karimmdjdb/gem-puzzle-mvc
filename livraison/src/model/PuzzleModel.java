package puzzle.model;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


/**
 * Classe représentant le modèle pour un jeu de puzzle.
 */
public class PuzzleModel extends puzzle.util.AbstractModel
{
    
    private int n,m;
    private Piece<Integer>[][] grid;
    private int coup = 0;

    
    /**
     * Constructeur pour créer un modèle de puzzle avec une taille spécifiée.
     *
     * @param n Le nombre de lignes du puzzle.
     * @param m Le nombre de colonnes du puzzle.
     */
    public PuzzleModel(int n, int m)
    {   // Implémentation du constructeur
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


     /**
     * Effectue un mouvement aléatoire dans le puzzle.
     */
    public void randomMove()
    {
        ArrayList<int[]> nextToEmpty = new ArrayList<>();
        int i = getEmptyPos()[0],  j = getEmptyPos()[1];
        for(int a = -1; a < 2 ; a++)
        {
            for(int b = -1; b < 2; b++)
            {
                if((a == 0 & b == 0) || (a != 0 && b != 0)) continue;
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


    /**
     * Mélange le puzzle en effectuant plusieurs mouvements aléatoires.
     */
    public void scramble()
    {
        for(int i = 0; i<1000; i++)
        {
            randomMove();
        }
    }

    
    /**
     * Récupère le nombre de lignes dans le puzzle.
     *
     * @return Le nombre de lignes dans le puzzle.
     */
    public int getRows()
    {
        return n;
    }

    
    /**
     * Récupère le nombre de colonnes dans le puzzle.
     *
     * @return Le nombre de colonnes dans le puzzle.
     */
    public int getCols()
    {
        return m;
    }


      /**
     * Récupère la grille du puzzle.
     *
     * @return La grille du puzzle.
     */
    public Piece[][] getGrid()
    {
        return this.grid;
    }


    /**
     * Vérifie si une cellule est adjacente à la cellule vide.
     *
     * @param i L'indice de la ligne de la cellule.
     * @param j L'indice de la colonne de la cellule.
     * @return true si la cellule est adjacente à la cellule vide, sinon false.
     */
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
    
    
    /**
     * Récupère les coordonnées de la cellule vide dans la grille.
     *
     * @return Un tableau d'entiers contenant les coordonnées de la cellule vide [i, j].
     */
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

    
    /**
     * Effectue un mouvement en échangeant la cellule vide avec une cellule adjacente.
     *
     * @param id L'indice de la cellule à déplacer dans un mouvement par clic.
     */
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
            coup++;
            this.fireChangement();
            
            /*List<Integer> values = new ArrayList<>();
            for(int i=0; i<n; i++)
            {
                for(int j=0; j<m; j++)
                {
                    values.add(grid[i][j].getValue());
                }
            }
            boolean ok = values.get(n*m-1) == -1;
            values.remove(n*m-1);
            List<Integer> valuesUnsorted = new ArrayList<>(values);
            Collections.sort(values);
            if(ok && values == valuesUnsorted)
            {
                System.out.println("Gagné !");
            }*/
        }
    }

    
    /**
     * Effectue un mouvement en échangeant la cellule vide avec une cellule adjacente.
     *
     * @param cell_i L'indice de la ligne de la cellule à déplacer.
     * @param cell_j L'indice de la colonne de la cellule à déplacer.
     */
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


    /**
     * Incrémente le nombre de coups joués dans le puzzle.
     */
    public void incrementeCoup()
    {
        coup++;
    }


    /**
     * Récupère le nombre de coups joués dans le puzzle.
     *
     * @return Le nombre de coups joués.
     */
    public int getCoup()
    {
        return coup;
    }
}
