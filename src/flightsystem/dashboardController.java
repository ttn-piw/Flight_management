package flightsystem;

import static flightsystem.User.user;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author ASUS
 */

public class dashboardController implements Initializable {
        @FXML
    private TableView<BookingData> bookingtableView;
        
        @FXML
    private Button selectBtn1;
        
        @FXML
    private Button checkBtn;
        @FXML
    private TextField AC1;

    @FXML
    private TextField AC2;
    
    @FXML
    private TextField AID1;

    @FXML
    private TextField AID2;

    
    @FXML
    private TableView<?> tableViewFlight1;

    @FXML
    private TextField AN1;

    @FXML
    private TextField AN2;

    @FXML
    private TableColumn<?, ?> Airline_ID;

    @FXML
    private TableColumn<?, ?> Airline_contact;

    @FXML
    private TableColumn<?, ?> Airline_name;

    @FXML
    private TableColumn<?, ?> Airport_ID;

    @FXML
    private TableColumn<?, ?> Airport_city;

    @FXML
    private TableColumn<?, ?> Airport_name;

    @FXML
    private Label info_aa1;

    @FXML
    private Label info_seats;
    
    
    @FXML
    private Label info_ad1;

    @FXML
    private Label info_dd1;

     @FXML
    private Label info_da1;
     
    
    @FXML
    private Label cust_address;

    @FXML
    private Label cust_gender;

    @FXML
    private ComboBox<?> cust_id;

    @FXML
    private Label cust_mail;

    @FXML
    private Label cust_name;

    @FXML
    private Label cust_phone;
    
    @FXML
    private TextField cust_seats;
    
      @FXML
    private TextField AA;

    @FXML
    private TableColumn<FlightData, String> AA_table;

    @FXML
    private DatePicker AD;

    @FXML
    private TableColumn<FlightData, Date> AD_table;

    @FXML
    private TableColumn<FlightData, Integer> AID_table;

    @FXML
    private TableColumn<BookingData, String> BID_booking;

    @FXML
    private AnchorPane Booking;

    @FXML
    private TextField Booking_search;

    @FXML
    private TableColumn<BookingData, String> CID_booking;

    @FXML
    private TextField DA;

    @FXML
    private TableColumn<FlightData, String> DA_table;

    @FXML
    private DatePicker DD;

    @FXML
    private TableColumn<FlightData, Date> DD_table;

    @FXML
    private TextField FAID;

    @FXML
    private TextField FID;

    @FXML
    private TableColumn<BookingData, String> FID_booking;

    @FXML
    private TableColumn<FlightData, Integer> FID_table;

    @FXML
    private TextField FP;

    @FXML
    private TextField FS;

    @FXML
    private AnchorPane Flight_Cust;

    @FXML
    private AnchorPane Flight_table;

    @FXML
    private AnchorPane Information_Form;

    @FXML
    private TableColumn<FlightData, Double> P_table;

    @FXML
    private Button PayBtn;

    @FXML
    private TableColumn<FlightData, Integer> S_table;

    @FXML
    private AnchorPane Total;

    @FXML
    private Button addBtn;

    @FXML
    private TableColumn<BookingData, String> amount_booking;

    @FXML
    private Button availableBtn;

    @FXML
    private Button bookingBtn;


    @FXML
    private AreaChart<?, ?> chart;


    @FXML
    private Button InformationBtn;

    @FXML
    private TableColumn<BookingData, String> date_booking;

    @FXML
    private Button deleteBtn;

    @FXML
    private Button edit;

    @FXML
    private ComboBox<?> flight_id;

    @FXML
    private Button homeBtn;

    @FXML
    private AnchorPane home_available;

    @FXML
    private AnchorPane home_income;

    @FXML
    private AnchorPane home_price;

    @FXML
    private Label info_aa;

    @FXML
    private Label info_ad;

    @FXML
    private Label info_address;

    @FXML
    private Label info_da;

    @FXML
    private Label info_dd;

