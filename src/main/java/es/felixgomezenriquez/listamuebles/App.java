package es.felixgomezenriquez.listamuebles;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        
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
        mueble0.setModelo("Dacia");
        mueble0.setMarca("ALK");
        mueble0.setTienda("Ikea");
        mueble0.setColor("rojo");
        mueble0.setTamanyo(200);
        mueble0.setPrecio(2);
        mueble0.setFechaFabricacion("1998");

        Mueble mueble2 = new Mueble();
        
        
        
        listaMuebles.getListaMuebles().add(mueble0);
        listaMuebles.getListaMuebles().add(mueble2);
        
        
        /*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
        
        
        
        
        
        
        
        
        
        
        layoutBottom.botonGuardar.setOnAction((t) -> {
            UtilXML.guardarArchivo(stage, listaMuebles);
        });
        
        layoutBottom.botonAbrir.setOnAction((t) -> {
            Muebles listaMueblesImport = UtilXML.abrirArchivo(stage);
            System.out.println("Numero de muebles nuevos: "+ listaMueblesImport.getListaMuebles().size());
            
            listaMuebles.unirMuebles(listaMueblesImport);
            //Muebles.unirMuebles(listaMuebles, listaMueblesImport);
            System.out.println("Mostrando cada elemento de la lista unida");
            for (int i = 0; i < listaMuebles.getListaMuebles().size(); i++) {
                System.out.println(listaMuebles.getListaMuebles().get(i));
            }
            
        });
        
        layoutLeft.botonAnterior.setOnAction((t) -> {
            
            layoutCenter.actualizarTexto(listaMuebles.getListaMuebles().get(0));
            
        });
        
    }

    public static void main(String[] args) {
        launch();
    }

}