package puzzle;

import puzzle.model.PuzzleModel;
import puzzle.view.PuzzleGui;


/**
 * Classe de démonstration pour l'exécution du jeu de puzzle.
 */
public class Demo
{   
    /**
     * Méthode principale pour démarrer l'application.
     *
     * @param args Les arguments de la ligne de commande (non utilisés ici).
     */
    public static void main(String[] args)
    {   
        // Crée une nouvelle instance de la fenêtre de jeu PuzzleGui.
        javax.swing.JFrame window = new PuzzleGui();
    }
}