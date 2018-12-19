/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qltv;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author TranQuangHuy
 */
public class muontrasach {

    private String mathe;
    private String mabandoc;
    private String hoten;
    private int soluong;
    private String ngaymuon;

    ArrayList<sach> listS = new ArrayList<>();

    public void muonsach() {
        sachapp sapp = new sachapp();
        Scanner sc = new Scanner(System.in);
        System.out.print("\t-Nhập mã thẻ: ");
        mathe = sc.nextLine();
        System.out.print("\t-Nhập mã bạn đọc: ");
        mathe = sc.nextLine();
        System.out.print("\t-Nhập họ tên: ");
        mathe = sc.nextLine();
        System.out.print("\t-Nhập ngày mượn: ");
        ngaymuon = sc.nextLine();
        System.out.print("\t-Nhập số lượng sách muốn mượn: ");
        soluong = sc.nextInt();

        for (int i = 1; i <= soluong; i++) {
            sc = new Scanner(System.in);
            String b = "";
            sach s = new sach();
            System.out.print("Nhập mã sách thứ " + (i) + ": ");
                b = sc.nextLine();
                if(sapp.checkma(b)){ 
                    listS.add(s);              
                  System.out.println("Thêm thành công");           
                    } else {
                        System.out.println("Mã sách bạn nhập không đúng.");
                    }
                }
            }
        

    public void hienthi() {
        System.out.println("\t-Mã thẻ: " + mathe);
        System.out.println("\t-Mã bạn đọc: " + mabandoc);
        System.out.println("\t-Họ tên: " + hoten);
        System.out.println("\t-số lượng: " + mathe);
        System.out.println("\t-Mã thẻ: " + mathe);
    }
}
