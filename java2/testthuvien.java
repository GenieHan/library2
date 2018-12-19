/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thuvien1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author MyPC
 */
public class testthuvien {
    static testketnoi kn=new testketnoi();
    public static void main(String[] args) {
        Connection cn=kn.gettestketnoi();
        Statement stm = null;
        ResultSet rs = null;
        String sql="select * from nhanvien";
        try{
        stm=cn.createStatement();
        rs=stm.executeQuery(sql);
        while(rs.next()){
        System.out.println("id: "+rs.getString(1)+"\tname: "+rs.getString(2)  );
        }
        } catch(Exception e) {
            System.out.println("loi gi do roi");
        }
   }
}
