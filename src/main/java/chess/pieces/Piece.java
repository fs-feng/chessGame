package chess.pieces;

import chess.board.Square;

import javax.swing.*;
import java.awt.*;

public abstract class Piece {
    private Square currentSquare;
    private final PieceColor color;
    private final Icon pieceIcon;

    public Piece(Square currentSquare, PieceColor color, String pieceName) {
        this.currentSquare = currentSquare;
        this.currentSquare.setPiece(this);
        this.color = color;
        pieceIcon = setupIcon(pieceName);
    }

    private ImageIcon setupIcon(String pieceName) {
        Image pieceImage = new ImageIcon(this.getClass().getResource("/" + color + "_" + pieceName + ".png")).getImage();
        int newWidth = (int) (pieceImage.getWidth(null) * 1.5);
        int newHeight = (int) (pieceImage.getHeight(null) * 1.5);
        pieceImage = pieceImage.getScaledInstance(newWidth, newHeight, Image.SCALE_AREA_AVERAGING);

        return new ImageIcon(pieceImage);
    }

    public Icon getPieceIcon() {
        return pieceIcon;
    }
}
