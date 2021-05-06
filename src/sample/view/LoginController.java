package sample.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import sample.Controller;
import sample.Main;
import sample.SceneEnum;

import java.io.IOException;

public class LoginController extends Controller {

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPassword;

    public void handleLogin(){

    }

    public void handleRegister(){
//        try {
            parentStage.close();
            owner.userRegister();
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(Main.class.getResource(SceneEnum.getResource(sceneEnum)));
//            Parent childNode = (Parent) loader.load();
//            rootLayout.setCenter(childNode);
//            rootLayout.setAlignment(childNode, Pos.TOP_LEFT);
//            Controller controller = loader.getController();
//            controller.setOwner(this);
//            controller.setParentStage(primaryStage);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @FXML
    void initialize() {
    }
}