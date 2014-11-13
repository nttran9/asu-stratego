package edu.asu.stratego.gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import edu.asu.stratego.game.Game;
import edu.asu.stratego.gui.board.SetupPanel;
import edu.asu.stratego.media.ImageConstants;

/**
 * Wrapper class for a JavaFX scene. Contains a scene UI and its associated 
 * event handlers for playing a game of Stratego.
 */
public class BoardScene {
    
    Scene scene;
    
    /**
     * Creates a new instance of BoardScene.
     */
    public BoardScene() {
        
        /* ================ Board Design ================
         * 
         * The scene is divided into a 12 x 12 grid.
         * Each unit represents a 1 x 1 area.
         * 
         * The scene should be about roughly 85% of the 
         * square of the height of the player's screen 
         * resolution.
         * 
         *          = = = = = = = = = = = =
         *          = + + + + + + + + + + =
         *          = + + + + + + + + + + =
         *          = + + + + + + + + + + =
         *          = + + + + + + + + + + =
         *          = + + + + + + + + + + =
         *          = + + + + + + + + + + =
         *          = + + + + + + + + + + =
         *          = + + + + + + + + + + =
         *          = + + + + + + + + + + =
         *          = + + + + + + + + + + =
         *          = = = = = = = = = = = =
         * 
         * Each '=' indicates part of the board border.
         * Each '+' indicates an individual board square.
         * 
         * Part of the border image is semi-transparent so
         * that the scene background color can come through 
         * to indicate which player's turn it is.
         */
        
        // Set the background color (turn indicator).
        Rectangle background = new Rectangle(0, 0, ClientStage.getSide(), ClientStage.getSide());
        background.setFill(new Color(0.48, 0.13, 0.13, 1.0));
        
        // Resize the board.
        final int size = 10;
        for (int row = 0; row < size; ++row) {
            for (int col = 0; col < size; ++col) {
                Game.getBoard().getSquare(row, col).getPane().getPiece().setFitHeight(ClientStage.getUnit());
                Game.getBoard().getSquare(row, col).getPane().getPiece().setFitWidth(ClientStage.getUnit());
            }
        }
        
        // Set the setup panel.
        SetupPanel panel = new SetupPanel();
        
        // Create the border.
        ImageView border = new ImageView(ImageConstants.border);
        border.setFitHeight(ClientStage.getSide());
        border.setFitWidth(ClientStage.getSide());
        
        StackPane root = new StackPane(background, Game.getBoard().getPane(), border, panel);
        Game.getBoard().getPane().setAlignment(Pos.CENTER);
        panel.setAlignment(Pos.CENTER);
        
        scene = new Scene(root, ClientStage.getSide(), ClientStage.getSide());
    }
    
    public double getUnit() {
        return ClientStage.getUnit();
    }
}