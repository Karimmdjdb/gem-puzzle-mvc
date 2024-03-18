package puzzle.view;

import javax.swing.JPanel;
import puzzle.model.PuzzleModel;

public class PuzzleGui extends javax.swing.JFrame
{
    JPanel panel;

    public PuzzleGui(PuzzleModel model)
    {
        super("Puzzle");
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        panel = new PuzzleView(model);
        System.out.println(panel);
        add(panel);
        pack();
        setVisible(true);
    }
}