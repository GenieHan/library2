/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qltv;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TranQuangHuy
 */
public class bandocapp {

    Scanner sc = new Scanner(System.in);
    ArrayList<bandoc> listBD;

    public void loadfile() {
        listBD= new ArrayList<>();
        Connection cnn = null;
        ketnoi kn = new ketnoi();
        cnn = kn.gettestketnoi();
        ResultSet rs = null;
        String sql = "select * from bandoc";
        try {
            PreparedStatement ps = cnn.prepareCall(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                bandoc bd = new bandoc();
                bd.setMabandoc(rs.getString("mabandoc"));
                bd.setHoten(rs.getString("hoten"));
                bd.setGioitinh(rs.getString("gioitinh"));
                bd.setNgaysinh(rs.getString("ngaysinh"));
                bd.setDiachi(rs.getString("diachi"));
                bd.setEmail(rs.getString("email"));
                bd.setSdt(rs.getString("sdt"));
                bd.setNgaydangki(rs.getString("ngaydangki"));
                bd.setSochungminh(rs.getString("sochungminh"));
                listBD.add(bd);
            }
        } catch (Exception e) {
            System.out.println("loi gi do roi");
        }

    }
        public void showAll() {
        this.loadfile();
        System.out.printf("%-10s%-25s%-15s%-10s%-20s%-15s%-25s%-15s%-15s\n", "MÃ", "HỌ TÊN", "NGÀY SINH", "GIỚI TÍNH", "ĐỊA CHỈ", "SĐT", "EMAIL", "NGÀY ĐĂNG KÍ", "CMT");
        System.out.println("________________________________________________________________________________"
                + "__________________________________________________________________________________");
        for (int i = 0; i < listBD.size(); i++) {
            // System.out.println("Thông tin bạn đọc thứ " + (i + 1));
            listBD.get(i).hienthi();
        }
        System.out.println("________________________________________________________________________________"
                + "__________________________________________________________________________________");
    }
  public void menu() {
        int a = 0; 
        Scanner sc = new Scanner(System.in);

        do {
        System.out.println(" ________________QUẢN LÍ BẠN ĐỌC__________________");
        System.out.println("|   1.Danh sách bạn đọc                           |");
        System.out.println("|   2.Thêm 1 bạn đọc                              |");
        System.out.println("|   3.Xóa 1 bạn đọc                               |");
        System.out.println("|   4.Sửa 1 bạn đọc                               |");
        System.out.println("|   5.Tìm kiếm 1 bạn đọc                          |");
        System.out.println("|   0.Quay lại                                    |");
        System.out.println("|_________________________________________________|");
    
        System.err.print("Nhập lựa chọn: ");
        a = sc.nextInt();
        switch (a) {
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
                break;

        }
    }while(a == 1 || a == 2 || a == 3 || a == 4 || a == 5);

        }


