package sample;

import Connectvy.ConnectionClass;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Controller_AddMO implements Initializable {

    ConnectionClass connectionClass = new ConnectionClass();
    // we call conneClass  that we make it up
    Connection connection = connectionClass.getConnection();

    @FXML
    private JFXDatePicker Date_Warranty_AddMO;
    @FXML
    private JFXDatePicker Date_StartMo_AddMO;
    @FXML
    private JFXDatePicker Date_EndMO_AddMO;
    @FXML
    private JFXTextField Txfiled_SPCost_AddMO;
    @FXML
    private JFXTextField Txfiled_MOCost_AddMO;
    @FXML
    private JFXTextField Txfiled_VAT_AddMO;
    @FXML
    private JFXTextField Txfiled_TotalCost_AddMO;
    @FXML
    private JFXTextField Txfiled_MOnum_AddMO;
    @FXML
    private JFXTextArea Txfiled_ProplemDisc_AddMO;
    @FXML
    private ComboBox<String> Selct_Techichan_AddMO;
    @FXML
    private ComboBox<String> Selct_MoStatus_AddMO;
    ObservableList<String> ListOfStatus = FXCollections.observableArrayList("UnderMO", "Another Problem", "Finsh");

    ObservableList<String> ListOfTechichan = FXCollections.observableArrayList();

    @FXML
    private JFXTextField Txfiled_SpSerialN_AddMO;
    @FXML
    private JFXTextField Txfiled_SearchSP_AddMO;
    @FXML
    private JFXTextField Txfiled_CusName_AddMO;
    @FXML
    private JFXTextField Txfiled_CusMnum_AddMO;
    @FXML
    private JFXTextField Txfiled_DevSerialN_AddMO;
    @FXML
    private JFXTextField Txfiled_DevDiscription_AddMO;
    @FXML
    private JFXButton Btn_Print_AddMo;
    @FXML
    private JFXButton Btn_Cancle_AddMo;
    @FXML
    private JFXButton Btn_Delete_AddMo;
    @FXML
    private JFXButton Btn_Save_AddMo;
    @FXML
    private JFXButton Btn_Search_AddMo;
    @FXML
    private TableView<Controller_AddMO.AddSP> Table_AddSP_AddMO;
    @FXML
    private TableColumn<Controller_AddMO.AddSP, String> Col_SPdisc_AddSP_AddMO;
    @FXML
    private TableColumn<Controller_AddMO.AddSP, String> Col_SPname_AddSP_AddMO;
    @FXML
    private TableColumn<Controller_AddMO.AddSP, Integer> Col_SPnum_AddSP_AddMO;

    ObservableList<Controller_AddMO.AddSP> list = FXCollections.observableArrayList();
    ObservableList<Controller_AddMO.SelectedSP> list2 = FXCollections.observableArrayList();
    @FXML
    private TableView<Controller_AddMO.SelectedSP> Table_SelectedSP_AddMO;
    @FXML
    private TableColumn<Controller_AddMO.SelectedSP, String> Col_SPdisc_SelectedSP_AddMO;
    @FXML
    private TableColumn<Controller_AddMO.SelectedSP, String> Col_SPname_SelectedSP_AddMO;
    @FXML
    private TableColumn<Controller_AddMO.SelectedSP, Integer> Col_SPnum_SelectedSP_AddMO;
    @FXML
    private TableColumn<Controller_AddMO.SelectedSP, String> Col_SPSN_SelectedSP_AddMO;

    ObservableList<Controller_AddMO.SelectedSP> SPSelected2, AllSP2;
    int count = 0;

    @FXML
    private void M_Txfiled_SpSerialN_AddMO(ActionEvent event) {
        AllSP2 = Table_SelectedSP_AddMO.getItems();
        SPSelected2 = Table_SelectedSP_AddMO.getSelectionModel().getSelectedItems();
        //  SPSelected2.get(0).SP_SNProperty("");
        //Txfiled_SpSerialN_AddMO.getText();

        for (int i = 0; i < SPSelected2.size(); i++) {
            list2.add(new Controller_AddMO.SelectedSP(SPSelected2.get(i).getSP2_Number(), SPSelected2.get(i).getSP2_Name(),
                    SPSelected2.get(i).getSP2_Description(), SPSelected2.get(i).getSP_Price2(), Txfiled_SpSerialN_AddMO.getText()));
            SPSelected2.forEach(AllSP2::remove);
            Table_SelectedSP_AddMO.setItems(list2);

        }
    }

    @FXML
    private void M_MousClicked_TabelSelecSP_AddMO(MouseEvent event) {

        SPSelected2 = Table_SelectedSP_AddMO.getSelectionModel().getSelectedItems();

        Txfiled_SpSerialN_AddMO.setText(SPSelected2.get(0).getSP_SN());

        //Txfiled_SpSerialN_AddMO.setText(SPSelected2.get(0).getSP_SN());
    }

    @FXML
    private void M_Btn_ReomveSP_AddMo(ActionEvent event) {

        AllSP2 = Table_SelectedSP_AddMO.getItems();
        SPSelected2 = Table_SelectedSP_AddMO.getSelectionModel().getSelectedItems();

        Txfiled_SpSerialN_AddMO.setText(SPSelected2.get(0).getSP_SN());
        //_____________________
        //for (AddSP addSP : Table_AddSP_AddMO.getSelectionModel().getSelectedItems()) {
        /* for (int i = 0; i < SPSelected2.size(); i++) {
            //for(int i =1;i<=1; i++){
            //list.clear();
            list.add(new Controller_AddMO.AddSP(SPSelected2.get(i).getSP2_Number(), SPSelected2.get(i).getSP2_Name(), SPSelected2.get(i).getSP2_Description(), 
        SPSelected2.get(i).getSP_Price2()));
            Table_AddSP_AddMO.setItems(list);

            }*/
        //}
        SPSelected2.forEach(AllSP2::remove);
        double spcost = 0;
        System.out.println("size=  " + list2.size());

        if (list2.size() == 0) {
            spcost = 0.00;
            Txfiled_SPCost_AddMO.setText(String.valueOf(spcost));

        } else {

            for (int i = 0; i < list2.size(); i++) {
                double[] mypriceArray = new double[list2.size()];
                mypriceArray[i] = list2.get(i).getSP_Price2();
                System.out.println(mypriceArray[i]);
                spcost += mypriceArray[i];
                System.out.println("pr= " + i + "  " + mypriceArray[i]);
                Txfiled_SPCost_AddMO.setText(String.valueOf(spcost));
            }
        }

        // Txfiled_SPCost_AddMO.setText(String.valueOf(spcost));
    }

    /*private void M_Txfiled_SearchSP_AddMO(ActionEvent event) {
        System.out.println(event.getEventType().toString());
        list.clear();

        String id1 = Txfiled_SearchSP_AddMO.getText();
        if (Txfiled_SearchSP_AddMO.getText().isEmpty()){
            String sql1 ="SELECT * FROM spare_parts";
            System.out.println(sql1);
            Search(sql1);
            

        }else {
            String sql1 = "SELECT * FROM spare_parts WHERE SP_NBRE = '" + id1 + "'";
            String trysql = "SELECT * FROM spare_parts WHERE SP_NBRE LIKE '"+id1+"%';";
            System.out.println(trysql);
            Search(trysql);

        }}*/
    public void Search(String Search) {
        ResultSet rs = connectionClass.execQuery(Search);
        try {
            while (rs.next()) {
                String mname = rs.getString("SP_NBRE");
                String mid = rs.getString("SP_NAME");
                String mobile = rs.getString("DESCRIPTION");
                String price = rs.getString("PRICE");

                int SP_num = Integer.parseInt(mname);
                double SP_Pri = Double.parseDouble(price);

                list.add(new Controller_AddMO.AddSP(SP_num, mid, mobile, SP_Pri));

            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        Table_AddSP_AddMO.getItems().setAll(list);

    }

    @FXML

    private void M_Btn_AddSP_AddMo(ActionEvent event) {

        ObservableList<Controller_AddMO.AddSP> SPSelected, AllSP;
        AllSP = Table_AddSP_AddMO.getItems();
        SPSelected = Table_AddSP_AddMO.getSelectionModel().getSelectedItems();

        //_____________________
        //for (AddSP addSP : Table_AddSP_AddMO.getSelectionModel().getSelectedItems()) {
        for (int i = 0; i < SPSelected.size(); i++) {
            //for(int i =1;i<=1; i++){
            list2.add(new Controller_AddMO.SelectedSP(SPSelected.get(i).getSP_Number(), SPSelected.get(i).getSP_Name(),
                    SPSelected.get(i).getSP_Description(), SPSelected.get(i).getSP_Price(), "null"));
            Table_SelectedSP_AddMO.setItems(list2);

        }
        //}
        double spcost = 0;
        for (int i = 0; i < list2.size(); i++) {
            double[] mypriceArray = new double[list2.size()];
            mypriceArray[i] = list2.get(i).getSP_Price2();
            System.out.println(mypriceArray[i]);
            spcost += mypriceArray[i];
            Txfiled_SPCost_AddMO.setText(String.valueOf(spcost));
        }

        // Txfiled_SPCost_AddMO.setText(String.valueOf(spcost));
        //SPSelected.forEach(AllSP::remove);
        //System.out.println(SPSelected);
        //list.add(new Controller_AddMO.AddSP(aa, mid, mobile));
        //list2.add(SPSelected.get(1));
        //System.out.println(SPSelected.get(0).SP_Description);
        //Table_AddSP_AddMO.getItems().setAll(list);
        //Table_SelectedSP_AddMO.getItems().setAll(list2);
        //SPSelected.forEach(AllSP::remove);
    }
    void loadWindow(String loc , String title){
        try {

            Parent parent = FXMLLoader.load(getClass().getResource(loc));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setScene(new Scene(parent));
            stage.setTitle(title);
            stage.show();
        } catch (IOException s) {
            s.printStackTrace();
        }}


    @FXML
    private void M_Btn_Print_AddMo(ActionEvent event) {
        loadWindow("/sample/Print_Window.fxml" ,"" );
    }

    @FXML
    private void M_Btn_Cancle_AddMo(ActionEvent event) {
        Txfiled_MOnum_AddMO.setDisable(false);
           
       Txfiled_ProplemDisc_AddMO.clear();
       Txfiled_CusMnum_AddMO.clear();
       Txfiled_SPCost_AddMO.clear();
       Txfiled_MOCost_AddMO.clear();
       Txfiled_DevSerialN_AddMO.clear();
       Txfiled_DevDiscription_AddMO.clear();
       Txfiled_SpSerialN_AddMO.clear();
       Txfiled_TotalCost_AddMO.clear();
       Txfiled_VAT_AddMO.clear();
       Txfiled_MOnum_AddMO.clear();
       Txfiled_SearchSP_AddMO.clear();
       
       Selct_Techichan_AddMO.getSelectionModel().clearSelection();
       Selct_MoStatus_AddMO.getSelectionModel().clearSelection();
       Date_Warranty_AddMO.getEditor().clear();
       Date_StartMo_AddMO.getEditor().clear();
       Date_EndMO_AddMO.getEditor().clear();
       
    }

    @FXML
    private void M_Btn_Delete_AddMo(ActionEvent event) {
    }

    @FXML
    private void M_Btn_Save_AddMo(ActionEvent event) throws SQLException {

        

        if (count == 1) {
            System.out.println("Equal  insert");

            String sql1 = "INSERT INTO `maintenance _operation` VALUES(" + "NULL" + "," + "'" +Selct_MoStatus_AddMO.getValue()+ "'" + "," + "'" + Txfiled_MOCost_AddMO.getText()
                    + "'" + "," + "'" + Txfiled_SPCost_AddMO + "'" + "," + "'" + Date_EndMO_AddMO.getValue() + "'" + "," + "'" + Date_EndMO_AddMO.getValue() + "'" + "," + "'" 
                    +Date_Warranty_AddMO.getValue() + "'" + ","+ "'" + Txfiled_ProplemDisc_AddMO.getText() + "'" + "," + "'" + Txfiled_DevSerialN_AddMO.getText() + "'" + "," + "'" + Txfiled_DevDiscription_AddMO.getText() +
                    "'" + "," + "'" + Selct_Techichan_AddMO.getValue() + "'" + "," + "'" + Txfiled_CusMnum_AddMO.getText() + "'" + "," + "'" + "2019-01-27" + "'" + "," + "'" + "100" + "'" + ")";
            System.out.println(sql1);
            java.sql.Statement statement1 = connection.createStatement();
            statement1.executeUpdate(sql1);

        } else if (count == 2) {
            System.out.println("Equal  update");
            System.out.println(Selct_MoStatus_AddMO.getValue());
            String sql1 = "UPDATE  `maintenance _operation` SET STATE='" + Selct_MoStatus_AddMO.getValue() + "',MO_COST='" + Txfiled_SPCost_AddMO.getText() + "' WHERE MO_NBER= '"+ Txfiled_MOnum_AddMO.getText()+"'";
            System.out.println(sql1);
            java.sql.Statement statement1 = connection.createStatement();
            statement1.executeUpdate(sql1);
        }

    }
    

    @FXML
    private void M_Btn_Search_AddMo(ActionEvent event) throws SQLException {
         Connection connection = connectionClass.getConnection();
         Statement st = connection.createStatement();
               st.executeQuery("select * FROM  `maintenance _operation` WHERE MO_NBER= '" + Txfiled_MOnum_AddMO.getText()+ "'");
              ResultSet rs = st.getResultSet();
              //st = connection.prepareCall(sql);
              
              if(rs.first()){
                  
            count =2;
          Txfiled_MOnum_AddMO.setDisable(true);
            Txfiled_ProplemDisc_AddMO.setText(rs.getString("PROBLEM_DESC"));
            Txfiled_CusMnum_AddMO.setText(rs.getString("CUS_MOBILE_NBER"));
            Txfiled_SPCost_AddMO.setText(rs.getString("SP_COST"));
            Txfiled_MOCost_AddMO.setText(rs.getString("MO_COST"));
            Txfiled_DevSerialN_AddMO.setText(rs.getString("DEVICE_SN"));
            Txfiled_DevDiscription_AddMO.setText(rs.getString("DEVICE_DESC"));
            Date_Warranty_AddMO.getEditor().setText(rs.getString("WARRANTY"));
            Date_StartMo_AddMO.getEditor().setText(rs.getString("STARTING_DATE"));
            Date_EndMO_AddMO.getEditor().setText(rs.getString("ENDING_DATE"));
          //List<String> State = new ArrayList<>();
          //State.add(rs.getString("STATE"));
          //Selct_MoStatus_AddMO.setItems(FXCollections.observableArrayList(State));
          Selct_MoStatus_AddMO.getSelectionModel().select(rs.getString("STATE"));
          
          
          //List<String> Tec = new ArrayList<>();
          //Tec.add(rs.getString("EMPLOYEE_ID"));
          Selct_Techichan_AddMO.getSelectionModel().select(rs.getString("EMPLOYEE_ID"));
          
             Btn_Delete_AddMo.setDisable(false);
             Btn_Save_AddMo.setDisable(false);
             Btn_Print_AddMo.setDisable(false);
             Btn_Delete_AddMo.setDisable(false);
             Txfiled_CusName_AddMO.setDisable(true);
             Btn_Cancle_AddMo.setDisable(false);
             
      
              }else
              {
                  count =1;
                  Txfiled_MOnum_AddMO.setDisable(true);
                  Txfiled_MOnum_AddMO.clear();
                  Btn_Delete_AddMo.setDisable(true);
                  Btn_Cancle_AddMo.setDisable(false);
                  Btn_Save_AddMo.setDisable(false);
                  Btn_Print_AddMo.setDisable(false);
                   Txfiled_CusName_AddMO.setDisable(false);
                 
            
              }
  
     

      java.sql.Statement statement1 = connection.createStatement();
       //statement1.executeQuery(sql);

    }
        
       

    

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //ConnectionClass connectionClass =new ConnectionClass();
        // we call conneClass  that we make it up
        connectionClass.connectDB();
        //Connection connection= connectionClass.getConnection();
        intilCol();
        loadData();
        loadTech();
        System.out.println("Byee");
        Selct_Techichan_AddMO.setItems(ListOfTechichan);
        Selct_MoStatus_AddMO.setItems(ListOfStatus);

    }

    public void loadTech() {
        String query = "SELECT EMP_NAME FROM employee";
        ResultSet rs = connectionClass.execQuery(query);
        try {
            while (rs.next()) {

                ListOfTechichan.add(rs.getString("EMP_NAME"));

            }
            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();

        }

    }

    private void intilCol() {

        Col_SPnum_AddSP_AddMO.setCellValueFactory(new PropertyValueFactory<>("SP_Number"));
        Col_SPname_AddSP_AddMO.setCellValueFactory(new PropertyValueFactory<>("SP_Name"));
        Col_SPdisc_AddSP_AddMO.setCellValueFactory(new PropertyValueFactory<>("SP_Description"));

        Col_SPnum_SelectedSP_AddMO.setCellValueFactory(new PropertyValueFactory<>("SP_Number2"));
        Col_SPname_SelectedSP_AddMO.setCellValueFactory(new PropertyValueFactory<>("SP_Name2"));
        Col_SPdisc_SelectedSP_AddMO.setCellValueFactory(new PropertyValueFactory<>("SP_Description2"));
        Col_SPSN_SelectedSP_AddMO.setCellValueFactory(new PropertyValueFactory<>("SP_SN"));

    }

    private void loadData() {

        String query = "SELECT * FROM spare_parts";
        ResultSet rs = connectionClass.execQuery(query);
        try {
            while (rs.next()) {
                String mname = rs.getString("SP_NBRE");
                String mid = rs.getString("SP_NAME");
                String mobile = rs.getString("DESCRIPTION");
                String price = rs.getString("PRICE");

                int SP_num = Integer.parseInt(mname);
                double SP_Pri = Double.parseDouble(price);

                list.add(new Controller_AddMO.AddSP(SP_num, mid, mobile, SP_Pri));

            }
            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        Table_AddSP_AddMO.getItems().setAll(list);

    }
    String id2 = "";

    @FXML
    private void Hellllllooo(KeyEvent event) {
        System.out.println(event.getEventType().toString());
        System.out.println(event.getText());
        list.clear();
        id2 += event.getText();
        if (event.getText().equals("")) {
            id2 = id2.substring(0, id2.length() - 1);

        }

        String id1 = Txfiled_SearchSP_AddMO.getText();
        System.out.println("__________  " + id2);
        System.out.println("__________  " + id1);
        System.out.println("__________  " + Txfiled_SearchSP_AddMO.getText());

        if (id2.isEmpty()) {
            String sql1 = "SELECT * FROM spare_parts";
            System.out.println(sql1);
            Search(sql1);

        } else {
            String sql1 = "SELECT * FROM spare_parts WHERE SP_NAME = '" + id2 + "'";
            String trysql = "SELECT * FROM spare_parts WHERE SP_NAME LIKE '" + id2 + "%';";
            System.out.println(trysql);
            Search(trysql);

        }
    }

    @FXML
    private void M_Txfiled_SPCost_AddMO(ActionEvent event) {
        double costofmaint = Double.parseDouble(Txfiled_MOCost_AddMO.getText());
        double costofSP = Double.parseDouble(Txfiled_SPCost_AddMO.getText());
        double total = costofmaint + costofSP;
        double vat = total * 0.05;

        double Total = total + vat;
        Txfiled_VAT_AddMO.setText(String.valueOf(vat));
        Txfiled_TotalCost_AddMO.setText(String.valueOf(Total));
    }

    public static class AddSP {

        private final SimpleIntegerProperty SP_Number;
        private final SimpleStringProperty SP_Name;
        private final SimpleStringProperty SP_Description;
        private final SimpleDoubleProperty SP_Price;

        AddSP(int SP_Number, String SP_Name, String SP_Description, double SP_Price) {
            this.SP_Number = new SimpleIntegerProperty(SP_Number);
            this.SP_Name = new SimpleStringProperty(SP_Name);
            this.SP_Description = new SimpleStringProperty(SP_Description);
            this.SP_Price = new SimpleDoubleProperty(SP_Price);

        }

        public Integer getSP_Number() {
            return SP_Number.get();
        }

        public SimpleIntegerProperty SP_NumberProperty() {
            return SP_Number;
        }

        public String getSP_Name() {
            return SP_Name.get();
        }

        public SimpleStringProperty SP_NameProperty() {
            return SP_Name;
        }

        public String getSP_Description() {
            return SP_Description.get();
        }

        public SimpleStringProperty SP_DescriptionProperty() {
            return SP_Description;
        }

        public double getSP_Price() {
            return SP_Price.get();
        }

        public SimpleDoubleProperty SP_PriceProperty() {
            return SP_Price;
        }

    }

    public static class SelectedSP {

        private final SimpleIntegerProperty SP_Number2;
        private final SimpleStringProperty SP_Name2;
        private final SimpleStringProperty SP_Description2;
        private final SimpleDoubleProperty SP_Price2;
        private final SimpleStringProperty SP_SN;

        SelectedSP(Integer SP_Number2, String SP_Name2, String SP_Description2, double SP_Price2, String SP_SN) {
            this.SP_Number2 = new SimpleIntegerProperty(SP_Number2);
            this.SP_Name2 = new SimpleStringProperty(SP_Name2);
            this.SP_Description2 = new SimpleStringProperty(SP_Description2);
            this.SP_Price2 = new SimpleDoubleProperty(SP_Price2);
            this.SP_SN = new SimpleStringProperty(SP_SN);

        }

        public Integer getSP2_Number() {
            return SP_Number2.get();
        }

        public SimpleIntegerProperty SP_Number2Property() {
            return SP_Number2;
        }

        public String getSP2_Name() {
            return SP_Name2.get();
        }

        public SimpleStringProperty SP_Name2Property() {
            return SP_Name2;
        }

        public String getSP2_Description() {
            return SP_Description2.get();
        }

        public SimpleStringProperty SP_Description2Property() {
            return SP_Description2;
        }

        public double getSP_Price2() {
            return SP_Price2.get();
        }

        public SimpleDoubleProperty SP_Price2Property() {
            return SP_Price2;
        }

        public String getSP_SN() {
            return SP_SN.get();
        }

        public SimpleStringProperty SP_SNProperty() {
            return SP_SN;
        }

    }
}
