/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.ILocationDAO;
import java.util.List;
import mapper.LocationMapper;
import models.Location;

/**
 *
 * @author admin
 */
public class LocationDAO extends AbstractDAO<Location> implements ILocationDAO {

    @Override
    public List<Location> getAll() {
        String sql = "{Call sp_getAll_Location}";
        return query(sql, new LocationMapper());
    }

    @Override
    public void delete(Location location) {
        String sql = "";
        this.update(sql, location.getLocationId());
    }

    @Override
    public void update(Location location) {
        String sql = "";
        this.update(sql, location.getLocationName(), location.getLocationId());
    }

    @Override
    public void save(Location location) {
        String sql="";
        this.insert(sql, location.getLocationName());
    }
}
