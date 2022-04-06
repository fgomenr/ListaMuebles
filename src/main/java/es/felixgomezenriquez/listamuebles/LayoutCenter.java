/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.felixgomezenriquez.listamuebles;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 *
 * @author usuario
 */
public class LayoutCenter extends HBox{
    private Label[] lb = new Label[7];
    
    public LayoutCenter(){
        
        for (int i = 0; i >= 6; i++) {
            lb[i]= new Label();
            lb[i].setMaxSize(50, 50);
            lb[i].setText("Mensaje predeterminado");
            this.getChildren().add(lb[i]);
        }
        this.setAlignment(Pos.CENTER);

    }
    
    public void actualizarTexto(Mueble mueble, int muebleAhora){
        
        lb[muebleAhora].setText(mueble.getModelo());
        
//        lb[muebleActual].setText(mueble.getMarca());
//        lb[muebleActual].setText(Float.toString(mueble.getPrecio()));
//        lb[muebleActual].setText(Float.toString(mueble.getTamanyo()));
//        lb[muebleActual].setText(mueble.getModelo());
//        lb[muebleActual].setText(mueble.getModelo());
    }
    
}

//char[][] tablero;
//
//tablero = new char[TAM_X_TABLERO][TAM_Y_TABLERO];