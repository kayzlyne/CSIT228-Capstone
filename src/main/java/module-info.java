module Controllers {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
<<<<<<< Updated upstream

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
=======
    requires javafx.media;
    requires javafx.swing;

    requires org.controlsfx.controls;
    requires  com.dlsc.formsfx;
    requires net.synedra.validatorfx;    requires org.kordamp.ikonli.javafx;
>>>>>>> Stashed changes
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens Controllers to javafx.fxml;
<<<<<<< Updated upstream
    exports Controllers;
}
=======
    opens Classes.User to javafx.fxml;
    opens Classes.Category to javafx.fxml;
    opens Classes.Budget to javafx.fxml;

    exports Controllers;
    exports Classes.User;
    exports Classes.Category;
    exports Classes.Budget;
}
>>>>>>> Stashed changes
