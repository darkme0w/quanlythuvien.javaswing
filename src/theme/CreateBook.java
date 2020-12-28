/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theme;

import dao.IBooksDAO;
import dao.ILocationDAO;
import dao.IPublicserDAO;
import dao.impl.BookDAO;
import dao.impl.LocationDAO;
import dao.impl.PublicserDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Book;
import models.Location;
import models.Publicser;
import utils.Myultis;

/**
 *
 * @author admin
 */
public class CreateBook extends javax.swing.JInternalFrame {

    /**
     * Creates new form CreateBook
     */
    private DefaultTableModel dftbBook;
    //Location
    private List<Location> listLocation = new ArrayList<>();
    private ILocationDAO locationDAO;
    private Location location;
    //Publicser 
    private List<Publicser> listPublicser = new ArrayList<>();
    private IPublicserDAO publicserDAO;
    private Publicser publicser;
    //Book
    private List<Book> listBook = new ArrayList<>();
    private IBooksDAO bookDAO;
    private Book books;

    private String idBook;

    public CreateBook() {
        initComponents();
        bookDAO = new BookDAO();
        preapareGUI();
        loadData();
        loadCBox();
    }

    private void loadCBox() {
        listLocation.removeAll(listLocation);
        listPublicser.removeAll(listPublicser);
        locationDAO = new LocationDAO();
        publicserDAO = new PublicserDAO();
        listPublicser = publicserDAO.getAll();
        listLocation = locationDAO.getAll();
        for (Location location1 : listLocation) {
            cbLocation.addItem(location1);

        }
        for (Publicser publicser1 : listPublicser) {
            cbPublicser.addItem(publicser1);
        }

    }

    private void preapareGUI() {
        dftbBook = new DefaultTableModel();
        dftbBook.addColumn("ID");
        dftbBook.addColumn("Mã sách");
        dftbBook.addColumn("Tên sách");
        dftbBook.addColumn("Giá sách");
        dftbBook.addColumn("Số lượng");
        dftbBook.addColumn("Năm xuất bản");
        dftbBook.addColumn("Trạng thái");
        dftbBook.addColumn("Nhà xuất bản");
        dftbBook.addColumn("Vị trí");
    }

    private void loadData() {

        listBook = bookDAO.getAll();
        Vector v;

        for (Book book : listBook) {
            v = new Vector();
            v.add(book.getBookId());
            v.add(book.getBooksCode());
            v.add(book.getBooksName());
            v.add(book.getBooksPrice());
            v.add(book.getQuantity());
            v.add(book.getYear());
            if (book.getStatus() == 1) {
                v.add("Còn sách");
            } else {
                v.add("Hết sách");
            }
            v.add(book.getPublicserName());
            v.add(book.getLocationName());

            dftbBook.addRow(v);
        }

//        listBook.forEach(s->System.out.println(s.toString()));
        jTable1.setModel(dftbBook);
    }

    private int getValueRadio() {
        if (jRadioButton1.isSelected()) {
            return 1;
        } else if (jRadioButton2.isSelected()) {
            return 0;
        } else {
            return 0;
        }
    }

    private void sortByASC() {
        listBook.removeAll(listBook);
        listBook = bookDAO.sortASC();
        Vector v;
        for (Book book : listBook) {
            v = new Vector();
            v.add(book.getBookId());
            v.add(book.getBooksCode());
            v.add(book.getBooksName());
            v.add(book.getBooksPrice());
            v.add(book.getQuantity());
            v.add(book.getYear());
            if (book.getStatus() == 1) {
                v.add("Còn sách");
            } else {
                v.add("Hết sách");
            }
            v.add(book.getPublicserName());
            v.add(book.getLocationName());

            dftbBook.addRow(v);
        }
        jTable1.setModel(dftbBook);
    }

    private void sortByDESC() {
        listBook.removeAll(listBook);
        listBook = bookDAO.sortDESC();
        Vector v;
        for (Book book : listBook) {
            v = new Vector();
            v.add(book.getBookId());
            v.add(book.getBooksCode());
            v.add(book.getBooksName());
            v.add(book.getBooksPrice());
            v.add(book.getQuantity());
            v.add(book.getYear());
            if (book.getStatus() == 1) {
                v.add("Còn sách");
            } else {
                v.add("Hết sách");
            }
            v.add(book.getPublicserName());
            v.add(book.getLocationName());

            dftbBook.addRow(v);
        }
        jTable1.setModel(dftbBook);
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
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jmnEdit = new javax.swing.JMenuItem();
        jmnDelete = new javax.swing.JMenuItem();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtBookCode = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtBookName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jtBPrice = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jQuantity = new javax.swing.JTextField();
        jtYear = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cbLocation = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        cbPublicser = new javax.swing.JComboBox<>();
        btnAdd = new keeptoo.KButton();
        btnEdit = new keeptoo.KButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        vldBCode = new javax.swing.JLabel();
        vldBName = new javax.swing.JLabel();
        vldBPrice = new javax.swing.JLabel();
        vldBQuantity = new javax.swing.JLabel();
        vldBYear = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jComboBox3 = new javax.swing.JComboBox<>();
        btnRefesh = new keeptoo.KButton();
        btnSearch = new keeptoo.KButton();
        txtSearch = new javax.swing.JTextField();
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

        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(1200, 650));
        setVisible(true);

