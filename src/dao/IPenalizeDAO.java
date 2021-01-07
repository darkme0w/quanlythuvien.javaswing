/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.Penalize;

/**
 *
 * @author admin
 */
public interface IPenalizeDAO {
    List<Penalize> getAll();
    void save(Penalize penalize);
    void update(Penalize penalize);
    List<Penalize> sortAsc();
    List<Penalize> sortDesc();
}
