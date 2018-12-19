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
public class nhanvien {
    
    private String id;
    private String name;
    private String phone;
    private String email;
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public nhanvien() {
    }

    public nhanvien(String id, String name, String phone, String email, String password) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return this.id + "-" + this.name;
    }
    
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập thông tin nhân viên:");
        System.out.print("\t-ID:");
        this.id = sc.nextLine();
        System.out.print("\t-Name:");
        this.name = sc.nextLine();
        System.out.print("\t-Phone:");
        this.phone = sc.nextLine();
        System.out.print("\t-Email:");
        this.email = sc.nextLine();
        System.out.print("\t-Password:");
        this.password = sc.nextLine();
    }
    
    public void hienthi(){
        System.out.println("\t -ID: "+ this.id);
        System.out.println("\t -Name: "+this.name);
        System.out.println("\t -Phone: "+this.phone);
        System.out.println("\t -Email: " + this.email);
        System.out.println("\t -Password: " + this.password);
    }
}
