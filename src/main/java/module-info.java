module main.gui {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
            requires net.synedra.validatorfx;
                requires org.kordamp.bootstrapfx.core;
            
    opens main.gui to javafx.fxml;
    exports main.gui;
    exports controllers;
    opens controllers to javafx.fxml;
}