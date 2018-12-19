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
public class QLTV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        nhanvienapp nvapp = new nhanvienapp();
        sachapp sapp = new sachapp();
        bandocapp bdapp = new bandocapp();
        muontrasach mt = new muontrasach();
        int func = 0;
        if(nvapp.DangNhap()){
        do {
            Scanner sc = new Scanner(System.in);

            //System.out.println(" ________________________________________________________");
            System.out.println(" _________________QUẢN LÍ THƯ VIỆN_______________________");
            System.out.println("|________________________MENU____________________________|");
            System.out.println("|     1.QUẢN LÍ SÁCH                                     |");
            System.out.println("|     2.QUẢN LÍ BẠN ĐỌC                                  |");
            System.out.println("|     3.QUẢN LÍ MƯỢN SÁCH                                |");
            System.out.println("|     4.QUẢN LÍ TRẢ SÁCH                                 |");
            System.out.println("|     5.TRA THÔNG TIN PHIẾU MƯỢN                         |");
            System.out.println("|     6.QUẢN LÍ NHÂN VIÊN                                |");
            System.out.println("|     0.EXIT                                             |");
            System.out.println("|________________________________________________________|");
            System.err.print("Mời bạn nhập lựa chọn: ");
            func = sc.nextInt();
            switch (func) {
                case 1:
                    sapp.menu();
                    break;
                case 2:
                    bdapp.menu();
                    break;
                case 3:

                    mt.muonsach();
                    break;
                case 4:
                    mt.trasach();
                    break;
                case 5:
                    String a;
                    sc = new Scanner(System.in);
                    System.out.print("\t-Nhập mã bạn đọc:");
                    a = sc.nextLine();
                    if ((bdapp.checkma(a) == false)) {
                        do {
                            System.err.print("Mã không tồn tại xin nhập lại:");
                            a = sc.nextLine();
                        } while (bdapp.checkma(a) == false);
                    }
                    mt.trathongtinphieumuon(a);
                    break;
                case 6:
                    nvapp.menu();
                    break;

                default:
                    break;
            }
        } while (func == 1 || func == 2 || func == 3 || func == 4 || func == 5 || func == 6);
    }
    }
}
