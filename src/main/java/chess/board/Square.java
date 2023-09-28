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


    public void setSquareButton(SquareButton squareButton) {
        this.squareButton = squareButton;
    }

    public void selectPiece() {
        if (piece != null) {
            if (selectedPiece == null) {
                selectedPiece = piece;
                squareButton.selectPiece();
            } else if (selectedPiece.getColor() == piece.getColor()) {
                selectedPiece.getCurrentSquare().getSquareButton().deselectPiece();
                selectedPiece = piece;
                squareButton.selectPiece();
            } else {
                selectedPiece.getCurrentSquare().getSquareButton().deselectPiece();
                selectedPiece.getCurrentSquare().getSquareButton().setIcon(null);
                selectedPiece.move(this, this.getPiece());
                selectedPiece.getCurrentSquare().getSquareButton().setPieceIcon();
                selectedPiece = null;
            }
        } else if (selectedPiece != null) {
            selectedPiece.getCurrentSquare().getSquareButton().deselectPiece();
            selectedPiece.getCurrentSquare().getSquareButton().setIcon(null);
            selectedPiece.move(this);
            selectedPiece.getCurrentSquare().getSquareButton().setPieceIcon();
            selectedPiece = null;
        }
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

}
