/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.Category;

/**
 *
 * @author admin
 */
public interface ICategoryDAO extends GenericDAO<Category> {

    List<Category> getAll();

    void delete(Category category);

    void update(Category category);

    void save(Category category);

    List<Category> sortAsc();

    List<Category> sortDesc();
}
