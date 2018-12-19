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
        Scanner sc = new Scanner(System.in);
          int func  = 0 ;   
          nhanvienapp nvapp = new nhanvienapp(); 
          sachapp sapp = new sachapp();
          bandocapp bdapp = new bandocapp();
          muontrasach mt = new muontrasach();
      do{
        //System.out.println(" ________________________________________________________");
        System.out.println(" _________________QUẢN LÍ THƯ VIỆN_______________________");
        System.out.println("|________________________MENU____________________________|");
        System.out.println("|     1.QUẢN LÍ NHÂN VIÊN                                |");                           
        System.out.println("|     2.QUẢN LÍ SÁCH                                     |");
        System.out.println("|     3.QUẢN LÍ BẠN ĐỌC                                  |");
        System.out.println("|     4.QUẢN LÍ MƯỢN SÁCH                                |");
        System.out.println("|     5.QUẢN LÍ TRẢ SÁCH                                 |");
        System.out.println("|     0.EXIT                                             |");
        System.out.println("|________________________________________________________|");
        System.err.print("Mời bạn nhập lựa chọn: ");   
        func = sc.nextInt();   
        switch (func) {
            case 1:                
                nvapp.menu();
                break;
            case 2:               
                sapp.menu();
                 break;
            case 3:                
                bdapp.menu();
                break;
            case 4:
                mt.muonsach();
                break;
            default:
                break;
        } 
      }while(func != 0);
    }
}
