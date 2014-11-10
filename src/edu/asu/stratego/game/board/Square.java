package edu.asu.stratego.game.board;

import edu.asu.stratego.game.PieceType;
import edu.asu.stratego.gui.board.BoardSquare;
import edu.asu.stratego.gui.board.BoardSquareType;

public class Square {

    private BoardSquare pane;
    private PieceType piece;
    
    public Square(BoardSquareType type) {
        pane = new BoardSquare(type);
    }
    
    public BoardSquare getPane() {
        return pane;
    }
}