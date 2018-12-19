/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qltv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TranQuangHuy
 */
public class ketnoi {  
    Connection cnn=null;
    public Connection gettestketnoi(){
    try{
    String uRL = ("jdbc:sqlserver://;databaseName=QLTV");
    String user = ("sa");
    String pass = ("123");
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    cnn = DriverManager.getConnection(uRL,user,pass);
    //System.out.println("thanh cong");
    } catch(Exception e){
    System.out.println("ket noi that bai");
    }
    return cnn;
    }
   
}
