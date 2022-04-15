package es.felixgomezenriquez.listamuebles;

import java.text.ParseException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.web.WebView;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
    
    int muebleActual=0;

    @Override
    public void start(Stage stage) throws ParseException {
        
        BorderPane root = new BorderPane();
        
        root.setBackground(new Background(
                new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, new Insets(0, 0, 0, 0))));
        
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
        
        
//        Mueble mueble2 = new Mueble();
//        mueble2.setModelo("Mueble dsddsdsds - MC 90");
//        mueble2.setMarca("ES Interiorismo");
//        mueble2.setTienda("Muebleslluesma");
//        mueble2.setColor("Aire-Turquesa");
//        mueble2.setTamanyo(200);
//        mueble2.setPrecio((float)468.12);
//        mueble2.setFechaFabricacion("02-02-2000");
//        mueble2.setUrl("www.google.com");
//        listaMuebles.getListaMuebles().add(mueble2);

        try {
            
            layoutCenter.actualizarTexto(listaMuebles.getListaMuebles().get(muebleActual));
            System.out.println(listaMuebles.getListaMuebles().size());
            
        } catch (Exception e) {
            e.printStackTrace();
            //alert "añade un XML valido para visionar"
        }
 

        
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
            try {
                muebleActual--;
                layoutCenter.actualizarTexto(listaMuebles.getListaMuebles().get(muebleActual));
               
            } catch (Exception e) {
                e.printStackTrace();
                //alert se ha excedido el numero de muebles 
                muebleActual=0;
            }
            
            
        });
        
        layoutRight.botonSiguiente.setOnAction((t) -> {
            try {
               muebleActual++;
               layoutCenter.actualizarTexto(listaMuebles.getListaMuebles().get(muebleActual));
               
            } catch (Exception e) {
                e.printStackTrace();
                //alert se ha excedido el numero de muebles 
                muebleActual= listaMuebles.getListaMuebles().size() - 1;
                System.out.println(listaMuebles.getListaMuebles().size());
            }
            
            
        });
        
        layoutCenter.comprar.setOnAction((t) -> {
            try {
                WebView view = new WebView();
                view.getEngine().load(listaMuebles.getListaMuebles().get(muebleActual).getUrl());
                
                //Cambiar tamaño de la pantalla nueva pra que quede guay
                Pane p =new Pane();
                Stage s = new Stage();
                Scene sc = new Scene(p);
                
                s.setScene(sc);
                s.show();
            
                p.getChildren().add(view);
                
            } catch (Exception e) {
                e.printStackTrace();
                //alert no tiene enlace de compra
            }
            
        });
        
    }

    public static void main(String[] args) {
        launch();
    }

}
