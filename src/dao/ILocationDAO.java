/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.Location;

/**
 *
 * @author admin
 */
public interface ILocationDAO extends GenericDAO<Location>{
    List<Location> getAll();
    void delete(Location location);
    void update(Location location);
    void save(Location location);
}
