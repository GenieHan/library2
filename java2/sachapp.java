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
public class sachapp {

    Scanner sc = new Scanner(System.in);
    ArrayList<sach> listS;

    public void showAll() {
        System.out.printf("%-15s%-40s%-30s%-25s%-15s%-20s\n", "MÃ SÁCH", "TÊN SÁCH", "TÁC GIẢ", "NXB", "NĂM ", "THỂ LOẠI");
        System.out.println("________________________________________________________________________________________________________________________________________________");
        for (int i = 0; i < listS.size(); i++) {
            // System.out.println("Thông tin sách thứ " + (i + 1));
            listS.get(i).hienthi();
        }
        System.out.println("________________________________________________________________________________________________________________________________________________");

    }

    public void loadfile() {
        listS = new ArrayList<>();
        Connection cnn = null;
        ketnoi kn = new ketnoi();
        cnn = kn.gettestketnoi();
        ResultSet rs = null;
        String sql = "select * from sach";
        try {
            PreparedStatement ps = cnn.prepareCall(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                sach s = new sach();
                s.setMasach(rs.getString("masach"));
                s.setTensach(rs.getString("tensach"));
                s.setNamxuatban(rs.getString("namxb"));
                s.setNhaxuatban(rs.getString("nxb"));
                s.setMatg(rs.getString("matg"));
                s.setSoluong(rs.getInt("soluong"));
                s.setTheloai(rs.getString("theloai"));
                s.setTacgia(rs.getString("tentg"));
                listS.add(s);

            }
        } catch (Exception e) {
            System.out.println("loi gi do roi");
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
            case 1:
                this.loadfile();
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

    public boolean them() {
        this.loadfile();
            sach s = new sach();
            s.nhap();
        try {

            Connection cnn = null;
            ketnoi kn = new ketnoi();
            cnn = kn.gettestketnoi();

            String sql = "insert into sach(masach,tensach,matg,tentg,theloai,nxb,soluong,namxb) values (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, s.getMasach());
            ps.setString(2, s.getTensach());
            ps.setString(3, s.getMatg());
            ps.setString(4, s.getTacgia());
            ps.setString(5, s.getTheloai());
            ps.setString(6, s.getNhaxuatban());
            ps.setInt(7, s.getSoluong());
            ps.setString(8, s.getNamxuatban());
           
            System.out.println("Bạn đã thêm thành công ^^ !");
             System.out.printf("%-15s%-40s%-30s%-25s%-15s%-20s\n", "MÃ SÁCH", "TÊN SÁCH", "TÁC GIẢ", "NXB", "NĂM ", "THỂ LOẠI");
        System.out.println("_________________________________"
                + "________________________________________________"
                + "_______________________________________________________________");
              s.hienthi();
            return ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(nhanvienapp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean xoa() {
        int index = 0;
        this.loadfile();
        Connection cnn = null;
        ketnoi kn = new ketnoi();
        cnn = kn.gettestketnoi();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã sách cần xóa: ");
        String a = sc.nextLine();
        for (int i = 0; i < listS.size(); i++) {
            if (listS.get(i).getMasach().equalsIgnoreCase(a) == true) {
                         System.err.println("Thông tin sách cần xóa");
                          System.out.printf("%-15s%-40s%-30s%-25s%-15s%-20s\n", "MÃ SÁCH", "TÊN SÁCH", "TÁC GIẢ", "NXB", "NĂM ", "THỂ LOẠI");
        System.out.println("_________________________________"
                + "________________________________________________"
                + "_______________________________________________________________");
               listS.get(i).hienthi();


            }
        }
            try {

                System.out.println("Bạn đã xóa thành công ^^ !");
                String sql = "delete from sach where masach=?";
                PreparedStatement ps = cnn.prepareStatement(sql);
                ps.setString(1, a);
                return ps.executeUpdate() > 0;
            } catch (SQLException ex) {
                Logger.getLogger(bandocapp.class.getName()).log(Level.SEVERE, null, ex);
            }

        return false;
    }

    public boolean sua() {
        this.loadfile();
        int index = 0;
      
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã sách cần sửa: ");
        String a = sc.nextLine();
              Connection cnn = null;
        ketnoi kn = new ketnoi();
        cnn = kn.gettestketnoi();

        int flag = 0;
        for (int i = 0; i < listS.size(); i++) {
            if (listS.get(i).getMasach().equalsIgnoreCase(a) == true) {
                index = i;
                flag = 1;
            }
        }
        if (flag == 1) {
            try {
                System.out.println("Thông tin sách bạn muốn sửa.");
   System.out.printf("%-15s%-40s%-30s%-25s%-15s%-20s\n", "MÃ SÁCH", "TÊN SÁCH", "TÁC GIẢ", "NXB", "NĂM ", "THỂ LOẠI");
        System.out.println("_________________________________"
                + "________________________________________________"
                + "_______________________________________________________________");
                listS.get(index).hienthi();
                        sach s = new sach();
                System.out.println("Nhập thông tin mới ");
                s.nhap();                             
           String sql = "update  sach set masach =?,tensach=?,matg=?,tentg=?,soluong=?,nxb=?,namxb=?,theloai=? where masach = ?";
            PreparedStatement  ps = cnn.prepareStatement(sql); 
            ps.setString(1, s.getMasach());
            ps.setString(2, s.getTensach());
            ps.setString(3, s.getMatg());
            ps.setString(4, s.getTacgia());
            ps.setInt(5, s.getSoluong());
            ps.setString(6, s.getTheloai());
            ps.setString(7, s.getNhaxuatban());
            ps.setString(8, s.getNamxuatban());
            ps.setString(9, a);
        
            System.out.println("Bạn đã sửa thành công .!");
            System.out.printf("%-15s%-40s%-30s%-25s%-15s%-20s\n", "MÃ SÁCH", "TÊN SÁCH", "TÁC GIẢ", "NXB", "NĂM ", "THỂ LOẠI");
        System.out.println("________________________________"
                + "_______________________________________________________________"
                + "_________________________________________________");
        s.hienthi();
            return ps.executeUpdate()>0;
              
            } catch (SQLException ex) {
                Logger.getLogger(nhanvienapp.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.err.println("Không có mã sách nào .!");
        }
        return false;
    


    }

    public boolean checkma(String a) {
        this.loadfile();
        boolean flag = false;
        for (int i = 0; i < listS.size(); i++) {
            if (listS.get(i).getMasach().equalsIgnoreCase(a) == true) {
                flag = true;
            }
        }
        return flag;
    }

    public void timkiem() {
        this.loadfile();
        int index = 0;
        System.out.print("Nhập mã sách cần tìm: ");
        String a = sc.nextLine();
        int flag = 0;
        for (int i = 0; i < listS.size(); i++) {
            if (listS.get(i).getMasach().equalsIgnoreCase(a) == true) {
                flag = 1;
                index = i;
            }
        }
        if (flag == 1) {
            System.out.println("Thông tin sách bạn muốn tìm.");
            listS.get(index).hienthi();
        } else {
            System.err.println("Không có mã sách nào .!");
        }
    }
 public void in(String a) {
        for (int i = 0; i < listS.size(); i++) {
            if (listS.get(i).getMasach().equalsIgnoreCase(a) == true) {
                listS.get(i).hienthi();
            }
        }

}
}
