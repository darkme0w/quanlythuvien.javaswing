/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.IReaderDAO;
import java.util.List;
import mapper.ReaderMapper;
import models.Reader;

/**
 *
 * @author admin
 */
public class ReaderDAO extends AbstractDAO<Reader> implements IReaderDAO {

    @Override
    public List<Reader> getAll() {
        String sql = "{Call sp_getAll_Reader}";
        return query(sql, new ReaderMapper());
    }

    @Override
    public void delete(Reader reader) {
        String sql = "{Call sp_delete_Reader(?)}";
        this.update(sql, reader.getReaderId());
    }

    @Override
    public void update(Reader reader) {
        String sql = "{Call sp_edit_Reader(?,?,?,?,?,?,?,?)}";
        this.update(sql, reader.getReaderName(),reader.getPhone(),reader.getEmail(),reader.getAddress(),reader.getAccount(),reader.getStatus(),reader.getGender(),reader.getReaderId());
    }

    @Override
    public void save(Reader reader) {
        String sql = "{Call sp_add_Reader (?,?,?,?,?,?,?)}";
        this.insert(sql, reader.getReaderName(),reader.getPhone(),reader.getEmail(),reader.getAddress(),reader.getAccount(),reader.getStatus(),reader.getGender());
    }

    @Override
    public List<Reader> sortAsc() {
        String sql = "{Call sp_sortByASC_Reader}";
        return this.query(sql, new ReaderMapper());
    }

    @Override
    public List<Reader> sortDesc() {
        String sql = "{Call sp_sortByDESC_Reader}";
        return this.query(sql, new ReaderMapper());
    }

}
