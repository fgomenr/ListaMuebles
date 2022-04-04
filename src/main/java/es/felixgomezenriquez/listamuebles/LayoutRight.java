/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.felixgomezenriquez.listamuebles;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 *
 * @author usuario
 */
public class LayoutRight extends HBox{
    
    Button botonSiguiente = new Button("Siguiente");
        
     public LayoutRight(){
        
        this.getChildren().addAll(botonSiguiente);
        this.setAlignment(Pos.CENTER);        
        this.setMinWidth(100);
        this.setMaxWidth(150);
    }
    
}
