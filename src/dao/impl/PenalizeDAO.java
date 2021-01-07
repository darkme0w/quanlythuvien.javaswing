/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.IPenalizeDAO;
import java.util.List;
import mapper.PenalizeMapper;
import models.Penalize;

/**
 *
 * @author admin
 */
public class PenalizeDAO extends AbstractDAO<Penalize> implements IPenalizeDAO {

    @Override
    public List<Penalize> getAll() {
        String sql = "{Call sp_getAll_vwPenalize}";
        return query(sql, new PenalizeMapper());
    }

    @Override
    public void save(Penalize penalize) {
        String sql = "{Call create_Penalize(?,?,?)}";
        this.insert(sql, penalize.getReaderId(), penalize.getLibrarianId(), penalize.getNote());
    }

    @Override
    public void update(Penalize penalize) {
        String sql = "{Call update_Penalize(?,?)}";
        this.insert(sql, penalize.getNote(), penalize.getReaderId());
    }

    @Override
    public List<Penalize> sortAsc() {
        String sql = "{Call sp_getAll_vwPenalize_asc}";
        return query(sql, new PenalizeMapper());
    }

    @Override
    public List<Penalize> sortDesc() {
        String sql = "{Call sp_getAll_vwPenalize_desc}";
        return query(sql, new PenalizeMapper());
    }

}
