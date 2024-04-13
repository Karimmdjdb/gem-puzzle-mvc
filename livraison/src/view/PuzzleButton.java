package puzzle.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class PuzzleButton extends javax.swing.JButton
{
    private int size, id;
    private Integer value;
    public PuzzleButton(puzzle.model.Piece<Integer> piece, int size, java.awt.event.ActionListener listener, int id)
    {
        super(piece.toString());
        this.size = size;
        this.value = piece.getValue();
        this.id = id;
        this.addActionListener(listener);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        setFocusable(true);
        setEnabled(true);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if(this.value == null) g2d.setColor(PuzzleView.COLOR1);
        else g2d.setColor(PuzzleView.COLOR2);
        g2d.fillOval(0,0, size, size);
        g2d.setColor(PuzzleView.COLOR1);
        g2d.drawString(getText(), size/2 -5, size/2 + 5);
    }

    public int getId()
    {
        return this.id;
    }
}