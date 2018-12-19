/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qltv;

import java.io.PrintStream;

/**
 *
 * @author TranQuangHuy
 */
public class sachmuon {
    private  String masach;
    private  String tensach;
    private  String ngaymuon;

    public String getMasach() {
        return masach;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public String getNgaymuon() {
        return ngaymuon;
    }

    public void setNgaymuon(String ngaymuon) {
        this.ngaymuon = ngaymuon;
    }
    void intt(){
     System.out.printf("\n%-10s%-40s%-20s",masach, tensach, ngaymuon);
    
    }
    
}
