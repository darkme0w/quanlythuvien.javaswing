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
public class Publicser {
    private int publicserId;
    private String publicserName;
    private String address;

    public Publicser() {
    }

    public Publicser(String publicserName, String address) {
        this.publicserName = publicserName;
        this.address = address;
    }

    public int getPublicserId() {
        return publicserId;
    }

    public void setPublicserId(int publicserId) {
        this.publicserId = publicserId;
    }

    public String getPublicserName() {
        return publicserName;
    }

    public void setPublicserName(String publicserName) {
        this.publicserName = publicserName;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return this.publicserName;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
}
