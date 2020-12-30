/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theme;

import dao.ILibrarianDAO;
import dao.impl.LibrarianDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import models.Librarian;
import utils.Myultis;

/**
 *
 * @author admin
 */
public class ManagerLibrarian extends javax.swing.JInternalFrame {

    /**
     * Creates new form ManagerLibrarian
     */
    private DefaultTableModel dtfLibrarian;
    private List<Librarian> listLibrarian = new ArrayList<Librarian>();
    private ILibrarianDAO librarianDAO;
    private Librarian librarian;
    private String idLibrarian;

    public ManagerLibrarian() {
        initComponents();
        librarianDAO = new LibrarianDAO();
        preapareGUI();
        loadData();
    }

    private void preapareGUI() {
        dtfLibrarian = new DefaultTableModel();
        dtfLibrarian.addColumn("Mã thủ thư");
        dtfLibrarian.addColumn("Tên thủ thư");
        dtfLibrarian.addColumn("Tên tài khoản");
        dtfLibrarian.addColumn("Mật khẩu");
        dtfLibrarian.addColumn("Số điện thoại");
        dtfLibrarian.addColumn("Giới tính");
        dtfLibrarian.addColumn("Quyền");
        dtfLibrarian.addColumn("Ngày tạo");

    }

    private int getValueRadioPermission() {
        if (rdqtv.isSelected()) {
            return 1;
        } else if (rdtt.isSelected()) {
            return 0;
        } else {
            return 0;
        }
    }

    private int getValueRadioGender() {
        if (rdnam.isSelected()) {
            return 1;
        } else if (rdnu.isSelected()) {
            return 0;
        } else {
            return 0;
        }
    }

    private void loadData() {
        listLibrarian.removeAll(listLibrarian);
        listLibrarian = librarianDAO.getAll();
        Vector v;

        for (Librarian librarian : listLibrarian) {
            System.out.println(librarian.getUserName());
            System.out.println(librarian.getPassword());
            v = new Vector();
            v.add(librarian.getLibrarianId());
            v.add(librarian.getLibrarianName());
            v.add(librarian.getUserName());
            v.add(librarian.getPassword());
            v.add(librarian.getPhone());
            if (librarian.getGender() == 1) {
                v.add("Nam");
            }
            if (librarian.getGender() == 2) {
                v.add("Nữ");
            }

            if (librarian.getPermission() == 1) {
                v.add("Quản trị viên");
            }
            if (librarian.getPermission() == 2) {
                v.add("Thủ thư");
            }
            v.add(librarian.getCreatedDate());
            dtfLibrarian.addRow(v);
        }

        jTable1.setModel(dtfLibrarian);

    }
    
    
    private void sortByASC() {
        listLibrarian.removeAll(listLibrarian);
        listLibrarian = librarianDAO.sortAsc();
        Vector v;

        for (Librarian librarian : listLibrarian) {
            v = new Vector();
            v.add(librarian.getLibrarianId());
            v.add(librarian.getLibrarianName());
            v.add(librarian.getUserName());
            v.add(librarian.getPassword());
            v.add(librarian.getPhone());
            if (librarian.getGender() == 1) {
                v.add("Nam");
            }
            if (librarian.getGender() == 2) {
                v.add("Nữ");
            }

            if (librarian.getPermission() == 1) {
                v.add("Quản trị viên");
            }
            if (librarian.getPermission() == 2) {
                v.add("Thủ thư");
            }
            v.add(librarian.getCreatedDate());
            dtfLibrarian.addRow(v);
        }

        jTable1.setModel(dtfLibrarian);

    }
    
