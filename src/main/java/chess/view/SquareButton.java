package chess.view;

import chess.board.Square;
import chess.pieces.Piece;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The SquareButton class represents a custom JButton that is associated with a square on a chessboard.
 * This class extends JButton with additional functionality to hold a Piece
 */
public class SquareButton extends JButton {
    private static Piece selectedPiece = null;
    private static SquareButton selectedButton = null;
    private SquareButton button = this;
    private Square square;


    /**
     * Constructs a SquareButton with the specified column, row, and associated square.
     * The button's preferred size is set to 90x90 pixels and the border is set to empty.
     * If the associated square contains a piece, the button's icon is set to the piece's icon.
     * The button's background color is determined based on the column and row values.
     *
     * @param col the column for the square
     * @param row the row position for the square
     * @param square associated square to bind the gui and the logic
     */
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


    //Actionlistener
    public void setupActionListener() {
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (square.getPiece() != null) {
                    selectedPiece = square.getPiece();
                    selectedButton = button;
                } else if (selectedPiece.getColor() == square.getPiece().getColor() && square.getPiece() != null) {
                    selectedPiece = square.getPiece();
                    selectedButton = button;
                } else if (selectedPiece != null) {
                    selectedPiece.move(getSquare());
                    setPieceIcon();
                    selectedButton.setIcon(null);
                    selectedButton = null;
                    selectedPiece = null;
                }

                if (square.getPiece() != null) {
                    selectedPiece = square.getPiece();

                }
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
