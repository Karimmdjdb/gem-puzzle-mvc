package puzzle.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Color;


/**
  * un bouton personnalisé
  * @author Karim 
  */
public class PuzzleButton extends javax.swing.JButton implements java.awt.event.MouseListener
{
    private int size, value, id;
    private boolean hovered = false, hoverable;

    /**
      * constructeur de la classe PuzzleButton.
      * @param piece la piéce de puzzle dont la valeur sera affichée par la bouton.
      * @param size diamétre de l'affichage du bouton.
      * @param listener écouteur d'action qui définir le comportement lors du clic sur le bouton.
      * @param id identificateur du bouton.
      * @param hover booléen qui définit si le bouton doit changer de couleur au survol.
      */
    public PuzzleButton(puzzle.model.Piece piece, int size, java.awt.event.ActionListener listener, int id, boolean hover)
    {
        super(piece.toString2());
        this.size = size;
        this.value = piece.getValue();
        this.id = id;
        this.hoverable = hover;
        this.addActionListener(listener);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        setFocusable(true);
        setEnabled(true);
        addMouseListener(this);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if(this.value == -1) g2d.setColor(PuzzleView.COLOR1);
        else
        {
            if(hoverable && hovered) g2d.setColor(PuzzleView.COLOR4);
            else g2d.setColor(PuzzleView.COLOR2);
        }
        g2d.fillOval(0,0, size, size);
        g2d.setColor(PuzzleView.COLOR1);
        g2d.drawString(getText(), size/2 -5, size/2 + 5);
        getParent().repaint();
    }

    /**
      * méthode qui permet de récpérer l'identifiant du bouton.
      * @return l'identificateur du bouton. 
      */
    public int getId()
    {
        return this.id;
    }

    /**
      * méthode qui permet de changer la valeur de isHovered
      * lors du survol du bouton.
      * @param isIt la valeur que prendra isHovered. 
      */
    public void turnHovered(boolean isIt)
    {
        hovered = isIt;
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e)
    {

    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e)
    {
        ((PuzzleButton)e.getSource()).hovered = true;
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e)
    {
        ((PuzzleButton)e.getSource()).hovered = false;
    }

    /**
      * {@inheritDoc}
      */
    @Override
    public void mousePressed(java.awt.event.MouseEvent e)
    {
        
    }

    /**
      * {@inheritDoc}
      */
    @Override
    public void mouseReleased(java.awt.event.MouseEvent e)
    {
        
    }
}