/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.IBillsDAO;
import java.util.List;
import mapper.BillsMapper;
import models.Bills;

/**
 *
 * @author admin
 */
public class BiilsDAO extends AbstractDAO<Bills> implements IBillsDAO {

    @Override
    public List<Bills> getAll() {
        String sql = "{Call sp_getAll_Bills}";
        return query(sql, new BillsMapper());
    }

    @Override
    public Bills findOne(Integer id) {
        String sql = "{Call sp_finbyid_viewBill (?)}";
        List<Bills> bill = query(sql, new BillsMapper(), id);
        return bill.isEmpty() ? null : bill.get(0);
    }

    @Override
    public Integer save(Bills bills) {
        String sql = "INSERT INTO books.Bills(ReaderID, CreatedDate, PayDay,LirarianID)VALUES(?,?,?,?)";
        return insertReturnId(sql, bills.getReaderId(), bills.getCreatedDate(), bills.getPayDay(), bills.getLibrarianId());
    }

    @Override
    public void update(Bills bills) {
       String sql = "{Call sp_updatePayDay_Bill(?,?,?)}";
       this.update(sql,bills.getCreatedDate(), bills.getPayDay(),bills.getBillsId());
    }

    @Override
    public void delete(Bills bills) {
      String sql = "{Call sp_delete_Bill(?)}";
      this.update(sql, bills.getBillsId());
    }

    @Override
    public void updateStatus(Bills bills) {
       String sql = "{Call sp_updateStatus_Bill(?,?)}";
       this.update(sql,bills.getStatus(), bills.getBillsId());
    }

}
