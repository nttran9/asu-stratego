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
import edu.asu.stratego.media.ImageConstants;

/**
 * Wrapper class for a JavaFX scene. Contains a scene UI and its associated 
 * event handlers for playing a game of Stratego.
 */
public class BoardScene {
    
    private final double UNIT;
    private final int SIDE;
    
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
        
        // Calculate the Scene dimensions from screen resolution.
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        SIDE = (int) (0.85 * screenSize.getHeight()) / 12 * 12;
        UNIT = SIDE / 12;
        
        // Set the background color (turn indicator).
        Rectangle background = new Rectangle(0, 0, SIDE, SIDE);
        background.setFill(new Color(1.0, 1.0, 1.0, 1.0));
        
        // Resize the board.
        final int size = 10;
        for (int row = 0; row < size; ++row) {
            for (int col = 0; col < size; ++col) {
<<<<<<< HEAD
                Game.getBoard().getSquare(row, col).getPane().getPiece().setFitHeight(UNIT);
                Game.getBoard().getSquare(row, col).getPane().getPiece().setFitWidth(UNIT);
=======
                squares[row][col] = new StackPane();
                
                if ((row + col) % 2 == 0) {
                    imageGrid[row][col] = new ImageView(ImageConstants.darkGrass);
                    squares[row][col].getChildren().add(imageGrid[row][col]);
                }
                else {
                    imageGrid[row][col] = new ImageView(ImageConstants.lightGrass);
                    squares[row][col].getChildren().add(imageGrid[row][col]);
                }
                
                // Resize each square.
                imageGrid[row][col].setFitHeight(UNIT);
                imageGrid[row][col].setFitWidth(UNIT);
                
                addLake(squares,row,col);
                
                boardGrid.add(squares[row][col], col, row);
>>>>>>> a7ee3d1027fe232adf2faad6cc64f2f3d2fb3c34
            }
        }
        
        // Create the border.
        ImageView border = new ImageView(ImageConstants.border);
        border.setFitHeight(SIDE);
        border.setFitWidth(SIDE);
        
        StackPane root = new StackPane(background, Game.getBoard().getPane(), border);
        Game.getBoard().getPane().setAlignment(Pos.CENTER);
        
        scene = new Scene(root, SIDE, SIDE);
    }
<<<<<<< HEAD
=======
    
    private void addLake(StackPane squares[][], int row, int col) {
        ImageView[][] imageGrid = new ImageView[10][10];
        boolean lakeFlag = false;
        
        if(row == 4 & col == 2) {
        	imageGrid[row][col] = new ImageView(ImageConstants.lake1_1);
        	lakeFlag = true;
        }
        else if(row == 4 & col == 3) {
        	imageGrid[row][col] = new ImageView(ImageConstants.lake1_2);
        	lakeFlag = true;
        }
        else if(row == 5 & col == 2) {
        	imageGrid[row][col] = new ImageView(ImageConstants.lake1_3);
        	lakeFlag = true;
        }
        else if(row == 5 & col == 3) {
        	imageGrid[row][col] = new ImageView(ImageConstants.lake1_4);
        	lakeFlag = true;
        }
        else if(row == 4 & col == 6) {
        	imageGrid[row][col] = new ImageView(ImageConstants.lake2_1);
        	lakeFlag = true;
        }
        else if(row == 4 & col == 7) {
        	imageGrid[row][col] = new ImageView(ImageConstants.lake2_2);
        	lakeFlag = true;
        }
        else if(row == 5 & col == 6) {
        	imageGrid[row][col] = new ImageView(ImageConstants.lake2_3);
        	lakeFlag = true;
        }
        else if(row == 5 & col == 7) {
        	imageGrid[row][col] = new ImageView(ImageConstants.lake2_4);
        	lakeFlag = true;
        }
        
        if(lakeFlag) {
        	squares[row][col].getChildren().add(imageGrid[row][col]);

        	imageGrid[row][col].setFitHeight(UNIT);
            imageGrid[row][col].setFitWidth(UNIT);
        }
    }
>>>>>>> a7ee3d1027fe232adf2faad6cc64f2f3d2fb3c34
}