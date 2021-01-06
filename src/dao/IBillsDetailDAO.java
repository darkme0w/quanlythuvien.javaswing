/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.BillsDetail;

/**
 *
 * @author phamh
 */
public interface IBillsDetailDAO extends GenericDAO<BillsDetail>{
    List<BillsDetail> getAll(int billId);
    void save(BillsDetail billsDetail);
    void update(BillsDetail billsDetail);
    void delete(BillsDetail billsDetail);
}
