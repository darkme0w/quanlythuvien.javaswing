/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.Reader;

/**
 *
 * @author admin
 */
public interface IReaderDAO extends GenericDAO<Reader>{
    List<Reader> getAll();
    void delete(Reader reader);
    void update(Reader reader);
    void save(Reader reader);
    List<Reader> sortAsc();
    List<Reader> sortDesc();
}
