/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.IPublicserDAO;
import java.util.List;
import mapper.PublicserMapper;
import models.Publicser;

/**
 *
 * @author admin
 */
public class PublicserDAO extends AbstractDAO<Publicser> implements IPublicserDAO{

    @Override
    public List<Publicser> getAll() {
        String sql = "{Call sp_getAll_Publicser}";
        return query(sql, new PublicserMapper());
    }

    @Override
    public void delete(Publicser publicser) {
        String sql = "{Call delete_Publicser_Byid(?)}";
        this.insert(sql, publicser.getPublicserId());
    }

    @Override
    public void update(Publicser publicser) {
        String sql = "{Call update_Publicser(?,?,?)}";
        this.insert(sql, publicser.getPublicserName(),publicser.getAddress(),publicser.getPublicserId());
    }

    @Override
    public void save(Publicser publicser) {
        String sql = "{Call create_Publicser(?,?)}";
        this.insert(sql, publicser.getPublicserName(),publicser.getAddress());
    }

    @Override
    public List<Publicser> sortAsc() {
       String sql = "{Call sort_Publicser_ASC}";
        return query(sql, new PublicserMapper());
    }

    @Override
    public List<Publicser> sortDesc() {
        String sql = "{Call sort_Publicser_DESC}";
        return query(sql, new PublicserMapper());
    }
    
}
