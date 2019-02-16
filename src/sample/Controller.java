package sample;
import Connectvy.ConnectionClass;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Controller implements Initializable{
    ConnectionClass connectionClass = new ConnectionClass();
    // we call conneClass  that we make it up
    Connection connection = connectionClass.getConnection();
   
    
    public ListView listv;
    @FXML
    private Tab Main_Tab;
    @FXML
    private ImageView icMaonMove;
    @FXML
    private Label MainLable1;
    @FXML
    private JFXTextField Txfiled_Name_Customer;
    @FXML
    private JFXTextField Txfiled_Address_Customer;
    @FXML
    private JFXTextField Txfiled_MNum_Customer;
    @FXML
    private JFXTextField Txfiled_Email_Customer;
    @FXML
    private JFXButton Btn_ChangeMN_Customer;
    @FXML
    private JFXButton Btn_Save_Customer;
      @FXML
    private JFXButton Btn_Cancle_Customer;

    @FXML
    private JFXButton Btn_Delete_Customer;
    @FXML
    private JFXButton Btn_Search_Customer;
    @FXML
    private Tab Mangment_MO_Tab;
    @FXML
    private JFXTextField Txfiled_Name_SP;
    @FXML
    private JFXTextField Txfiled_Quantity_SP;
    @FXML
    private JFXTextField Txfiled_SPNum_SP;
    @FXML
    private JFXTextField Txfiled_Price_SP;
    @FXML
    private JFXTextArea Txfiled_Discription_SP;
    @FXML
    private JFXButton Btn_Cancle_SP;
    @FXML
    private JFXButton Btn_Delete_SP;
    @FXML
    private JFXButton Btn_Save_SP;
    @FXML
    private JFXButton Btn_Search_SP;
      
    @FXML
    private ToggleGroup ReportsDate;
    @FXML
    private Label MainLable;
     private JFXButton Btn_Cancel_Employee;

    @FXML
    private JFXButton Btn_Delete_Employee;

    @FXML
    private JFXButton Btn_Save_Employee;

    @FXML
    private JFXButton Btn_Search_Employee;
   
  @FXML
    private JFXTextField Txfiled_Name_Supplier;

    @FXML
    private JFXTextField Txfiled_Address_Supplier;

    @FXML
    private JFXTextField Txfiled_Num_Supplier;

    @FXML
    private JFXTextField Txfiled_MNum_Supplier;

    @FXML
    private JFXTextField Txfiled_Email_Supplier;

    @FXML
    private JFXButton Btn_Cancle_Supplier;

    @FXML
    private JFXButton Btn_Delete_Supplier;

    @FXML
    private JFXButton Btn_Save_Supplier;

    @FXML
    private JFXButton Btn_Search_Supplier;
    @FXML
    private JFXTextField Txfiled_Name_Employee;

    @FXML
    private JFXTextField Txfiled_MNum_Employee;

    @FXML
    private ComboBox<String> Selct_Sex_Employee;

    @FXML
    private ComboBox<String> Selct_JType_Employee;
    ObservableList<String> ListOfJType = FXCollections.observableArrayList("Administrator", "ReceptionDesk", "Technician");
    ObservableList<String> ListOfSex = FXCollections.observableArrayList("Male", "Female");
            

    @FXML
    private JFXTextField Txfiled_Num_Employee;

    @FXML
    private JFXTextField Txfiled_Email_Employee;

    @FXML
    private JFXTextField Txfiled_Address_Employee;

    @FXML
    private JFXTextField Txfiled_Password_Employee;
  
    int count = 0;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        connectionClass.connectDB();
        listv.getItems().add("- عمليات الصيانة الحالية");
        listv.getItems().add("- عمليات الصيانة المنتهية");
        listv.getItems().add("- عمليات الصيانة السابقة");
        listv.getItems().add("- تقدير مالي عن عملية صيانة");
        listv.getItems().add("---------------------------");
        listv.getItems().add("- قائمة بالعملاء");
        listv.getItems().add("- قائمة عمليات الصيانة لعميل");
        listv.getItems().add("---------------------------");
        listv.getItems().add("- قائمة بالموظفين");
        listv.getItems().add("- قائمة عمليات الصيانة لموظف");
        listv.getItems().add("---------------------------");
        listv.getItems().add("- قائمة بالمزودين");
        listv.getItems().add("---------------------------");
        listv.getItems().add("- قطع على وشك النفاذ");
        listv.getItems().add("- قطع الغيار التي نفذت كميتها");
        
        Selct_JType_Employee.setItems(ListOfJType);
        Selct_Sex_Employee.setItems(ListOfSex);



           }
    
    
    void loadWindow(String loc , String title){
        try {

            Parent parent = FXMLLoader.load(getClass().getResource(loc));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setScene(new Scene(parent));
            stage.setTitle(title);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }}


    @FXML
    private void Btn_AddMO_MangeMO(ActionEvent event) {
      loadWindow("/sample/AddMo_AR.fxml" ,"" );

    }

   
    @FXML
    private void M_Txfiled_MNum_Customer(ActionEvent event) {
    }

    @FXML
    private void M_Btn_ChangeMN_Customer(ActionEvent event) {
    }

    @FXML
    private void M_Btn_Cancle_Customer(ActionEvent event) {
        clear();
    }

    @FXML
    private void M_Btn_Delete_Customer(ActionEvent event) throws SQLException {
           
        String sql1 = "DELETE FROM  `customer`  WHERE CUS_MOBILE_NBER= " +  Txfiled_MNum_Customer.getText();
        System.out.println(sql1);
        java.sql.Statement statement1 = connection.createStatement();
        statement1.executeUpdate(sql1);
        clear();
    }
     public void clear(){
        Txfiled_MNum_Customer.clear();
        Txfiled_Name_Customer.clear();
        Txfiled_Email_Customer.clear();
        Txfiled_Address_Customer.clear();
        
        Txfiled_MNum_Customer.setDisable(false);
        
    }

    @FXML
    private void M_Btn_Save_Customer(ActionEvent event) throws SQLException {
         if (Txfiled_MNum_Customer.getText().isEmpty() || Txfiled_Name_Customer.getText().isEmpty() ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Pleas enter the value");
            alert.showAndWait();
            return;

        }
         
        
      if (count == 1) {
            System.out.println("Equal  insert");
              String sqll= ("INSERT INTO customer (CUS_MOBILE_NBER,CUS_NAME,CUS_EMAIL,CUS_ADDRESS) VALUES('" +Txfiled_MNum_Customer.getText()+ "','" +   Txfiled_Name_Customer.getText() + "','" + Txfiled_Email_Customer.getText() + "','" +Txfiled_Address_Customer.getText()+ "')");
                   //"INSERT INTO customer (CUS_MOBILE_NBER ,'CUS_NAME','CUS_EMAIL',' CUS_ADDRESS') VALUES ("+Txfiled_MNum_Customer.getText()+ ""+","+"" +   Txfiled_Name_Customer.getText() + "" + ","+"" +    Txfiled_Email_Customer.getText()+ "" + ","+"" +  Txfiled_Address_Customer.getText()+")"; 
          System.out.println(sqll);
        java.sql.Statement statement1 = connection.prepareStatement(sqll);
 
      
 
   statement1.executeUpdate(sqll);

         
      }

    else if (count == 2){
         System.out.println("Equal  update");
            //System.out.println(Selct_MoStatus_AddMO.getValue());
            String sql1 = "UPDATE  `customer` SET CUS_NAME='" + Txfiled_Name_Customer.getText() + "',CUS_EMAIL='" + Txfiled_Email_Customer.getText()  +"',CUS_ADDRESS='"+ Txfiled_Address_Customer.getText()
                    +  "' WHERE CUS_MOBILE_NBER= '" + Txfiled_MNum_Customer.getText() + "'";
            System.out.println(sql1);
            java.sql.Statement statement1 = connection.createStatement();
            statement1.executeUpdate(sql1);
    }else if (count==3){
        System.out.println("Equal  update mobile number");
        String sqll = "UPDATE customer SET CUS_MOBILE_NBER='"+ Txfiled_MNum_Customer.getText()+"' WHERE CUS_NAME= '" + Txfiled_Name_Customer.getText() + "'";
        System.out.println(sqll);
            java.sql.Statement statement1 = connection.createStatement();
            statement1.executeUpdate(sqll);
        
    }
      //count = 2;
    
    }
    public int number = 0;

        
   

    

    @FXML
    private void M_Btn_Search_Customer(ActionEvent event) throws SQLException {
           
             Connection connection = connectionClass.getConnection();
        Statement st = connection.createStatement();
        st.executeQuery("SELECT * FROM `customer`  WHERE CUS_MOBILE_NBER = " + Txfiled_MNum_Customer.getText());
        ResultSet rs = st.getResultSet();
        if (rs.first()) {

            System.out.println( Txfiled_MNum_Customer.getText());

            System.out.println("THIS MO NUMBER IN DB== " + rs.getString("CUS_MOBILE_NBER"));
            System.out.println("THIS MO NUMBER IN FILED== " +  Txfiled_MNum_Customer.getText());

            if (rs.getString("CUS_MOBILE_NBER").equals( Txfiled_MNum_Customer.getText())) {

              
                
                count = 2;
                
                
                Txfiled_Name_Customer.setText(rs.getString("CUS_NAME"));
                Txfiled_Email_Customer.setText(rs.getString("CUS_EMAIL"));
                Txfiled_Address_Customer.setText(rs.getString("CUS_ADDRESS"));
                Txfiled_MNum_Customer.setDisable(true);
                Btn_Delete_Customer.setDisable(false);
                Btn_Cancle_Customer.setDisable(false);
                Btn_ChangeMN_Customer.setDisable(false); 
               
                
        }}
        else{  
                System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
                count =1;
                Txfiled_MNum_Customer.setDisable(true);
                Txfiled_MNum_Customer.clear();
                Btn_Cancle_Customer.setDisable(false);
                Btn_Save_Customer.setDisable(false);
                Btn_Delete_Customer.setDisable(false);
                 Btn_ChangeMN_Customer.setDisable(false);
                
                
        
        }
        

    } 
    
        
     @FXML
    void M_Btn_Cancel_Employee(ActionEvent event) {
        Txfiled_Num_Employee.setDisable(false);
        Txfiled_Name_Employee.clear();
        Txfiled_Email_Employee.clear();
         Txfiled_Address_Employee.clear();
         Txfiled_MNum_Employee.clear();
         Selct_JType_Employee.getSelectionModel().clearSelection();
         Selct_Sex_Employee.getSelectionModel().clearSelection();
         Txfiled_Password_Employee.clear();
         
        

    }
    @FXML
    void M_Btn_Delete_Employee(ActionEvent event) throws SQLException {
        String sql1 = "DELETE FROM  `employee`  WHERE EMPLOYEE_ID= " +   Txfiled_Num_Employee.getText();
        System.out.println(sql1);
        java.sql.Statement statement1 = connection.createStatement();
        statement1.executeUpdate(sql1);
        Txfiled_Num_Employee.setDisable(false);
        Txfiled_Name_Employee.clear();
        Txfiled_Email_Employee.clear();
         Txfiled_Address_Employee.clear();
         Txfiled_MNum_Employee.clear();
         Selct_JType_Employee.getSelectionModel().clearSelection();
         Selct_Sex_Employee.getSelectionModel().clearSelection();
         Txfiled_Password_Employee.clear();
        

    }
     @FXML
   private void M_Btn_Save_Employee(ActionEvent event) throws SQLException {
         
    
        if ( Txfiled_Num_Employee.getText().isEmpty() || Txfiled_Name_Employee.getText().isEmpty() || Txfiled_Email_Employee.getText().isEmpty() || 
                  Txfiled_Address_Employee.getText().isEmpty() ||   Txfiled_MNum_Employee.getText().isEmpty()|| Selct_JType_Employee.getValue().isEmpty()||Selct_Sex_Employee.getValue().isEmpty() ||Txfiled_Password_Employee.getText().isEmpty() ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Pleas enter the value");
            alert.showAndWait();
            return;

        }
         
        
      if (count == 1) {
            System.out.println("Equal  insert");
             String sqll= "INSERT INTO employee (EMPLOYEE_ID, EMP_NAME, EMP_EMAIL,EMP_ADDRESS,EMP_MOBILE_NBER,JOP_TYPE,SEX,PASSWORD) VALUES ("+number+ "," + "'" +  Txfiled_Name_Employee.getText() + "'" + ","+"'" +   Txfiled_Email_Employee.getText()+ 
                     "'" + ","+"'" +  Txfiled_Address_Employee.getText()+"'"+","+"'" + Txfiled_MNum_Employee.getText()+ "'"+","+"'"+ Selct_JType_Employee.getValue()+ "'"+","+"'" +Selct_Sex_Employee.getValue()+
                    "'"+","+"'" + Txfiled_Password_Employee.getText()+ "')"; 
          System.out.println(sqll);
        java.sql.Statement statement1 = connection.prepareStatement(sqll);
 
 
   statement1.executeUpdate(sqll);

         
      }

    else if (count == 2){
         System.out.println("Equal  update");
            //System.out.println(Selct_MoStatus_AddMO.getValue());
            String sql1 = "UPDATE  `employee` SET   EMP_NAME='" +  Txfiled_Name_Employee.getText() + "',EMP_EMAIL='" + Txfiled_Email_Employee.getText()  +"',EMP_ADDRESS='"+  Txfiled_Address_Employee.getText()+"',EMP_MOBILE_NBER='"+Txfiled_MNum_Employee.getText()
                    + "',JOP_TYPE='"+Selct_JType_Employee.getValue()+ "',SEX='"+Selct_Sex_Employee.getValue()+ "',PASSWORD='"+Txfiled_Password_Employee.getText()
                    +  " 'WHERE EMPLOYEE_ID=' " + Txfiled_Num_Employee.getText() + "'";
                        
            
                   
            System.out.println(sql1);
            java.sql.Statement statement1 = connection.createStatement();
            statement1.executeUpdate(sql1);
    }
      count = 2;
    
    

    }
      @FXML
   private void M_Btn_Search_Employee(ActionEvent event) throws SQLException {
       
        if ( Txfiled_Num_Employee.getText().isEmpty() || Txfiled_Name_Employee.getText().isEmpty() || Txfiled_Email_Employee.getText().isEmpty() || 
                  Txfiled_Address_Employee.getText().isEmpty() ||   Txfiled_MNum_Employee.getText().isEmpty()|| Selct_JType_Employee.getValue()==null||Selct_Sex_Employee.getValue()==null ||Txfiled_Password_Employee.getText().isEmpty() ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
         Connection connection = connectionClass.getConnection();   
        Statement st = connection.createStatement();
        st.executeQuery("SELECT * FROM `employee`  WHERE EMPLOYEE_ID = " +  Txfiled_Num_Employee.getText() );
        ResultSet rs = st.getResultSet();
        if (rs.first()) {

            System.out.println( Txfiled_Num_Employee.getText());

            System.out.println("THIS NU NUMBER IN DB== " + rs.getString("EMPLOYEE_ID"));
            System.out.println("THIS NU NUMBER IN FILED== " +  Txfiled_Num_Employee.getText());

            if (rs.getString("EMPLOYEE_ID").equals(Txfiled_Num_Employee.getText())) {

            
                count = 2;
                
                
                 Txfiled_Name_Employee.setText(rs.getString("EMP_NAME"));
                Txfiled_Email_Employee.setText(rs.getString("EMP_EMAIL"));
                Txfiled_Address_Employee.setText(rs.getString("EMP_ADDRESS"));
                 Txfiled_MNum_Employee.setText(rs.getString("EMP_MOBILE_NBER"));
                 Selct_JType_Employee.getSelectionModel().select(rs.getString("JOP_TYPE"));
                   Selct_Sex_Employee.getSelectionModel().select(rs.getString("SEX"));
                  Txfiled_Password_Employee.setText(rs.getString("PASSWORD"));
                
                   Txfiled_Num_Employee.setDisable(true);
                    Btn_Save_Employee.setDisable(false);
                Btn_Delete_Employee.setDisable(false);
                 Btn_Cancel_Employee.setDisable(false);
                
               
                
        }}
        
        else{  
            
               Statement st2 = connection.createStatement();
            st2.executeQuery("SELECT * FROM employee ORDER BY EMPLOYEE_ID DESC LIMIT 1");
            ResultSet rs2 = st2.getResultSet();
            //System.out.println("FFFFFFFFFFFFFFFFF"+rs2.getString("MO_NBER"));
            if (rs2.first()) {
                
                System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
                //System.out.println();
                
                count = 1;
                number = Integer.parseInt(rs2.getString("EMPLOYEE_ID"));
                number ++;
                System.out.println(number);
                  Txfiled_Num_Employee.setText(String.valueOf(number));
                  Txfiled_Num_Employee.setDisable(true);
                Btn_Save_Employee.setDisable(false);
                Btn_Delete_Employee.setDisable(false);
                 Btn_Cancel_Employee.setDisable(false);
                
                
                
               }}} 

        
   }
   

    
        
    

  
    @FXML
    private void Btn_Edit_MangeCurrentMO(ActionEvent event) {
    }

    @FXML
    private void M_Txfiled_Search_MangeCurrentMO(ActionEvent event) {
    }

    @FXML
    private void Btn_Edit_MangeFinshedMO(ActionEvent event) {
    }

    @FXML
    private void Txfiled_Search_MangeFinshedMO(ActionEvent event) {
    }

    @FXML
    private void Btn_Edit_MangePreviousMO(ActionEvent event) {
    }

    @FXML
    private void Txfiled_Search_MangePreviousMO(ActionEvent event) {
    }

    @FXML
    private void Btn_Edit_MangePendingMO(ActionEvent event) {
    }

    @FXML
    private void Txfiled_Search_MangePendingMO(ActionEvent event) {
    }

   

    @FXML
    private void M_Txfiled_Name_SP(ActionEvent event) {
    }
    @FXML
    void M_Btn_Search_SP(ActionEvent event) throws SQLException {
            
          Connection connection = connectionClass.getConnection();   
        Statement st = connection.createStatement();
        st.executeQuery("SELECT * FROM `spare_parts`  WHERE SP_NBER = " +  Txfiled_SPNum_SP.getText() );
        ResultSet rs = st.getResultSet();
        if (rs.first()) {

            System.out.println( Txfiled_SPNum_SP.getText());

            System.out.println("THIS NU NUMBER IN DB== " + rs.getString("SP_NBER"));
            System.out.println("THIS NU NUMBER IN FILED== " +  Txfiled_SPNum_SP.getText());

            if (rs.getString("SP_NBER").equals(Txfiled_SPNum_SP.getText())) {

            
                count = 2;
                
                
                 Txfiled_Name_SP.setText(rs.getString("SP_NAME"));
                Txfiled_Price_SP.setText(rs.getString("PRICE"));
                Txfiled_Quantity_SP.setText(rs.getString("QUANTITY"));
                 Txfiled_Discription_SP.setText(rs.getString("DESCRIPTION"));
                
                   Txfiled_SPNum_SP.setDisable(true);
                    Btn_Save_SP.setDisable(false);
                Btn_Delete_SP.setDisable(false);
                 Btn_Cancle_SP.setDisable(false);
                
               
                
        }}
        
        else{  
            
               Statement st2 = connection.createStatement();
            st2.executeQuery("SELECT * FROM spare_parts ORDER BY SP_NBER DESC LIMIT 1");
            ResultSet rs2 = st2.getResultSet();
            //System.out.println("FFFFFFFFFFFFFFFFF"+rs2.getString("MO_NBER"));
            if (rs2.first()) {
                
                System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
                //System.out.println();
                
                count = 1;
                number = Integer.parseInt(rs2.getString("SP_NBER"));
                number ++;
                System.out.println(number);
                 Txfiled_SPNum_SP.setText(String.valueOf(number));
                 Txfiled_SPNum_SP.setDisable(true);
                 Btn_Save_SP.setDisable(false);
                Btn_Delete_SP.setDisable(false);
                 Btn_Cancle_SP.setDisable(false);
                
                
                
               }}} 


    @FXML
    private void M_Btn_Cancle_SP(ActionEvent event) {
          Txfiled_SPNum_SP.setDisable(false);
         Txfiled_Name_SP.clear();
         Txfiled_Price_SP.clear();
         Txfiled_Quantity_SP.clear();
          Txfiled_Discription_SP.clear();
    }

    @FXML
    private void M_Btn_Delete_SP(ActionEvent event) throws SQLException {
          String sql1 = "DELETE FROM  `spare_parts`  WHERE SP_NBER= " +   Txfiled_SPNum_SP.getText();
        System.out.println(sql1);
        java.sql.Statement statement1 = connection.createStatement();
        statement1.executeUpdate(sql1);
          Txfiled_SPNum_SP.setDisable(false);
         Txfiled_Name_SP.clear();
         Txfiled_Price_SP.clear();
         Txfiled_Quantity_SP.clear();
          Txfiled_Discription_SP.clear();
        
    }

    @FXML
    private void M_Btn_Save_SP(ActionEvent event) throws SQLException {
         if ( Txfiled_SPNum_SP.getText().isEmpty() || Txfiled_Name_SP.getText().isEmpty() || Txfiled_Price_SP.getText().isEmpty() || 
                 Txfiled_Quantity_SP.getText().isEmpty() ||  Txfiled_Discription_SP.getText().isEmpty()  ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Pleas enter the value");
            alert.showAndWait();
            return;

        }
         
        
      if (count == 1) {
            System.out.println("Equal  insert");
             String sqll= "INSERT INTO spare_parts (SP_NBER, SP_NAME, PRICE,QUANTITY ,DESCRIPTION) VALUES ("+number+ "," + "'" +  Txfiled_Name_SP.getText() + "'" + ","+"'" +   Txfiled_Price_SP.getText()+ 
                     "'" + ","+"'" +  Txfiled_Quantity_SP.getText()+"'"+","+"'" + Txfiled_Discription_SP.getText()+ "')"; 
          System.out.println(sqll);
        java.sql.Statement statement1 = connection.prepareStatement(sqll);
 
 
   statement1.executeUpdate(sqll);

         
      }

    else if (count == 2){
         System.out.println("Equal  update");
            //System.out.println(Selct_MoStatus_AddMO.getValue());
            String sql1 = "UPDATE  `spare_parts` SET  SP_NAME='" +  Txfiled_Name_SP.getText() + "',PRICE='" + Txfiled_Price_SP.getText()  +"',QUANTITY='"+ Txfiled_Quantity_SP.getText() +"',DESCRIPTION='"+Txfiled_Discription_SP.getText()
                    +  " 'WHERE SP_NBER=' " + Txfiled_SPNum_SP.getText() + "'";
                        
            
                   
            System.out.println(sql1);
            java.sql.Statement statement1 = connection.createStatement();
            statement1.executeUpdate(sql1);
    }
     // count = 2;
    
    } 
     @FXML
   private void M_Btn_Save_Supplier(ActionEvent event) throws SQLException {
         if ( Txfiled_Num_Supplier.getText().isEmpty() || Txfiled_MNum_Supplier.getText().isEmpty() || Txfiled_Email_Supplier.getText().isEmpty() || 
                 Txfiled_Name_Supplier.getText().isEmpty() ||  Txfiled_Address_Supplier.getText().isEmpty()  ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Pleas enter the value");
            alert.showAndWait();
            return;

        }
         
        
      if (count == 1) {
            System.out.println("Equal  insert");
             String sqll= "INSERT INTO supplier (SUPPLIER_NBER, SUP_MOBILE_NBER, SUP_EMAIL,SUP_NAME ,SUP_ADDRESS) VALUES ("+number +","+"'" +   Txfiled_MNum_Supplier.getText() + "'" + ","+"'" +    Txfiled_Email_Supplier.getText()+ 
                     "'" + ","+"'" +  Txfiled_Name_Supplier.getText()+"'"+","+"'" +Txfiled_Address_Supplier.getText()+ "')"; 
          System.out.println(sqll);
        java.sql.Statement statement1 = connection.prepareStatement(sqll);
 
 
   statement1.executeUpdate(sqll);

         
      }

    else if (count == 2){
         System.out.println("Equal  update");
            //System.out.println(Selct_MoStatus_AddMO.getValue());
            String sql1 = "UPDATE  `supplier` SET  SUP_MOBILE_NBER='" + Txfiled_MNum_Supplier.getText() + "',SUP_EMAIL='" + Txfiled_Email_Supplier.getText()  +"',SUP_NAME='"+ Txfiled_Name_Supplier.getText() +"',SUP_ADDRESS='"+Txfiled_Address_Supplier.getText()
                    +  "' WHERE SUPPLIER_NBER= '" + Txfiled_Num_Supplier.getText() + "'";
                   
            System.out.println(sql1);
            java.sql.Statement statement1 = connection.createStatement();
            statement1.executeUpdate(sql1);
    }
      count = 2;
    
    }
            
            

    

    @FXML
   private void M_Btn_Search_Supplier(ActionEvent event) throws SQLException, ParseException {
       
            
          Connection connection = connectionClass.getConnection();   
        Statement st = connection.createStatement();
        st.executeQuery("SELECT * FROM `supplier`  WHERE SUPPLIER_NBER = " +  Txfiled_Num_Supplier.getText() );
        ResultSet rs = st.getResultSet();
        if (rs.first()) {

            System.out.println( Txfiled_Num_Supplier.getText());

            System.out.println("THIS NU NUMBER IN DB== " + rs.getString("SUPPLIER_NBER"));
            System.out.println("THIS NU NUMBER IN FILED== " +  Txfiled_Num_Supplier.getText());

            if (rs.getString("SUPPLIER_NBER").equals( Txfiled_Num_Supplier.getText())) {

            
                
                count = 2;
                
                
                Txfiled_MNum_Supplier.setText(rs.getString("SUP_MOBILE_NBER"));
                Txfiled_Email_Supplier.setText(rs.getString("SUP_EMAIL"));
                Txfiled_Name_Supplier.setText(rs.getString("SUP_NAME"));
                Txfiled_Address_Supplier.setText(rs.getString("SUP_ADDRESS"));
                
                    Txfiled_Num_Supplier.setDisable(true);
                    Btn_Save_Supplier.setDisable(false);
                Btn_Delete_Supplier.setDisable(false);
                 Btn_Cancle_Supplier.setDisable(false);
                
               
                
        }}
        
        else{  
            Statement st2 = connection.createStatement();
            st2.executeQuery("SELECT * FROM supplier ORDER BY SUPPLIER_NBER DESC LIMIT 1");
            ResultSet rs2 = st2.getResultSet();
            //System.out.println("FFFFFFFFFFFFFFFFF"+rs2.getString("MO_NBER"));
            if (rs2.first()) {
                
                System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
                //System.out.println();
                
                count = 1;
                number = Integer.parseInt(rs2.getString("SUPPLIER_NBER"));
                number++;
                System.out.println(number);
                 Txfiled_Num_Supplier.setText(String.valueOf(number));
                 Txfiled_Num_Supplier.setDisable(true);
                  Btn_Save_Supplier.setDisable(false);
                Btn_Delete_Supplier.setDisable(false);
                 Btn_Cancle_Supplier.setDisable(false);
                
                
               }}} 

        
    
    
    @FXML
   private void M_Btn_Delete_Supplier(ActionEvent event) throws SQLException {
        String sql1 = "DELETE FROM  `supplier`  WHERE SUPPLIER_NBER= " +   Txfiled_Num_Supplier.getText();
        System.out.println(sql1);
        java.sql.Statement statement1 = connection.createStatement();
        statement1.executeUpdate(sql1);
             clearSUP ();
    }
     @FXML
   private void M_Btn_Cancle_Supplier(ActionEvent event) {
       
                clearSUP ();
    }
   public void clearSUP (){
       Txfiled_Num_Supplier.setDisable(false);
       Txfiled_Num_Supplier.clear();
        Txfiled_MNum_Supplier.clear();
                Txfiled_Email_Supplier.clear();
                Txfiled_Name_Supplier.clear();
                Txfiled_Address_Supplier.clear();
                
                
       
       
   }
    
    
    

    
    @FXML
    private void prbuttonReports(ActionEvent event) {
    }

 

    
    @FXML
    public void Mangment_MO_tab_selected(Event event) {

        MainLable.setText("ادارة عمليات الصيانة");

    }

    @FXML
    public void Mangment_Customer_tab_selected(Event event) {
       MainLable.setText("ادارة العملاء");

    }

    @FXML
    public void Mangment_supliers_tab_selected(Event event) {
        MainLable.setText("ادارة المزودين");
    }

    @FXML
    public void Mangment_Staff_tab_selected(Event event) {
        MainLable.setText("ادارة الموظفين");
    }

    @FXML
    public void RequstSpearPart_tab_selected(Event event) {
       MainLable.setText("طلب قطع غيار");
    }

    @FXML
    public void Mangment_SpearParts_tab_selected(Event event) {
        MainLable.setText("ادارة قطع الغيار");
    }

    @FXML
    public void Mangment_Reports_tab_selected(Event event) {
        MainLable.setText("ادارة التقارير");
    }
     @FXML
    private void Main_Tab(Event event) {
         MainLable.setText(" ");
    }

    @FXML
    private void Mangment_Tools_tab_selected(Event event) {
                 MainLable.setText("الأدوات");

    }


    
    

}












