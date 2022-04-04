/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.felixgomezenriquez.listamuebles;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

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
    }
}
