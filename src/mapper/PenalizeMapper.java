/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import models.Penalize;

/**
 *
 * @author admin
 */
public class PenalizeMapper implements RowMapper<Penalize> {

    @Override
    public Penalize mapRow(ResultSet rs) {
        Penalize penalize = new Penalize();
        try {
            penalize.setLibrarianName(rs.getNString("LibrarianName"));
            penalize.setReaderName(rs.getString("Phone"));
            penalize.setPhone(rs.getNString("ReaderName"));
            penalize.setNote(rs.getNString("Note"));
            return penalize;
        } catch (SQLException ex) {
            return null;
        }
    }

}
