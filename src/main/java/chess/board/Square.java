package chess.board;

import chess.pieces.Piece;
import chess.view.SquareButton;

public class Square {
    private static Piece selectedPiece = null;

    private int row;
    private int col;
    private Piece piece;
    private SquareButton squareButton;


    public Square(int row, int col) {
        this.row = row;
        this.col = col;
        piece = null;
    }


    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public SquareButton getSquareButton() {
        return squareButton;
    }

    public void setSquareButton(SquareButton squareButton) {
        this.squareButton = squareButton;
    }

    public void selectPiece() {
        if (selectedPiece == null && piece != null) {
            selectedPiece = piece;
        } else if (selectedPiece.getColor() == piece.getColor()) {
            selectedPiece = piece;
        }
    }
}
