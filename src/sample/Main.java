package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.view.LoginController;
import sample.view.RegisterController;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
//    private AnchorPane rLayout;

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("./view/login.fxml"));
        primaryStage.setTitle("LoginController");
        this.primaryStage=primaryStage;
        initLogin();
    }

    /**
     * Root Layout vvsgeh function
     */
    public void initLogin() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("./view/login.fxml"));
            AnchorPane pane = (AnchorPane) loader.load();

            // Scene beldej bui heseg
            Scene scene = new Scene(pane);
            primaryStage.setScene(scene);
            // Root Layout -iin controller beldej bui heseg
            LoginController controller = loader.getController();
            controller.setOwner(this);
            controller.setParentStage(primaryStage);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Root Layout vvsgeh function
     */
    public void userRegister() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource(SceneEnum.getResource(SceneEnum.SCENE_REGISTER)));
            AnchorPane pane = (AnchorPane) loader.load();

            // Scene beldej bui heseg
            Scene scene = new Scene(pane);
            primaryStage.setScene(scene);
            // Root Layout -iin controller beldej bui heseg
            RegisterController controller = loader.getController();
            controller.setOwner(this);
            controller.setParentStage(primaryStage);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changeScene(SceneEnum sceneEnum) {
//        if(checkPermission(sceneEnum)) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Main.class.getResource(SceneEnum.getResource(sceneEnum)));
                Parent childNode = (Parent) loader.load();
                rootLayout.setCenter(childNode);
                rootLayout.setAlignment(childNode, Pos.TOP_LEFT);
                Controller controller = loader.getController();
                controller.setOwner(this);
                controller.setParentStage(primaryStage);
            } catch (IOException e) {
                e.printStackTrace();
            }
//        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
