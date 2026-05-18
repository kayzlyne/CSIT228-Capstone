module Controllers {

    requires javafx.controls;
    requires javafx.fxml;

    opens Controllers to javafx.fxml;
    opens Classes.User to javafx.fxml;
    opens Classes.Category to javafx.fxml;
    opens Classes.Budget to javafx.fxml;
    opens Classes.Transaction to javafx.fxml;

    exports Controllers;
    exports Classes.User;
    exports Classes.Category;
    exports Classes.Budget;
    exports Classes.Transaction;
}