    private void sortByDESC() {
        listLibrarian.removeAll(listLibrarian);
        listLibrarian = librarianDAO.sortDesc();
        Vector v;

        for (Librarian librarian : listLibrarian) {
            v = new Vector();
            v.add(librarian.getLibrarianId());
            v.add(librarian.getLibrarianName());
            v.add(librarian.getUserName());
            v.add(librarian.getPassword());
            v.add(librarian.getPhone());
            if (librarian.getGender() == 1) {
                v.add("Nam");
            }
            if (librarian.getGender() == 2) {
                v.add("Nữ");
            }

            if (librarian.getPermission() == 1) {
                v.add("Quản trị viên");
            }
            if (librarian.getPermission() == 2) {
                v.add("Thủ thư");
            }
            v.add(librarian.getCreatedDate());
            dtfLibrarian.addRow(v);
        }

        jTable1.setModel(dtfLibrarian);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jmnEdit = new javax.swing.JMenuItem();
        jmnDelete = new javax.swing.JMenuItem();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        txtUser = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        btnAdd = new keeptoo.KButton();
        btnEdit = new keeptoo.KButton();
        rdnam = new javax.swing.JRadioButton();
        rdnu = new javax.swing.JRadioButton();
        jLabel18 = new javax.swing.JLabel();
        rdqtv = new javax.swing.JRadioButton();
        rdtt = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        pnlma = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jComboBox3 = new javax.swing.JComboBox<>();
        kButton5 = new keeptoo.KButton();
        jLabel17 = new javax.swing.JLabel();
        txtfilter = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jmnEdit.setText("Sửa");
        jmnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnEditActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jmnEdit);

