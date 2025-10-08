module edu.au.cpsc.module7 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
//    requires edu.au.cpsc.module7;


    opens edu.au.cpsc.module7 to javafx.fxml;
    exports edu.au.cpsc.module7;
    exports edu.au.cpsc.module7.controller;
    opens edu.au.cpsc.module7.controller to javafx.fxml;
}