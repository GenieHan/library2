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
public class bandoc {
    private String mabandoc;
    private String hoten;
    private String gioitinh;
    private String ngaysinh;
    private String sochungminh;
    private String diachi;
    private String email;
    private String sdt;
    private String ngaydangki;

    public bandoc() {
    }

    public bandoc(String mathe, String hoten, String gioitinh, String ngaysinh, String sochungminh, String diachi, String email, String sdt, String ngaydangki) {
        this.mabandoc = mathe;
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
        this.sochungminh = sochungminh;
        this.diachi = diachi;
        this.email = email;
        this.sdt = sdt;
        this.ngaydangki = ngaydangki;
    }

    public String getMathe() {
        return mabandoc;
    }

    public void setMathe(String mathe) {
        this.mabandoc = mathe;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getSochungminh() {
        return sochungminh;
    }

    public void setSochungminh(String sochungminh) {
        this.sochungminh = sochungminh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getNgaydangki() {
        return ngaydangki;
    }

    public void setNgaydangki(String ngaydangki) {
        this.ngaydangki = ngaydangki;
    }
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập thông tin bạn đọc:");
        System.out.print("\t-Mã:");
        this.mabandoc = sc.nextLine();
        System.out.print("\t-Tên:");
        this.hoten = sc.nextLine();
        System.out.print("\t-Ngày sinh:");
        this.ngaysinh = sc.nextLine();
        System.out.print("\t-Giới tính:");
        this.gioitinh = sc.nextLine();
        System.out.print("\t-Số CMT:");
        this.sochungminh = sc.nextLine();
        System.out.print("\t-Địa chỉ:");
        this.diachi = sc.nextLine();
        System.out.print("\t-Email:");
        this.email = sc.nextLine();
        System.out.print("\t-SDT:");
        this.sdt = sc.nextLine();
        System.out.print("\t-Ngày đăng kí:");
        this.ngaydangki = sc.nextLine();
    
    }
    public  void hienthi(){
        System.out.println("\t -Mã: "+ this.mabandoc);
        System.out.println("\t -Tên: "+this.hoten);
        System.out.println("\t -SDT: "+this.sdt);
        System.out.println("\t -Email: " + this.email);
    }

    public String getMabandoc() {
        return mabandoc;
    }

    public void setMabandoc(String mabandoc) {
        this.mabandoc = mabandoc;
    }
    
}
