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
public class BookCategory {

    private int bookId;
    private int cateogryId;
    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public BookCategory() {
    }

    public BookCategory(int bookId, int cateogryId) {
        this.bookId = bookId;
        this.cateogryId = cateogryId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getCateogryId() {
        return cateogryId;
    }

    public void setCateogryId(int cateogryId) {
        this.cateogryId = cateogryId;
    }
    
    
}