        jmnDelete.setText("Xóa");
        jmnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnDeleteActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jmnDelete);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        kGradientPanel1.setkBorderRadius(0);
        kGradientPanel1.setkEndColor(new java.awt.Color(51, 153, 0));
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 204, 204));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(300, 470));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Quản lý thủ thư");
        jLabel6.setPreferredSize(new java.awt.Dimension(215, 29));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Tên thủ thư");

        txtName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtName.setCaretColor(new java.awt.Color(204, 0, 255));
        txtName.setBackground(new java.awt.Color(0,0,0,0));
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Số điện thoại");

        txtPhone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPhone.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtPhone.setCaretColor(new java.awt.Color(204, 0, 255));
        txtPhone.setBackground(new java.awt.Color(0,0,0,0));
        txtPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneActionPerformed(evt);
            }
        });

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Địa chỉ");

        txtAddress.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtAddress.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtAddress.setCaretColor(new java.awt.Color(204, 0, 255));
        txtAddress.setBackground(new java.awt.Color(0,0,0,0));
        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });

        txtUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUser.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtUser.setCaretColor(new java.awt.Color(204, 0, 255));
        txtUser.setBackground(new java.awt.Color(0,0,0,0));
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Tên tài khoản");

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Mật khẩu");

        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtPassword.setCaretColor(new java.awt.Color(204, 0, 255));
        txtPassword.setBackground(new java.awt.Color(0,0,0,0));
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Giới tính");

        btnAdd.setText("Thêm");
        btnAdd.setkBorderRadius(40);
        btnAdd.setkEndColor(new java.awt.Color(0, 204, 204));
        btnAdd.setkFillButton(false);
        btnAdd.setkHoverEndColor(new java.awt.Color(204, 0, 204));
        btnAdd.setkHoverForeGround(new java.awt.Color(255, 204, 255));
        btnAdd.setkHoverStartColor(new java.awt.Color(0, 204, 204));
        btnAdd.setkStartColor(new java.awt.Color(255, 255, 255));
        btnAdd.setPreferredSize(new java.awt.Dimension(80, 30));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setText("Sửa");
        btnEdit.setkBorderRadius(40);
        btnEdit.setkEndColor(new java.awt.Color(0, 204, 204));
        btnEdit.setkFillButton(false);
        btnEdit.setkHoverEndColor(new java.awt.Color(204, 0, 204));
        btnEdit.setkHoverForeGround(new java.awt.Color(255, 204, 255));
        btnEdit.setkHoverStartColor(new java.awt.Color(0, 204, 204));
        btnEdit.setkStartColor(new java.awt.Color(255, 255, 255));
        btnEdit.setPreferredSize(new java.awt.Dimension(80, 30));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdnam);
        rdnam.setText("Nam");
        rdnam.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        rdnam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdnamActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdnu);
        rdnu.setText("Nữ");
        rdnu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Quyền");

        buttonGroup2.add(rdqtv);
        rdqtv.setText("Quản trị viên");
        rdqtv.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        rdqtv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdqtvActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdtt);
        rdtt.setText("Thủ thư");
        rdtt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Mã thủ thư");

        pnlma.setForeground(new java.awt.Color(255, 255, 255));
        pnlma.setText("...");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10)
                                .addComponent(jLabel11)
                                .addComponent(jLabel12)
                                .addComponent(jLabel13)
                                .addComponent(jLabel14)
                                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(pnlma))
                                .addComponent(jLabel18)
                                .addComponent(jLabel16)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, kGradientPanel1Layout.createSequentialGroup()
                                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(rdnam, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(rdqtv, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(10, 10, 10)
                                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(rdnu, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(rdtt, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGap(46, 46, 46)))
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtAddress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                                .addComponent(txtUser, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(pnlma))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdqtv)
                    .addComponent(rdtt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdnam)
                    .addComponent(rdnu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        getContentPane().add(kGradientPanel1, java.awt.BorderLayout.LINE_START);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setPreferredSize(new java.awt.Dimension(544, 35));
        jPanel2.setLayout(new java.awt.BorderLayout());
        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel4.setPreferredSize(new java.awt.Dimension(20, 445));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel4, java.awt.BorderLayout.LINE_START);

        jPanel5.setPreferredSize(new java.awt.Dimension(544, 60));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sắp xếp", "A-Z", "Z-A" }));
        jComboBox3.setPreferredSize(new java.awt.Dimension(80, 30));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        jPanel5.add(jComboBox3);

        kButton5.setText("Tải lại");
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
        jPanel5.add(kButton5);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("Tìm kiếm");
        jPanel5.add(jLabel17);

        txtfilter.setPreferredSize(new java.awt.Dimension(200, 30));
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
        jPanel5.add(txtfilter);

        jTextField8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jTextField8.setCaretColor(new java.awt.Color(204, 0, 255));
        txtName.setBackground(new java.awt.Color(0,0,0,0));
        jPanel5.add(jTextField8);

        jPanel3.add(jPanel5, java.awt.BorderLayout.PAGE_START);

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
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        librarian = new Librarian();
        librarian.setLibrarianName(txtName.getText());
        librarian.setUserName(txtUser.getText());
        librarian.setPassword(txtPassword.getText());
        librarian.setPhone(txtPhone.getText());
        librarian.setAddress(txtAddress.getText());
        librarian.setGender(getValueRadioGender());
        librarian.setPermission(getValueRadioPermission());
        librarianDAO.save(librarian);
        Myultis.clearTable(dtfLibrarian);
        preapareGUI();
        loadData();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        librarian = new Librarian();
        librarian.setLibrarianName(txtName.getText());
        librarian.setUserName(txtUser.getText());
        librarian.setPassword(txtPassword.getText());
        librarian.setPhone(txtPhone.getText());
        librarian.setAddress(txtAddress.getText());
        librarian.setGender(getValueRadioGender());
        librarian.setPermission(getValueRadioPermission());
        int getid = new Integer(pnlma.getText());
        librarian.setLibrarianId(getid);
        librarianDAO.update(librarian);
        Myultis.clearTable(dtfLibrarian);
        preapareGUI();
        loadData();
    }//GEN-LAST:event_btnEditActionPerformed

    private void kButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton5ActionPerformed
        Myultis.clearTable(dtfLibrarian);
        preapareGUI();
        loadData();
    }//GEN-LAST:event_kButton5ActionPerformed

    private void rdnamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdnamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdnamActionPerformed

    private void rdqtvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdqtvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdqtvActionPerformed

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed

    }//GEN-LAST:event_txtAddressActionPerformed

    private void jmnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnEditActionPerformed
        int pos = jTable1.getSelectedRow();
        idLibrarian = dtfLibrarian.getValueAt(pos, 0).toString();
        pnlma.setText(dtfLibrarian.getValueAt(pos, 0).toString());
        txtName.setText(dtfLibrarian.getValueAt(pos, 1).toString());
        txtPhone.setText(dtfLibrarian.getValueAt(pos, 2).toString());
        txtAddress.setText(dtfLibrarian.getValueAt(pos, 3).toString());
        txtUser.setText(dtfLibrarian.getValueAt(pos, 4).toString());
        txtPhone.setText(dtfLibrarian.getValueAt(pos, 5).toString());
        if (dtfLibrarian.getValueAt(pos, 6).toString().equals(rdnam.getActionCommand())) {
            rdnam.setSelected(true);
        } else if (dtfLibrarian.getValueAt(pos, 6).toString().equals(rdnu.getActionCommand())) {
            rdnu.setSelected(true);
        } else {
            rdnam.setSelected(true);
        }

        if (dtfLibrarian.getValueAt(pos, 6).toString().equals(rdqtv.getActionCommand())) {
            rdqtv.setSelected(true);
        } else if (dtfLibrarian.getValueAt(pos, 6).toString().equals(rdtt.getActionCommand())) {
            rdtt.setSelected(true);
        } else {
            rdqtv.setSelected(true);
        }

    }//GEN-LAST:event_jmnEditActionPerformed

    private void jmnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnDeleteActionPerformed
        int pos = jTable1.getSelectedRow();
        String name = dtfLibrarian.getValueAt(pos, 1).toString();
        int choose = JOptionPane.showConfirmDialog(rootPane, "Bạn chắc chắn muốn xóa " + name, "", JOptionPane.OK_CANCEL_OPTION);
        if (choose == JOptionPane.OK_OPTION) {
            idLibrarian = dtfLibrarian.getValueAt(pos, 0).toString();
            int id = Integer.valueOf(idLibrarian);
            librarian = new Librarian();
            librarian.setLibrarianId(id);
            librarianDAO.delete(librarian);
            Myultis.clearTable(dtfLibrarian);
            preapareGUI();
            loadData();
        } else {
            System.out.println(".");
        }
    }//GEN-LAST:event_jmnDeleteActionPerformed

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        if (evt.isPopupTrigger()) {
            jPopupMenu1.show(jTable1, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_jTable1MouseReleased

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneActionPerformed

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        if (evt.getSource() == jComboBox3) {
            String msg = (String) jComboBox3.getSelectedItem();
            switch (msg) {
                case "A-Z":
                    Myultis.clearTable(dtfLibrarian);
                    preapareGUI();
                    sortByASC();
                    break;
                case "Z-A":
                    Myultis.clearTable(dtfLibrarian);
                    preapareGUI();
                    sortByDESC();
                    break;
            }
        }
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void txtfilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfilterActionPerformed
        
    }//GEN-LAST:event_txtfilterActionPerformed

    private void txtfilterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfilterKeyReleased
        String query = txtfilter.getText();
        Myultis.filter(query, dtfLibrarian, jTable1);
    }//GEN-LAST:event_txtfilterKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private keeptoo.KButton btnAdd;
    private keeptoo.KButton btnEdit;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JMenuItem jmnDelete;
    private javax.swing.JMenuItem jmnEdit;
    private keeptoo.KButton kButton5;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel pnlma;
    private javax.swing.JRadioButton rdnam;
    private javax.swing.JRadioButton rdnu;
    private javax.swing.JRadioButton rdqtv;
    private javax.swing.JRadioButton rdtt;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtUser;
    private javax.swing.JTextField txtfilter;
    // End of variables declaration//GEN-END:variables
}
