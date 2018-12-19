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
public class nhanvien {
    nhanvienapp nvapp  =new nhanvienapp();
    private String manv;
    private String tennv;
    private String chucvu;
    private String ngaysinh;
    private String diachi;
    private String matkhau;

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }


    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public nhanvien() {
    }

    public nhanvien(String manv, String tennv, String chucvu, String ngaysinh, String diachi, String matkhau) {
        this.manv = manv;
        this.tennv = tennv;
        this.chucvu = chucvu;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.matkhau = matkhau;
    }

    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập thông tin nhân viên:");
        System.out.print("\t-Mã nhân viên:");
        this.manv = sc.nextLine();
        if((nvapp.checkma(manv)==true)){
        do{  
            System.out.print("Mã đã tồn tại xin nhập lại:");
            this.manv = sc.nextLine();       
        }while(nvapp.checkma(manv)==true);
        }
        System.out.print("\t-Tên nhân viên:");
        this.tennv = sc.nextLine();
        System.out.print("\t-Ngày sinh:");
        this.ngaysinh = sc.nextLine();
        System.out.print("\t-Chức vụ:");
        this.chucvu = sc.nextLine();
        System.out.print("\t-Địa chỉ:");
        this.diachi = sc.nextLine();
        System.out.print("\t-Password:");
        this.matkhau = sc.nextLine();
    }
    
    public void hienthi(){
        System.out.printf("%-10s%-30s%-20s%-15s%-15s\n",this.manv,this.tennv,this.ngaysinh,this.diachi,this.chucvu);
//        System.out.println("\t -Mã: "+ this.manv);
//        System.out.println("\t -Tên: "+this.tennv);
//        System.out.println("\t -Ngày sinh: "+this.ngaysinh);
//        System.out.println("\t -Chức vụ: "+this.chucvu);
//        System.out.println("\t -Địa chỉ: " + this.diachi);
    }
}
