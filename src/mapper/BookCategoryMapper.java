/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import models.BookCategory;

/**
 *
 * @author phamh
 */
public class BookCategoryMapper implements RowMapper<BookCategory>{

    @Override
    public BookCategory mapRow(ResultSet rs) {
        BookCategory bCategory = new BookCategory();
        try {
            bCategory.setBookId(rs.getInt("BooksID"));
            bCategory.setCateogryId(rs.getInt("CategoryID"));
            bCategory.setCategoryName(rs.getNString("CategoryName"));
            return bCategory;
        } catch (SQLException ex) {
            return null;
        }
    }
    
}
