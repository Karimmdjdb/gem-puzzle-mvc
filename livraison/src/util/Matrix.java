package puzzle.util;

/**
 * Classe de traitement de matrices
 **/
public class Matrix
{   
    // Méthode qui affiche une matrice
    public static void show(Object[][] m)
    {
        int row = m.length;
        int col = m[0].length;
        for(int i=0; i < row; i++)
        {
            for(int j=0; j < col; j++)
            {
                if(j != col-1)
                {
                    System.out.print(m[i][j] + " | ");
                }
                else
                {
                    System.out.print(m[i][j]);
                }
            }
            System.out.println();
        }
    }
}