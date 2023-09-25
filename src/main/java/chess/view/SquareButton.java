package chess.view;

import chess.board.Square;

import javax.swing.*;
import java.awt.*;

public class SquareButton extends JButton {
    private Square square;
    public SquareButton(int col, int row, Square square) {
        this.setPreferredSize(new Dimension(90,90));
        this.setBorder(BorderFactory.createEmptyBorder());
        this.square = square;
        if (this.square.getPiece() != null) {
            this.setPieceIcon();
        }


        setButtonColor(col, row);
    }

    public void setButtonColor(int col, int row) {
        if ((col % 2 == 1 && row % 2 == 1) || (col % 2 == 0 && row % 2 == 0))
            this.setBackground(Color.decode("#FAF0E6"));
        else
            this.setBackground(Color.decode("#800020"));

    }

    public void setPieceIcon() {
        this.setIcon(square.getPiece().getPieceIcon());
    }
}
