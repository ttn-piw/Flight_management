/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flightsystem;

import static flightsystem.User.user;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button loginBtn;

    @FXML
    private Hyperlink signin_Createacc;

    @FXML
    private Button signin_close;

    @FXML
    private Button signup_close;

    @FXML
    private TextField signin_email;

    @FXML
    private AnchorPane signin_form;

    @FXML
    private TextField signup_id;

    @FXML
    private PasswordField signin_password;

    @FXML
    private Button signupBtn;

    @FXML
    private TextField signup_address;

    @FXML
    private Hyperlink signup_already;

    @FXML
    private TextField signup_email;

    @FXML
    private AnchorPane signup_form;

    @FXML
    private TextField signup_name;

    @FXML
    private PasswordField signup_password;
    
    @FXML
    private ComboBox signup_gender;

    @FXML
    private TextField signup_phone;

    @FXML
    void BT_Gender(ActionEvent event){
        ObservableList<String> genders = FXCollections.observableArrayList("Male","Female","Others");
        signup_gender.setItems(genders);
    }
    @FXML
    void switchForm(ActionEvent event) {
        if(event.getSource() == signin_Createacc){
            
            signup_form.setVisible(true);
            signin_form.setVisible(false);
            
            signup_name.setText("");
            signup_email.setText("");
            signup_phone.setText("");
            signup_address.setText("");

            
        }else if(event.getSource() == signup_already){
            
            signin_form.setVisible(true);
            signup_form.setVisible(false);
            
            signin_email.setText("");
            signin_password.setText("");
            
        }
    }
    
    private Connection connect;
    private PreparedStatement prepare, ps;
    private Statement statement;
    private ResultSet result;
    private double x = 0;
    private double y = 0;
  
    
   public boolean validationEmail(String email) {
    // Sử dụng biểu thức chính quy để kiểm tra email có đúng dạng abc@gmail.com
    Pattern pattern = Pattern.compile("[a-zA-Z0-9]+@gmail.com");
    Matcher match = pattern.matcher(email);
    return match.matches();
}



