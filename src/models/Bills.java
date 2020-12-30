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

    public Bills() {
    }

    public Bills(LocalDate createdDate, LocalDate payDay) {
        this.createdDate = createdDate;
        this.payDay = payDay;
    }

    public Bills(int readerId, LocalDate createdDate, LocalDate payDay) {
        this.readerId = readerId;
        this.createdDate = createdDate;
        this.payDay = payDay;
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

    public int getBillsId() {
        return billsId;
    }

    public void setBillsId(int billsId) {
        this.billsId = billsId;
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
    
    
}
