/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import models.BillsDetail;

/**
 *
 * @author phamh
 */
public class BillsDetailMapper implements RowMapper<BillsDetail>{

    @Override
    public BillsDetail mapRow(ResultSet rs) {
        BillsDetail billsDetail = new BillsDetail();
        try {
            billsDetail.setBookId(rs.getInt("BooksID"));
            billsDetail.setBillId(rs.getInt("BillsID"));
            billsDetail.setQuantity(rs.getInt("Quantity"));
            billsDetail.setBookName(rs.getNString("BooksName"));
            billsDetail.setBookCode(rs.getString("BooksCode"));
            billsDetail.setPublicser(rs.getNString("PublicserName"));
            billsDetail.setStatus(rs.getInt("Status"));
            return billsDetail;
        } catch (SQLException ex) {
            return null;
        }
    }
    
}
