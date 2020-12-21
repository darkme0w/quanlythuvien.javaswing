/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.IBooksDAO;
import java.util.List;
import mapper.BookMapper;
import models.Book;

/**
 *
 * @author admin
 */
public class BookDAO extends AbstractDAO<Book> implements IBooksDAO{

    @Override
    public List<Book> getAll() {
       String sql = "{Call sp_getAll_Books}";
       return query(sql, new BookMapper());
    }

    @Override
    public void delete(Book book) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Book book) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Book book) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
