/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import models.Author;

/**
 *
 * @author admin
 */
public class AuthorMapper implements RowMapper<Author> {

    @Override
    public Author mapRow(ResultSet rs) {
        Author author = new Author();
        try {
            author.setAuthorId(rs.getInt("AuthorID"));
            author.setAuthorName(rs.getNString("AuthorName"));
            return author;
        } catch (SQLException e) {
            return null;
        }

    }

}
