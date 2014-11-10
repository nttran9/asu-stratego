package edu.asu.stratego.gui.board;

import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import edu.asu.stratego.gui.board.BoardSquareType;
import edu.asu.stratego.media.ImageConstants;

public class BoardSquare extends StackPane {
    
    private ImageView piece = new ImageView(ImageConstants.blue_back);
    
    public BoardSquare(BoardSquareType type) {
        // Background image.
        if (type == BoardSquareType.LIGHT)
            this.setStyle("-fx-background-image: url(edu/asu/stratego/media/images/board/grass1.png)");
        else if (type == BoardSquareType.DARK)
            this.setStyle("-fx-background-image: url(edu/asu/stratego/media/images/board/grass2.png)");
        
        this.getChildren().add(piece);
    }
    
    public ImageView getPiece() {
        return piece;
    }
}