/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qltv;

import java.util.Scanner;

/**
 *
 * @author TranQuangHuy
 */
public class sach {
    private String masach;
    private String tensach;
    private String tacgia;
    private String nhaxuatban;
    private String namxuatban;
    private String theloai;
    private String trangthai;

    public sach(String masach, String tensach, String tacgia, String nhaxuatban, String namxuatban, String theloai, String trangthai) {
        this.masach = masach;
        this.tensach = tensach;
        this.tacgia = tacgia;
        this.nhaxuatban = nhaxuatban;
        this.namxuatban = namxuatban;
        this.theloai = theloai;
        this.trangthai = trangthai;
    }
    

    public sach(String masach, String tensach, String tacgia, String nhaxuatban, String namxuatban, String theloai) {
        this.masach = masach;
        this.tensach = tensach;
        this.tacgia = tacgia;
        this.nhaxuatban = nhaxuatban;
        this.namxuatban = namxuatban;
        this.theloai = theloai;
    }

    public sach() {
    }

    public sach(String masach, String tensach, String nhaxuatban, String namxuatban, String theloai) {
        this.masach = masach;
        this.tensach = tensach;
        this.nhaxuatban = nhaxuatban;
        this.namxuatban = namxuatban;
        this.theloai = theloai;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

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

    public String getNhaxuatban() {
        return nhaxuatban;
    }

    public void setNhaxuatban(String nhaxuatban) {
        this.nhaxuatban = nhaxuatban;
    }

    public String getNamxuatban() {
        return namxuatban;
    }

    public void setNamxuatban(String namxuatban) {
        this.namxuatban = namxuatban;
    }

    public String getTheloai() {
        return theloai;
    }

    public void setTheloai(String theloai) {
        this.theloai = theloai;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }
    
   public void nhap(){
           Scanner sc = new Scanner(System.in);
        System.out.println("---NHẬP THÔNG TIN SÁCH---");
        System.out.print("\t Nhập mã sách: ");
        masach = sc.nextLine();
        System.out.print("\t Nhập tên sách: ");
        tensach = sc.nextLine();        
        System.out.print("\t Nhập tác giả: ");
        tacgia = sc.nextLine();   
        System.out.print("\t Nhập nhà xuất bản: ");
        nhaxuatban = sc.nextLine();       
        System.out.print("\t Nhập năm xuất bản: ");
        namxuatban = sc.nextLine();       
        System.out.print("\t Nhập thể loại: ");
        theloai = sc.nextLine();
        
   }
    @Override
    public String toString() {
        return this.masach + "-" + this.tensach;
    }
   public boolean checkma(String a){
   boolean flag = true;
        for (int i = 0; i < 10; i++) {
           
       }
   return  flag;
   }
   public void hienthi(){
       System.out.println("\t -Mã sách: "+ this.masach);
        System.out.println("\t -Tên sách: "+this.tensach);
        System.out.println("\t -Tác giả: "+this.tacgia);
        System.out.println("\t -Nhà xuất bản: " + this.nhaxuatban);
        System.out.println("\t -Năm xuất bản: " + this.namxuatban);
        System.out.println("\t -Thể loại: " + this.theloai);
   }
}
