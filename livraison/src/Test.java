package puzzle;
import puzzle.model.PuzzleModel;
import puzzle.util.Matrix;

public class Test
{
    public static void main(String[] args)
    {
        PuzzleModel p =new PuzzleModel(4,4);
        Matrix.show(p.getGrid());
        System.out.println("all tests passed successfully !");
    }
}