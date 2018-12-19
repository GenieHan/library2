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
    private String matg;
    private String tacgia;
    private String nhaxuatban;
    private String namxuatban;
    private String theloai;
    private int soluong;

    public sach(String masach, String tensach, String tacgia, String nhaxuatban, String namxuatban, String theloai, int soluong) {
        this.masach = masach;
        this.tensach = tensach;
        this.tacgia = tacgia;
        this.nhaxuatban = nhaxuatban;
        this.namxuatban = namxuatban;
        this.theloai = theloai;
        this.soluong = soluong;
    }

    public sach() {
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
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

    public String getMatg() {
        return matg;
    }

    public void setMatg(String matg) {
        this.matg = matg;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("---NHẬP THÔNG TIN SÁCH---");
        System.out.print("\t Nhập mã sách: ");
        masach = sc.nextLine();
        System.out.print("\t Nhập tên sách: ");
        tensach = sc.nextLine();
        System.out.print("\t Nhập mã tác giả: ");
        matg = sc.nextLine();
        System.out.print("\t Nhập tên tác giả: ");
        tacgia = sc.nextLine();
        System.out.print("\t Nhập thể loại: ");
        theloai = sc.nextLine();
        System.out.print("\t Nhập nhà xuất bản: ");
        nhaxuatban = sc.nextLine();
        System.out.print("\t Nhập năm xuất bản: ");
        namxuatban = sc.nextLine();
        System.out.print("\t Nhập số lượng: ");
        soluong = sc.nextInt();

    }

    @Override
    public String toString() {
        return this.masach + "-" + this.tensach;
    }

    public boolean checkma(String a) {
        boolean flag = true;
        for (int i = 0; i < 10; i++) {

        }
        return flag;
    }

    public void hienthi() {
       System.out.printf("%-15s%-40s%-30s%-25s%-15s%-20s\n",this.masach,this.tensach,this.tacgia,this.nhaxuatban,this.namxuatban,this.theloai);
//
//        System.out.println("\t -Mã sách: " + this.masach);
//        System.out.println("\t -Tên sách: " + this.tensach);
//        System.out.println("\t -Tác giả: " + this.tacgia);
//        System.out.println("\t -Nhà xuất bản: " + this.nhaxuatban);
//       System.out.println("\t -Năm xuất bản: " + this.namxuatban);
//       System.out.println("\t -Thể loại: " + this.theloai);
    }
}
