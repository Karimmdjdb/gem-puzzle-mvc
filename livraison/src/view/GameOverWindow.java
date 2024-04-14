package puzzle.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Fenêtre pop up pour annoncer la fin du jeu.
 */

public class GameOverWindow extends JFrame implements ActionListener
{
    private JButton btn1, btn2;
    private PuzzleGui parent;

    /**
     * Constructeur de la fenêtre d'annonce de fin du jeu.
     *
     * @param parent La fenêtre parente.
     */
    public GameOverWindow(PuzzleGui parent)
    {
        super("Game Over");
        this.parent = parent;
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);

        JPanel main = new JPanel(new BorderLayout());

        JPanel sub1 = new JPanel();
        JLabel label = new JLabel("Félicitation ! vous avez réussi");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        sub1.add(label);

        JPanel sub2 = new JPanel(new GridLayout(1,3));
        btn1 = new JButton("rejouer");
        btn1.addActionListener(this);
        btn2 = new JButton("quitter");
        btn2.addActionListener(this);
        
        sub2.add(btn1);
        sub2.add(createEmptyArea());
        sub2.add(btn2);

        main.add(sub1, BorderLayout.NORTH);
        main.add(createEmptyArea(), BorderLayout.WEST);
        main.add(createEmptyArea(), BorderLayout.EAST);
        main.add(sub2, BorderLayout.CENTER);
        main.add(createEmptyArea(), BorderLayout.SOUTH);

        add(main);
        pack();
        setVisible(true);
    }


    /**
     * Crée une zone vide pour l'espacement.
     *
     * @return Le panneau avec une zone vide.
     */
    private JPanel createEmptyArea()
    {
        JPanel empty = new JPanel();
        empty.setPreferredSize(new Dimension(50,25));
        return empty;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        JButton target = (JButton)e.getSource();
        if(target == btn1)
        {
            parent.changeModel();
            dispose();
        }

        else if(target == btn2)
        {
            System.exit(0);   
        }
    }
}