/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author admin
 */
public class Book {
    private int bookId;
    private String booksCode;
    private String booksName;
    private float booksPrice;
    private int quantity;
    private int status;
    private int year;
    private int locationId;
    private int publicserId;

    public Book() {
    }

    public Book(String booksCode, String booksName, float booksPrice, int quantity, int status, int year, int locationId, int publicserId) {
        this.booksCode = booksCode;
        this.booksName = booksName;
        this.booksPrice = booksPrice;
        this.quantity = quantity;
        this.status = status;
        this.year = year;
        this.locationId = locationId;
        this.publicserId = publicserId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBooksCode() {
        return booksCode;
    }

    public void setBooksCode(String booksCode) {
        this.booksCode = booksCode;
    }

    public String getBooksName() {
        return booksName;
    }

    public void setBooksName(String booksName) {
        this.booksName = booksName;
    }

    public float getBooksPrice() {
        return booksPrice;
    }

    public void setBooksPrice(float booksPrice) {
        this.booksPrice = booksPrice;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public int getPublicserId() {
        return publicserId;
    }

    public void setPublicserId(int publicserId) {
        this.publicserId = publicserId;
    }
    
    
    
}
