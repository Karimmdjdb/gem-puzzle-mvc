package puzzle.view;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;


/**
  * un bouton personnalisé
  * @author Karim 
  */
public class PuzzleButton extends javax.swing.JButton implements java.awt.event.MouseListener
{
    public static final int MODE_CHIFFRE = 0, MODE_IMAGE = 1;
    private int width, height, id;
    private Integer value;
    private boolean hovered = false, hoverable;
    public static int mode ;
    private static BufferedImage backgroundImage;
    private BufferedImage img = null;

    static
    {
      mode = MODE_CHIFFRE;

      try
        {
          backgroundImage = ImageIO.read(new FileInputStream("livraison/src/assets/image.jpg"));
        }
        catch(IOException e)
        {
          System.out.println(e.getMessage());
        }
    }

    /**
      * constructeur de la classe PuzzleButton.
      * @param piece la piéce de puzzle dont la valeur sera affichée par la bouton.
      * @param size diamétre de l'affichage du bouton.
      * @param listener écouteur d'action qui définir le comportement lors du clic sur le bouton.
      * @param id identificateur du bouton.
      * @param hover booléen qui définit si le bouton doit changer de couleur au survol.
      */
    public PuzzleButton(puzzle.model.Piece<Integer> piece, int width, int height, java.awt.event.ActionListener listener, int id, boolean hover, int cols)
    {
        super(piece.toString());
        this.width = width;
        this.height = height;
        this.value = piece.getValue();
        this.id = id;
        this.hoverable = hover;
        if(this.value != null)
        {
          int cell_i = (this.value - 1) / cols;
          int cell_j = (this.value - 1) % cols;
          this.img = backgroundImage.getSubimage(cell_j*width, cell_i*height, width, height);
        }
        this.addActionListener(listener);
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
        if(mode == MODE_CHIFFRE)
        {
          this.setBorderPainted(false);
          if(this.value == null) g2d.setColor(PuzzleView.COLOR1);
          else
          {
              if(hoverable && hovered) g2d.setColor(PuzzleView.COLOR4);
              else g2d.setColor(PuzzleView.COLOR2);
          }
          g2d.fillOval(0,0, width, height);
          g2d.setColor(PuzzleView.COLOR1);
          g2d.drawString(getText(), width/2 -10, height/2 + 5);
        }

        else if(mode == MODE_IMAGE)
        {
          this.setBorderPainted(true);
          if(this.value == null)
          {
            g2d.setColor(Color.BLACK);
            g2d.fillRect(0, 0, width, height);
          }
          else
          {
            g2d.drawImage(img, 0, 0, null);
          }
        }
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