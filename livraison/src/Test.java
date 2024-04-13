package puzzle;
import puzzle.model.PuzzleModel;
import puzzle.util.Matrix;

public class Test
{
    public static void main(String[] args)
    {
        PuzzleModel p =new PuzzleModel(4,4);
        for(int i=0; i<1000; i++)
        {
            p.scramble();
        }
        Matrix.show(p.getGrid());
        System.out.println(p.cellIsNextToEmpty(3, 2));
    }
}