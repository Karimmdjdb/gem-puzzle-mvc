package puzzle.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Fenêtre de sélection des dimensions personnalisées de la grille de jeu.
 */

public class SelectionWindow extends JFrame implements ActionListener
{
    private JTextField rows, cols;
    private PuzzleGui parent;

    /**
     * Constructeur de la fenêtre de sélection des dimensions personnalisées.
     *
     * @param parent La fenêtre parente.
     */
    public SelectionWindow(PuzzleGui parent)
    {
        super("Personnalisation");
        this.parent = parent;
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);

        JPanel main = new JPanel(new BorderLayout());

        JPanel sub1 = new JPanel();
        JLabel label = new JLabel("Séléctionnez une taille pour la grille de jeu \n(3x3 à 10x10).");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        sub1.add(label);

        JPanel sub2 = new JPanel(new GridLayout(2,2));
        sub2.setAlignmentX(CENTER_ALIGNMENT);
        JLabel label1 = new JLabel("lignes :");
        rows = new JTextField();
        JLabel label2 = new JLabel("colonnes :");
        cols = new JTextField();

        label1.setAlignmentX(Component.CENTER_ALIGNMENT);
        sub2.add(label1);
        sub2.add(rows);
        sub2.add(label2);
        sub2.add(cols);

        JPanel sub3 = new JPanel();
        JButton btn = new JButton("Valider");
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.addActionListener(this);
        sub3.add(btn);
        main.add(sub3, BorderLayout.SOUTH);

        main.add(sub1, BorderLayout.NORTH);
        main.add(createEmptyArea(), BorderLayout.WEST);
        main.add(createEmptyArea(), BorderLayout.EAST);
        main.add(sub2, BorderLayout.CENTER);

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
        empty.setPreferredSize(new Dimension(100,50));
        return empty;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Integer lignes = null;
        Integer colonnes = null;
        System.out.println(rows.getText() + " " + cols.getText());
        try
        {
            lignes = Integer.parseInt(rows.getText());
            colonnes = Integer.parseInt(cols.getText());
        }
        catch(Exception ex)
        {
        }

        if(lignes == null || colonnes == null || lignes < 3 || lignes > 10 || colonnes < 3 || colonnes > 10)
        {
            JOptionPane.showMessageDialog(this, "Arguments invalides.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        else
        {
            PuzzleGui.diff[6] = lignes;
            PuzzleGui.diff[7] = colonnes;
            parent.changeLevel(PuzzleGui.LVL_CUSTOM);
            PuzzleButton.randomImage();
            parent.changeModel();
            this.dispose();
        }
    }
}