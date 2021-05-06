package sample.view;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import sample.Controller;

public class RegisterController extends Controller {

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtUserName;

    @FXML
    private TextField txtMajor;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtPhone;

    @FXML
    private DatePicker dpBirth;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtPasswordRepeat;

    public void handleRegister(){

    }

    public void handleBack(){
        parentStage.close();
        owner.initLogin();
    }
    @FXML
    void initialize() {
    }

}
