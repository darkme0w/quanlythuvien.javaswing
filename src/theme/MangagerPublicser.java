/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theme;

import dao.IPublicserDAO;
import dao.impl.AuthorDAO;
import dao.impl.PublicserDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import models.Author;
import models.Publicser;

/**
 *
 * @author admin
 */
public class MangagerPublicser extends javax.swing.JInternalFrame {

    private DefaultTableModel dtfPublicser;
    private List<Publicser> listPublicser = new ArrayList<Publicser>();
    private IPublicserDAO publicserDAO;
    private Publicser publicser;

    /**
     * Creates new form MangagerPublicser
     */
    public MangagerPublicser() {
        initComponents();
        publicserDAO = new PublicserDAO();
        preapareGUI();
        loadData();
    }

    private void preapareGUI() {
        dtfPublicser = new DefaultTableModel();
        dtfPublicser.addColumn("Mã nhà xuất bản");
        dtfPublicser.addColumn("Tên nhà xuất bản");
        dtfPublicser.addColumn("Địa chỉ");
    }

    private void loadData() {
        listPublicser.removeAll(listPublicser);
        publicserDAO = new PublicserDAO();
        listPublicser = publicserDAO.getAll();
        Vector v;

        for (Publicser publicser : listPublicser) {
            v = new Vector();
            v.add(publicser.getPublicserId());
            v.add(publicser.getPublicserName());
            v.add(publicser.getAddress());
            dtfPublicser.addRow(v);
        }

        jTable1.setModel(dtfPublicser);

        if (listPublicser.size() > 0) {
            jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    int pos = jTable1.getSelectedRow();
                    if (pos < 0) {
                        pos = 0;
                    }
                    publicser = listPublicser.get(pos);
                    lblid.setText(String.valueOf(publicser.getPublicserId()));
                    txtnhaxuatban.setText(publicser.getPublicserName());
                    txtdiachi.setText(publicser.getAddress());
                }

            });
        }

    }

    private void sortByASC() {
        listPublicser.removeAll(listPublicser);
        publicserDAO = new PublicserDAO();
        listPublicser = publicserDAO.sortAsc();
        Vector v;

        for (Publicser publicser : listPublicser) {
            v = new Vector();
            v.add(publicser.getPublicserId());
            v.add(publicser.getPublicserName());
            v.add(publicser.getAddress());
            dtfPublicser.addRow(v);
        }

        jTable1.setModel(dtfPublicser);

        if (listPublicser.size() > 0) {
            jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    int pos = jTable1.getSelectedRow();
                    if (pos < 0) {
                        pos = 0;
                    }
                    publicser = listPublicser.get(pos);
                    lblid.setText(String.valueOf(publicser.getPublicserId()));
                    txtnhaxuatban.setText(publicser.getPublicserName());
                    txtdiachi.setText(publicser.getAddress());
                }

            });
        }

    }

    private void sortByDESC() {
        listPublicser.removeAll(listPublicser);
        publicserDAO = new PublicserDAO();
        listPublicser = publicserDAO.sortDesc();
        Vector v;

        for (Publicser publicser : listPublicser) {
            v = new Vector();
            v.add(publicser.getPublicserId());
            v.add(publicser.getPublicserName());
            v.add(publicser.getAddress());
            dtfPublicser.addRow(v);
        }

        jTable1.setModel(dtfPublicser);

        if (listPublicser.size() > 0) {
            jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    int pos = jTable1.getSelectedRow();
                    if (pos < 0) {
                        pos = 0;
                    }
                    publicser = listPublicser.get(pos);
                    lblid.setText(String.valueOf(publicser.getPublicserId()));
                    txtnhaxuatban.setText(publicser.getPublicserName());
                    txtdiachi.setText(publicser.getAddress());
                }

            });
        }

    }

    private void clearTable() {
        dtfPublicser = new DefaultTableModel();
        int count = dtfPublicser.getRowCount();
        for (int i = count - 1; i >= 0; i--) {
            dtfPublicser.removeRow(i);
        }
    }

    private void search(String query) {
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dtfPublicser);
        jTable1.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
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
        jLabel9 = new javax.swing.JLabel();
        txtnhaxuatban = new javax.swing.JTextField();
        kButton2 = new keeptoo.KButton();
        kButton3 = new keeptoo.KButton();
        txtfilter = new javax.swing.JTextField();
        jComboBox3 = new javax.swing.JComboBox<>();
        kButton5 = new keeptoo.KButton();
        jLabel10 = new javax.swing.JLabel();
        txtdiachi = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        lblid = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        kButton6 = new keeptoo.KButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        kGradientPanel2.setkBorderRadius(0);
        kGradientPanel2.setkEndColor(new java.awt.Color(51, 153, 0));
        kGradientPanel2.setkStartColor(new java.awt.Color(0, 204, 204));
        kGradientPanel2.setPreferredSize(new java.awt.Dimension(590, 200));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Quản lý nhà xuất bản");
        jLabel6.setPreferredSize(new java.awt.Dimension(215, 29));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Tên nhà xuất bản");

        txtnhaxuatban.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtnhaxuatban.setForeground(new java.awt.Color(255, 255, 255));
        txtnhaxuatban.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtnhaxuatban.setCaretColor(new java.awt.Color(204, 0, 255));
        txtnhaxuatban.setBackground(new java.awt.Color(0,0,0,0));
        txtnhaxuatban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnhaxuatbanActionPerformed(evt);
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

        kButton3.setText("Sửa");
        kButton3.setkBorderRadius(40);
        kButton3.setkEndColor(new java.awt.Color(0, 204, 204));
        kButton3.setkFillButton(false);
        kButton3.setkHoverEndColor(new java.awt.Color(204, 0, 204));
        kButton3.setkHoverForeGround(new java.awt.Color(255, 204, 255));
        kButton3.setkHoverStartColor(new java.awt.Color(0, 204, 204));
        kButton3.setkStartColor(new java.awt.Color(255, 255, 255));
        kButton3.setPreferredSize(new java.awt.Dimension(80, 30));
        kButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton3ActionPerformed(evt);
            }
        });

        txtfilter.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtfilter.setForeground(new java.awt.Color(255, 255, 255));
        txtfilter.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtfilter.setCaretColor(new java.awt.Color(204, 0, 255));
        txtfilter.setBackground(new java.awt.Color(0,0,0,0));
        txtfilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfilterActionPerformed(evt);
            }
        });
        txtfilter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtfilterKeyReleased(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sắp xếp", "A-Z", "Z-A" }));
        jComboBox3.setPreferredSize(new java.awt.Dimension(80, 30));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        kButton5.setText("Xóa");
        kButton5.setkBorderRadius(0);
        kButton5.setkEndColor(new java.awt.Color(51, 153, 0));
        kButton5.setkHoverEndColor(new java.awt.Color(204, 0, 204));
        kButton5.setkHoverForeGround(new java.awt.Color(255, 204, 255));
        kButton5.setkHoverStartColor(new java.awt.Color(0, 204, 204));
        kButton5.setkStartColor(new java.awt.Color(0, 204, 204));
        kButton5.setPreferredSize(new java.awt.Dimension(80, 30));
        kButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton5ActionPerformed(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Địa chỉ");

        txtdiachi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtdiachi.setForeground(new java.awt.Color(255, 255, 255));
        txtdiachi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtdiachi.setCaretColor(new java.awt.Color(204, 0, 255));
        txtdiachi.setBackground(new java.awt.Color(0,0,0,0));
        txtdiachi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdiachiActionPerformed(evt);
            }
        });

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Mã nhà xuất bản");

        lblid.setForeground(new java.awt.Color(255, 255, 255));
        lblid.setText("...");

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Tìm kiếm");

        kButton6.setText("Tải lại");
        kButton6.setkBorderRadius(0);
        kButton6.setkEndColor(new java.awt.Color(51, 153, 0));
        kButton6.setkHoverEndColor(new java.awt.Color(204, 0, 204));
        kButton6.setkHoverForeGround(new java.awt.Color(255, 204, 255));
        kButton6.setkHoverStartColor(new java.awt.Color(0, 204, 204));
        kButton6.setkStartColor(new java.awt.Color(0, 204, 204));
        kButton6.setPreferredSize(new java.awt.Dimension(80, 30));
        kButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtfilter, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(kButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(kButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(71, 71, 71)
                        .addComponent(txtdiachi))
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                .addComponent(lblid)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                .addComponent(txtnhaxuatban, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                                .addGap(250, 250, 250)))))
                .addContainerGap())
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(lblid)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtnhaxuatban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(kGradientPanel2, java.awt.BorderLayout.PAGE_START);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(200, 402));

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

    private void txtnhaxuatbanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnhaxuatbanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnhaxuatbanActionPerformed

    private void kButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton2ActionPerformed
        publicser = new Publicser();
        publicser.setPublicserName(txtnhaxuatban.getText());
        publicser.setAddress(txtdiachi.getText());
        publicserDAO.save(publicser);
        clearTable();
        preapareGUI();
        loadData();
    }//GEN-LAST:event_kButton2ActionPerformed

    private void kButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton3ActionPerformed
        publicser = new Publicser();
        int getid = new Integer(lblid.getText());
        publicser.setPublicserName(txtnhaxuatban.getText());
        publicser.setAddress(txtdiachi.getText());
        publicser.setPublicserId(getid);
        publicserDAO.update(publicser);
        System.out.println(getid);
        clearTable();
        preapareGUI();
        loadData();
    }//GEN-LAST:event_kButton3ActionPerformed

    private void txtfilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfilterActionPerformed

    private void kButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton5ActionPerformed
        publicserDAO.delete(publicser);
        clearTable();
        preapareGUI();
        loadData();
    }//GEN-LAST:event_kButton5ActionPerformed

    private void txtdiachiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdiachiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdiachiActionPerformed

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

    private void txtfilterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfilterKeyReleased
        String query = txtfilter.getText();
        search(query);
    }//GEN-LAST:event_txtfilterKeyReleased

    private void kButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton6ActionPerformed
        clearTable();
        preapareGUI();
        loadData();
    }//GEN-LAST:event_kButton6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private keeptoo.KButton kButton2;
    private keeptoo.KButton kButton3;
    private keeptoo.KButton kButton5;
    private keeptoo.KButton kButton6;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JLabel lblid;
    private javax.swing.JTextField txtdiachi;
    private javax.swing.JTextField txtfilter;
    private javax.swing.JTextField txtnhaxuatban;
    // End of variables declaration//GEN-END:variables
}
