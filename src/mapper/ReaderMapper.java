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
            reader.setPhone(rs.getString("Phone"));
            reader.setEmail(rs.getString("Email"));
            reader.setAddress(rs.getNString("Address"));
            reader.setAccount(rs.getFloat("Account"));
            reader.setStatus(rs.getInt("Status"));
            reader.setGender(rs.getInt("Gender"));
            Date cDate = rs.getDate("CreatedDate");
            reader.setCreatedDate(cDate.toLocalDate());
            return reader;
        } catch (SQLException ex) {
            return null;
        }

    }

}
