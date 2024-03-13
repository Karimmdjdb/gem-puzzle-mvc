package puzzle.view;

import puzzle.model.PuzzleModel;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.RenderingHints;
import javax.swing.JButton;

public class PuzzleView extends javax.swing.JPanel implements puzzle.util.Listener, java.awt.event.ActionListener
{
    // Constantes
    private int CELL_SIZE = 100;
    private Color COLOR1 = new Color(9, 9, 51);
    private Color COLOR2 = new Color(107, 107, 160);
    private Color COLOR3 = new Color(169, 169, 202);


    private PuzzleModel model;

    public PuzzleView(PuzzleModel p)
    {
        model = p;
        setPreferredSize(new Dimension (model.getCols()*CELL_SIZE, model.getRows()*CELL_SIZE));
        setLayout(new GridLayout(model.getRows(), model.getCols()));
        setBackground(COLOR3);

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
                JButton btn;
                if(i==x && j==y)
                {
                    btn = new JButton(model.getGrid()[i][j].toString2()){
                    public void paintComponent(Graphics g)
                    {
                        Graphics2D g2d = (Graphics2D)g;
                        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                        g2d.setColor(COLOR1);
                        g2d.fillOval(0,0,CELL_SIZE,CELL_SIZE);
                        super.paintComponent(g);
                    }
                };
                }
                else
                {
                    btn = new JButton(model.getGrid()[i][j].toString2()){
                    public void paintComponent(Graphics g)
                    {
                        Graphics2D g2d = (Graphics2D)g;
                        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                        g2d.setColor(COLOR2);
                        g2d.fillOval(0,0,CELL_SIZE,CELL_SIZE);
                        super.paintComponent(g);
                    }
                };
                }
                
                btn.setContentAreaFilled(false);
                btn.setBorderPainted(false);
                btn.addActionListener(this);
                btn.setFocusable(false);
                add(btn);
            }
        }
    }

    @Override
    public void modelUpdated(Object source)
    {
        this.repaint();
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e)
    {
        System.out.println("test");
    }
}