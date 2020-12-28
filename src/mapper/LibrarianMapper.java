/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Librarian;

/**
 *
 * @author admin
 */
public class LibrarianMapper implements RowMapper<Librarian> {
    
    @Override
    public Librarian mapRow(ResultSet rs) {
        Librarian librarian = new Librarian();
        try {
            librarian.setLibrarianId(rs.getInt("LibrarianID"));
            librarian.setLibrarianName(rs.getNString("LibrarianName"));
            librarian.setUserName(rs.getNString("UserName"));
            librarian.setPassword(rs.getNString("Password"));
            librarian.setPhone(rs.getString("Phone"));
            librarian.setAddress(rs.getNString("Address"));
            librarian.setGender(rs.getInt("Gender"));
            librarian.setPermission(rs.getInt("Permission"));
            Date date = rs.getDate("CreatedDate");
            librarian.setCreatedDate(date.toLocalDate());
            return librarian;
        } catch (SQLException ex) {
            return null;
        }
    }
    
}