public void signup() {
    String sql = "INSERT INTO customers  VALUES (?,?,?,?,?,?)";
    String sql1 = "INSERT INTO user_login  VALUES(?,?,?)";
    connect = database01.connectDatabase01();
    try {
        // Bước 1: Truy vấn giá trị maxID hiện có trong cơ sở dữ liệu
        int maxCustomerId = getMaxCustomerIdFromDatabase();
        int maxUserId = getMaxUserIdFromDatabase();

        // Bước 2: Tăng giá trị maxID lên 1 để tạo ID mới
        int newCustomerId = maxCustomerId + 1;
        int newUserId = maxUserId + 1;

        prepare = connect.prepareStatement(sql);
        prepare.setInt(1, newCustomerId);
        prepare.setString(2, signup_name.getText());
        prepare.setString(3, (String) signup_gender.getSelectionModel().getSelectedItem());
        
        String email = signup_email.getText();
        if (!validationEmail(email)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Invalid Email. Email must be in the right format");
            alert.showAndWait();
            return; // Kết thúc hàm nếu email không hợp lệ
        }

        prepare.setString(4, signup_email.getText());
        prepare.setString(5, signup_phone.getText());
        prepare.setString(6, signup_address.getText());

        ps = connect.prepareStatement(sql1);
        ps.setInt(1, newUserId);
        ps.setString(2, signup_email.getText());
        ps.setString(3, signup_password.getText());

        Alert alert;
        if (signup_email.getText().isEmpty() || signup_name.getText().isEmpty()
                || signup_phone.getText().isEmpty() || signup_address.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else if (signup_password.getText().length() < 8 ){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Invalid Password");
            alert.showAndWait();
        } else {
            prepare.execute();
            ps.execute();
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Successfully create a new account!");
            alert.showAndWait();

            signup_name.setText("");
            signup_email.setText("");
            signup_phone.setText("");
            signup_address.setText("");
            signup_password.setText("");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

// Bước 1: Truy vấn giá trị maxID cho cust_id từ cơ sở dữ liệu
private int getMaxCustomerIdFromDatabase() {
    int maxCustomerId = 0; // Giá trị mặc định nếu không tìm thấy dữ liệu

    try {
        connect = database01.connectDatabase01();
        String sql = "SELECT MAX(cust_id) FROM customers"; // Truy vấn giá trị maxID cho cust_id
        PreparedStatement preparedStatement = connect.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            maxCustomerId = resultSet.getInt(1); // Lấy giá trị maxID từ kết quả truy vấn
        }

        resultSet.close();
        preparedStatement.close();
    } catch (Exception e) {
        e.printStackTrace();
    }

    return maxCustomerId;
}

// Bước 2: Truy vấn giá trị maxID cho user_id từ cơ sở dữ liệu
private int getMaxUserIdFromDatabase() {
    int maxUserId = 0; // Giá trị mặc định nếu không tìm thấy dữ liệu

    try {
        connect = database01.connectDatabase01();
        String sql = "SELECT MAX(user_id) FROM user_login"; // Truy vấn giá trị maxID cho user_id
        PreparedStatement preparedStatement = connect.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            maxUserId = resultSet.getInt(1); // Lấy giá trị maxID từ kết quả truy vấn
        }

        resultSet.close();
        preparedStatement.close();
    } catch (Exception e) {
        e.printStackTrace();
    }

    return maxUserId;
}


public void signin() {
    String email = signin_email.getText();
    String pass = signin_password.getText();

    if (email.isEmpty() || pass.isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText("Please fill in both email and password fields");
        alert.showAndWait();
        return;
    }

    String sql = "select * from user_login where user_email = ? and password = ?";
    connect = database01.connectDatabase01();

    try {
        prepare = connect.prepareStatement(sql);
        prepare.setString(1, email);
        prepare.setString(2, pass);

        result = prepare.executeQuery();

        if (result.next()) {
            User.signin_email = result.getString("user_email");
            // Truy vấn bảng customers để lấy tên người dùng
            String customerNameQuery = "SELECT cust_name FROM customers WHERE cust_email = ?";
            PreparedStatement customerNameStatement = connect.prepareStatement(customerNameQuery);
            customerNameStatement.setString(1, User.signin_email);
            ResultSet customerNameResult = customerNameStatement.executeQuery();

            if (customerNameResult.next()) {
                User.user = customerNameResult.getString("cust_name");
            } else {
                // Xử lý trường hợp không tìm thấy tên người dùng
                User.user = "Unknown"; // Hoặc bạn có thể xử lý theo cách khác
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Login Successfully");
            alert.showAndWait();
            
            loginBtn.getScene().getWindow().hide();

            // Load the dashboard.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
            Parent root = loader.load();

            // Create a new stage for the dashboard and set the scene
            Stage dashboardStage = new Stage();
            Scene scene = new Scene(root);
            dashboardStage.setScene(scene);

            // Optional: Add functionality for dragging the undecorated stage
            root.setOnMousePressed((MouseEvent event) -> {
                x = event.getSceneX();
                y = event.getSceneY();
            });

            root.setOnMouseDragged((MouseEvent event) -> {
                dashboardStage.setX(event.getScreenX() - x);
                dashboardStage.setY(event.getScreenY() - y);
            });

            // Set stage style and show the dashboard
            dashboardStage.initStyle(StageStyle.TRANSPARENT);
            dashboardStage.show();

            // Close the current window
            Stage currentStage = (Stage) signin_email.getScene().getWindow();
            currentStage.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Wrong Email/Password");
            alert.showAndWait();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

   
    public void signIn_close() {
        System.exit(0);
    }
    
    public void signUp_close() {
        System.exit(0);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        BT_Gender(null);
    }    

  
  
}