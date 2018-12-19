/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qltv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author TranQuangHuy
 */
public class testketnoi {
    public Connection gettestketnoi(){
        Connection cnn=null;
    try{
    String uRL = ("jdbc:sqlserver://;databaseName=QLTV");
    String user = ("sa");
    String pass = ("123");
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    cnn = DriverManager.getConnection(uRL,user,pass);
    System.out.println("thanh cong");
    } catch(Exception e){
    System.out.println("ket noi that bai");
    }
    return cnn;
    }
   
    public static void main(String[] args) { 
      ArrayList<nhanvien> listNV = new ArrayList<>(); 
        Connection cnn = null;
        testketnoi kn=new testketnoi();
        cnn=kn.gettestketnoi();
        ResultSet rs = null;
        String sql="select * from nhanvien";
        try{ 
        PreparedStatement ps = cnn.prepareCall(sql);
        rs = ps.executeQuery();
        while(rs.next()){
            nhanvien nv = new nhanvien();
            nv.setManv(rs.getString("manv"));
            nv.setTennv(rs.getString("tennv"));
            nv.setNgaysinh(rs.getString("ngaysinh"));
           nv.setChucvu(rs.getString("chucvu"));
           nv.setDiachi(rs.getString("diachi"));
           nv.setMatkhau(rs.getString("matkhau"));
        listNV.add(nv);
       
        }
        } catch(Exception e) {
            System.out.println("loi gi do roi");
        }
        for (int i = 0; i < listNV.size(); i++) {
            listNV.get(i).hienthi();
        }
}
}

