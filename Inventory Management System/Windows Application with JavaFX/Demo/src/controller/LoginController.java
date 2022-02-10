package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Product;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import sample.Main;


import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class LoginController {

    @FXML
    private TextField txt_user;

    @FXML
    private TextField txt_pass;

    //function to check login credentials
    public void checkCred(ActionEvent actionEvent) {
        String username;
        String password;
        username=txt_user.getText();
        password=txt_pass.getText();


        if(username.equals("ajzmart") && password.equals("password"))
        {
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("../layout/inventory.fxml"));
                Stage stage=new Stage();
                Scene scene=new Scene(root);
                scene.getStylesheets().add(getClass().getResource("../styles/application.css").toExternalForm());
                stage.setScene(scene);
                stage.setTitle("AJZMART/Inventory");
                ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            txt_user.clear();
            txt_pass.clear();
            JOptionPane.showMessageDialog(null, "Wrong UserID or Password");
        }
    }


}
