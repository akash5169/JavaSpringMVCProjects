package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Product;
import sample.Main;

import javax.swing.*;
import java.net.URL;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

public class UpdateController implements Initializable {

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {


    }


    public void iniSup(ActionEvent actionEvent) {
        String s=pcat.getValue();

        ObservableList<String> sup=FXCollections.observableArrayList();

        sup.add(s+"1");
        sup.add(s+"2");
        sup.add(s+"3");

        psup.setItems(sup);
    }

    public void updateProd(ActionEvent actionEvent) {
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

        for(Product pr:Main.inventory)
        {
            if (pr.getProduct_id()==p.getProduct_id())
            {
                pr=p;
            }
        }
        JOptionPane.showMessageDialog(null, "Product Updated");
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void cancel(ActionEvent actionEvent) {
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    void initData(Product product) {
        String categories[]={"Dairy","Produce","Frozen","Grocery","HouseHold&Gen","Meat","Seafood"};
        String pr_place[]={"Row1","Row2","Row3","Row4","Row5","Row6","Freezer1","Freezer2"};
        String un[]={"kg","lbs","oz","foz","gal","ltr"};
        p=product;

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


        pcat.setValue(p.getProduct_cate());
        pplc.setValue(p.getPlace());
        puni.setValue(p.getWeight_unit());

        pwei.setText(String.valueOf(p.getWeight()));
        pbov.setText(p.getBorv());
        ptax.setText(String.valueOf(p.getTax()));
        pdisc.setText(String.valueOf(p.getDiscount()));
        pexp.setValue(p.getExpiration_date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        pmfn.setValue(p.getManufacture_date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        ptype.setText(p.getProduct_type());
        pplc.setValue(p.getPlace());
        psup.setValue(p.getSupplier_id());
        ppri.setText(String.valueOf(p.getPrice()));

        prodId.setText(String.valueOf(p.getProduct_id()));
        // Code Source in description

    }
}
