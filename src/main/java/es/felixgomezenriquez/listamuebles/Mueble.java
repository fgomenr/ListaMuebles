/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.felixgomezenriquez.listamuebles;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.TemporalQueries.localDate;

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
    private LocalDate fecha;
    
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
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String fechaFormateada = this.fecha.format(formatter);

        return fechaFormateada;

    }
    public void setFechaFabricacion(int año, int mes, int dia) throws ParseException{
        this.fecha= this.fecha.of(año, mes, dia);
        

    }
    
    
     @Override
    public String toString() {
        String r = "";
        r += "Modelo: " + this.getModelo() + "\n";
        r += "Marca: " + this.getMarca() + "\n";
        r += "Tienda: " +this.getTienda()+ "\n";
        r += "Color: " +this.getColor()+ "\n";
        r += "Tamaño: " +this.getTamanyo()+ "\n";
        r += "Precio: " +this.getPrecio()+ "\n";
        r += "Fecha de Fabricacion: " +this.getFechaFabricacion()+ "\n";
        return r;
    }
}
