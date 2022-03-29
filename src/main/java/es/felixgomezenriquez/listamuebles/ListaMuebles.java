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
public class ListaMuebles {
    
    private ArrayList<Mueble> listaMuebles = new ArrayList();
    
    public ArrayList<Mueble> getListaMuebles() {
        return listaMuebles;
    }
    
    @XmlElement(name = "mueble")
    public void setListaMuebles(ArrayList<Mueble> listaMuebles) {
        this.listaMuebles = listaMuebles;
    }
    
}
