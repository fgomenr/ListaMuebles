package es.felixgomezenriquez.listamuebles;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        
        StackPane root = new StackPane();
        
        var scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
        
        Mueble mueble1= new Mueble();
        mueble1.setColor("Rojo");
        
        ListaMuebles listaMuebles = new ListaMuebles();
        
        listaMuebles.getListaMuebles().add(mueble1);
        
        System.out.println(listaMuebles.getListaMuebles().get(0));
        
        
        Boton botonGuardar = new Boton("Guardar", root);
        
        Boton botonAbrir = new Boton("Abrir", root);

        HBox botones = new HBox();
        
        botones.getChildren().addAll(botonAbrir,botonGuardar);
        botones.setMaxSize(150, 50);
        
        root.getChildren().add(botones);
        
        
        root.setAlignment(Pos.BOTTOM_RIGHT);
        
        
        
    }

    public static void main(String[] args) {
        launch();
    }

}