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
public class nhanvienapp {

    Scanner sc = new Scanner(System.in);
    ArrayList<nhanvien> listNV;

    public void loadfile() {
        listNV = new ArrayList<>();
        Connection cnn = null;
        ketnoi kn = new ketnoi();
        cnn = kn.gettestketnoi();
        ResultSet rs = null;
        String sql = "select * from nhanvien";
        try {
            PreparedStatement ps = cnn.prepareCall(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                nhanvien nv = new nhanvien();
                nv.setManv(rs.getString("manv"));
                nv.setTennv(rs.getString("tennv"));
                nv.setNgaysinh(rs.getString("ngaysinh"));
                nv.setChucvu(rs.getString("chucvu"));
                nv.setDiachi(rs.getString("diachi"));
                nv.setMatkhau(rs.getString("matkhau"));
                listNV.add(nv);
            }
        } catch (Exception e) {
            System.out.println("loi gi do roi");
        }

    }

    public void menu() {
        int a = 0;
        do {
            System.out.println(" ________________QUẢN LÍ NHÂN VIÊN__________________");
            System.out.println("|   1.Danh sách nhân viên                           |");
            System.out.println("|   2.Thêm 1 nhân viên                              |");
            System.out.println("|   3.Xóa 1 nhân viên                               |");
            System.out.println("|   4.Sửa 1 nhân viên                               |");
            System.out.println("|   5.Tìm kiếm 1 nhân viên                          |");
            System.out.println("|   0.Quay lại                                      |");
            System.out.println("|___________________________________________________|");
            Scanner sc = new Scanner(System.in);

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

            }
        } while (a == 1 || a == 2 || a == 3 || a == 4 || a == 5);
    }

    public void showAll() {
        this.loadfile();
        System.out.printf("%-10s%-30s%-20s%-15s%-15s\n", "MÃ NV", "TÊN NHÂN VIÊN", "NGÀY SINH", "ĐỊA CHỈ", "CHỨC VỤ");
        System.out.println("____________________________________________________________________________________");
        for (int i = 0; i < listNV.size(); i++) {
            // System.out.println("Thông tin nhân viên thứ " + (i + 1));
            listNV.get(i).hienthi();
        }
    }

    public boolean them() {
        try {
            this.loadfile();
            Connection cnn = null;
            ketnoi kn = new ketnoi();
            cnn = kn.gettestketnoi();

            nhanvien nv = new nhanvien();
            nv.nhap();
            String sql = "insert into nhanvien(manv,tennv,ngaysinh,diachi,chucvu,matkhau) values (?,?,?,?,?,?)";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, nv.getManv());
            ps.setString(2, nv.getTennv());
            ps.setString(3, nv.getNgaysinh());
            ps.setString(4, nv.getDiachi());
            ps.setString(5, nv.getChucvu());
            ps.setString(6, nv.getMatkhau());
            System.out.println("Bạn đã thêm thành công ^^ !");
            return ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(nhanvienapp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean xoa() {
        try {
            this.loadfile();
            int index = 0;
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhập mã nhân viên cần xóa: ");
            String a = sc.nextLine();
            int flag = 0;
            Connection cnn = null;
            ketnoi kn = new ketnoi();
            cnn = kn.gettestketnoi();
            String sql = "delete from nhanvien where manv=?";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, a);
            for (int i = 0; i < listNV.size(); i++) {
                if (listNV.get(i).getManv().equalsIgnoreCase(a) == true) {
                    index = i;
                    flag = 1;                   
                }
            }
            if (flag == 1) {
                System.out.println("Thông tin nhân viên cần xóa");
                listNV.get(index).hienthi();
                
                System.out.println("Bạn đã xóa thành công ^^ !");
                  return ps.executeUpdate() > 0;
            } else {
                System.out.println("không có mã nhân viên nào.!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(nhanvienapp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean sua() {
        this.loadfile();
        int index = 0;
              Connection cnn = null;
        ketnoi kn = new ketnoi();
        cnn = kn.gettestketnoi();
        System.out.print("Nhập mã nhân viên cần sửa: ");
        String a = sc.nextLine();
        int flag = 0;
        for (int i = 0; i < listNV.size(); i++) {
            if (listNV.get(i).getManv().equalsIgnoreCase(a) == true) {
                index = i;
                flag = 1;
            }
        }
        if (flag == 1) {
            try {
                System.out.println("Thông tin nhân viên bạn muốn sửa.");
                System.out.printf("%-10s%-30s%-20s%-15s%-15s\n", "MÃ NV", "TÊN NHÂN VIÊN", "NGÀY SINH", "ĐỊA CHỈ", "CHỨC VỤ");
                System.out.println("____________________________________________________________________________________");
                listNV.get(index).hienthi();

                nhanvien nv = new nhanvien();
                System.out.println("Nhập thông tin mới cho nhân viên");
                nv.nhap();                             
           String sql = "update  nhanvien set manv =?,tennv=?,ngaysinh=?,diachi=?,chucvu=? where manv = ?";
           // String sql = "update  nhanvien set manv = '"+nv.getManv()+"'tennv = '"+nv.getTennv()+"'where manv='"+a+"'";
            PreparedStatement  ps = cnn.prepareStatement(sql); 
            ps.setString(1, nv.getManv());
            ps.setString(2, nv.getTennv());
            ps.setString(3, nv.getNgaysinh());
            ps.setString(4, nv.getDiachi());
            ps.setString(5, nv.getChucvu());
            ps.setString(6, a);
            System.out.println("Bạn đã sửa thành công .!");
            return ps.executeUpdate()>0;
              
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
        System.out.print("Nhập mã Nhân Viên cần tìm: ");
        String a = sc.nextLine();
        int flag = 0;
        for (int i = 0; i < listNV.size(); i++) {
            if (listNV.get(i).getManv().equalsIgnoreCase(a) == true) {
                flag = 1;
                index = i;
            }
        }
        if (flag == 1) {
            System.out.println("Thông tin Nhân Viên bạn muốn tìm.");
            System.out.printf("%-10s%-30s%-20s%-15s%-15s\n", "MÃ NV", "TÊN NHÂN VIÊN", "NGÀY SINH", "ĐỊA CHỈ", "CHỨC VỤ");
            System.out.println("____________________________________________________________________________________");
            listNV.get(index).hienthi();
        } else {
            System.out.println("Không có mã Nhân Viên nào .!");
        }
    }

    public boolean checkma(String a) {
        this.loadfile();
        boolean flag = false;
        for (int i = 0; i < listNV.size(); i++) {
            if (listNV.get(i).getManv().equalsIgnoreCase(a) == true) {
                flag = true;
            }
        }
     
        return flag;
    }
        public boolean DangNhap() {
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        String a = "";
        this.loadfile();
        System.err.println("Nhap ma va mat khau dang nhap.!");
        do {

            System.out.print("User: ");
            String user = sc.nextLine();
            for (int i = 0; i < listNV.size(); i++) {
                if (listNV.get(i).getManv().equalsIgnoreCase(user) == true) {
                    a = listNV.get(i).getMatkhau();
                    flag = true;
                }
            }
            if (flag == false) {
                System.err.println("Ma so khong chinh sac.!");
            }
        } while (flag == false);

        
            if (flag == true){ do{
                System.out.print("Passord: ");
                String pass = sc.nextLine();
                if (a.equalsIgnoreCase(pass) == true) {
                    flag = true;
                } else {
                    flag = false;
                    System.err.println("Sai Password.!");
                }
            }while (flag == false);
        } 
        return flag;
    }
}
