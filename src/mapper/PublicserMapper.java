/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Publicser;

/**
 *
 * @author admin
 */
public class PublicserMapper implements RowMapper<Publicser> {

    @Override
    public Publicser mapRow(ResultSet rs) {
        Publicser publicser = new Publicser();
        try {
            publicser.setPublicserId(rs.getInt("PublicserID"));
            publicser.setPublicserName(rs.getNString("PublicserName"));
            publicser.setAddress(rs.getNString("Address"));
            return publicser;
        } catch (SQLException ex) {
            return null;
        }

    }

}
