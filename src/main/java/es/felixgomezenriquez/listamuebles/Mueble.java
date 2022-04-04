/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.felixgomezenriquez.listamuebles;

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
    private String fechaFabricacion;
    
    
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
        return this.fechaFabricacion;
    }
    public void setFechaFabricacion(String fechaFabricacion){
        this.fechaFabricacion=fechaFabricacion;
    }
    
    
     @Override
    public String toString() {
        String r = "";
        r += "Modelo: " + modelo + "\n";
        r += "Marca: " +  marca + "\n";
        r += "Tienda: " +tienda+ "\n";
        r += "Color: " +color+ "\n";
        r += "Tamaño: " +tamanyo+ "\n";
        r += "Precio: " +precio+ "\n";
        r += "Fecha de Fabricacion: " +fechaFabricacion+ "\n";
        return r;
    }
}
