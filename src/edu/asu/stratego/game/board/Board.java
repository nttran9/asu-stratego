package edu.asu.stratego.game.board;

import edu.asu.stratego.gui.board.BoardPane;
import edu.asu.stratego.gui.board.BoardSquareType;

public class Board {

    private final BoardPane pane;
    private final int size = 10;
    private Square[][] squares;
    
    public Board() {
        squares = new Square[size][size];
        for (int row = 0; row < size; ++row) {
            for (int col = 0; col < size; ++col) {
                if ((row + col) % 2 == 0)
                    squares[row][col] = new Square(BoardSquareType.DARK);
                else
                    squares[row][col] = new Square(BoardSquareType.LIGHT);
            }
        }
        
        pane = new BoardPane(this);
    }
    
    public Square getSquare(int row, int col) {
        return squares[row][col];
    }
    
    public BoardPane getPane() {
        return pane;
    }
}