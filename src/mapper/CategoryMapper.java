/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Category;

/**
 *
 * @author admin
 */
public class CategoryMapper implements RowMapper<Category>{

    @Override
    public Category mapRow(ResultSet rs) {
      Category category = new Category();
        try {
            category.setCategoryId(rs.getInt("CategoryID"));
            category.setCategoryName(rs.getNString("CategoryName"));
            return category;
        } catch (SQLException ex) {
            return null;
        }
    }
    
}
