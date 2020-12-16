/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import mapper.RowMapper;

/**
 *
 * @author admin
 */
public interface GenericDAO<T> {
       <T> List <T> query(String sql, RowMapper<T> rowMapper, Object... parameter);
       void update(String sql, Object... parameters);
       
       
}
