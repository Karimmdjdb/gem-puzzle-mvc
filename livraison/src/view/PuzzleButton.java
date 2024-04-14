package puzzle.view;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Random;
/**
 * Classe représentant un bouton dans l'interface graphique du puzzle.
 */

public class PuzzleButton extends javax.swing.JButton implements java.awt.event.MouseListener
{
    public static final int MODE_CHIFFRE = 0, MODE_IMAGE = 1;
    public static final int NB_IMAGES = 7;
    private int width, height, id;
    private Integer value;
    private boolean hovered = false, hoverable;
    public static int mode ;
    private static BufferedImage backgroundImage;
    private BufferedImage img = null;

    static
    {
      mode = MODE_CHIFFRE;

      randomImage();
    }

    
    /**
     * Initialise les propriétés du bouton de puzzle.
     *
     * @param piece    La pièce associée au bouton.
     * @param width    La largeur du bouton.
     * @param height   La hauteur du bouton.
     * @param listener L'écouteur d'événements pour le bouton.
     * @param id       L'identifiant du bouton.
     * @param hover    Indique si le bouton peut être survolé par la souris.
     * @param cols     Le nombre de colonnes dans le puzzle.
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
        setFocusable(false);
        setEnabled(true);
        addMouseListener(this);
    }


     /**
     * {@inheritDoc}
     */
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
     * Récupère l'identifiant du bouton.
     *
     * @return L'identifiant du bouton.
     */
    public int getId()
    {
        return this.id;
    }

    
    /**
     * Active ou désactive l'état de survol du bouton.
     *
     * @param isIt true pour activer le survol, false pour le désactiver.
     */
    public void turnHovered(boolean isIt)
    {
        hovered = isIt;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void mouseClicked(java.awt.event.MouseEvent e)
    {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mouseEntered(java.awt.event.MouseEvent e)
    {
        ((PuzzleButton)e.getSource()).hovered = true;
    }


    /**
     * {@inheritDoc}
     */
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

    /**
     * choisit au hasard l'image qui sera representée dans l'interface
     */
    public static void randomImage()
    {
      try
        {
          Random r = new Random();
          backgroundImage = ImageIO.read(new FileInputStream("assets/image" + (r.nextInt(NB_IMAGES) + 1) + ".jpg"));
        }
        catch(IOException e)
        {
          System.out.println(e.getMessage());
        }
    }
}
