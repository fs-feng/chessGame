package chess.view;

import chess.board.Board;
import chess.pieces.King;
import chess.pieces.Piece;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


/**
 * ChessBoard Panel that displays the chessfield
 */
public class ChessBoardPanel extends JPanel {
    private Board board;
    private SquareButton[][] boardButtons;
    private GridBagConstraints gbc = new GridBagConstraints();

    public ChessBoardPanel() {
        this.setLayout(new GridBagLayout());
        setupBoard();
    }



    private void setupBoard() {
        boardButtons = new SquareButton[8][8];
        board = new Board();

        createTopLabels();
        createSideLabels();
        setupSquares();
    }

    private void setupSquares() {
        for (int col = 0; col < 8; col++) {
            for (int row = 0; row < 8; row++) {
                boardButtons[col][row] = new SquareButton(col, row, board.getSquareBoard()[col][row]);
                gbc.gridx = row + 1;
                gbc.gridy = col + 1;
                this.add(boardButtons[col][row], gbc);
            }
        }
    }

    private void createTopLabels() {
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(new JLabel(),gbc);
        for (int i = 0; i < 8; i++) {
            JLabel label = new JLabel(Character.toString((char) ('A' + i)), SwingConstants.CENTER);
            label.setPreferredSize(new Dimension(90,30));
            label.setBackground(Color.BLACK);
            label.setForeground(Color.white);
            label.setOpaque(true);
            gbc.gridx = i + 1;
            gbc.gridy = 0;
            this.add(label, gbc);
        }
    }

    private void createSideLabels() {
        for (int i = 0; i < 8; i++) {
            JLabel label = new JLabel(Integer.toString(8 - i), SwingConstants.CENTER);
            label.setPreferredSize(new Dimension(30,90));
            label.setBackground(Color.BLACK);
            label.setForeground(Color.white);
            label.setOpaque(true);
            gbc.gridx = 0;
            gbc.gridy = i + 1;
            this.add(label, gbc);
        }
    }
}
