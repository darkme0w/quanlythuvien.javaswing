/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Reader;

/**
 *
 * @author admin
 */
public class ReaderMapper implements RowMapper<Reader> {

    @Override
    public Reader mapRow(ResultSet rs) {
        Reader reader = new Reader();
        try {
            reader.setReaderId(rs.getInt("ReaderID"));
            reader.setReaderName(rs.getNString("ReaderName"));
            reader.setEmail(rs.getNString("Email"));
            reader.setAddress(rs.getNString("Address"));
            reader.setAccount(rs.getFloat("Account"));
            reader.setStatus(rs.getInt("Status"));
            reader.setPhone(rs.getString("Phone"));
            reader.setGender(rs.getInt("Gennder"));
            Date cDate = rs.getDate("CreatedDate");
            reader.setCreatedDate(cDate.toLocalDate());
            return reader;
        } catch (SQLException ex) {
            return null;
        }

    }

}
