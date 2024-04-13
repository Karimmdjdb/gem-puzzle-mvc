package puzzle.view;

import javax.swing.JPanel;
import puzzle.model.PuzzleModel;


/**
  * classe qui gére l'affichage d'une fenêtre affichant un puzzle de Taquin. 
  * @author Karim 
  */
public class PuzzleGui extends javax.swing.JFrame
{
    JPanel panel;
    /**
      * constructeur de la classe PuzzleGui
      * @param model le modéle géré par la classe PuzzleGui 
      */
    public PuzzleGui(PuzzleModel model)
    {
        super("Puzzle");
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        panel = new PuzzleView(model);
        add(panel);
        pack();
        setVisible(true);
    }
}