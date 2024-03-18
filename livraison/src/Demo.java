package puzzle;

import puzzle.model.PuzzleModel;
import puzzle.view.PuzzleGui;

public class Demo
{
    public static void main(String[] args)
    {
        PuzzleModel p = new PuzzleModel(5,4);
        javax.swing.JFrame window = new PuzzleGui(p);
    }
}