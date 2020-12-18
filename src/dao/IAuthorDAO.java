/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.Author;

/**
 *
 * @author admin
 */
public interface IAuthorDAO extends GenericDAO<Author>{
    List<Author> getAll();
    void save(Author author);
    void update(Author author);
    void delete(Author author);
}
