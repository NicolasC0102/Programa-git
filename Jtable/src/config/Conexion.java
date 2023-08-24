/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 *
 * @author Nicol
 */
public class Conexion {
     
    Connection con;
    
    public Conexion(){
    
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/registrousuario", "root", "");
        
        } catch (ClassNotFoundException | SQLException e){
            System.err.println("Error en la conexión" + e);
        }
    }
    public Connection getConnection(){
        return con;
    }

}
