/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theme;

import java.lang.Object;
import javax.swing.RowFilter;
import dao.ICategoryDAO;
import dao.impl.CategoryDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import models.Category;

/**
 *
 * @author admin
 */
public class ManagerCategory extends javax.swing.JInternalFrame {

    /**
     * Creates new form ManagerCategory
     */
    private DefaultTableModel dtfCategory;
    private List<Category> listCategory = new ArrayList<Category>();
    private ICategoryDAO categoryDAO;
    private Category category;

    public ManagerCategory() {
        initComponents();
        categoryDAO = new CategoryDAO();
        preapareGUI();
        loadData();
    }

    private void preapareGUI() {
        dtfCategory = new DefaultTableModel();
        dtfCategory.addColumn("Mã danh mục");
        dtfCategory.addColumn("Tên danh mục");
    }

    private void loadData() {
        listCategory.removeAll(listCategory);
        categoryDAO = new CategoryDAO();
        listCategory = categoryDAO.getAll();
        Vector v;

        for (Category category : listCategory) {
            v = new Vector();
            v.add(category.getCategoryId());
            v.add(category.getCategoryName());

            dtfCategory.addRow(v);
        }

        jTable1.setModel(dtfCategory);

        if (listCategory.size() > 0) {
            jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    int pos = jTable1.getSelectedRow();
                    if (pos < 0) {
                        pos = 0;
                    }
                    category = listCategory.get(pos);
                    lblid.setText(String.valueOf(category.getCategoryId()));
                    txtname.setText(category.getCategoryName());
                }

            });
        }

    }

    private void sortByASC() {
        listCategory.removeAll(listCategory);
        categoryDAO = new CategoryDAO();
        listCategory = categoryDAO.sortAsc();
        Vector v;

        for (Category category : listCategory) {
            v = new Vector();
            v.add(category.getCategoryId());
            v.add(category.getCategoryName());

            dtfCategory.addRow(v);
        }

        jTable1.setModel(dtfCategory);

        if (listCategory.size() > 0) {
            jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    int pos = jTable1.getSelectedRow();
                    if (pos < 0) {
                        pos = 0;
                    }
                    category = listCategory.get(pos);
                    lblid.setText(String.valueOf(category.getCategoryId()));
                    txtname.setText(category.getCategoryName());
                }

            });
        }

    }

    private void sortByDESC() {
        listCategory.removeAll(listCategory);
        categoryDAO = new CategoryDAO();
        listCategory = categoryDAO.sortDesc();
        Vector v;

        for (Category category : listCategory) {
            v = new Vector();
            v.add(category.getCategoryId());
            v.add(category.getCategoryName());

            dtfCategory.addRow(v);
        }

        jTable1.setModel(dtfCategory);

        if (listCategory.size() > 0) {
            jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    int pos = jTable1.getSelectedRow();
                    if (pos < 0) {
                        pos = 0;
                    }
                    category = listCategory.get(pos);
                    lblid.setText(String.valueOf(category.getCategoryId()));
                    txtname.setText(category.getCategoryName());
                }

            });
        }

    }

    private void search(String query) {
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dtfCategory);
        jTable1.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }

    private void clearTable() {
        dtfCategory = new DefaultTableModel();
        int count = dtfCategory.getRowCount();
        for (int i = count - 1; i >= 0; i--) {
            dtfCategory.removeRow(i);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel6 = new javax.swing.JLabel();
        jlabel7 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        kButton2 = new keeptoo.KButton();
        update = new keeptoo.KButton();
        txtsearch = new javax.swing.JTextField();
        jComboBox3 = new javax.swing.JComboBox<>();
        btndelete = new keeptoo.KButton();
        btndelete1 = new keeptoo.KButton();
        jlabel8 = new javax.swing.JLabel();
        lblid = new javax.swing.JLabel();
        jlabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        kGradientPanel2.setkBorderRadius(0);
        kGradientPanel2.setkEndColor(new java.awt.Color(51, 153, 0));
        kGradientPanel2.setkStartColor(new java.awt.Color(0, 204, 204));
        kGradientPanel2.setPreferredSize(new java.awt.Dimension(590, 180));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Quản lý danh mục");
        jLabel6.setPreferredSize(new java.awt.Dimension(215, 29));

        jlabel7.setForeground(new java.awt.Color(255, 255, 255));
        jlabel7.setText("Tên danh mục");

        txtname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtname.setForeground(new java.awt.Color(255, 255, 255));
        txtname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtname.setCaretColor(new java.awt.Color(204, 0, 255));
        txtname.setBackground(new java.awt.Color(0,0,0,0));
        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });

        kButton2.setText("Thêm");
        kButton2.setkBorderRadius(40);
        kButton2.setkEndColor(new java.awt.Color(0, 204, 204));
        kButton2.setkFillButton(false);
        kButton2.setkHoverEndColor(new java.awt.Color(204, 0, 204));
        kButton2.setkHoverForeGround(new java.awt.Color(255, 204, 255));
        kButton2.setkHoverStartColor(new java.awt.Color(0, 204, 204));
        kButton2.setkStartColor(new java.awt.Color(255, 255, 255));
        kButton2.setPreferredSize(new java.awt.Dimension(80, 30));
        kButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton2ActionPerformed(evt);
            }
        });

        update.setText("Sửa");
        update.setkBorderRadius(40);
        update.setkEndColor(new java.awt.Color(0, 204, 204));
        update.setkFillButton(false);
        update.setkHoverEndColor(new java.awt.Color(204, 0, 204));
        update.setkHoverForeGround(new java.awt.Color(255, 204, 255));
        update.setkHoverStartColor(new java.awt.Color(0, 204, 204));
        update.setkStartColor(new java.awt.Color(255, 255, 255));
        update.setPreferredSize(new java.awt.Dimension(80, 30));
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        txtsearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtsearch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtsearch.setCaretColor(new java.awt.Color(204, 0, 255));
        txtsearch.setBackground(new java.awt.Color(0,0,0,0));
        txtsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsearchActionPerformed(evt);
            }
        });
        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearchKeyReleased(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sắp xếp", "A-Z", "Z-A" }));
        jComboBox3.setPreferredSize(new java.awt.Dimension(80, 30));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        btndelete.setText("Xóa");
        btndelete.setkBorderRadius(0);
        btndelete.setkEndColor(new java.awt.Color(51, 153, 0));
        btndelete.setkHoverEndColor(new java.awt.Color(204, 0, 204));
        btndelete.setkHoverForeGround(new java.awt.Color(255, 204, 255));
        btndelete.setkHoverStartColor(new java.awt.Color(0, 204, 204));
        btndelete.setkStartColor(new java.awt.Color(0, 204, 204));
        btndelete.setPreferredSize(new java.awt.Dimension(80, 30));
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        btndelete1.setText("Tải lại");
        btndelete1.setkBorderRadius(0);
        btndelete1.setkEndColor(new java.awt.Color(51, 153, 0));
        btndelete1.setkHoverEndColor(new java.awt.Color(204, 0, 204));
        btndelete1.setkHoverForeGround(new java.awt.Color(255, 204, 255));
        btndelete1.setkHoverStartColor(new java.awt.Color(0, 204, 204));
        btndelete1.setkStartColor(new java.awt.Color(0, 204, 204));
        btndelete1.setPreferredSize(new java.awt.Dimension(80, 30));
        btndelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndelete1ActionPerformed(evt);
            }
        });

        jlabel8.setForeground(new java.awt.Color(255, 255, 255));
        jlabel8.setText("Mã danh mục :");

        lblid.setForeground(new java.awt.Color(255, 255, 255));
        lblid.setText("...");

        jlabel9.setForeground(new java.awt.Color(255, 255, 255));
        jlabel9.setText("Tìm kiếm :");

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlabel7)
                            .addComponent(jlabel8))
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btndelete1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                .addComponent(lblid)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jlabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16))))
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel8)
                    .addComponent(lblid)
                    .addComponent(jlabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndelete1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(kGradientPanel2, java.awt.BorderLayout.PAGE_START);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void kButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton2ActionPerformed
        category = new Category();
        category.setCategoryName(txtname.getText());
        categoryDAO.save(category);
        clearTable();
        preapareGUI();
        loadData();
    }//GEN-LAST:event_kButton2ActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        category = new Category();
        int getid = new Integer(lblid.getText());
        category.setCategoryName(txtname.getText());
        category.setCategoryId(getid);
        categoryDAO.update(category);
        clearTable();
        preapareGUI();
        loadData();
    }//GEN-LAST:event_updateActionPerformed

    private void txtsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        categoryDAO.delete(category);
        clearTable();
        preapareGUI();
        loadData();
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btndelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndelete1ActionPerformed
        clearTable();
        preapareGUI();
        loadData();
    }//GEN-LAST:event_btndelete1ActionPerformed

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
        String query = txtsearch.getText();
        search(query);
    }//GEN-LAST:event_txtsearchKeyReleased

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        if (evt.getSource() == jComboBox3) {
            String msg = (String) jComboBox3.getSelectedItem();
            switch (msg) {
                case "A-Z":
                    clearTable();
                    preapareGUI();
                    sortByASC();
                    break;
                case "Z-A":
                    clearTable();
                    preapareGUI();
                    sortByDESC();
                    break;
            }
        }
    }//GEN-LAST:event_jComboBox3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private keeptoo.KButton btndelete;
    private keeptoo.KButton btndelete1;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jlabel7;
    private javax.swing.JLabel jlabel8;
    private javax.swing.JLabel jlabel9;
    private keeptoo.KButton kButton2;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JLabel lblid;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtsearch;
    private keeptoo.KButton update;
    // End of variables declaration//GEN-END:variables

}
