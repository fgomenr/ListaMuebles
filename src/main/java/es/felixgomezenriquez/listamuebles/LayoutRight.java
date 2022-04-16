/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.felixgomezenriquez.listamuebles;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

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
        this.setBackground(new Background(
                   new BackgroundFill(Color.rgb(189, 160, 131), CornerRadii.EMPTY, new Insets(5, 5, 5, 5))));     

    }
    
}
