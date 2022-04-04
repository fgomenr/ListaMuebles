/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.felixgomezenriquez.listamuebles;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

/**
 *
 * @author usuario
 */
public class LayoutLeft extends HBox {
    Button botonAnterior = new Button("Anterior");

    
    public LayoutLeft(){
        
        this.setMinWidth(100);
        this.setMaxWidth(150);
        this.getChildren().addAll(botonAnterior);
        this.setAlignment(Pos.CENTER);
        
    }
    
    
}
