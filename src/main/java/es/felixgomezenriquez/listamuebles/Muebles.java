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
@XmlRootElement
public class Muebles {
    
     private ArrayList<Mueble> listaMuebles = new ArrayList();
    
    public ArrayList<Mueble> getListaMuebles() {
        return listaMuebles;
    }
    
    @XmlElement(name = "mueble")
    public void setListaMuebles(ArrayList<Mueble> listaMuebles) {
        this.listaMuebles = listaMuebles;
    }
    
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
