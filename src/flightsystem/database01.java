/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightsystem;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ASUS
 */
public class database01 {
    public static Connection connectDatabase01(){
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/flight_manage_WB", "root", "orcl");
            return connect;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
