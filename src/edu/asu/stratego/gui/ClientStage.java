package edu.asu.stratego.gui;

import java.net.Socket;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * The ConnectionStage class, which inherits from the JavaFX Stage class, is a 
 * preset Stage for facilitating easy navigation between scenes in the Client 
 * application.
 */
public class ClientStage extends Stage {
    
    ConnectionScene connection;
    Socket socket;
    
    /**
     * Creates a new instance of ClientStage.
     * @param socket connection socket used to connect the client to the server
     */
    public ClientStage(Socket socket) {
        this.setScene(new Scene(new Pane(), 300, 150));
        this.setTitle("ASU Stratego");
        this.setResizable(false);
        this.show();
        
        this.socket = socket;
    }
    
    /**
     * Switch to the Connection Scene.
     * @see edu.asu.stratego.gui.ConnectionScene
     */
    public void setConnectionScene() {
        connection = new ConnectionScene(socket);
        this.setScene(connection.scene);
    }
}