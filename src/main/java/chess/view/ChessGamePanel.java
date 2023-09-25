package chess.view;

import javax.swing.*;
import java.awt.*;

public class ChessGamePanel extends JPanel {
    private ChessToolbarPanel toolbarPanel;
    private ChessBoardPanel boardPanel;

    public ChessGamePanel() {
        this.setLayout(new BorderLayout());

        boardPanel = new ChessBoardPanel();
        toolbarPanel = new ChessToolbarPanel();

        this.add(toolbarPanel, BorderLayout.NORTH);
        this.add(boardPanel, BorderLayout.CENTER);
    }
}
