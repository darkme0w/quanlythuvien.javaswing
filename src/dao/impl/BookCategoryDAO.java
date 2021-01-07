/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.IBookCategoryDAO;
import java.util.List;
import mapper.BookCategoryMapper;
import models.BookCategory;

/**
 *
 * @author phamh
 */
public class BookCategoryDAO extends AbstractDAO<BookCategory> implements IBookCategoryDAO {

    @Override
    public List<BookCategory> getAll(int id) {
        String sql = "{Call sp_getAll_vwBookCategory(?)}";
        return query(sql, new BookCategoryMapper(), id);
    }

    @Override
    public void delete(BookCategory bCategory) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(BookCategory bCategory) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(BookCategory bCategory) {
        String sql = "{Call sp_insert_BookCategory(?,?)}";
        this.insert(sql, bCategory.getBookId(), bCategory.getCateogryId());
    }

}
