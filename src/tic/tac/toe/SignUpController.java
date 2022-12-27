/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tac.toe;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author CLINIC
 */
public class SignUpController implements Initializable {

    @FXML
    private AnchorPane signUpScreen;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField EmailTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private PasswordField repasswordTextField;
    @FXML
    private Button signUpBtn;
    @FXML
    private Text haveAnAccountText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
