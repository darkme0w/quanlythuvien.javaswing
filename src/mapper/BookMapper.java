/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import models.Book;

/**
 *
 * @author admin
 */
public class BookMapper implements RowMapper<Book>{

    @Override
    public Book mapRow(ResultSet rs) {
        try {
            Book book = new Book();
            book.setBookId(rs.getInt("BooksID"));
            book.setBooksName(rs.getNString("BooksName"));
            book.setBooksCode(rs.getString("BooksCode"));
            book.setBooksPrice(rs.getFloat("BooksPrice"));
            book.setQuantity(rs.getInt("Quantity"));
            book.setStatus(rs.getInt("Status"));
            book.setYear(rs.getInt("Year"));
            book.setLocationId(rs.getInt("LocationID"));
            book.setPublicserId(rs.getInt("PublicserID"));
            return book;
        } catch (SQLException e) {
            return null;
        }
    }
    
    
}
