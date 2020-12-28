/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.ILibrarianDAO;
import java.util.List;
import mapper.LibrarianMapper;
import models.Librarian;

/**
 *
 * @author admin
 */
public class LibrarianDAO extends AbstractDAO<Librarian> implements ILibrarianDAO {

    @Override
    public List<Librarian> getAll() {
        String sql = "{Call sp_getAll_Librarian}";
        return query(sql, new LibrarianMapper());
    }

    @Override
    public void delete(Librarian librarian) {
        String sql = "{Call delete_Librarian_Byid(?)}";
        this.insert(sql, librarian.getLibrarianId());
    }

    @Override
    public void update(Librarian librarian) {
        String sql = "{Call update_Librarian(?,?,?,?,?,?,?,?)}";
        this.insert(sql, 
                librarian.getLibrarianName(),
                librarian.getUserName(),
                librarian.getPassword(),
                librarian.getPhone(),
                librarian.getAddress(),
                librarian.getGender(),
                librarian.getPermission(),                
                librarian.getLibrarianId());
    }

    @Override
    public void save(Librarian librarian) {
        String sql = "{Call create_Librarian(?,?,?,?,?,?,?)}";
        this.insert(sql,
                librarian.getLibrarianName(),
                librarian.getUserName(),
                librarian.getPassword(),
                librarian.getPhone(),
                librarian.getAddress(),
                librarian.getGender(),
                librarian.getPermission());
    }

    @Override
    public List<Librarian> sortAsc() {
       String sql = "{Call sort_Librarian_ASC}";
        return query(sql, new LibrarianMapper());
    }

    @Override
    public List<Librarian> sortDesc() {
       String sql = "{Call sort_Librarian_DESC}";
        return query(sql, new LibrarianMapper());
    }

}
