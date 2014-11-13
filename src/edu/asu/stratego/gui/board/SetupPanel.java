package edu.asu.stratego.gui.board;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import edu.asu.stratego.gui.ClientStage;

public class SetupPanel extends GridPane {
    
    public SetupPanel() {
        final double UNIT = ClientStage.getUnit();
        
        // Panel background.
        this.setStyle("-fx-background-image: url(edu/asu/stratego/media/images/board/setup_panel.png); " + 
                      "-fx-background-repeat: stretch;" +
                      "-fx-background-size: " + UNIT * 10 + " " + UNIT * 5 + ";");
        
        // Create header UI.
        HBox header = new HBox();
        add(header, 0, 0);
    }
}