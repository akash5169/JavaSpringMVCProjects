package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Product;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

//launching class of application
public class Main extends Application {
    //main list that stores all data
    public static LinkedList<Product> inventory=new LinkedList<>();
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../layout/login.fxml"));
        primaryStage.setTitle("AJZMart");
        Scene scene=new Scene(root, 400, 420);
        scene.getStylesheets().add(getClass().getResource("../styles/application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) throws ParseException, InterruptedException, IOException {
        initialize(inventory);
        launch(args);
    }

    //get data from excel sheet and run
    public static void initialize(LinkedList<Product> inv) throws ParseException, InterruptedException, IOException
    {   SimpleDateFormat sf= new SimpleDateFormat("MM/dd/yyyy");
        FileInputStream fis=new FileInputStream(new File("C:\\Users\\hp\\IdeaProjects\\Demo\\resources\\data.xlsx"));
        //creating workbook instance that refers to .xlsx file
        XSSFWorkbook wb=new XSSFWorkbook(fis);
        System.out.println("Data initialisation in progress..please wait");
        //creating a Sheet object to retrieve the object
        XSSFSheet sheet=wb.getSheetAt(0);

        int i=0;
        for (Row row:sheet)
        {
            if(i==0)
            {
                i++;
                continue;
            }
            Product p=new Product();
            p.setProduct_cate(row.getCell(0).getStringCellValue());
            p.setProduct_type(row.getCell(1).getStringCellValue());
            p.setBorv(row.getCell(2).getStringCellValue());
            p.setPlace(row.getCell(3).getStringCellValue());
            p.setWeight((float)(row.getCell(4).getNumericCellValue()));
            p.setWeight_unit(row.getCell(5).getStringCellValue());
            p.setManufacture_date((row.getCell(6).getDateCellValue()));
            p.setExpiration_date(row.getCell(7).getDateCellValue());
            p.setPrice((float)(row.getCell(8).getNumericCellValue()));
            p.setTax((float)(row.getCell(9).getNumericCellValue()));
            p.setDiscount((float)(row.getCell(10).getNumericCellValue()));
            p.setSupplier_id(row.getCell(11).getStringCellValue());
            inv.add(p);
            TimeUnit.MILLISECONDS.sleep(1000);
        }

        wb.close();
        System.out.println("Data initialisation in completed..");
    }
}
