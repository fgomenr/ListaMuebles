package es.felixgomezenriquez.listamuebles;

import java.text.ParseException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
    
    int muebleActual=0;

    @Override
    public void start(Stage stage) throws ParseException {
        
        BorderPane root = new BorderPane();
        
        var scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
                
        Muebles listaMuebles = new Muebles();

        
        
        LayoutBottom layoutBottom = new LayoutBottom();
        
        LayoutCenter layoutCenter = new LayoutCenter();
        
        LayoutLeft layoutLeft = new LayoutLeft();
        
        LayoutRight layoutRight = new LayoutRight();
        
        root.setCenter(layoutCenter);
        root.setBottom(layoutBottom);
        root.setRight(layoutRight);
        root.setLeft(layoutLeft);
        
        
        
        
        /*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
        
    
        
        
         Mueble mueble0= new Mueble();
        mueble0.setModelo("Mueble cama - MC 90");
        mueble0.setMarca("ES Interiorismo");
        mueble0.setTienda("Muebleslluesma");
        mueble0.setColor("Aire-Turquesa");
        mueble0.setTamanyo(200);
        mueble0.setPrecio((float)468.12);
        mueble0.setFechaFabricacion(2020,2,3);
        mueble0.getFechaFabricacion();
        
        Mueble mueble2 = new Mueble();
        mueble2.setModelo("Mueble dsddsdsds - MC 90");
        mueble2.setMarca("ES Interiorismo");
        mueble2.setTienda("Muebleslluesma");
        mueble2.setColor("Aire-Turquesa");
        mueble2.setTamanyo(200);
        mueble2.setPrecio((float)468.12);
        mueble2.setFechaFabricacion(2020,2,3);
        mueble2.getFechaFabricacion();
        
        
        listaMuebles.getListaMuebles().add(mueble0);
        listaMuebles.getListaMuebles().add(mueble2);
        
        
        /*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
        muebleActual=0;
        layoutCenter.actualizarTexto(listaMuebles.getListaMuebles().get(muebleActual),muebleActual);
        System.out.println(listaMuebles.getListaMuebles().size());

        
        layoutBottom.botonGuardar.setOnAction((t) -> {
            UtilXML.guardarArchivo(stage, listaMuebles);
        });
        
        layoutBottom.botonAbrir.setOnAction((t) -> {
            Muebles listaMueblesImport = UtilXML.abrirArchivo(stage);
            System.out.println("Numero de muebles nuevos: "+ listaMueblesImport.getListaMuebles().size());
            
            listaMuebles.unirMuebles(listaMueblesImport);
            Muebles.unirMuebles(listaMuebles, listaMueblesImport);
            System.out.println("Mostrando cada elemento de la lista unida");
            for (int i = 0; i < listaMuebles.getListaMuebles().size(); i++) {
                System.out.println(listaMuebles.getListaMuebles().get(i));
            }
            
        });
        
        layoutLeft.botonAnterior.setOnAction((t) -> {
            try {
                muebleActual--;
                layoutCenter.actualizarTexto(listaMuebles.getListaMuebles().get(muebleActual),muebleActual);
               
            } catch (Exception e) {
                e.printStackTrace();
                //alert
                muebleActual=0;
            }
            
            
        });
        
        layoutRight.botonSiguiente.setOnAction((t) -> {
            try {
               muebleActual++;
               layoutCenter.actualizarTexto(listaMuebles.getListaMuebles().get(muebleActual),muebleActual);
               
            } catch (Exception e) {
                e.printStackTrace();
                //alert
                muebleActual= listaMuebles.getListaMuebles().size() - 1;
                System.out.println(listaMuebles.getListaMuebles().size());
            }
            
            
        });
        
    }

    public static void main(String[] args) {
        launch();
    }

}