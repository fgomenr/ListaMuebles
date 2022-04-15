/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.felixgomezenriquez.listamuebles;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

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
        this.setBackground(new Background(
                new BackgroundFill(Color.CYAN, CornerRadii.EMPTY, new Insets(5, 5, 5, 5))));
    }
    
    
}
