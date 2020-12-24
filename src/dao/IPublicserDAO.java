/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.Publicser;

/**
 *
 * @author admin
 */
public interface IPublicserDAO extends GenericDAO<Publicser>{
    List<Publicser> getAll();
    void delete(Publicser publicser);
    void update(Publicser publicser);
    void save(Publicser publicser);
    List<Publicser> sortAsc();
    List<Publicser> sortDesc();
}
