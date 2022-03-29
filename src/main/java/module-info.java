module es.felixgomezenriquez.listamuebles {
    requires javafx.controls;
    requires java.xml.bind;
    requires jakarta.activation;
    requires java.activation;
    exports es.felixgomezenriquez.listamuebles;
    opens es.felixgomezenriquez.listamuebles to java.xml.bind;
}


