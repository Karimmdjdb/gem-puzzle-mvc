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
    public final static int LVL_EASY = 0, LVL_MEDIUM = 1, LVL_HARD = 2, LVL_CUSTOM = 3;
    public static int[] diff = new int[]{3, 3, 5, 5, 10, 10, 0, 0};
    private int level = LVL_EASY;
    private PuzzleView canvas;
    private JCheckBoxMenuItem check1, check2, check3;
    private JLabel coups;



    public PuzzleGui()
    {
        super("Puzzle");
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        //ajout de la barre de menus
        setJMenuBar(buildMenuBar());
        
        //ajout du canvas
        canvas = new PuzzleView(newModel());
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
      int newLevel = level;
      switch(item)
      {
        case "Chiffres":
          PuzzleButton.mode = PuzzleButton.MODE_CHIFFRE;
          break;
        
        case "Image":
          PuzzleButton.mode = PuzzleButton.MODE_IMAGE;
          break;

        case "Nouvelle partie":
          canvas.changeModel(newModel());
          break;
        
        case "Facile":
          newLevel = LVL_EASY;
          check1.setState(true);
          check2.setState(false);
          check3.setState(false);
          break;

        case "Moyen":
          newLevel = LVL_MEDIUM;
          check1.setState(false);
          check2.setState(true);
          check3.setState(false);
          break;

        case "Difficile":
          newLevel = LVL_HARD;
          check1.setState(false);
          check2.setState(false);
          check3.setState(true);
          break;
        
        case "Personnalisé":
          new SelectionWindow(this);
          check1.setState(false);
          check2.setState(false);
          check3.setState(false);
          break;
        
        default :
          break;
      }

      if(level != newLevel)
      {
        level = newLevel;
        canvas.changeModel(newModel());
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

        JCheckBoxMenuItem item2_1_1 = new JCheckBoxMenuItem("Facile");
        menu2_1.add(item2_1_1);
        item2_1_1.addActionListener(this);
        check1 = item2_1_1;
        check1.setState(true);

        JCheckBoxMenuItem item2_1_2 = new JCheckBoxMenuItem("Moyen");
        menu2_1.add(item2_1_2);
        item2_1_2.addActionListener(this);
        check2 = item2_1_2;

        JCheckBoxMenuItem item2_1_3 = new JCheckBoxMenuItem("Difficile");
        menu2_1.add(item2_1_3);
        item2_1_3.addActionListener(this);
        check3 = item2_1_3;

        menu2_1.addSeparator();

        JMenuItem item2_1_4 = new JMenuItem("Personnalisé");
        menu2_1.add(item2_1_4);
        item2_1_4.addActionListener(this);


        menu2.add(menu2_1);

        menuBar.add(menu2);

        coups = new JLabel();
        menuBar.add(coups);
        menuBar.add(new JLabel("                                              nombre de coups : 0"));

        return menuBar;
    }

    public PuzzleModel newModel()
    {
      return new PuzzleModel(diff[2*level], diff[2*level+1]);
    }

    public void changeModel()
    {
      canvas.changeModel(newModel());
    }

    public void changeLevel(int newLevel)
    {
      this.level = newLevel;
    }

    public void changeCoups(int nombre)
    {
      coups.setText("                                              nombre de coups : " + nombre);
    }
}