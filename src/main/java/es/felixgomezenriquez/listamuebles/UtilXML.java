/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.felixgomezenriquez.listamuebles;

import java.io.File;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author usuario
 */

//Esta clase tiene todas las funciones en relacion con el tratamiento de datos XML

public class UtilXML {

    //Este metodo guarda la lista de muebles en un archivo XML, sino lo logra
    //Manda un mensaje por pantalla informando del error
    public static void guardarArchivo(Stage stage, Muebles listaMuebles) {

        JAXBContext contexto;
        try {

            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Guardar XML en");
            File fileListaMuebles = fileChooser.showSaveDialog(stage);

            contexto = JAXBContext.newInstance(Muebles.class);
            Marshaller marshaller = contexto.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(listaMuebles, System.out);
            marshaller.marshal(listaMuebles, fileListaMuebles);
        } catch (JAXBException ex) {
            System.out.println("Se ha producido un error");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("CUIDADO!!");
            alert.setHeaderText("No se ha podido guardar el archivo XML");
            alert.showAndWait();
            ex.printStackTrace();
        }

    }
    
    
    //Este metodo abre un XML del que extrae la lista de muebles, sino lo logra
    //Manda un mensaje por pantalla informando del error.
    public static Muebles abrirArchivo(Stage stage) {

        try {
            JAXBContext contexto = JAXBContext.newInstance(Muebles.class);
            Muebles listaMueblesImport;
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Abrir XML");
            File fileListaMueblesImport = fileChooser.showOpenDialog(stage);
            Unmarshaller unmarshaller = contexto.createUnmarshaller();
            listaMueblesImport = (Muebles) unmarshaller.unmarshal(fileListaMueblesImport);

            //Muestra la estructura xml del archivo abierto
            System.out.println("Estructura XML del archivo abierto" + "\n");
            Marshaller marshaller = contexto.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(listaMueblesImport, System.out);
            System.out.println("\n");

            //Muestra cada mueble de la lista
            System.out.println("Mostrando cada elemento de la lista");
            for (int i = 0; i < listaMueblesImport.getListaMuebles().size(); i++) {
                System.out.println(listaMueblesImport.getListaMuebles().get(i));
            }

            return listaMueblesImport;

        } catch (JAXBException ex) {
            System.out.println("Se ha producido un error");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("CUIDADO!!");
            alert.setHeaderText("No se ha podido abrir el archivo XML");
            alert.showAndWait();
            ex.printStackTrace();
            return null;
        }
    }

}
