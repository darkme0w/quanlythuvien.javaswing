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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Publicser publicser) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Publicser publicser) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
