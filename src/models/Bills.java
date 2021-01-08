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
public class Bills {

    private int billsId;
    private int readerId;
    private int librarianId;
    private LocalDate createdDate;
    private LocalDate payDay;
    private String readerName;
    private String address;
    private String phone;
    private int gender;
    private String librarianName;
    private int status;

    public Bills() {
    }

    public Bills(int readerId, LocalDate createdDate, LocalDate payDay, String librarianName) {
        this.readerId = readerId;
        this.createdDate = createdDate;
        this.payDay = payDay;
        this.librarianName = librarianName;
    }

    public Bills(int billsId, LocalDate createdDate, LocalDate payDay, String readerName, String address, String phone, int gender, String librarianName, int status) {
        this.billsId = billsId;
        this.createdDate = createdDate;
        this.payDay = payDay;
        this.readerName = readerName;
        this.address = address;
        this.phone = phone;
        this.gender = gender;
        this.librarianName = librarianName;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getLibrarianName() {
        return librarianName;
    }

    public void setLibrarianName(String librarianName) {
        this.librarianName = librarianName;
    }

    public Bills(int billsId, int readerId, int librarianId, LocalDate createdDate, LocalDate payDay, String readerName, String address, String phone, int gender) {
        this.billsId = billsId;
        this.readerId = readerId;
        this.librarianId = librarianId;
        this.createdDate = createdDate;
        this.payDay = payDay;
        this.readerName = readerName;
        this.address = address;
        this.phone = phone;
        this.gender = gender;
    }

    public int getBillsId() {
        return billsId;
    }

    public void setBillsId(int billsId) {
        this.billsId = billsId;
    }

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    public int getLibrarianId() {
        return librarianId;
    }

    public void setLibrarianId(int librarianId) {
        this.librarianId = librarianId;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getPayDay() {
        return payDay;
    }

    public void setPayDay(LocalDate payDay) {
        this.payDay = payDay;
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

}
