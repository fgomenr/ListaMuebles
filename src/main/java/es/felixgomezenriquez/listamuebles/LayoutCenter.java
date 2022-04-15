/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.felixgomezenriquez.listamuebles;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


/**
 *
 * @author usuario
 */
public class LayoutCenter extends VBox{
    private Label[] lb = new Label[7];
    Button comprar=new Button("Comprar");
    
    public LayoutCenter(){
        
        VBox labels = new VBox();
        labels.setAlignment(Pos.BASELINE_CENTER);
        labels.setPadding(new Insets(50,0,0,15));
        CornerRadii cornerradi =new CornerRadii(300,300, 300,300, false);
        
        for (int i = 0; i < 7; i++) {
            lb[i]= new Label();
            lb[i].setWrapText(true);
            lb[i].setPadding(new Insets(5));
            lb[i].setBackground(new Background(
                new BackgroundFill(Color.BURLYWOOD, cornerradi, Insets.EMPTY)));
            lb[i].setText("Mensaje predeterminado");
            labels.getChildren().add(lb[i]);
            labels.setMargin(lb[i], new Insets(2, 2, 2, 2));
        }
        
               
       
       VBox botonCompra= new VBox();
       

       //botonCompra.setBackground(new Background(
         //       new BackgroundFill(Color.BURLYWOOD, cornerradi, Insets.EMPTY)));
       
       botonCompra.setAlignment(Pos.BOTTOM_CENTER);

       botonCompra.getChildren().add(comprar);
       botonCompra.setPadding(new Insets(50,0,0,15));

       
       
       
       
       this.setBackground(new Background(
                new BackgroundFill(Color.CYAN, CornerRadii.EMPTY, new Insets(5, 5, 5, 5))));
       this.getChildren().addAll(labels,botonCompra);


    }
    
    public void actualizarTexto(Mueble mueble){
        
            lb[0].setText("Modelo: " + mueble.getModelo());
            lb[1].setText("Marca: " + mueble.getMarca());
            lb[2].setText("Color: " +mueble.getColor()); 
            lb[3].setText("Precio: " +String.valueOf(mueble.getPrecio())+"€");
            lb[4].setText("Tienda: " +mueble.getTienda()); 
            lb[5].setText("Tamaño: " +String.valueOf(mueble.getTamanyo())+"cm");
            lb[6].setText("Fecha de Fabricacion: " +mueble.getFechaFabricacion()); 
 
    }
    
}
