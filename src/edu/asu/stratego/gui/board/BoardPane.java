package edu.asu.stratego.gui.board;

import edu.asu.stratego.game.board.Board;
import javafx.scene.layout.GridPane;

public class BoardPane extends GridPane {
    
    public BoardPane(Board board) {
        final int size = 10;
        
        for (int row = 0; row < size; ++row) {
            for (int col = 0; col < size; ++col) {
                add(board.getSquare(row, col).getPane(), row, col);
            }
        }
    }
}