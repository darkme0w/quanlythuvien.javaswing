/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.IBookAuthorDAO;
import java.util.List;
import mapper.BookAuthorMapper;
import models.BookAuthor;

/**
 *
 * @author phamh
 */
public class BookAuthorDAO extends AbstractDAO<BookAuthor> implements IBookAuthorDAO {

    @Override
    public List<BookAuthor> getAll(int id) {
        String sql = "{Call sp_getAll_vwBookAuthor(?)}";
        return query(sql, new BookAuthorMapper(), id);
    }

    @Override
    public void delete(BookAuthor bAuthor) {
        String sql = "{Call sp_delete_BookAuthor(?)}";
        this.update(sql, bAuthor.getBookId());
    }

    @Override
    public void update(BookAuthor bAuthor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(BookAuthor bAuthor) {
        String sql = "{Call sp_insert_BookAuthor(?,?)}";
        this.insert(sql, bAuthor.getBookId(), bAuthor.getAuthorId());
    }

}