    @FXML
    private Label info_email;

    @FXML
    private Label info_flightID;

    @FXML
    private Label info_gender;

    @FXML
    private Label info_id;

    @FXML
    private Label info_name;

    @FXML
    private Label info_phone;
    
    @FXML
    private TableView<FlightData> tableViewFlight;

    @FXML
    private TableColumn<BookingData, String> name_booking;

    @FXML
    private TableColumn<BookingData, String> phone_booking;

    @FXML
    private Button receiptBtn;

    @FXML
    private Button resetBtn;

    @FXML
    private TextField searchBtn;

    @FXML
    private TableColumn<BookingData, String> seat_booking;

    @FXML
    private Button selectBtn;

    @FXML
    private Button signoutBtn;

    @FXML
    private Button updateBtn;
    
    @FXML
    private AnchorPane main_form;
    
    @FXML
    private Label user;
    
    @FXML
    private Label total_field;
   
    @FXML
    private AnchorPane Flight_table1;
    
        @FXML
    private Label home_Flight;

    @FXML
    private Label home_Income;

    @FXML
    private Label home_Price;
    
    //    DATABASE TOOLS
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Statement statement;
   
   @FXML
    void switchForm01(ActionEvent event) {
        if(event.getSource() == homeBtn) {
            Total.setVisible(true);
            Flight_table.setVisible(false);
            Information_Form.setVisible(false);
            Booking.setVisible(false);
            
            dashboardDisplayAB();
            dashboardDisplayIT();
            dashboardDisplayTI();
            dashboardChart();
        } else if(event.getSource() == availableBtn) {
            Total.setVisible(false);
            Flight_table.setVisible(true);
            Information_Form.setVisible(false);
            Booking.setVisible(false);
        } else if(event.getSource() == bookingBtn) {
            Total.setVisible(false);
            Flight_table.setVisible(false);
            Information_Form.setVisible(true);
            Booking.setVisible(false);
        } else if(event.getSource() == InformationBtn) {
            Total.setVisible(false);
            Flight_table.setVisible(false);
            Information_Form.setVisible(false);
            Booking.setVisible(true);
            
            bookingShowDataList();
            bookingSearch();
        }
        
    };
    
     
    private Button closeBtn;
    private Button minimizeBtn;

     public void account() {
        user.setText(User.user);
    }
     
