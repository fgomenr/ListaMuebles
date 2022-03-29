/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.felixgomezenriquez.listamuebles;

import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;


public class Boton extends Button{
    
    public Boton(String titulo, StackPane root){
        
        this.setText(titulo);        
    }    
}
