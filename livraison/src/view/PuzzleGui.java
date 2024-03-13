package puzzle.view;

import javax.swing.JPanel;
import puzzle.model.PuzzleModel;

public class PuzzleGui extends javax.swing.JFrame
{
    JPanel panel;

    public PuzzleGui(PuzzleModel model)
    {
        super("Puzzle");
        panel = new PuzzleView(model);
        add(panel);
        pack();
        setVisible(true);
    }
}