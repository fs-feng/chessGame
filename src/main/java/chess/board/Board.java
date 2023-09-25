package chess.board;

import chess.pieces.*;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private Square[][] squareBoard;
    private List<Piece> whitePieces;
    private List<Piece> blackPieces;

    public Board() {
        newSquareBoard();
        setupPieces();
    }

    private void setupPieces() {
        whitePieces = new ArrayList<>();
        blackPieces = new ArrayList<>();

        whitePieces.add(new Rook(this.squareBoard[7][0], PieceColor.white, "rook"));
        whitePieces.add(new Rook(this.squareBoard[7][1], PieceColor.white, "knight"));
        whitePieces.add(new Rook(this.squareBoard[7][2], PieceColor.white, "bishop"));
        whitePieces.add(new Rook(this.squareBoard[7][3], PieceColor.white, "queen"));
        whitePieces.add(new Rook(this.squareBoard[7][4], PieceColor.white, "king"));
        whitePieces.add(new Rook(this.squareBoard[7][5], PieceColor.white, "bishop"));
        whitePieces.add(new Rook(this.squareBoard[7][6], PieceColor.white, "knight"));
        whitePieces.add(new Rook(this.squareBoard[7][7], PieceColor.white, "rook"));
        for (int i = 0; i < 8; i++) {
            whitePieces.add(new Rook(this.squareBoard[6][i], PieceColor.white, "pawn"));
        }

        blackPieces.add(new Rook(this.squareBoard[0][0], PieceColor.black, "rook"));
        blackPieces.add(new Rook(this.squareBoard[0][1], PieceColor.black, "knight"));
        blackPieces.add(new Rook(this.squareBoard[0][2], PieceColor.black, "bishop"));
        blackPieces.add(new Rook(this.squareBoard[0][3], PieceColor.black, "king"));
        blackPieces.add(new Rook(this.squareBoard[0][4], PieceColor.black, "queen"));
        blackPieces.add(new Rook(this.squareBoard[0][5], PieceColor.black, "bishop"));
        blackPieces.add(new Rook(this.squareBoard[0][6], PieceColor.black, "knight"));
        blackPieces.add(new Rook(this.squareBoard[0][7], PieceColor.black, "rook"));

        for (int i = 0; i < 8; i++) {
            blackPieces.add(new Rook(this.squareBoard[1][i], PieceColor.black, "pawn"));
        }

    }

    public void newSquareBoard() {
        squareBoard = new Square[8][8];
        for (int col = 0; col < 8; col++) {
            for (int row = 0; row < 8; row++) {
                squareBoard[col][row] = new Square(row, col);
            }
        }
    }

    public Square[][] getSquareBoard() {
        return squareBoard;
    }
}
