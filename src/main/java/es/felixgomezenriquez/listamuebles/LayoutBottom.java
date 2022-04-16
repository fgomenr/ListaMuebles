/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.felixgomezenriquez.listamuebles;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.effect.Effect;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author usuario
 */
public class LayoutBottom extends VBox {
    Button botonGuardar = new Button("Guardar");

    Button botonAbrir = new Button("Abrir");

    

    public LayoutBottom (){
        
        
        this.getChildren().addAll(botonAbrir,botonGuardar);
        this.setAlignment(Pos.CENTER);
        this.setMinHeight(100);
        this.setMaxHeight(200);
        this.setMargin(botonAbrir, new Insets(5, 0, 5, 0));
        this.setMargin(botonGuardar, new Insets(5, 0, 10, 0));
        this.setBackground(new Background(
                new BackgroundFill(Color.rgb(189, 160, 131), CornerRadii.EMPTY, new Insets(5, 5, 5, 5))));
        
        
    }
}
