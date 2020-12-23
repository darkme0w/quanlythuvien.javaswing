/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.ICategoryDAO;
import java.util.List;
import mapper.CategoryMapper;
import models.Category;

/**
 *
 * @author admin
 */
public class CategoryDAO extends AbstractDAO<Category> implements ICategoryDAO {

    @Override
    public List<Category> getAll() {
        String sql = "{Call getAll_Category}";
        return query(sql, new CategoryMapper());
    }

    @Override
    public void delete(Category category) {
        String sql = "{Call delete_Category_Byid (?)}";
        this.update(sql, category.getCategoryId());

    }

    @Override
    public void update(Category category) {
        String sql = "{Call update_Category(?,?)}";
        this.update(sql, category.getCategoryName(), category.getCategoryId());
    }

    @Override
    public void save(Category category) {
        String sql = "{Call create_Category (?)}";
        this.insert(sql, category.getCategoryName());
    }

    @Override
    public List<Category> search(Category category) {
        String sql = "{Call search_Category_Byname (?)}";
        return query(sql, new CategoryMapper(), category.getCategoryName());
    }

    @Override
    public List<Category> sortAsc() {
       String sql = "{Call sort_Category_ASC}";
        return query(sql, new CategoryMapper()); 
    }

    @Override
    public List<Category> sortDesc() {
        String sql = "{Call sort_Category_DESC}";
        return query(sql, new CategoryMapper()); 
    }

}


