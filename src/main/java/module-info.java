module Controllers {
    requires javafx.controls;
    requires javafx.fxml;

    opens Controllers to javafx.fxml;
    opens Users to javafx.fxml;
    exports Controllers;
    exports Users;
}
