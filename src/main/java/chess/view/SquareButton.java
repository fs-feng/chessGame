package chess.view;

import chess.board.Square;
import chess.pieces.Piece;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SquareButton extends JButton {
    private static Piece selectedPiece = null;
    private static SquareButton selectedButton = null;
    private SquareButton button = this;
    private Square square;



    public SquareButton(int col, int row, Square square) {
        this.setPreferredSize(new Dimension(90,90));
        this.setBorder(BorderFactory.createEmptyBorder());
        this.square = square;
        this.square.setSquareButton(this);
        if (this.square.getPiece() != null) {
            this.setPieceIcon();
        }

        setupActionListener();
        setButtonColor(col, row);
    }



    public void setupActionListener() {
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                square.selectPiece();
            }

        });
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

    public Square getSquare() {
        return square;
    }
}
