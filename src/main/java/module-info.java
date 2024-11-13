module com.must.atm.mustatm {
    requires javafx.controls;
    requires javafx.fxml;
    requires atlantafx.base;
    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.materialdesign2;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;

    opens com.must.atm.mustatm.Controller to javafx.fxml;
    exports com.must.atm.mustatm.Controller;

}