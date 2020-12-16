/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import models.Location;

/**
 *
 * @author admin
 */
public class LocationMapper implements RowMapper<Location> {

    @Override
    public Location mapRow(ResultSet rs) {
        Location location = new Location();
        try {
            location.setLocationId(rs.getInt("LocationID"));
            location.setLocationName(rs.getNString("LocationName"));
            return location;

        } catch (SQLException e) {
            return null;
        }
    }

}
