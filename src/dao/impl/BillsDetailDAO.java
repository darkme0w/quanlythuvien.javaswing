/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.IBillsDetailDAO;
import java.util.List;
import models.BillsDetail;

/**
 *
 * @author phamh
 */
public class BillsDetailDAO extends AbstractDAO<BillsDetail> implements IBillsDetailDAO{

    @Override
    public List<BillsDetail> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(BillsDetail billsDetail) {
        String sql = "{Call sp_insert_BillDetail(?,?,?)}";
        this.insert(sql, billsDetail.getBillId(),billsDetail.getBookId(),billsDetail.getQuantity());
    }

    @Override
    public void update(BillsDetail billsDetail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(BillsDetail billsDetail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
