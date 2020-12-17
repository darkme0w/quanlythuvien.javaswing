/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.IAuthorDAO;
import java.util.List;
import mapper.AuthorMapper;
import models.Author;

/**
 *
 * @author admin
 */
public class AuthorDAO extends AbstractDAO<Author> implements IAuthorDAO {

    @Override
    public List<Author> getAll() {
        String sql = "";
        return query(sql, new AuthorMapper());
    }

    @Override
    public void save(Author author) {
        String sql = "";
        this.insert(sql, author.getAuthorName());
    }

    @Override
    public void update(Author author) {
        String sql = "";
        this.update(sql, author.getAuthorName(), author.getAuthorId());
    }

    @Override
    public void delete(Author author) {
        String sql = "";
        this.update(sql, author.getAuthorId());
    }

}
