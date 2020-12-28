/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.Librarian;

/**
 *
 * @author admin
 */
public interface ILibrarianDAO extends GenericDAO<Librarian>{
    List<Librarian> getAll();
    void delete(Librarian librarian);
    void update(Librarian librarian);
    void save(Librarian librarian);
    List<Librarian> sortAsc();
    List<Librarian> sortDesc();
}
