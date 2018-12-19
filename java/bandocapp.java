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
public class bandocapp {

    Scanner sc = new Scanner(System.in);
    ArrayList<bandoc> listBD = new ArrayList<>();

    public void showAll() {
        for (int i = 0; i < listBD.size(); i++) {
            System.out.println("Thông tin bạn đọc thứ " + (i + 1));
            listBD.get(i).hienthi();
        }
    }

    public void menu() {
        System.out.println(" ________________QUẢN LÍ BẠN ĐỌC__________________");
        System.out.println("|   1.Danh sách bạn đọc                           |");
        System.out.println("|   2.Thêm 1 bạn đọc                              |");
        System.out.println("|   3.Xóa 1 bạn đọc                               |");
        System.out.println("|   4.Sửa 1 bạn đọc                               |");
        System.out.println("|   5.Tìm kiếm 1 bạn đọc                          |");
        System.out.println("|   0.Quay lại                                    |");
        System.out.println("|_________________________________________________|");
        bandocapp bdapp = new bandocapp();
        int func;       
        Scanner sc = new Scanner(System.in);
        System.err.print("Nhập lựa chọn: ");
        func = sc.nextInt();
        System.out.println("\n");
        switch (func) {
            case 1:
                bdapp.showAll();
                break;
            case 2:
                bdapp.them();
                break;
            case 3:
                bdapp.xoa();
                break;
            case 4:
                bdapp.sua();
                break;
            case 5:
                bdapp.timkiem();
                break;
            default:
                break;

        }
    }

    void them() {
        bandoc bd = new bandoc();
        bd.nhap();
        listBD.add(bd);
    }

    void xoa() {
        int index = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã bạn đọc cần xóa: ");
        String a = sc.nextLine();
        int flag = 0;
        for (int i = 0; i < listBD.size(); i++) {
            if (listBD.get(i).getMabandoc().equalsIgnoreCase(a) == true) {
                index = i;
                flag = 1;

            }
        }
        if (flag == 1) {
            System.out.println("Thông tin bạn đọc cần xóa");
            listBD.get(index).hienthi();
            listBD.remove(index);
            System.out.println("Bạn đã xóa thành công ^^ !");
        } else {
            System.out.println("không có mã bạn đọc nào.!");
        }
    }

    void sua() {
        int index = 0;
        bandoc bd = new bandoc();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã bạn đọc cần sửa: ");
        String a = sc.nextLine();
        int flag = 0;
        for (int i = 0; i < listBD.size(); i++) {
            if (listBD.get(i).getMabandoc().equalsIgnoreCase(a) == true) {
                index = i;
                flag = 1;
            }
        }
        if (flag == 1) {
            System.out.println("Thông tin nhân viên bạn muốn sửa.");
            listBD.get(index).hienthi();
            nhanvien kh = new nhanvien();
            System.out.println("Nhập thông tin mới cho nhân viên");
            bd.nhap();
            listBD.remove(index);
            listBD.add(index, bd);
            System.out.println("Bạn đã sửa thành công .!");
        } else {
            System.out.println("Không có mã bạn đọc nào .!");
        }
    }

    public void timkiem() {
        int index = 0;
        System.out.print("Nhập mã bạn đọc cần sửa: ");
        String a = sc.nextLine();
        int flag = 0;
        for (int i = 0; i < listBD.size(); i++) {
            if (listBD.get(i).getMabandoc().equalsIgnoreCase(a) == true) {
                flag = 1;
                index = 1;
            }
        }
        if (flag == 1) {
            System.out.println("Thông tin bạn dọc bạn muốn tìm.");
            listBD.get(index).hienthi();
        } else {
            System.out.println("Không có mã bạn đọc nào .!");
        }
    }
}
