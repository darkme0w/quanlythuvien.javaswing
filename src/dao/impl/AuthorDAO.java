/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.IAuthorDAO;
import java.util.List;
import mapper.AuthorMapper;
import mapper.CategoryMapper;
import models.Author;

/**
 *
 * @author admin
 */
public class AuthorDAO extends AbstractDAO<Author> implements IAuthorDAO {

    @Override
    public List<Author> getAll() {
        String sql = "{Call get_All_Author}";
        return query(sql, new AuthorMapper());
    }

    @Override
    public void save(Author author) {
        String sql = "{Call create_Auhtor (?)}";
        this.insert(sql, author.getAuthorName());
    }

    @Override
    public void update(Author author) {
        String sql = "{Call update_Author(?,?)}";
        this.update(sql, author.getAuthorName(), author.getAuthorId());
    }

    @Override
    public void delete(Author author) {
        String sql = "{Call delete_Author_Byid (?)}";
        this.update(sql, author.getAuthorId());
    }

    @Override
    public List<Author> sortAsc() {
        String sql = "{Call sort_Author_ASC}";
        return query(sql, new AuthorMapper());
    }

    @Override
    public List<Author> sortDesc() {
       String sql = "{Call sort_Author_DESC}";
        return query(sql, new AuthorMapper());  
    }

}
