package puzzle.view;

import java.awt.*;
import javax.swing.*;
import puzzle.model.PuzzleModel;
import puzzle.util.Matrix;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import puzzle.util.Matrix;

/**
  * classe qui gére l'affichage et le contrôle d'un modéle de jeu du Taquin (respectant le pattern MVC). 
  * @author Melissa, Karim 
  */
public class PuzzleView extends JPanel implements puzzle.util.Listener, java.awt.event.ActionListener
{
    // Constantes
    private final static int CANVAS_WIDTH = 500, CANVAS_HEIGHT = 500;
    public final static Color COLOR1 = new Color(9, 9, 51);
    public final static Color COLOR2 = new Color(107, 107, 160);
    public final static Color COLOR3 = new Color(169, 169, 202);
    public final static Color COLOR4 = new Color(98, 88, 152);


    private PuzzleModel model;
    private JPanel panel;
    private JLabel label;
    private int cellWidth, cellHeight;
    /**
      * constructeur de la classe
      * @param p le modéle qu'affichera la classe PuzzleView. 
      */
    public PuzzleView(PuzzleModel p)
    {
        super(true);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(COLOR3);

        panel = new JPanel();
        panel.setBackground(null);
        panel.setPreferredSize(new Dimension (CANVAS_WIDTH, CANVAS_HEIGHT));
        this.add(panel);

        changeModel(p);
    }
    
    @Override
    public void modelUpdated(Object source)
    {
        panel.removeAll();
        int x=model.getEmptyPos()[0], y=model.getEmptyPos()[1];
        JButton btn;
        for(int i = 0; i < model.getRows(); i++)
        {
            //System.out.println(i);
            for(int j = 0; j < model.getCols(); j++)
            {
                btn = new PuzzleButton(model.getGrid()[i][j], cellWidth, cellHeight, this, i*model.getCols()+j, model.cellIsNextToEmpty(i, j), model.getCols());
                panel.add(btn);
            }
        }
        PuzzleGui parent = (PuzzleGui)SwingUtilities.getWindowAncestor(this);
        if(parent != null) parent.changeCoups(model.getCoup());
        this.revalidate();
        this.repaint();
    }

    /**
      * {@inheritDoc}
      */
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e)
    {
        model.switchCell(((PuzzleButton)e.getSource()).getId());
    }

    public void changeModel(PuzzleModel newModel)
    {
      this.model = newModel;
      this.model.scramble();
      this.model.addListener(this);
      cellWidth = CANVAS_WIDTH / model.getCols();
      cellHeight = CANVAS_HEIGHT / model.getRows();
      panel.setLayout(new GridLayout(model.getRows(), model.getCols()));
      modelUpdated(null);
    }
}