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
public class menu {

    public void menu() {
        System.out.println(" ________________________________________________________");
        System.out.println("|______________________QUẢN LÍ THƯ VIỆN__________________|");
        System.out.println("|_________________________MENU___________________________|");
        System.out.println("                    1.QUẢN LÍ NHÂN VIÊN");
        System.out.println("                    2.QUẢN LÍ NHÂN SÁCH");
        System.out.println("                    3.QUẢN LÍ NHÂN BẠN ĐỌC");
        System.out.println("                    4.QUẢN LÍ NHÂN PHIẾU MƯỢN");
        System.out.println("                    0.EXIT");
        System.err.print("Mời bạn nhập lựa chọn: ");

    }

    public void menu1() {
        int func;
        System.out.println("|______________________QUẢN LÍ NHÂN VIÊN__________________|");
        System.out.println("1.Thêm 1 nhân viên");
        System.out.println("2.Xóa 1 nhân viên");
        System.out.println("3.Sửa 1 nhân viên");
        System.out.println("4.Tìm kiếm 1 nhân viên");
        System.out.println("0.Quay lại");
        Scanner sc = new Scanner(System.in);
        nhanvienapp nvapp = new nhanvienapp();
        func = sc.nextInt();
        switch (func) {
            case 1:
                nvapp.them();
                break;
            case 2:
                nvapp.xoa();
                break;
            case 3:
                nvapp.sua();
                break;
            case 4:
                nvapp.timkiem();
                break;
            default:

        }
    }

    public void menu2() {
        int func;
        System.out.println("|______________________QUẢN LÍ SÁCH__________________|");
        System.out.println("1.Thêm 1 sách");
        System.out.println("2.Xóa 1 sách");
        System.out.println("3.Sửa 1 sách");
        System.out.println("4.Tìm kiếm 1 sách");
        System.out.println("0.Quay lại");
        Scanner sc = new Scanner(System.in);
        func = sc.nextInt();
        switch (func) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            default:

        }
    }

    public void menu3() {
        System.out.println("|______________________QUẢN LÍ BẠN ĐỌC__________________|");
        System.out.println("1.Thêm 1 bạn đọc");
        System.out.println("2.Xóa 1 bạn đọc");
        System.out.println("3.Sửa 1 bạn đọc");
        System.out.println("4.Tìm kiếm 1 bạn đọc");
        System.out.println("0.Quay lại");
        bandocapp bdapp = new bandocapp();
        int func;
        Scanner sc = new Scanner(System.in);
        func = sc.nextInt();
        switch (func) {
            case 1:
                bdapp.them();
                break;
            case 2:
                bdapp.xoa();
                break;
            case 3:
                bdapp.sua();
                break;
            case 4:
                bdapp.timkiem();
                break;
            default:
                break;

        }
    }

    public void menu4() {
        int func;
        System.out.println("|______________________QUẢN LÍ PHIẾU MƯỢN__________________|");
        System.out.println("1.Mượn sách");
        System.out.println("2.Trả sách");
        System.out.println("4.Tra cứu 1 phiếu mượn");
        System.out.println("0.Quay lại");

        Scanner sc = new Scanner(System.in);
        func = sc.nextInt();
        switch (func) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            default:

        }
    }

}
