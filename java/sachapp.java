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
public class sachapp {


    Scanner sc = new Scanner(System.in);
    ArrayList<sach> listS = new ArrayList<>();

    public void showAll() {
        for (int i = 0; i < listS.size(); i++) {
            System.out.println("Thông tin bạn đọc thứ " + (i + 1));
            listS.get(i).hienthi();
        }
    }

    public void menu() {
        int func;
        System.out.println(" _______________QUẢN LÍ SÁCH__________________");
        System.out.println("|   1.Danh sách các sách hiện có              |");
        System.out.println("|   2.Thêm 1 sách                             |");
        System.out.println("|   3.Xóa 1 sách                              |");
        System.out.println("|   4.Sửa 1 sách                              |");
        System.out.println("|   5.Tìm kiếm 1 sách                         |");
        System.out.println("|   0.Quay lại                                |");
        System.out.println("|_____________________________________________|");
        Scanner sc = new Scanner(System.in);
        System.err.print("Nhập lựa chọn:");
        func = sc.nextInt();
        System.out.println("\n");
        switch (func) {
            case 1 :
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
    }

    public void them() {
        sach s = new sach();
        s.nhap();
        listS.add(s);
        System.out.println("Thêm thành công.!");
    }

  public  void xoa() {
        int index = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã sách cần xóa: ");
        String a = sc.nextLine();
        int flag = 0;
        for (int i = 0; i < listS.size(); i++) {
            if (listS.get(i).getMasach().equalsIgnoreCase(a) == true) {
                index = i;
                flag = 1;

            }
        }
        if (flag == 1) {
            System.out.println("Thông tin sách cần xóa");
            listS.get(index).hienthi();
            listS.remove(index);
            System.out.println("Bạn đã xóa thành công ^^ !");
        } else {
            System.out.println("không có mã sách nào.!");
        }
    }

    void sua() {
        int index = 0;
        sach s = new sach();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã sách cần sửa: ");
        String a = sc.nextLine();
        int flag = 0;
        for (int i = 0; i < listS.size(); i++) {
            if (listS.get(i).getMasach().equalsIgnoreCase(a) == true) {
                index = i;
                flag = 1;
            }
        }
        if (flag == 1) {
            System.out.println("Thông tin sách bạn muốn sửa.");
            listS.get(index).hienthi();
            nhanvien kh = new nhanvien();
            System.out.println("Nhập thông tin mới cho sách");
            s.nhap();
            listS.remove(index);
            listS.add(index, s);
            System.out.println("Bạn đã sửa thành công .!");
        } else {
            System.out.println("Không có mã sách nào .!");
        }
    }
  public boolean checkma(String a){
   boolean flag = false;
        for (int i = 0; i < listS.size(); i++) {
            if (listS.get(i).getMasach().equalsIgnoreCase(a) == true) {
                flag = true;            
            }
        }
   return  flag;
   }
    public void timkiem() {
        int index = 0;
        System.out.print("Nhập mã sách cần tìm: ");
        String a = sc.nextLine();
        int flag = 0;
        for (int i = 0; i < listS.size(); i++) {
            if (listS.get(i).getMasach().equalsIgnoreCase(a) == true) {
                flag = 1;
                index = 1;
            }
        }
        if (flag == 1) {
            System.out.println("Thông tin sách bạn muốn tìm.");
            listS.get(index).hienthi();
        } else {
            System.out.println("Không có mã sách nào .!");
        }
    }
    
}


