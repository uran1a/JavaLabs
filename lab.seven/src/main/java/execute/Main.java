package execute;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {
    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        var fxml_node = Main.class.getResource("/fxml/mainScene.fxml");
        var parent = FXMLLoader.load(Objects.requireNonNull(fxml_node));
        stage.setScene(new Scene((Parent)parent));
        stage.setResizable(false);
        stage.setTitle("Лабораторная работа 7"); stage.show();
    }
}
