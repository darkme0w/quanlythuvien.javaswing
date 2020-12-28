/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.time.LocalDate;

/**
 *
 * @author admin
 */
public class Librarian {
    private int librarianId;
    private String librarianName;
    private String phone;
    private String address;
    private String userName;
    private String password;
    private int gender;
    private int permission;
    private LocalDate createdDate;

    public Librarian() {
    }

    public Librarian(int librarianId, String librarianName, String phone, String address, String userName, String password, int gender, int permission, LocalDate createdDate) {
        this.librarianId = librarianId;
        this.librarianName = librarianName;
        this.phone = phone;
        this.address = address;
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.permission = permission;
        this.createdDate = createdDate;
    }

    public int getLibrarianId() {
        return librarianId;
    }

    public void setLibrarianId(int librarianId) {
        this.librarianId = librarianId;
    }

    public String getLibrarianName() {
        return librarianName;
    }

    public void setLibrarianName(String librarianName) {
        this.librarianName = librarianName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }
    
}