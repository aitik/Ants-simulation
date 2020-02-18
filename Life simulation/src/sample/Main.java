package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1050, 600));
        primaryStage.show();
        //spent a lot of time playing around with themes and changing css files bc creator messed up
        JMetro jMetro = new JMetro(Style.LIGHT);
        jMetro.setParent(root);
    }
    public static void main(String[] args) {
        launch(args);
        //just checking if there is a conflict with versions
        System.out.println("java version: "+System.getProperty("java.version"));
        System.out.println("javafx.version: " + System.getProperty("javafx.version"));
    }
}
