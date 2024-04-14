package puzzle.view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import puzzle.model.PuzzleModel;


/**
  * classe qui gére l'affichage d'une fenêtre affichant un puzzle de Taquin. 
  * @author Karim 
  */
public class PuzzleGui extends javax.swing.JFrame implements ActionListener
{
    public static int[] diff = new int[]{3,3};
    private PuzzleView canvas;



    public PuzzleGui()
    {
        super("Puzzle");
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        //ajout de la barre de menus
        setJMenuBar(buildMenuBar());
        
        //ajout du canvas
        canvas = new PuzzleView(new PuzzleModel(diff[0],diff[1]));
        add(canvas);
        pack();
        setVisible(true);
    }


    /**
      * constructeur de la classe PuzzleGui
      * @param model le modéle géré par la classe PuzzleGui 
      */
    public PuzzleGui(PuzzleModel model)
    {
        super("Puzzle");
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        //ajout de la barre de menus
        setJMenuBar(buildMenuBar());
        
        //ajout du canvas
        canvas = new PuzzleView(model);
        add(canvas);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
      String item = ((JMenuItem)e.getSource()).getText();
      switch(item)
      {
        case "Chiffres":
          PuzzleButton.mode = PuzzleButton.MODE_CHIFFRE;
          break;
        
        case "Image":
          PuzzleButton.mode = PuzzleButton.MODE_IMAGE;
          break;

        case "Nouvelle partie":
          canvas.changeModel(new PuzzleModel(diff[0],diff[1]));
          break;
        
        case "Facile":
          diff[0] = 3;
          diff[1] = 3;
          break;

        case "Moyen":
          diff[0] = 5;
          diff[1] = 5;
          break;

        case "Difficile":
          diff[0] = 10;
          diff[1] = 10;
          break;
        
        default :
          break;
      }

      canvas.repaint();
    }

    private JMenuBar buildMenuBar()
    {
        JMenuBar menuBar = new JMenuBar();

        JMenu menu1 = new JMenu("Affichage");

        JMenuItem item1_1 = new JMenuItem("Chiffres");
        menu1.add(item1_1);
        item1_1.addActionListener(this);

        JMenuItem item1_2 = new JMenuItem("Image");
        menu1.add(item1_2);
        item1_2.addActionListener(this);

        menuBar.add(menu1);

        JMenu menu2 = new JMenu("Jeu");

        JMenuItem item2_1 = new JMenuItem("Nouvelle partie");
        menu2.add(item2_1);
        item2_1.addActionListener(this);

        JMenu menu2_1 = new JMenu("Difficulté");

        JMenuItem item2_1_1 = new JMenuItem("Facile");
        menu2_1.add(item2_1_1);
        item2_1_1.addActionListener(this);

        JMenuItem item2_1_2 = new JMenuItem("Moyen");
        menu2_1.add(item2_1_2);
        item2_1_2.addActionListener(this);

        JMenuItem item2_1_3 = new JMenuItem("Difficile");
        menu2_1.add(item2_1_3);
        item2_1_3.addActionListener(this);

        menu2_1.addSeparator();

        JMenuItem item2_1_4 = new JMenuItem("Personnalisé");
        menu2_1.add(item2_1_4);
        item2_1_4.addActionListener(this);


        menu2.add(menu2_1);

        menuBar.add(menu2);

        return menuBar;
    }
}