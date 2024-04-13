package puzzle;

import puzzle.model.PuzzleModel;
import puzzle.view.PuzzleGui;

public class Demo
{
    public static void main(String[] args)
    {
        PuzzleModel p = new PuzzleModel(3,3);
        javax.swing.JFrame window = new PuzzleGui(p);
    }
}