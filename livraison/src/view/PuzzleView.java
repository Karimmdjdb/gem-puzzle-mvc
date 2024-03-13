package puzzle.view;

import puzzle.model.PuzzleModel;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Graphics;
import javax.swing.JButton;

public class PuzzleView extends javax.swing.JPanel implements puzzle.util.Listener
{
    PuzzleModel model;
    int cellSize = 100;

    public PuzzleView(PuzzleModel p)
    {
        model = p;
        setPreferredSize(new Dimension (model.getCols()*cellSize, model.getRows()*cellSize));
        setLayout(new GridLayout(model.getRows(), model.getCols()));
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for(int i=0; i<model.getRows(); i++)
        {
            for(int j=0; j<model.getCols(); j++)
            {
                add(new JButton(model.getGrid()[i][j].toString()));
            }
        }
    }

    @Override
    public void modelUpdated(Object source)
    {
        this.repaint();
    }
}