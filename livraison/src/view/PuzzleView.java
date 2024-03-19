package puzzle.view;

import javax.swing.JPanel;
import puzzle.model.PuzzleModel;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.RenderingHints;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Component;
import puzzle.util.Matrix;

public class PuzzleView extends JPanel implements puzzle.util.Listener, java.awt.event.ActionListener
{
    // Constantes
    private final static int CELL_SIZE = 100;
    public final static Color COLOR1 = new Color(9, 9, 51);
    public final static Color COLOR2 = new Color(107, 107, 160);
    public final static Color COLOR3 = new Color(169, 169, 202);


    private PuzzleModel model;
    private JPanel panel;
    private JLabel label;

    public PuzzleView(PuzzleModel p)
    {
        super(true);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        model = p;
        model.addListener(this);
        setBackground(COLOR3);
        setPreferredSize(new Dimension (model.getCols()*CELL_SIZE, model.getRows()*CELL_SIZE+40));

        panel = new JPanel(new GridLayout(model.getRows(), model.getCols()));
        panel.setBackground(null);
        panel.setPreferredSize(new Dimension (model.getCols()*CELL_SIZE , model.getRows()*CELL_SIZE));

        label = new JLabel("Coups : " + model.getCoup());

        this.add(panel);
        this.add(label);

        modelUpdated(null);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        System.out.println("euh");
        super.paintComponent(g);
        validate();
    }

    @Override
    public void modelUpdated(Object source)
    {
        panel.removeAll();
        int x=model.getEmptyPos()[0], y=model.getEmptyPos()[1];
        JButton btn;
        for(int i = 0; i < model.getRows(); i++)
        {
            for(int j = 0; j < model.getCols(); j++)
            {
                btn = new PuzzleButton(model.getGrid()[i][j], CELL_SIZE, this, i*model.getCols()+j);
                //btn = new JButton(model.getGrid()[i][j].toString2());
                panel.add(btn);
            }
        }
        this.revalidate();
        this.repaint();
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e)
    {
        System.out.println("click !");
        model.switchCell(((PuzzleButton)e.getSource()).getId());
    }
}