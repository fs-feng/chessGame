package chess.view;

import javax.swing.*;
import java.awt.*;


/**
 * Main application Frame Window for my chess game
 * GameFrame extends JFrame to create a Game Window
 * Chess Game Panel will be initialized and added
 */
public class GameFrame extends JFrame {
    private ChessGamePanel gamePanel;


    /**
     * Constructor GameFrame
     * initalizes a GamePanel and adds it
     * Sets behaviour for the GameFrame
     */
    public GameFrame() {
        gamePanel = new ChessGamePanel();
        this.add(gamePanel, BorderLayout.CENTER);

        this.setTitle("Chess");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
}
