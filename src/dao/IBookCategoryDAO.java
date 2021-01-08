/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.BookCategory;

/**
 *
 * @author phamh
 */
public interface IBookCategoryDAO extends GenericDAO<BookCategory>{
    List<BookCategory> getAll(int id);

    void delete(BookCategory bCategory);

    void update(BookCategory bCategory);

    void save(BookCategory bCategory);
    
     void delete(BookCategory bCategory, int bookId);
}
