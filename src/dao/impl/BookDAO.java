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
public class BookDAO extends AbstractDAO<Book> implements IBooksDAO {

    @Override
    public List<Book> getAll() {
        String sql = "{Call sp_getAll_Books}";
        return query(sql, new BookMapper());
    }

    @Override
    public void delete(Book book) {
        String sql = "{Call sp_delete_Book (?)}";
        this.update(sql, book.getBookId());
    }

    @Override
    public void update(Book book) {
        String sql = "{Call sp_update_Book (?,?,?,?,?,?,?,?,?)}";
        this.update(sql, book.getBooksCode(), book.getBooksName(), book.getBooksPrice(), book.getQuantity(), book.getStatus(), book.getYear(), book.getLocationId(), book.getPublicserId(), book.getBookId());
    }

    @Override
    public void save(Book book) {
        String sql = "{Call sp_insert_Book (?,?,?,?,?,?,?,?)}";
        this.insert(sql, book.getBooksCode(), book.getBooksName(), book.getBooksPrice(), book.getQuantity(), book.getStatus(), book.getYear(), book.getLocationId(), book.getPublicserId());
    }

    @Override
    public List<Book> sortASC() {
        String sql = "{Call sp_sortByASC_vwBook}";
        return query(sql, new BookMapper());
    }

    @Override
    public List<Book> sortDESC() {
        String sql = "{Call sp_sortByDESC_vwBook}";
        return query(sql, new BookMapper());
    }

}
