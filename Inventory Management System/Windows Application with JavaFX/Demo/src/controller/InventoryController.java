package controller;

//All the imports required for Controller
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Product;
import sample.Main;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class InventoryController implements Initializable {
    // getting reference of main invetory list from Main class.
    static LinkedList<Product> inventory = Main.inventory;

    // Declaring and linking fxml elements used in scenes
    @FXML
    private TableView<Product> invTable;

    @FXML
    private TableColumn<Product, CheckBox> cBox;

    @FXML
    private TableColumn<Product, Long> pid;


    @FXML
    private TableColumn<Product, String> pcat;

    @FXML
    private TableColumn<Product, String> ptype;

    @FXML
    private TableColumn<Product, String> pbov;

    @FXML
    private TableColumn<Product, String> pplc;

    @FXML
    private TableColumn<Product, Float> pwei;

    @FXML
    private TableColumn<Product, String> puni;

    @FXML
    private TableColumn<Product, Date> pmnf;

    @FXML
    private TableColumn<Product, Date> pexp;


    @FXML
    private TableColumn<Product, Float> ppri;


    @FXML
    private TableColumn<Product, Float> ptax;


    @FXML
    private TableColumn<Product, Float> pdisc;


    @FXML
    private TableColumn<Product, String> psup;

    @FXML
    private TextField searchField;

    ObservableList<Product> listM;
    ObservableList<Product> dataList;

//Function for getting the data in form of Observable list from Main inventory list
    public static ObservableList<Product> getData(){

        ObservableList list = FXCollections.observableArrayList();
        try {
            for (Product p: inventory) {
                list.add(p);
               }

        } catch (Exception e) {
        }
        return list;
    }


//function to initialize Controller and linking fxml elements with model class.
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cBox.setCellValueFactory(new PropertyValueFactory<>("cbox"));
        pid.setCellValueFactory(new PropertyValueFactory<>("product_id"));
        pcat.setCellValueFactory(new PropertyValueFactory<>("product_cate"));
        ptype.setCellValueFactory(new PropertyValueFactory<>("product_type"));
        pbov.setCellValueFactory(new PropertyValueFactory<>("borv"));
        pplc.setCellValueFactory(new PropertyValueFactory<>("place"));
        pwei.setCellValueFactory(new PropertyValueFactory<>("weight"));
        puni.setCellValueFactory(new PropertyValueFactory<>("weight_unit"));
        pmnf.setCellValueFactory(new PropertyValueFactory<>("Manufacture_date"));

        pmnf.setCellFactory(column -> {
            TableCell<Product, Date> cell = new TableCell<Product, Date>() {
                private SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

                @Override
                protected void updateItem(Date item, boolean empty) {
                    super.updateItem(item, empty);
                    if(empty) {
                        setText(null);
                    }
                    else {
                        setText(format.format(item));
                    }
                }
            };

            return cell;
        });
        pexp.setCellValueFactory(new PropertyValueFactory<>("Expiration_date"));

        pexp.setCellFactory(column -> {
            TableCell<Product, Date> cell = new TableCell<Product, Date>() {
                private SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

                @Override
                protected void updateItem(Date item, boolean empty) {
                    super.updateItem(item, empty);
                    if(empty) {
                        setText(null);
                    }
                    else {
                        setText(format.format(item));
                    }
                }
            };

            return cell;
        });
        ppri.setCellValueFactory(new PropertyValueFactory<>("Price"));
        ptax.setCellValueFactory(new PropertyValueFactory<>("tax"));
        pdisc.setCellValueFactory(new PropertyValueFactory<>("discount"));
        psup.setCellValueFactory(new PropertyValueFactory<>("supplier_id"));


//linking observable list to TableView in scene
        invTable.setItems(getData());
        invTable.refresh();
        // Code Source in description
    }

    //function to delete selected items
    public void deleteProd(ActionEvent actionEvent) {
        ObservableList<Product> list = FXCollections.observableArrayList();

//getting the selected rows in observable list
        for(Product p : getData())
        {
            if(p.getCbox().isSelected())
            {
                list.add(p);
            }

        }
//removing rows
        Main.inventory.removeAll(list);
        //displaying list after delete
        invTable.setItems(getData());
    }

    //function to show add prompt and display list after addition
    public void addProd(ActionEvent actionEvent) throws IOException {
        Stage popUpStage = new Stage();
        popUpStage.setTitle("Add Product");
        popUpStage.initModality(Modality.WINDOW_MODAL);
        popUpStage.initOwner(((Node)(actionEvent.getSource())).getScene().getWindow());
        //linking stage to add fxml file
        Parent root = FXMLLoader.load(getClass().getResource("../layout/add_prompt.fxml"));
        Scene popUpScene = new Scene(root);
        popUpStage.setScene(popUpScene);
        //showing add prompt
        popUpStage.showAndWait();
        invTable.setItems(getData());
        invTable.refresh();
    }

    //calling update prompt for each selected items
    public void updateProd(ActionEvent actionEvent) throws IOException {

        ObservableList<Product> list = FXCollections.observableArrayList();
        list.clear();
        for(Product p : getData())
        {
            if(p.getCbox().isSelected())
            {
                list.add(p);
                System.out.println("I ran-"+p.getProduct_id());
            }

        }


        //calling the update dialogue
        for (Product p:list)
        {
            showUpdateDialog(p,actionEvent);
            p.getCbox().setSelected(false);
        }
        invTable.setItems(getData());
        invTable.refresh();
    }

    //search function
    @FXML
    void search_product() {

        dataList = getData();
        invTable.setItems(dataList);
        //creating a filter list and adding our data
        FilteredList<Product> filteredData = new FilteredList<>(dataList, b -> true);

        //linking search field to listener
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            //setting predicate for filtered list based on comparisons
            filteredData.setPredicate(product -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                String sDate=lowerCaseFilter;

                char ch[]=sDate.toCharArray();
                Boolean flag=false;
                Boolean flag2=false;
                if(ch [0]=='>' || ch [0]=='<')
                {
                    System.out.println(ch[0]);
                    if(ch.length>10 && sDate.contains("/"))
                    {flag=true;}
                    else
                    {
                        flag2=true;
                    }
                }
                String sDate2="";
                for(int i=1;i<ch.length;i++)
                {
                    sDate2=sDate2+ch[i];
                }
                SimpleDateFormat sf= new SimpleDateFormat("MM/dd/yyyy");
                Date d=null;
                try {
                    d=sf.parse(sDate2);
                    System.out.println(d);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                //filters according to various columns
                if(flag && ch[0]=='<')
                {
                    Boolean b=product.getExpiration_date().before(d);
                    return b;
                }
                else if(flag && ch[0]=='>')
                {
                    Boolean b=product.getExpiration_date().after(d);
                    return b;
                }
                else if (product.getProduct_cate().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                    return true;
                } else if (product.getProduct_type().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                }else if (product.getPlace().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                }
                else if (product.getBorv().toLowerCase().indexOf(lowerCaseFilter)!=-1) {
                    return true;
                }
                else if(product.getSupplier_id().toLowerCase().indexOf(lowerCaseFilter)!=-1)
                {
                    return true;
                }else if (String.valueOf(product.getProduct_id()).toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                    return true;
                }
                else if(flag2 && ch[0]=='>')
                {
                    Boolean b=false;
                    try{
                        Float dis=Float.parseFloat(sDate2);
                        b=product.getDiscount()>dis;
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }

                    return b;
                }
                else if(flag2 && ch[0]=='<')
                {
                    Boolean b=false;
                    try{
                        Float dis=Float.parseFloat(sDate2);
                        b=product.getDiscount()<dis;
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }

                    return b;
                }
                else
                    return false; // Does not match.
            });
        });
        SortedList<Product> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(invTable.comparatorProperty());
        invTable.setItems(sortedData);
    }

    public Stage showUpdateDialog(Product product,ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "../layout/update_prompt.fxml"
                )
        );

        Stage stage = new Stage();
        stage.setScene(
                new Scene(loader.load())
        );

        UpdateController controller = loader.getController();
        controller.initData(product);

        stage.setTitle("Update Product");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node)(actionEvent.getSource())).getScene().getWindow());

        stage.show();

        return stage;
    }
}