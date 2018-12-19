/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qltv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TranQuangHuy
 */
public class muontrasach {

    public void trathongtinphieumuon(String a) {
        String mabandoc = null;
        String hoten = null;
        String ngaymuon;
        ArrayList<sachmuon> list = new ArrayList<>();
        Connection cnn = null;
        ketnoi kn = new ketnoi();
        cnn = kn.gettestketnoi();
        ResultSet rs = null;
        String sql = "select BANDOC.mabandoc,BANDOC.hoten,SACH.masach,SACH.tensach,MUONSACH.ngaymuon"
                + " from BANDOC,SACH,MUONSACH where "
                + "BANDOC.mabandoc=MUONSACH.mabandoc and sach.masach = muonsach.masach and BANDOC.mabandoc = '" + a + "'";
        try {
            PreparedStatement ps = cnn.prepareCall(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                sachmuon sach = new sachmuon();
                mabandoc = rs.getString(1);
                hoten = rs.getString(2);
                sach.setMasach(rs.getString(3));
                sach.setTensach(rs.getString(4));
                sach.setNgaymuon(rs.getString(5));
                list.add(sach);
            }
        } catch (Exception e) {
            System.out.println("loi gi do roi");
        }
        System.out.println("\n\t-Thông tin phiếu mượn");
        System.out.printf("%-10s%-30s", "MÃ THẺ", "HỌ TÊN");
        System.out.printf("\n_________________________________________");
        System.out.printf("\n%-10s%-30s", mabandoc, hoten);
        System.out.print("\n\n\n_______________DANH SÁCH ĐANG MƯỢN________________________________");
        System.out.printf("\n%-10s%-40s%-20s", "MÃ SÁCH", "TÊN SÁCH", "NGÀY MƯỢN");
        System.out.print("\n__________________________________________________________________");

        for (int i = 0; i < list.size(); i++) {
            list.get(i).intt();
        }
        System.out.println("\n__________________________________________________________________");
    }

    public void muonsach() {
        bandocapp bd = new bandocapp();
        sachapp s = new sachapp();
        int soluong;
        String mathe;
        String ngaymuon;
        Connection cnn = null;
        ketnoi kn = new ketnoi();
        cnn = kn.gettestketnoi();
        Scanner sc = new Scanner(System.in);
        System.out.print("\t-Nhập mã bạn đọc:");
        mathe = sc.nextLine();
        if ((bd.checkma(mathe) == false)) {
            do {
                System.out.print("Mã không tồn tại xin nhập lại:");
                mathe = sc.nextLine();
            } while (bd.checkma(mathe) == false);

        }
         this.trathongtinphieumuon(mathe);
        System.out.print("\t-Nhập ngày mượn: ");
        ngaymuon = sc.nextLine();
        System.out.print("\t-Nhập số lượng sách muốn mượn:");
        soluong = sc.nextInt();
        for (int i = 1; i <= soluong; i++) {
            String masach;
            sc = new Scanner(System.in);
            System.out.print("\tNhập mã sách thứ " + (i) + ":");
            masach = sc.nextLine();
            if ((s.checkma(masach) == false)) {
                do {
                    System.err.print("Mã không tồn tại xin nhập lại:");
                    masach = sc.nextLine();

                } while (s.checkma(masach) == false);
            }
            System.out.printf("%-15s%-40s%-30s%-25s%-15s%-20s\n", "MÃ SÁCH", "TÊN SÁCH", "TÁC GIẢ", "NXB", "NĂM ", "THỂ LOẠI");
            System.out.println("_________________________________"
                    + "________________________________________________"
                    + "_______________________________________________________________");
            s.in(masach);
            System.out.println("Thêm thành công");
            try {
                String sql = "insert into muonsach(mabandoc,masach,ngaymuon) values (?,?,?)";
                PreparedStatement ps = cnn.prepareStatement(sql);
                ps.setString(1, mathe);
                ps.setString(2, masach);
                ps.setString(3, ngaymuon);
                boolean name = ps.executeUpdate() > 0;

            } catch (SQLException ex) {
                System.out.println("loi gi do");
            }

        }
        this.trathongtinphieumuon(mathe);

    }
    public void trasach(){
            bandocapp bd = new bandocapp();
        sachapp s = new sachapp();
        int soluong;
        String mathe;
        String ngaymuon;
        Connection cnn = null;
        ketnoi kn = new ketnoi();
        cnn = kn.gettestketnoi();
        Scanner sc = new Scanner(System.in);
        System.out.print("\t-Nhập mã bạn đọc muốn trả:");
        mathe = sc.nextLine();
        if ((bd.checkma(mathe) == false)) {
            do {
                System.out.print("Mã không tồn tại xin nhập lại:");
                mathe = sc.nextLine();
            } while (bd.checkma(mathe) == false);

        }
         this.trathongtinphieumuon(mathe);
//        System.out.print("\t-Nhập ngày mượn: ");
//        ngaymuon = sc.nextLine();
        System.out.print("\t-Nhập số lượng sách muốn trả:");
        soluong = sc.nextInt();
        for (int i = 1; i <= soluong; i++) {
            String masach;
            sc = new Scanner(System.in);
            System.out.print("\tNhập mã sách thứ " + (i) + ":");
            masach = sc.nextLine();
            if ((s.checkma(masach) == false)) {
                do {
                    System.err.print("Mã không tồn tại xin nhập lại:");
                    masach = sc.nextLine();

                } while (s.checkma(masach) == false);
            }
            System.out.printf("%-15s%-40s%-30s%-25s%-15s%-20s\n", "MÃ SÁCH", "TÊN SÁCH", "TÁC GIẢ", "NXB", "NĂM ", "THỂ LOẠI");
            System.out.println("_________________________________"
                    + "________________________________________________"
                    + "_______________________________________________________________");
            s.in(masach);
            System.out.println("Trả sách thành công");
            try {
                String sql = "delete from muonsach where mabandoc = ? and masach=?";
                PreparedStatement ps = cnn.prepareStatement(sql);
                ps.setString(1, mathe);
                ps.setString(2, masach);
     boolean name = ps.executeUpdate() > 0;

            } catch (SQLException ex) {
                System.out.println("loi gi do");
            }

        }
        this.trathongtinphieumuon(mathe);

    
    }
}
