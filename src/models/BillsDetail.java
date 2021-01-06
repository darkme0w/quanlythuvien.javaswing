/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author phamh
 */
public class BillsDetail {

    private int billId;
    private int bookId;
    private String bookName;
    private int quantity;
    private int status;
    private String bookCode;
    private String publicser;

    public String getPublicser() {
        return publicser;
    }

    public void setPublicser(String publicser) {
        this.publicser = publicser;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public BillsDetail(int billId, int bookId, String bookName, int quantity, int status) {
        this.billId = billId;
        this.bookId = bookId;
        this.bookName = bookName;
        this.quantity = quantity;
        this.status = status;
    }

    public BillsDetail() {
    }

    public BillsDetail(int billId, String bookName, int quantity, int status, String bookCode, String publicser) {
        this.billId = billId;
        this.bookName = bookName;
        this.quantity = quantity;
        this.status = status;
        this.bookCode = bookCode;
        this.publicser = publicser;
    }

    public BillsDetail(int billId, int bookId, int quantity) {
        this.billId = billId;
        this.bookId = bookId;
        this.quantity = quantity;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
