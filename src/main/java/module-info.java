module Controllers {

    requires javafx.controls;
    requires javafx.fxml;

    opens Controllers to javafx.fxml;
    opens Classes.User to javafx.fxml;
    opens Classes.Category to javafx.fxml;

    exports Controllers;
    exports Classes.User;
    exports Classes.Category;
}