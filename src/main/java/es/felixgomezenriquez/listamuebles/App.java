package es.felixgomezenriquez.listamuebles;

import java.text.ParseException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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

    int muebleActual = 0;

    @Override
    public void start(Stage stage) throws ParseException {

        BorderPane root = new BorderPane();
        
        //Le doy un color al fondo del panel que engobla todo los layouts para conseguir un 
        //Aspecto agradable para la vista 
        
        root.setBackground(new Background(
                new BackgroundFill(Color.rgb(131, 71, 51), CornerRadii.EMPTY, new Insets(0, 0, 0, 0))));

        var scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();

        //Creamos los objetos necesarios de las clases creadas
        
        Muebles listaMuebles = new Muebles();

        LayoutBottom layoutBottom = new LayoutBottom();

        LayoutCenter layoutCenter = new LayoutCenter();

        LayoutLeft layoutLeft = new LayoutLeft();

        LayoutRight layoutRight = new LayoutRight();
        
        
        //Añadimos a la pantalla los distintos layouts 
        root.setCenter(layoutCenter);
        root.setBottom(layoutBottom);
        root.setRight(layoutRight);
        root.setLeft(layoutLeft);

        //Probamos a mostrar el mueble 0 de la lista de muebles y en caso de que no haya saltara un error
        //Con un alert que nos informara de que debemos de abrir un archivo XML valido para ver su contenido
        
        try {

            layoutCenter.actualizarTexto(listaMuebles.getListaMuebles().get(muebleActual));
            System.out.println(listaMuebles.getListaMuebles().size());

        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Añade un XML valido");
            alert.setHeaderText("Añade un XML con el boton abrir, para visionar su contenido.");
            alert.showAndWait();
        }

        
        //Cuando se pulsa el boton de guardar se llama a la funcion correspondiente
        layoutBottom.botonGuardar.setOnAction((t) -> {
            UtilXML.guardarArchivo(stage, listaMuebles);
        });

        //Cuando se pulsa el boton de guardar se llama a la funcion correspondiente
        layoutBottom.botonAbrir.setOnAction((t) -> {
            
            Muebles listaMueblesImport = UtilXML.abrirArchivo(stage);

            System.out.println("Numero de muebles nuevos: " + listaMueblesImport.getListaMuebles().size());

            listaMuebles.unirMuebles(listaMueblesImport);
            //Muebles.unirMuebles(listaMuebles, listaMueblesImport);

            System.out.println("Mostrando cada elemento de la lista unida");
            for (int i = 0; i < listaMuebles.getListaMuebles().size(); i++) {
                System.out.println(listaMuebles.getListaMuebles().get(i));
            }

            //para que nos muestre el primer mueble de la lista, sino se quedaria con el mensaje predeterminado
            layoutCenter.actualizarTexto(listaMuebles.getListaMuebles().get(muebleActual));

        });

        //Retrocede un mueble cuando se pulsa el boton anterior, si se llega al limite salta una ventana
        //emergente informando se lo que ocurre
        
        layoutLeft.botonAnterior.setOnAction((t) -> {
            try {
                muebleActual--;
                layoutCenter.actualizarTexto(listaMuebles.getListaMuebles().get(muebleActual));

            } catch (Exception e) {
                e.printStackTrace();
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("CUIDADO!!");
                alert.setHeaderText("Se ha excedido el numero de muebles");
                alert.showAndWait();
                muebleActual = 0;
            }

        });
        //Avanza un mueble cuando se pulsa el boton siguiente, si se llega al limite salta una ventana
        //emergente informando se lo que ocurre
        
        layoutRight.botonSiguiente.setOnAction((t) -> {
            try {
                muebleActual++;
                layoutCenter.actualizarTexto(listaMuebles.getListaMuebles().get(muebleActual));

            } catch (Exception e) {
                e.printStackTrace();
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("CUIDADO!!");
                alert.setHeaderText("Se ha excedido el numero de muebles");
                alert.showAndWait();
                muebleActual = listaMuebles.getListaMuebles().size() - 1;
                System.out.println(listaMuebles.getListaMuebles().size());
            }

        });

        //Cuando se pulsa el boton Comprar se crea otra ventana nueva que te dirige a la url del 
        //articulo en cuestión.
        //Si no, te salta una ventana emergente que te avisa que no tiene una url valida dicho articulo
        
        
        layoutCenter.comprar.setOnAction((t) -> {
            try {
                WebView view = new WebView();
                view.getEngine().load(listaMuebles.getListaMuebles().get(muebleActual).getUrl());

                Pane p = new Pane();
                Stage s = new Stage();
                Scene sc = new Scene(p, 800, 600);

                s.setScene(sc);
                s.show();

                p.getChildren().add(view);

            } catch (Exception e) {
                e.printStackTrace();
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("CUIDADO!!");
                alert.setHeaderText("El articulo seleccionado no tiene un URL valido");
                alert.showAndWait();
            }

        });

    }

    public static void main(String[] args) {
        launch();
    }

}
