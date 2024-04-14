package puzzle;
import puzzle.model.PuzzleModel;
import puzzle.util.Matrix;

public class Test
{
    public static void main(String[] args)
    {
        PuzzleModel p =new PuzzleModel(4,3);
        p.switchCell(10);
        Matrix.show(p.getGrid());
    }
}