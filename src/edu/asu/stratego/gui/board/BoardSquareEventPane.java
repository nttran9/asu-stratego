package edu.asu.stratego.gui.board;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import edu.asu.stratego.game.Game;
import edu.asu.stratego.game.GameStatus;
import edu.asu.stratego.media.ImageConstants;

public class BoardSquareEventPane extends GridPane {
    
    private ImageView hover;
    
    private int row;
    private int col;
    
    public BoardSquareEventPane() {
        hover = new ImageView(ImageConstants.HIGHLIGHT_NONE);
        hover.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, new OnHover());
        hover.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, new OffHover());
        
        this.getChildren().add(hover);
    }
    
    private class OnHover implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent e) {
            ImageView hover = (ImageView) e.getSource();
            hover.setImage(ImageConstants.HIGHLIGHT_VALID);
        };
    }
    
    private class OffHover implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent e) {
            ImageView hover = (ImageView) e.getSource();
            hover.setImage(ImageConstants.HIGHLIGHT_NONE);
        };
    }
    
    private boolean isHoverValid() {
        // TODO Player's own piece is invalid.
        if (Game.getStatus() == GameStatus.IN_PROGRESS) {
            
        }
        
        return true;
    }
    
    public ImageView getHover() {
        return hover;
    }
    
    public void setPiece(Image p) {
        hover.setImage(p);
    }
    
    /**
     * @return the row
     */
    public int getRow() {
        return row;
    }

    /**
     * @param row the row to set
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * @return the col
     */
    public int getCol() {
        return col;
    }

    /**
     * @param col the col to set
     */
    public void setCol(int col) {
        this.col = col;
    }
}