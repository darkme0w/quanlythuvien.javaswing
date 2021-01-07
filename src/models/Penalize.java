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
public class Penalize {
    private int readerId;
    private int librarianId;
    private String readerName;
    private String librarianName;
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public String getLibrarianName() {
        return librarianName;
    }

    public Penalize(String readerName, String librarianName, String note) {
        this.readerName = readerName;
        this.librarianName = librarianName;
        this.note = note;
    }

    public void setLibrarianName(String librarianName) {
        this.librarianName = librarianName;
    }
    private String note;

    public Penalize() {
    }

    public Penalize(int readerId, int librarianId, String note) {
        this.readerId = readerId;
        this.librarianId = librarianId;
        this.note = note;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
}
