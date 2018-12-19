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
public class nhanvienapp {

    Scanner sc = new Scanner(System.in);
    ArrayList<nhanvien> listNV = new ArrayList<>();
    
public void menu() {
        int func;
        do{
        System.out.println(" ________________QUẢN LÍ NHÂN VIÊN__________________");
        System.out.println("|   1.Danh sách nhân viên                           |");
        System.out.println("|   2.Thêm 1 nhân viên                              |");
        System.out.println("|   3.Xóa 1 nhân viên                               |");
        System.out.println("|   4.Sửa 1 nhân viên                               |");
        System.out.println("|   5.Tìm kiếm 1 nhân viên                          |");
        System.out.println("|   0.Quay lại                                      |");
        System.out.println("|___________________________________________________|");
        Scanner sc = new Scanner(System.in);
        nhanvienapp nvapp = new nhanvienapp();
          System.err.print("Nhập lựa chọn: ");
        func = sc.nextInt();
        switch (func) {
            case 1:
                this.showAll();
                break;
            case 2:
                this.them();
                break;
            case 3:
                this.xoa();
                break;
            case 4:
                this.sua();
                break;
            case 5:
                this.timkiem();
                break;
            default:

        }
    }while(func !=0);
}
 public void showAll() {
        for (int i = 0; i < listNV.size(); i++) {
            System.out.println("Thông tin nhân viên thứ " + (i + 1));
            listNV.get(i).hienthi();
        }
    }
      
   public void them() {
        nhanvien nv = new nhanvien();
        nv.nhap();
        listNV.add(nv);
        System.out.println("Bạn đã thêm thành công ^^ !");

    }

   public void xoa() {
        int index = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã nhân viên cần xóa: ");
        String a = sc.nextLine();
        int flag = 0;
        for (int i = 0; i < listNV.size(); i++) {
            if (listNV.get(i).getId().equalsIgnoreCase(a) == true) {
                index = i;
                flag = 1;

            }
        }
        if (flag == 1) {
            System.out.println("Thông tin nhân viên cần xóa");
            listNV.get(index).hienthi();
            listNV.remove(index);
            System.out.println("Bạn đã xóa thành công ^^ !");
        } else {
            System.out.println("không có mã nhân viên nào.!");
        }
    }

 public   void sua() {
        int index = 0;
        nhanvien nv = new nhanvien();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã nhân viên cần sửa: ");
        String a = sc.nextLine();
        int flag = 0;
        for (int i = 0; i < listNV.size(); i++) {
            if (listNV.get(i).getId().equalsIgnoreCase(a) == true) {
                index = i;
                flag = 1;
            }
        }
        if (flag == 1) {
            System.out.println("Thông tin nhân viên bạn muốn sửa.");
            listNV.get(index).hienthi();
            nhanvien kh = new nhanvien();
            System.out.println("Nhập thông tin mới cho nhân viên");
            nv.nhap();
            listNV.remove(index);
            listNV.add(index, kh);
            System.out.println("Bạn đã sửa thành công .!");
        } else {
            System.out.println("Không có mã nhân viên nào .!");
        }
    }
        public void timkiem(){
        int index = 0;
        System.out.print("Nhập mã bạn đọc cần tìm: ");
        String a = sc.nextLine();
        int flag = 0;
        for (int i = 0; i < listNV.size(); i++) {
            if (listNV.get(i).getId().equalsIgnoreCase(a) == true) {               
                flag = 1;
                index = 1;
            }
        }
         if (flag == 1) {
            System.out.println("Thông tin bạn dọc bạn muốn tìm.");
            listNV.get(index).hienthi();
        } else {
            System.out.println("Không có mã bạn đọc nào .!");
        }
    }
}
