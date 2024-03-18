package puzzle.view;

import javax.swing.JPanel;
import puzzle.model.PuzzleModel;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.RenderingHints;
import javax.swing.JButton;
import puzzle.util.Matrix;

public class PuzzleView extends JPanel implements puzzle.util.Listener, java.awt.event.ActionListener
{
    // Constantes
    private int CELL_SIZE = 100;
    private Color COLOR1 = new Color(9, 9, 51);
    private Color COLOR2 = new Color(107, 107, 160);
    private Color COLOR3 = new Color(169, 169, 202);


    private PuzzleModel model;

    public PuzzleView(PuzzleModel p)
    {
        super(true);
        System.out.println(this);
        System.out.println("parent: " + getParent());
        model = p;
        model.addListener(this);
        setPreferredSize(new Dimension (model.getCols()*CELL_SIZE, model.getRows()*CELL_SIZE));
        setLayout(new GridLayout(model.getRows(), model.getCols()));
        setBackground(COLOR3);
        JButton btn;
        for(int i = 0; i < model.getRows(); i++)
        {
            for(int j = 0; j < model.getCols(); j++)
            {
                btn = new JButton(model.getGrid()[i][j].toString2());
                btn.setContentAreaFilled(false);
                btn.setBorderPainted(false);
                btn.addActionListener(this);
                btn.setFocusable(false);
                btn.putClientProperty("id", i*model.getCols()+j);
                add(btn);
            }
        }

    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int x=model.getEmptyPos()[0], y=model.getEmptyPos()[1];
        for(int i=0; i<model.getRows(); i++)
        {
            for(int j=0; j<model.getCols(); j++)
            {
            }
        }
    }

    @Override
    public void modelUpdated(Object source)
    {
        System.out.println("updated");
        this.repaint();
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e)
    {
        System.out.println(((JButton)e.getSource()).getClientProperty("id"));
        model.switchCell((int)((JButton)e.getSource()).getClientProperty("id"));
    }
}