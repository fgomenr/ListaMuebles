/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.felixgomezenriquez.listamuebles;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario
 */
//Esta clase guarda la informacion en lo referente a trabajar con la lista de muebles.
@XmlRootElement
public class Muebles {
    
     private ArrayList<Mueble> listaMuebles = new ArrayList();
    
    //Este metodo te devuelve el arraylist de la listamuebles, creado anteriormente 
    public ArrayList<Mueble> getListaMuebles() {
        return listaMuebles;
    }
    //Este metodo asigna la listaMuebles pasada por parametro a la listaMuebles del objeto
    
    @XmlElement(name = "mueble")
    public void setListaMuebles(ArrayList<Mueble> listaMuebles) {
        this.listaMuebles = listaMuebles;
    }
    
    //Este metodo une las 2 listas, la que ya habia mas la añadida del XML
    
    public ArrayList<Mueble> unirMuebles (Muebles listaMueblesNueva){
        //Se pueden unir de varias formas, usando un bucle for para ir añadiendo cada
        //mueble de la lista nueva a la original
        int numeroMueblesNuevos=listaMueblesNueva.getListaMuebles().size();
        for (int i = 0; i < numeroMueblesNuevos; i++) {
            this.listaMuebles.add(listaMueblesNueva.getListaMuebles().get(i));
        }
        //Tambien se puede unir directamente con el metodo addAll que pide como parametro una coleccion de objetos
        //para añadirlos
        //this.listaMuebles.addAll(listaMueblesNueva.getListaMuebles());
        return this.listaMuebles;
    }
    
    //Metodo que usa 2 parametros, la lista origen y la importada.
    
    static public ArrayList<Mueble> unirMuebles (Muebles listamueblesOrigen, Muebles listaMueblesNueva){
        //Se pueden unir de varias formas, usando un bucle for para ir añadiendo cada
        //mueble de la lista nueva a la original
        int numeroMueblesNuevos=listaMueblesNueva.getListaMuebles().size();
        for (int i = 0; i < numeroMueblesNuevos; i++) {
            listamueblesOrigen.getListaMuebles().add(listaMueblesNueva.getListaMuebles().get(i));
        }
        //Tambien se puede unir directamente con el metodo addAll que pide como parametro una coleccion de objetos
        //para añadirlos
        //listamueblesOrigen.getListaMuebles().addAll(listaMueblesNueva.getListaMuebles());
        return listamueblesOrigen.getListaMuebles();
    }
    
    
}
