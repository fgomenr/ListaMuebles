/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.felixgomezenriquez.listamuebles;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author usuario
 */
public class Mueble {
    
    private String modelo;
    private String marca;
    private String tienda;
    private String color;
    private int tamanyo;
    private float precio;
    private String fecha;
    private String url;
    //private LocalDate fecha;
    
    public String getModelo(){
        return this.modelo;
    }
    public void setModelo(String modelo){
        this.modelo=modelo;
    }
    public String getMarca(){
        return this.marca;
    }
    public void setMarca(String marca){
        this.marca=marca;
    }
    public String getTienda(){
        return this.tienda;
    }
    public void setTienda(String tienda){
        this.tienda=tienda;
    }  
    public String getColor(){
        return this.color;
    }
    public void setColor(String color){
        this.color=color;
    }
    
    public int getTamanyo(){
        return this.tamanyo;
    }
    public void setTamanyo(int tamanyo){
        this.tamanyo=tamanyo;
    }
    
    
    public float getPrecio(){
        return this.precio;
    }
    public void setPrecio(float precio){
        this.precio=precio;
    }
    
    
    public String getFechaFabricacion(){
        return this.fecha;
        
    }
    
    public void setFechaFabricacion(String fecha){
        this.fecha=fecha;

    }
        
//Tuve que hacer la fecha como string ya que no se pasaba al xml correctamente
//supongo que tendra algo que ver con los tipos de datos que admite el marshmaller
//busque pero no encontre nada al respecto.
// Pero comprobe si el formateado de la fecha se hacia correctamente y se realizaba con exito
// Si se comenta el metodo getFechaFabricacion y se descomenta el que esta comentado funciona correctamene
//De modo que pasandole una fecha como 2000-08-05 (formato con el que se trabaja en base de datos)
//Devuelve una fecha con formato mas legible para los usuarios como 08-08-2000.
    


//    public String getFechaFabricacion(){
//       
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        String fechaFormateada = this.fecha.format(formatter);
//
//        return fechaFormateada;
//
//    }
    
//
//    
//    
//    public void setFechaFabricacion(int año, int mes, int dia) throws ParseException{
//        this.fecha= this.fecha.of(año, mes, dia);
//        
//
//    }
    
    
    
    public String getUrl(){
        return this.url;
    }
    public void setUrl(String url){
        this.url=url;
    }
    
     @Override
    public String toString() {
        String r = "";
        r += "Modelo: " + this.getModelo() + "\n";
        r += "Marca: " + this.getMarca() + "\n";
        r += "Tienda: " +this.getTienda()+ "\n";
        r += "Color: " +this.getColor()+ "\n";
        r += "Tamaño: " +this.getTamanyo() + "cm" + "\n";
        r += "Precio: " +this.getPrecio()+ "€"+"\n";
        r += "Fecha de Fabricacion: " +this.getFechaFabricacion()+ "\n";
        return r;
    }
}
