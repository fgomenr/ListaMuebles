/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.felixgomezenriquez.listamuebles;

import java.io.File;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author usuario
 */
public class UtilXML {
    
    public static void guardarArchivo(Stage stage,ListaMuebles listaMuebles){
    
        JAXBContext contexto;
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Guardar XML en");
            File fileListaMuebles = fileChooser.showSaveDialog(stage);

            //File fileListaLibros = new File("ListaLibros.xml");
            contexto = JAXBContext.newInstance(ListaMuebles.class);
            Marshaller marshaller = contexto.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(listaMuebles, System.out);
            marshaller.marshal(listaMuebles, fileListaMuebles);
        } catch (JAXBException ex) {
            System.out.println("Se ha producido un error");
            ex.printStackTrace();
        }            
    
    }
    
}
