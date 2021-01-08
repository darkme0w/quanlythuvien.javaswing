/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.Bills;

/**
 *
 * @author admin
 */
public interface IBillsDAO extends GenericDAO<Bills>{
    List<Bills> getAll();
    Bills findOne(Integer id);
    Integer save(Bills bills);
    void update(Bills bills);
    void delete(Bills bills);
    void updateStatus(Bills bills);
}