     public ObservableList<FlightData> availableFlightData() {
         ObservableList<FlightData> flightListData = FXCollections.observableArrayList();
         String sql = "select *from flights";
         connect = database01.connectDatabase01();
         try {
             prepare = connect.prepareStatement(sql);
             result = prepare.executeQuery();
             
             FlightData FlightD;
             while(result.next()) {
                 FlightD = new FlightData(result.getInt("flight_id")
                                    , result.getInt("airline_id")
                                    , result.getDate("departure_date")
                                    , result.getDate("arrival_date")
                                    , result.getString("departure_airport")
                                    , result.getString("arrival_airport")
                                    , result.getInt("seats"), result.getDouble("price"));
                 flightListData.add(FlightD);
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         return flightListData;

     }
     
     private ObservableList<FlightData> availableFlightListData;
     public void availableShowFlightData() {
         availableFlightListData = availableFlightData();
         FID_table.setCellValueFactory(new PropertyValueFactory<>("flight_id"));
         AID_table.setCellValueFactory(new PropertyValueFactory<>("airline_id"));
         DD_table.setCellValueFactory(new PropertyValueFactory<>("departure_date"));
         AD_table.setCellValueFactory(new PropertyValueFactory<>("arrival_date"));
         DA_table.setCellValueFactory(new PropertyValueFactory<>("departure_airport"));
         AA_table.setCellValueFactory(new PropertyValueFactory<>("arrival_airport"));
         S_table.setCellValueFactory(new PropertyValueFactory<>("seats"));
         P_table.setCellValueFactory(new PropertyValueFactory<>("price"));
         
         tableViewFlight.setItems(availableFlightListData);
     }
     
     public void availableSelectFlightData() {
         FlightData FlightD = tableViewFlight.getSelectionModel().getSelectedItem();
         int n = tableViewFlight.getSelectionModel().getSelectedIndex();
         
         if((n-1) < -1) {
             return;
         }
         
         FID.setText(String.valueOf(FlightD.getFlight_id()));
         FAID.setText(String.valueOf(FlightD.getAirline_id()));
         DD.setValue(LocalDate.parse(String.valueOf(FlightD.getDeparture_date())));
         AD.setValue(LocalDate.parse(String.valueOf(FlightD.getArrival_date())));
         DA.setText(String.valueOf(FlightD.getDeparture_airport()));
         AA.setText(String.valueOf(FlightD.getArrival_airport()));
         FS.setText(String.valueOf(FlightD.getSeats()));
         FP.setText(String.valueOf(FlightD.getPrice()));
         
         
         
     }
  
     public void availableFlightAdd() {
    String addData = "INSERT INTO flights VALUES(?,?,?,?,?,?,?,?)";

    connect = database01.connectDatabase01();

    try {
        Alert alert;

        if (FID.getText().isEmpty()
                || FAID.getText().isEmpty()
                || DD.getValue() == null
                || AD.getValue() == null
                || DA.getText().isEmpty()
                || AA.getText().isEmpty()
                || FS.getText().isEmpty()
                || FP.getText().isEmpty()) {

            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();

        } else {

            // Check if the flight ID is already exist
            String check = "SELECT flight_id FROM flights WHERE flight_id = '"
                    + FID.getText() + "'";

            statement = connect.createStatement();
            result = statement.executeQuery(check);

            if (result.next()) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Flight ID: " + FID.getText() + " was already exist!");
                alert.showAndWait();

            } else {

                prepare = connect.prepareStatement(addData);
                prepare.setString(1, FID.getText());
                prepare.setString(2, FAID.getText());
                prepare.setString(3, String.valueOf(DD.getValue()));
                prepare.setString(4, String.valueOf(AD.getValue()));
                prepare.setString(5, DA.getText()); 
                prepare.setString(6, AA.getText());
                prepare.setString(7, FS.getText());
                prepare.setString(8, FP.getText());

                prepare.executeUpdate();

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Added!");
                alert.showAndWait();

                availableShowFlightData();
                availableFlightReset();
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

     public void availableFlightReset() {

        FID.setText("");
        FAID.setText("");
        DD.setValue(null);
        AD.setValue(null);
        DA.setText("");
        AA.setText("");
        FS.setText("");
        FP.setText("");

    }

     public void availableFlightUpdate() {
    String updateData = "UPDATE flights SET departure_date = ?, arrival_date = ?, departure_airport = ?, arrival_airport = ?, seats = ?, price = ? WHERE flight_id = ? AND airline_id = ?";

    connect = database01.connectDatabase01();

    Alert alert;

    try {

        if (FID.getText().isEmpty()
                || FAID.getText().isEmpty()
                || DD.getValue() == null 
                || AD.getValue() == null 
                || DA.getText().isEmpty()
                || AA.getText().isEmpty()
                || FS.getText().isEmpty()
                || FP.getText().isEmpty()) {

            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please select the item first");
            alert.showAndWait();

        } else {

            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to UPDATE Flight ID: " + FID.getText() + "?");

            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {

                prepare = connect.prepareStatement(updateData);
                prepare.setString(1, String.valueOf(DD.getValue()));
                prepare.setString(2, String.valueOf(AD.getValue()));
                prepare.setString(3, DA.getText());
                prepare.setString(4, AA.getText());
                prepare.setString(5, FS.getText());
                prepare.setString(6, FP.getText());
                prepare.setString(7, FID.getText());
                prepare.setString(8, FAID.getText());

                prepare.executeUpdate();

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Updated!");
                alert.showAndWait();

                availableShowFlightData();
                availableFlightReset();

            } else {
                return;
            }

        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

     
    public void availableFlightDelete(){
        
        String deleteData = "DELETE FROM flights WHERE flight_id = '"
                +FID.getText()+"'";
        
        connect = database01.connectDatabase01();
        
        try{
            
            Alert alert;
            
             if (FID.getText().isEmpty()
                    || FAID.getText().isEmpty()
                    || DD.getValue() == null 
                    || AD.getValue() == null 
                    || DA.getText().isEmpty()
                    || AA.getText().isEmpty()
                    || FS.getText().isEmpty()
                    || FP.getText().isEmpty()) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please select the item first");
                alert.showAndWait();

            } else {
                
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to delete Flight ID: " + FID.getText() + "?");
                
                Optional<ButtonType> option = alert.showAndWait();
                if(option.get().equals(ButtonType.OK)){
                    
                    statement = connect.createStatement();
                    statement.executeUpdate(deleteData);
                    
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();
                    
                    availableShowFlightData();
                    availableFlightReset();
                    
                }else{
                    return;
                }
            }
//            NOW LETS PROCEED TO BOOKING TICKET : ) 
        }catch(Exception e){e.printStackTrace();}
        
    }
     public void availableSearch(){
        
        FilteredList<FlightData> filter = new FilteredList<>(availableFlightListData, e-> true);
        
        searchBtn.textProperty().addListener((Observable, oldValue, newValue) ->{
            
            filter.setPredicate(predicateFlightData ->{
                
                if(newValue.isEmpty() || newValue == null){
                    return true;
                }
                
                String searchKey = newValue.toLowerCase();
//                NOTHING? THEN WE NEED TO DO THIS FIRST
                if(predicateFlightData.getFlight_id().toString().equals(searchKey)){
//                    NOTE, IF INTEGER OR IF THE DATA TYPE IS NOT STRING, YOU MUST BE DO toString()
                    return true;
                }else if(predicateFlightData.getAirline_id().toString().contains(searchKey)){
//                    NOTE, IF INTEGER OR IF THE DATA TYPE IS NOT STRING, YOU MUST BE DO toString()
                    return false;
                }else if(predicateFlightData.getDeparture_date().toString().contains(searchKey)) {
                    return false;
                }else if(predicateFlightData.getArrival_date().toString().contains(searchKey)) {
                    return false;
                }else if(predicateFlightData.getDeparture_airport().toLowerCase().contains(searchKey)){
                    return true;
                }else if(predicateFlightData.getArrival_airport().toLowerCase().contains(searchKey)){
                    return true;
                }else if(predicateFlightData.getSeats().toString().contains(searchKey)){
                    return false;
                }else if(predicateFlightData.getPrice().toString().contains(searchKey)){
                    return false;
                }else return false;
                
            });
        });
        
        SortedList<FlightData> sortList = new SortedList<>(filter);
        
        sortList.comparatorProperty().bind(tableViewFlight.comparatorProperty());
        tableViewFlight.setItems(sortList);
    }
   
    /*
   public void availableSearch() {
    FilteredList<FlightData> filter = new FilteredList<>(availableFlightListData, e -> true);

    searchBtn.textProperty().addListener((observable, oldValue, newValue) -> {
        filter.setPredicate(predicateFlightData -> {
            if (newValue.isEmpty() || newValue == null) {
                return true;
            }

            String searchKey = newValue.toLowerCase();
            // Check if flight_id is an exact match with the search key
            return predicateFlightData.getFlight_id().toString().equals(searchKey);
        });
    });

    SortedList<FlightData> sortList = new SortedList<>(filter);
    sortList.comparatorProperty().bind(tableViewFlight.comparatorProperty());
    tableViewFlight.setItems(sortList);
}
*/
    

    private double priceData =0;
     private double totalP = 0; 
 
  

     
     private double x = 0;
     private double y = 0;
     
    public void signout() {
         try {

            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to logout?");

            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {

                signoutBtn.getScene().getWindow().hide();
//                LOGIN FORM 
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                root.setOnMousePressed((MouseEvent event) -> {
                    x = event.getSceneX();
                    y = event.getSceneY();
                });

                root.setOnMouseDragged((MouseEvent event) -> {

                    stage.setX(event.getScreenX() - x);
                    stage.setY(event.getScreenY() - y);

                    stage.setOpacity(.8);
                });
                root.setOnMouseReleased((MouseEvent event) -> {
                    stage.setOpacity(1);
                });

                stage.initStyle(StageStyle.TRANSPARENT);

                stage.setScene(scene);
                stage.show();

            } else {
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private int countA = 0;
    public void dashboardDisplayAB(){
        
        String sql = "SELECT COUNT(flight_id) FROM flights";
        
        connect = database01.connectDatabase01();
        
        try{
            
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            while(result.next()){
                countA = result.getInt("COUNT(flight_id)");
            }
            
            home_Flight.setText(String.valueOf(countA));
            
        }catch(Exception e){e.printStackTrace();}
        
    }
    
   private double incomeToday = 0;

public void dashboardDisplayIT() {
    java.util.Date booking_date = new java.util.Date(); // Sử dụng java.util.Date
    java.sql.Date sqlDate = new java.sql.Date(booking_date.getTime());

    String sql = "SELECT SUM(total_amount) FROM bookings WHERE booking_date = ?";
    
    connect = database01.connectDatabase01();

    try {
        prepare = connect.prepareStatement(sql);
        prepare.setDate(1, sqlDate); // Sử dụng setDate để đặt giá trị thay thế cho ?
        result = prepare.executeQuery();

        while (result.next()) {
            incomeToday = result.getDouble("SUM(total_amount)");
        }

        home_Income.setText("$" + String.valueOf(incomeToday));

    } catch (Exception e) {
        e.printStackTrace();
    }
}
 private double totalPrice;
    public void dashboardDisplayTI(){
        
        String sql = "SELECT SUM(total_amount) FROM bookings";
        
        connect = database01.connectDatabase01();
        
        try{
            
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            while(result.next()){
                totalPrice = result.getDouble("SUM(total_amount)");
            }
            
            home_Price.setText("$"+String.valueOf(totalPrice));
            
        }catch(Exception e){e.printStackTrace();}
        
    }
    
    
    public void FlightIDList(){
        String FID = "Select * from flights";
        
        connect = database01.connectDatabase01();
        
        try{
            prepare = connect.prepareStatement(FID);
            result = prepare.executeQuery();
            
            ObservableList listB = FXCollections.observableArrayList();
            
            while(result.next()){
                listB.add(result.getString("flight_id"));
                
            }
           flight_id.setItems(listB);
           
        } catch (Exception e1){
            e1.printStackTrace();
        }
    }
    
 
public void dashboardChart(){
    chart.getData().clear();
    
    String sql = "SELECT booking_date, SUM(total_amount) FROM bookings WHERE booking_date IS NOT NULL GROUP BY booking_date ORDER BY TIMESTAMP(booking_date) ASC LIMIT 9";
    
    connect = database01.connectDatabase01();
    
    XYChart.Series chartData = new XYChart.Series();
    
    try {         
        prepare = connect.prepareStatement(sql);
        result = prepare.executeQuery();
        
        while (result.next()) {
            // Sử dụng getBigDecimal để lấy giá trị total_amount dưới dạng BigDecimal
            BigDecimal totalAmount = result.getBigDecimal(2);
            
            // Chuyển đổi giá trị BigDecimal thành double
            double totalAmountDouble = totalAmount.doubleValue();
            
            // Thêm dữ liệu vào chuỗi dữ liệu biểu đồ
            chartData.getData().add(new XYChart.Data(result.getString(1), totalAmountDouble));
        }
        
        // Thêm chuỗi dữ liệu biểu đồ vào biểu đồ
        chart.getData().add(chartData);
        
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void CustIDList(){
        String sql = "select * from customers";
        
        connect = database01.connectDatabase01();
         try{
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            ObservableList listB = FXCollections.observableArrayList();
            
            while(result.next()){
                listB.add(result.getString("cust_id"));
                
            }
           cust_id.setItems(listB);
           
        } catch (Exception e1){
            e1.printStackTrace();
        }
    }

public void FlightSelectBtn01(){
    
        String fid = (String) flight_id.getSelectionModel().getSelectedItem();
        
        Alert alert;
        
        if( fid == null){
        
        alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText("Pleas fill the blank field");
        alert.show();
    }else{
        
        String query = "select * from flights WHERE flight_id ='"+fid+"'";
        String query1 = "Select * from bookings WHERE flight_id ='"+fid+"'";
        
        try{
            PreparedStatement ps1;
            ResultSet rs;
            
            connect = database01.connectDatabase01();
            
            prepare = connect.prepareStatement(query);
            ps1     = connect.prepareStatement(query1);
            result = prepare.executeQuery();
            rs      = ps1.executeQuery();
            
            
            while(result.next() & rs.next()){
                /*info_dd1.setText(result.getString("departure_date"));
                info_ad1.setText(result.getString("arrival_date"));
                info_da1.setText(result.getString("departure_airport"));
                info_aa1.setText(result.getString("arrival_airport"));
                info_seats1.setText(result.getString("seats"));*/
                
                String departureDate = result.getString("departure_date");
                String arrivalDate = result.getString("arrival_date");
                String departureAirport = result.getString("departure_airport");
                String arrivalAirport = result.getString("arrival_airport");
                int seats = result.getInt("seats");
                int seats1 = rs.getInt("booked_seats");

                // Displaying the retrieved data in your GUI elements
                info_dd1.setText(departureDate);
                info_ad1.setText(arrivalDate);
                info_da1.setText(departureAirport);
                info_aa1.setText(arrivalAirport);

            }
            
            connect.close();
            prepare.close();
            ps1.close();
            
        } catch (Exception e1){
            e1.printStackTrace();
        }
        
        alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Message");
        alert.setHeaderText(null);
        alert.setContentText("Successfully Selected");
        alert.showAndWait();    
        }
        
    }
    
public void checkBtnFunc(){
        String cid = (String) cust_id.getSelectionModel().getSelectedItem();
        
        Alert alert;
        
        if( cid == null){
        
        alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText("Pleas fill the blank field");
        alert.show();
    }else{
        
        String query = "select * from customers WHERE cust_id ='"+cid+"'";
      
        try{
            
            connect = database01.connectDatabase01();
            
            prepare = connect.prepareStatement(query);
            result = prepare.executeQuery();
            
            while(result.next()) {
                
                String name = result.getString("cust_name");
                String gender = result.getString("cust_gender");
                String mail = result.getString("cust_email");
                String phone = result.getString("cust_phone");
                String address = result.getString("cust_address");
                        
                // Displaying the retrieved data in your GUI elements
                cust_name.setText(name);
                cust_gender.setText(gender);
                cust_mail.setText(mail);
                cust_phone.setText(phone);
                cust_address.setText(address);
            }            
            connect.close();
            prepare.close();

        } catch (Exception e1){
            e1.printStackTrace();
        }
        
        alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Message");
        alert.setHeaderText(null);
        alert.setContentText("Successfully Selected");
        alert.showAndWait();    
        }
    }

 public void bookingCusSelect(){
        
        String cid = (String) cust_id.getSelectionModel().getSelectedItem();
        String name = cust_name.getText();
        String gender = cust_gender.getText();
        String phone = cust_phone.getText();
        String email = cust_mail.getText();
        String address = cust_address.getText();
        
        String fid = (String) flight_id.getSelectionModel().getSelectedItem();
        String ddate = info_dd1.getText();
        String adate = info_ad1.getText();
        String dair =  info_da1.getText();
        String aair =  info_aa1.getText();
        String seats = cust_seats.getText();
        
        Alert alert;
        
        if( cid == null || name == null || gender == null || phone == null 
            || email == null || address == null || fid == null || ddate == null
            || adate == null || dair == null || aair == null || seats == null || seats.trim().isEmpty() ){
        
        alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText("Pleas fill the blank field");
        alert.show();
    }else{
        
         String totalPrice = "SELECT * FROM flights WHERE flight_id ='"+fid+"'";
        
        try{
            
            connect = database01.connectDatabase01();
            
            prepare = connect.prepareStatement(totalPrice);
            result = prepare.executeQuery();
            
            if (result.next()){
                priceData = result.getDouble("price");
            }
            
            totalP = priceData * Float.parseFloat(seats);
            
        } catch (Exception e1){
            e1.printStackTrace();
        }
        total_field.setText(String.valueOf(totalP));
        info_id.setText(cid);
        info_name.setText(name);
        info_gender.setText(gender);
        info_phone.setText(phone);
        info_email.setText(email);
        info_address.setText(address);
        
        info_flightID.setText(fid);
        info_dd.setText(ddate);
        info_ad.setText(adate);
        info_da.setText(dair);
        info_aa.setText(aair);
        info_seats.setText(seats);
     
            alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Successfully Selected");
            alert.showAndWait();    
        }
        
    }
    
    public void bookingCusReset(){
        cust_id.getSelectionModel().clearSelection();
        cust_name.setText("");
        cust_gender.setText("");
        cust_mail.setText("");
        cust_phone.setText("");
        cust_address.setText("");
    }
    
     public void PayButton(){
        
        String fid = (String) flight_id.getSelectionModel().getSelectedItem();
        String cid =info_id.getText();
        String booked_seats = cust_seats.getText();
        Double total_amount = totalP;
        
        String sqlQuery = "SELECT MAX(booking_id) AS max_id FROM bookings";
        String sql1 = "SELECT * FROM flights WHERE flight_id ='"+fid+"'";
        String sql2 = "INSERT INTO bookings(booking_id, flight_id, cust_id, booked_seats, total_amount, booking_date) VALUES(?,?,?,?,?,?)";
          try{
            
            PreparedStatement ps,ps1;
            ResultSet rs,rs1;
            
                connect = database01.connectDatabase01();        
                prepare = connect.prepareStatement(sqlQuery);
                ps      = connect.prepareStatement(sql1);
                ps1     =connect.prepareStatement(sql2);
                result = prepare.executeQuery();
                rs      = ps.executeQuery();

                int maxBookingID = 0; // Variable to store the maximum booking_id

                // Retrieve the maximum booking_id value from the ResultSet
                if (result.next()) {
                    maxBookingID = result.getInt("max_id");
                }
                int airline_id = 0;
                
                if (rs.next())  {
                    airline_id = rs.getInt("airline_id");
                }
                
                System.out.println("Airline ID: " + airline_id);
                    // Use the maxBookingID variable as needed
              
                
                int newBID = maxBookingID + 1;
                  System.out.println("Maximum Booking ID: " +newBID);
                  
                ps1.setInt(1, newBID);
                ps1.setInt(2, Integer.parseInt(fid));
                ps1.setInt(3, Integer.parseInt(cid));
                ps1.setInt(4, Integer.parseInt(booked_seats));
                ps1.setDouble(5, total_amount);
                ps1.setDate(6, Date.valueOf(java.time.LocalDate.now()));
             
                
               int rowsAffected = ps1.executeUpdate();
                if (rowsAffected > 0) {
            // Show success message
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Success");
                    alert.setHeaderText("Data Inserted Successfully");
                    alert.setContentText("The data has been inserted into the database.");
                    alert.showAndWait();
                }
                
                rs.close();
                ps.close();
                result.close();
                prepare.close();
                ps1.close();
            } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
   
     public ObservableList<BookingData> bookingDataList(){
        
        ObservableList<BookingData> bookingList = FXCollections.observableArrayList();
        
        String sql = "SELECT b.booking_id, b.flight_id, b.cust_id, c.cust_name, c.cust_phone, b.booked_seats, b.total_amount, b.booking_date FROM bookings b JOIN customers c ON b.cust_id = c.cust_id";
        
        connect = database01.connectDatabase01();
        
        try{
            
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            BookingData BookD;
            
            while(result.next()){
                
                BookD = new BookingData(
                        result.getInt("booking_id")
                        , result.getInt("flight_id")
                        , result.getInt("cust_id")
                        , result.getString("cust_name")
                        , result.getString("cust_phone")
                        , result.getInt("booked_seats")
                        , result.getDouble("total_amount")
                        , result.getDate("booking_date"));
                
                bookingList.add(BookD);
                
            }
            
        }catch(Exception e){e.printStackTrace();}
        return bookingList;
    }
   
      private ObservableList<BookingData> bookingDataL;
    public void bookingShowDataList(){
        
        bookingDataL = bookingDataList();
        
        BID_booking.setCellValueFactory(new PropertyValueFactory<>("booking_id"));
        FID_booking.setCellValueFactory(new PropertyValueFactory<>("flight_id"));
        CID_booking.setCellValueFactory(new PropertyValueFactory<>("cust_id"));
        name_booking.setCellValueFactory(new PropertyValueFactory<>("cust_name"));
        phone_booking.setCellValueFactory(new PropertyValueFactory<>("cust_phone"));
        seat_booking.setCellValueFactory(new PropertyValueFactory<>("booked_seats"));
        amount_booking.setCellValueFactory(new PropertyValueFactory<>("total_amount"));
        date_booking.setCellValueFactory(new PropertyValueFactory<>("booking_date"));
       
        bookingtableView.setItems(bookingDataL);
        
    }
    
    public void bookingSearch(){
        
        FilteredList<BookingData> filter = new FilteredList<>(bookingDataL, e-> true);
        
        Booking_search.textProperty().addListener((Observable, oldValue, newValue) ->{
            
            filter.setPredicate(predicateBookingData ->{
                
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                
                String searchKey = newValue.toLowerCase();
                
                if(predicateBookingData.getBooking_id().toString().equals(searchKey)){
                    return true;
                }else if(predicateBookingData.getFlight_id().toString().contains(searchKey)){
                    return false;
                }else if(predicateBookingData.getCust_id().toString().contains(searchKey)){
                    return false;
                }else if(predicateBookingData.getCust_name().toLowerCase().contains(searchKey)){
                    return true;
                }else if(predicateBookingData.getCust_phone().toLowerCase().contains(searchKey)){
                    return false;
                }else if(predicateBookingData. getBooked_seats().toString().contains(searchKey)){
                    return false;
                }else if(predicateBookingData. getTotal_amount().toString().contains(searchKey)){
                    return false;
                }else if(predicateBookingData. getBooking_date().toString().contains(searchKey)){
                    return false;
                }else return false;
                
            });
        });
        
        SortedList<BookingData> sortList = new SortedList<>(filter);
        
        sortList.comparatorProperty().bind(bookingtableView.comparatorProperty());
        bookingtableView.setItems(sortList);
    }
     
    
    public void close() {
        System.exit(0);
    }
    
    public void minimize() {
        Stage stage = (Stage)main_form.getScene().getWindow();
        stage.setIconified(true);
    }
    public void initialize(URL url, ResourceBundle resource) {
        account();
        
        availableShowFlightData();
         FlightSelectBtn01();
         FlightIDList();
         checkBtnFunc();
         bookingCusReset();
         CustIDList();
          bookingCusSelect();
          PayButton();
        dashboardDisplayAB();
        dashboardDisplayIT();
        dashboardDisplayTI();
        dashboardChart();
       
       
        bookingShowDataList();
    }
   
}