/*
package sample;

import com.jfoenix.controls.JFXButton;
import javafx.animation.TranslateTransition;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    public Tab Mangment_MO_Tab;
    public Label MainLable;

    public TreeTableView TableViewReports;
    public TreeTableColumn Table_ColomnViewReports;
   public Label RepLable;
    public Tab Main_Tab;
    public ImageView icMaonMove;
    public AnchorPane kk;
    public JFXButton prbutton;
    public ListView listv;
    public JFXButton ShowMoWindowbuttn;



    @FXML
    private Label MainLable1;
    @FXML
    private ToggleGroup ReportsDate;


    @FXML
    public void Mangment_MO_tab_selected(Event event) {

      //  MainLable.setText("ادارة عمليات الصيانة");

    }

    @FXML
    public void Mangment_Customer_tab_selected(Event event) {
//        MainLable.setText("ادارة العملاء");

    }

    @FXML
    public void Mangment_supliers_tab_selected(Event event) {
  //      MainLable.setText("ادارة المزودين");
    }

    @FXML
    public void Mangment_Staff_tab_selected(Event event) {
    //    MainLable.setText("ادارة الموظفين");
    }

    @FXML
    public void RequstSpearPart_tab_selected(Event event) {
    //    MainLable.setText("طلب قطع غيار");
    }

    @FXML
    public void Mangment_SpearParts_tab_selected(Event event) {
        //MainLable.setText("ادارة قطع الغيار");
    }

    @FXML
    public void Mangment_Reports_tab_selected(Event event) {
        //MainLable.setText("ادارة التقارير");
    }



    @FXML
    public void Main_Tab(Event event) {
       
    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listv.getItems().add("- عمليات الصيانة الحالية");
        listv.getItems().add("- عمليات الصيانة المنتهية");
        listv.getItems().add("- عمليات الصيانة السابقة");
        listv.getItems().add("- تقدير مالي عن عملية صيانة");
        listv.getItems().add("---------------------------");
        listv.getItems().add("- قائمة بالعملاء");
        listv.getItems().add("- قائمة عمليات الصيانة لعميل");
        listv.getItems().add("---------------------------");
        listv.getItems().add("- قائمة بالموظفين");
        listv.getItems().add("- قائمة عمليات الصيانة لموظف");
        listv.getItems().add("---------------------------");
        listv.getItems().add("- قائمة بالمزودين");
        listv.getItems().add("---------------------------");
        listv.getItems().add("- قطع على وشك النفاذ");
        listv.getItems().add("- قطع الغيار التي نفذت كميتها");


       


    }

    @FXML
    public void prbuttonReports(ActionEvent actionEvent) {
        //ReportTable.getItems().setAll(studentsModels1);
        //ReportTable.setItems(studentsModels1);
    }

    @FXML
    public void ShowMoWindow(ActionEvent actionEvent) {
        loadWindow("/sample/AddMoNeww.fxml" ,"" );
    }


    void loadWindow(String loc , String title){
        try {

            Parent parent = FXMLLoader.load(getClass().getResource(loc));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setScene(new Scene(parent));
            stage.setTitle(title);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }}

    @FXML
    private void Btn_ChangeMN_Customer(ActionEvent event) {
    }

    @FXML
    private void Btn_Cancle_Customer(ActionEvent event) {
    }

    @FXML
    private void Btn_Delete_Customer(ActionEvent event) {
    }

    @FXML
    private void Btn_Save_Customer(ActionEvent event) {
    }

    @FXML
    private void Btn_Search_Customer(ActionEvent event) {
    }

    @FXML
    private void Btn_Edit_MangeCurrentMO(ActionEvent event) {
    }

    @FXML
    private void Txfiled_Search_MangeCurrentMO(ActionEvent event) {
    }

    @FXML
    private void Btn_Edit_MangeFinshedMO(ActionEvent event) {
    }

    @FXML
    private void Txfiled_Search_MangeFinshedMO(ActionEvent event) {
    }

    @FXML
    private void Btn_Edit_MangePreviousMO(ActionEvent event) {
    }

    @FXML
    private void Txfiled_Search_MangePreviousMO(ActionEvent event) {
    }

    @FXML
    private void Btn_Edit_MangePendingMO(ActionEvent event) {
    }

    @FXML
    private void Txfiled_Search_MangePendingMO(ActionEvent event) {
    }


    class StudentsModel {

//  private SimpleStringProperty Name;
  private  SimpleStringProperty Name;



        public StudentsModel( String reports) {
   this.Name = new SimpleStringProperty(reports);

  }

  public String getName() {
   return Name.get();
  }

  public void setName(String reportTableCol) {
   this.Name = new SimpleStringProperty(reportTableCol);
  }

 }
}
*/