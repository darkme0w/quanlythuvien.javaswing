/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.BookAuthor;

/**
 *
 * @author phamh
 */
public interface IBookAuthorDAO extends GenericDAO<BookAuthor> {

    List<BookAuthor> getAll(int id);

    void delete(BookAuthor bAuthor);

    void update(BookAuthor bAuthor);

    void save(BookAuthor bAuthor);
    
    void delete(BookAuthor bookAuthor, int bookId);
}