    public boolean them() {
        bandoc bd = new bandoc();
        bd.nhap();
        try {
            Connection cnn = null;
            ketnoi kn = new ketnoi();
            cnn = kn.gettestketnoi();

            String sql = "insert into bandoc(mabandoc,hoten,ngaysinh,gioitinh,diachi,sdt,email,ngaydangki,sochungminh) values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, bd.getMabandoc());
            ps.setString(2, bd.getHoten());
            ps.setString(3, bd.getNgaysinh());
            ps.setString(4, bd.getDiachi());
            ps.setString(5, bd.getSdt());
            ps.setString(6, bd.getGioitinh());
            ps.setString(7, bd.getEmail());
            ps.setString(8, bd.getNgaysinh());
            ps.setString(9, bd.getSochungminh());
            System.out.println("Bạn đã thêm thành công ^^ !");
            return ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(nhanvienapp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean xoa() {
this.loadfile();
        int index = 0;
        Connection cnn = null;
        ketnoi kn = new ketnoi();
        cnn = kn.gettestketnoi();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã bạn đọc cần xóa: ");
        String a = sc.nextLine();
//        boolean flag = false;
        for (int i = 0; i < listBD.size(); i++) {
            if (listBD.get(i).getMabandoc().equalsIgnoreCase(a) == true) {
                         System.err.println("Thông tin bạn đọc cần xóa");
               listBD.get(i).hienthi();
//                index = i;
//                flag = true;

            }
        }
//        if (flag == true) {
            try {

                System.out.println("Bạn đã xóa thành công ^^ !");
                String sql = "delete from bandoc where mabandoc=?";
                PreparedStatement ps = cnn.prepareStatement(sql);
                ps.setString(1, a);
                return ps.executeUpdate() > 0;
            } catch (SQLException ex) {
                Logger.getLogger(bandocapp.class.getName()).log(Level.SEVERE, null, ex);
            }
//        } else {
//            System.out.println("không có mã bạn đọc nào.!");
//        }
        return false;
    }

    public boolean sua() {
        this.loadfile();
        Connection cnn = null;
        ketnoi kn = new ketnoi();
        cnn = kn.gettestketnoi();
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
            try {
                System.out.println("Thông tin bạn đọc bạn muốn sửa.");
                System.out.printf("%-10s%-30s%-10s%-20s%-20s%-20s%-30s%-20s%-10s\n", "MÃ", "HỌ TÊN", "NGÀY SINH", "GIỚI TÍNH", "ĐỊA CHỈ", "SĐT", "EMAIL", "NGÀY ĐĂNG KÍ", "CMT");
                System.out.println("________________________________________________________________________________"
                        + "__________________________________________________________________________________");
                listBD.get(index).hienthi();

                bandoc bandoc = new bandoc();
                System.out.println("Nhập thông tin mới cho bạn đọc");
                bd.nhap();
                String sql = "update  bandoc set mabandoc =?,hoten=?,ngaysinh=?,gioitinh=?,diachi=? ,sdt=?,email=?,sochungminh=?,ngaydangki=? where mabandoc = ?";
                PreparedStatement ps = cnn.prepareStatement(sql);
//                ps.setString(1, bd.getManv());
//                ps.setString(2, bd.getTennv());
//                ps.setString(3, bd.getNgaysinh());
//                ps.setString(4, bd.getDiachi());
//                ps.setString(5, bd.getChucvu());

                System.out.println("Bạn đã sửa thành công .!");
                return ps.executeUpdate() > 0;

            } catch (SQLException ex) {
                Logger.getLogger(nhanvienapp.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Không có mã nhân viên nào .!");

        }
        return false;
    }

    public void timkiem() {
        this.loadfile();
        int index = 0;
        String a;
        System.out.print("Nhập mã bạn đọc cần tìm: ");
         a = sc.nextLine();
        int flag = 0;
        for (int i = 0; i < listBD.size(); i++) {
            if (listBD.get(i).getMabandoc().equalsIgnoreCase(a) == true) {
                flag = 1;
                index = i;
            }
        }
        if (flag == 1) {
            System.out.println("Thông tin bạn dọc bạn muốn tìm.");
            System.out.printf("%-10s%-30s%-10s%-20s%-20s%-20s%-30s%-20s\n", "MÃ", "HỌ TÊN", "NGÀY SINH", "GIỚI TÍNH", "ĐỊA CHỈ", "SĐT", "EMAIL", "NGÀY ĐĂNG KÍ");
            System.out.println("________________________________________________________________________________"
                    + "__________________________________________________________________________________");
            listBD.get(index).hienthi();
        } else {
            System.out.println("Không có mã bạn đọc nào .!");
        }

    }
  public void in(String a) {
        for (int i = 0; i < listBD.size(); i++) {
            if (listBD.get(i).getMabandoc().equalsIgnoreCase(a) == true) {
                listBD.get(i).hienthi();
            }
        }

}
    public boolean checkma(String a) {
        this.loadfile();
        boolean flag = false;
        for (int i = 0; i < listBD.size(); i++)            
            if(listBD.get(i).getMabandoc().equalsIgnoreCase(a)==true) {
                flag = true;
            }
      
        return flag;
    }

 
}

