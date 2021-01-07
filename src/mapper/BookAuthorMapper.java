/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import models.BookAuthor;

/**
 *
 * @author phamh
 */
public class BookAuthorMapper implements RowMapper<BookAuthor>{

    @Override
    public BookAuthor mapRow(ResultSet rs) {
      BookAuthor bAuthor = new BookAuthor();
        try {
            bAuthor.setBookId(rs.getInt("BooksID"));
            bAuthor.setAuthorId(rs.getInt("AuthorID"));
            bAuthor.setAuthorName(rs.getNString("AuthorName"));
            return bAuthor;
        } catch (SQLException ex) {
            return null;
        }
    }
    
}
