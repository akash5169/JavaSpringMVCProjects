package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import model.Product;
import sample.Main;

import javax.swing.*;
import java.net.URL;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

public class AddController implements Initializable {

    @FXML
    private Label prodId;

    @FXML
    private ComboBox<String> pcat;

    @FXML
    private ComboBox<String> puni;

    @FXML
    private ComboBox<String> psup;

    @FXML
    private ComboBox<String> pplc;

    @FXML
    private TextField ptype;

    @FXML
    private TextField ptax;

    @FXML
    private TextField ppri;

    @FXML
    private TextField pdisc;

    @FXML
    private TextField pbov;

    @FXML
    private TextField pwei;

    @FXML
    private DatePicker pmfn;

    @FXML
    private DatePicker pexp;

    Product p;

    //initialize controller with data
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        p=new Product();
        long pid=p.getProduct_id();

        String categories[]={"Dairy","Produce","Frozen","Grocery","HouseHold&Gen","Meat","Seafood"};
        String pr_place[]={"Row1","Row2","Row3","Row4","Row5","Row6","Freezer1","Freezer2"};
        String un[]={"kg","lbs","oz","foz","gal","ltr"};

        ObservableList<String> cat= FXCollections.observableArrayList();
        ObservableList<String> plc= FXCollections.observableArrayList();
        ObservableList<String> uni= FXCollections.observableArrayList();
        for(String s:categories)
        {
            cat.add(s);
        }

        for(String s:pr_place)
        {
            plc.add(s);
        }

        for(String s:un)
        {
            uni.add(s);
        }

        pcat.setItems(cat);
        pplc.setItems(plc);
        puni.setItems(uni);

        prodId.setText(String.valueOf(pid));

    }

//function initialize supplier combobox
    public void iniSup(ActionEvent actionEvent) {
        String s=pcat.getValue();

        ObservableList<String> sup=FXCollections.observableArrayList();

        sup.add(s+"1");
        sup.add(s+"2");
        sup.add(s+"3");

        psup.setItems(sup);
    }

    //function that adds the data to main list
    public void addProd(ActionEvent actionEvent) {
        p.setWeight(Float.parseFloat(pwei.getText()));
        p.setBorv(pbov.getText());
        p.setTax(Float.parseFloat(ptax.getText()));
        p.setDiscount(Float.parseFloat(pdisc.getText()));
        p.setExpiration_date(Date.from(pexp.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        p.setManufacture_date(Date.from(pmfn.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        p.setWeight_unit(puni.getValue());
        p.setProduct_cate(pcat.getValue());
        p.setProduct_type(ptype.getText());
        p.setPlace(pplc.getValue());
        p.setSupplier_id(psup.getValue());
        p.setPrice(Float.parseFloat(ppri.getText()));

        Main.inventory.add(p);
        JOptionPane.showMessageDialog(null, "Product added");
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    //function to close the prompt
    public void cancel(ActionEvent actionEvent) {
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }
}