        kGradientPanel1.setkBorderRadius(0);
        kGradientPanel1.setkEndColor(new java.awt.Color(51, 153, 0));
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 204, 204));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(300, 470));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Quản lý sách");
        jLabel6.setPreferredSize(new java.awt.Dimension(215, 29));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Vị trí");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Mã sách");

        jtBookCode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtBookCode.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jtBookCode.setCaretColor(new java.awt.Color(204, 0, 255));
        jtBookCode.setBackground(new java.awt.Color(0,0,0,0));
        jtBookCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtBookCodeActionPerformed(evt);
            }
        });
        jtBookCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtBookCodeKeyReleased(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Tên sách");

        jtBookName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtBookName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jtBookName.setCaretColor(new java.awt.Color(204, 0, 255));
        jtBookName.setBackground(new java.awt.Color(0,0,0,0));
        jtBookName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtBookNameKeyReleased(evt);
            }
        });

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Giá sách");

        jtBPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtBPrice.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jtBPrice.setCaretColor(new java.awt.Color(204, 0, 255));
        jtBPrice.setBackground(new java.awt.Color(0,0,0,0));
        jtBPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtBPriceKeyReleased(evt);
            }
        });

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Số lượng");

        jQuantity.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jQuantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jQuantity.setCaretColor(new java.awt.Color(204, 0, 255));
        jQuantity.setBackground(new java.awt.Color(0,0,0,0));
        jQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jQuantityKeyReleased(evt);
            }
        });

        jtYear.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtYear.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jtYear.setCaretColor(new java.awt.Color(204, 0, 255));
        jtYear.setBackground(new java.awt.Color(0,0,0,0));
        jtYear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtYearKeyReleased(evt);
            }
        });

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Năm xuất bản");

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Trạng thái");

        cbLocation.setPreferredSize(new java.awt.Dimension(100, 25));
        cbLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLocationActionPerformed(evt);
            }
        });

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Nhà xuất bản");

        cbPublicser.setPreferredSize(new java.awt.Dimension(100, 25));
        cbPublicser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPublicserActionPerformed(evt);
            }
        });

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
        btnEdit.setEnabled(false);
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

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Còn sách");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Hết sách");

        vldBCode.setForeground(new java.awt.Color(255, 0, 51));

        vldBName.setForeground(new java.awt.Color(255, 0, 51));

        vldBPrice.setForeground(new java.awt.Color(255, 0, 51));

        vldBQuantity.setForeground(new java.awt.Color(255, 0, 51));

        vldBYear.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbPublicser, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtBookName)
                    .addComponent(jtBPrice)
                    .addComponent(jQuantity)
                    .addComponent(jtYear)
                    .addComponent(jtBookCode)
                    .addComponent(cbLocation, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(vldBCode))
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(vldBName))
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(vldBPrice))
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(vldBQuantity))
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(vldBYear))
                            .addComponent(jLabel14)
                            .addComponent(jLabel16)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(jRadioButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(jRadioButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addGap(5, 5, 5)
                .addComponent(cbLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(cbPublicser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(vldBCode))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtBookCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(vldBName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtBookName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(vldBPrice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtBPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(vldBQuantity))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(vldBYear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addGap(9, 9, 9)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
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
            .addGap(0, 542, Short.MAX_VALUE)
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

        btnRefesh.setText("Tải lại");
        btnRefesh.setkBorderRadius(0);
        btnRefesh.setkEndColor(new java.awt.Color(51, 153, 0));
        btnRefesh.setkHoverEndColor(new java.awt.Color(204, 0, 204));
        btnRefesh.setkHoverForeGround(new java.awt.Color(255, 204, 255));
        btnRefesh.setkHoverStartColor(new java.awt.Color(0, 204, 204));
        btnRefesh.setkStartColor(new java.awt.Color(0, 204, 204));
        btnRefesh.setPreferredSize(new java.awt.Dimension(80, 30));
        btnRefesh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefeshActionPerformed(evt);
            }
        });
        jPanel5.add(btnRefesh);

        btnSearch.setText("Tìm kiếm");
        btnSearch.setkBorderRadius(0);
        btnSearch.setkEndColor(new java.awt.Color(51, 153, 0));
        btnSearch.setkHoverEndColor(new java.awt.Color(204, 0, 204));
        btnSearch.setkHoverForeGround(new java.awt.Color(255, 204, 255));
        btnSearch.setkHoverStartColor(new java.awt.Color(0, 204, 204));
        btnSearch.setkStartColor(new java.awt.Color(0, 204, 204));
        btnSearch.setPreferredSize(new java.awt.Dimension(80, 30));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel5.add(btnSearch);

        txtSearch.setPreferredSize(new java.awt.Dimension(200, 30));
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        jPanel5.add(txtSearch);

        jPanel3.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Mã sách", "Tên sách", "Giá sách", "Số lượng", "Năm xuất bản", "Trạng thái", "Nhà xuất bản", "Vị trí"
            }
        ));
        jTable1.setPreferredSize(new java.awt.Dimension(800, 64));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
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

    private void jtBookCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtBookCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtBookCodeActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String bookCode = jtBookCode.getText();
        String bookName = jtBookName.getText();
        Float price = Float.valueOf(jtBPrice.getText());
        int quantity = Integer.valueOf(jQuantity.getText());
        int year = Integer.valueOf(jtYear.getText());
        int status = getValueRadio();
        Location idLocaltion = (Location) cbLocation.getSelectedItem();
        Publicser idpublicser = (Publicser) cbPublicser.getSelectedItem();
        if (bookCode.isEmpty() == false && bookName.isEmpty() == false && jtBPrice.getText().isEmpty() == false && jQuantity.getText().isEmpty() == false && jtYear.getText().isEmpty() == false) {
            if (vldBCode.getText().isEmpty() && vldBName.getText().isEmpty() && vldBPrice.getText().isEmpty() && vldBQuantity.getText().isEmpty() && vldBYear.getText().isEmpty()) {
                books = new Book(bookCode, bookName, price, quantity, status, year, idLocaltion.getLocationId(), idpublicser.getPublicserId());
                bookDAO.save(books);
                Myultis.clearTable(dftbBook);
                preapareGUI();
                loadData();
            }else{
                JOptionPane.showMessageDialog(rootPane, "Vui lòng xem lại các trường dữ liệu");
            }

        } else {
             JOptionPane.showMessageDialog(rootPane, "Hãy nhập đủ các trường trước khi thêm");
        }


    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed

        Float price = Float.valueOf(jtBPrice.getText());
        int quantity = Integer.valueOf(jQuantity.getText());
        int id = Integer.valueOf(idBook);
        int year = Integer.valueOf(jtYear.getText());
        int status = getValueRadio();
        Location idLocaltion = (Location) cbLocation.getSelectedItem();
        Publicser idpublicser = (Publicser) cbPublicser.getSelectedItem();
        books = new Book(id, jtBookCode.getText(), jtBookName.getText(), price, quantity, status, year, idLocaltion.getLocationId(), idpublicser.getPublicserId());
        bookDAO.update(books);

        Myultis.clearTable(dftbBook);
        preapareGUI();
        loadData();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchActionPerformed

    private void cbLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLocationActionPerformed

    }//GEN-LAST:event_cbLocationActionPerformed

    private void btnRefeshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefeshActionPerformed
        Myultis.clearTable(dftbBook);
        preapareGUI();
        loadData();
    }//GEN-LAST:event_btnRefeshActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed

        if (evt.getSource() == jComboBox3) {
            String msg = (String) jComboBox3.getSelectedItem();
            switch (msg) {
                case "A-Z":
                    Myultis.clearTable(dftbBook);
                    preapareGUI();
                    sortByASC();
                    break;
                case "Z-A":
                    Myultis.clearTable(dftbBook);
                    preapareGUI();
                    sortByDESC();
                    break;
                default:
                    Myultis.clearTable(dftbBook);
                    preapareGUI();
                    loadData();
                    break;
            }
        }
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void cbPublicserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPublicserActionPerformed


    }//GEN-LAST:event_cbPublicserActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        if (evt.isPopupTrigger()) {
            jPopupMenu1.show(jTable1, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_jTable1MouseReleased

    private void jmnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnEditActionPerformed
        int pos = jTable1.getSelectedRow();
        idBook = dftbBook.getValueAt(pos, 0).toString();
        jtBookCode.setText(dftbBook.getValueAt(pos, 1).toString());
        jtBookName.setText(dftbBook.getValueAt(pos, 2).toString());
        jtBPrice.setText(dftbBook.getValueAt(pos, 3).toString());
        jQuantity.setText(dftbBook.getValueAt(pos, 4).toString());
        jtYear.setText(dftbBook.getValueAt(pos, 5).toString());
        for (int i = 0; i < cbPublicser.getItemCount(); i++) {
            if (dftbBook.getValueAt(pos, 7).toString().equals(cbPublicser.getItemAt(i).getPublicserName())) {
                cbPublicser.setSelectedIndex(i);
                break;
            }
        }

        for (int j = 0; j < cbLocation.getItemCount(); j++) {
            if (dftbBook.getValueAt(pos, 8).toString().equals(cbLocation.getItemAt(j).getLocationName())) {
                cbLocation.setSelectedIndex(j);
                break;
            }
        }
        if (dftbBook.getValueAt(pos, 6).toString().equals(jRadioButton1.getActionCommand())) {
            jRadioButton1.setSelected(true);
        } else if (dftbBook.getValueAt(pos, 5).toString().equals(jRadioButton2.getActionCommand())) {
            jRadioButton2.setSelected(true);
        } else {
            jRadioButton1.setSelected(true);
        }
    }//GEN-LAST:event_jmnEditActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String query = txtSearch.getText();
        Myultis.filter(query, dftbBook, jTable1);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void jmnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnDeleteActionPerformed
        int pos = jTable1.getSelectedRow();
        String bookName = dftbBook.getValueAt(pos, 2).toString();
        int choose = JOptionPane.showConfirmDialog(rootPane, "Bạn chắc chắn muốn xóa " + bookName, "", JOptionPane.OK_CANCEL_OPTION);
        if (choose == JOptionPane.OK_OPTION) {
            idBook = dftbBook.getValueAt(pos, 0).toString();
            int id = Integer.valueOf(idBook);
            books = new Book();
            books.setBookId(id);
            bookDAO.delete(books);
            Myultis.clearTable(dftbBook);
            preapareGUI();
            loadData();
        } else {
            System.out.println(".");
        }
    }//GEN-LAST:event_jmnDeleteActionPerformed

    private void jtBookCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBookCodeKeyReleased

        if (jtBookCode.getText().isEmpty()) {
            vldBCode.setText("Không được để trống");
        } else if (jtBookCode.getText().equals(dftbBook.getValueAt(jTable1.getSelectedRow(), 1).toString())) {
            vldBCode.setText("Mã sách đã tồn tại");
        } else {
            vldBCode.setText("");
        }
    }//GEN-LAST:event_jtBookCodeKeyReleased

    private void jtBookNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBookNameKeyReleased
        if (jtBookName.getText().isEmpty()) {
            vldBName.setText("Không được để trống");
        } else {
            vldBName.setText("");
        }

    }//GEN-LAST:event_jtBookNameKeyReleased

    private void jtBPriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBPriceKeyReleased
        String regex = "[0-9]{1,40}";
        if (jtBPrice.getText().isEmpty()) {
            vldBPrice.setText("Không được để trống");
        } else if (Pattern.matches(regex, jtBPrice.getText()) == false) {
            vldBPrice.setText("Chỉ nhập số");
        } else {
            vldBPrice.setText("");
        }

    }//GEN-LAST:event_jtBPriceKeyReleased

    private void jQuantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jQuantityKeyReleased
        String regex = "[0-9]{1,40}";
        if (jQuantity.getText().isEmpty()) {
            vldBQuantity.setText("Không được để trống");
        } else if (Pattern.matches(regex, vldBQuantity.getText()) == false) {
            vldBQuantity.setText("Chỉ nhập số");
        } else {
            vldBQuantity.setText("");
        }
    }//GEN-LAST:event_jQuantityKeyReleased

    private void jtYearKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtYearKeyReleased
        String regex = "\\d{4}";
        if (jtYear.getText().isEmpty()) {
            vldBYear.setText("Không được để trống");
        } else if (Pattern.matches(regex, jtYear.getText()) == false) {
            vldBYear.setText("Nhập đúng định dạng năm");
        } else {
            vldBYear.setText("");
        }
    }//GEN-LAST:event_jtYearKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private keeptoo.KButton btnAdd;
    private keeptoo.KButton btnEdit;
    private keeptoo.KButton btnRefesh;
    private keeptoo.KButton btnSearch;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<Location> cbLocation;
    private javax.swing.JComboBox<Publicser> cbPublicser;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JTextField jQuantity;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenuItem jmnDelete;
    private javax.swing.JMenuItem jmnEdit;
    private javax.swing.JTextField jtBPrice;
    private javax.swing.JTextField jtBookCode;
    private javax.swing.JTextField jtBookName;
    private javax.swing.JTextField jtYear;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JLabel vldBCode;
    private javax.swing.JLabel vldBName;
    private javax.swing.JLabel vldBPrice;
    private javax.swing.JLabel vldBQuantity;
    private javax.swing.JLabel vldBYear;
    // End of variables declaration//GEN-END:variables
}
