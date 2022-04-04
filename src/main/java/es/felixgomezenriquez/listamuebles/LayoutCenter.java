/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.felixgomezenriquez.listamuebles;

import javafx.geometry.Pos;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 *
 * @author usuario
 */
public class LayoutCenter extends HBox{
    private TextArea ta = new TextArea();

    public LayoutCenter(){
                
        ta.setMaxSize(200, 200);
        ta.setEditable(false);
        this.getChildren().add(ta);
        this.setAlignment(Pos.CENTER);

    }
    
    public void actualizarTexto(Mueble mueble){
        
        ta.setText(mueble.toString());
    
    }
    
}
