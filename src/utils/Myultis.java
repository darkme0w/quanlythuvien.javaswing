/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTable;
/**
 *
 * @author phamh
 */
public class Myultis {
    public static void clearTable(DefaultTableModel dft) {
        int count = dft.getRowCount();
        for (int i = count - 1; i >= 0; i--) {
            dft.removeRow(i);
        }
    }
    
    public static void filter(String query,DefaultTableModel dft, JTable jtable){
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dft);
        jtable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }
    
    
}
