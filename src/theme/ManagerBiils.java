/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theme;

import dao.IBillsDAO;
import dao.IBillsDetailDAO;
import dao.IBooksDAO;
import dao.IReaderDAO;
import dao.impl.BiilsDAO;
import dao.impl.BillsDetailDAO;
import dao.impl.BookDAO;
import dao.impl.ReaderDAO;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import org.apache.poi.ss.usermodel.Cell;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Bills;
import models.BillsDetail;
import models.Book;
import models.Librarian;
import models.Reader;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import utils.Myultis;

/**
 *
 * @author admin
 */
public class ManagerBiils extends javax.swing.JInternalFrame {

    /**
     * Creates new form ManagerBiils
     */
    private List<Reader> listReader = new ArrayList<>();
    private IReaderDAO readerDAO;
    private Reader reader;

    private List<Book> listBook = new ArrayList<>();
    private IBooksDAO bookDAO;
    private Book book;

    private List<Bills> listBill = new ArrayList<>();
    private Bills bills;
    private IBillsDAO billDAO;
    private IBillsDetailDAO billsDetailDAO;
    private DefaultTableModel defaultTableModel;
    private DefaultTableModel dftbBills;
    private DefaultTableModel dftbBills1;

    public ManagerBiils() {
        initComponents();
        readerDAO = new ReaderDAO();
        bookDAO = new BookDAO();
        loadComboBox();
    }

    private void loadComboBox() {
        listReader.removeAll(listReader);
        listBook.removeAll(listBook);
        listReader = readerDAO.getAll();
        listBook = bookDAO.getAll();
        listReader.forEach(cbReader::addItem);
        listBook.stream().filter(b -> b.getStatus() == 1).forEach((Book e) -> cbBook.addItem(e));
        AutoCompleteDecorator.decorate(cbReader);
        AutoCompleteDecorator.decorate(cbBook);
        spnQuantity.setValue(1);

    }

    private void preapareGUI() {
        dftbBills = new DefaultTableModel();
        dftbBills.addColumn("Mã phiếu");
        dftbBills.addColumn("Ngày mượn");
        dftbBills.addColumn("Ngày trả");
        dftbBills.addColumn("Tên người mượn");
        dftbBills.addColumn("Số điện thoại");
        dftbBills.addColumn("Địa chỉ");
        dftbBills.addColumn("Giới tính");
        dftbBills.addColumn("Người lập phiếu");
        dftbBills.addColumn("Tình trạng");
    }

    private void preapareGUI1() {
        dftbBills1 = new DefaultTableModel();
        dftbBills1.addColumn("Mã phiếu");
        dftbBills1.addColumn("Ngày mượn");
        dftbBills1.addColumn("Ngày trả");
        dftbBills1.addColumn("Tên người mượn");
        dftbBills1.addColumn("Số điện thoại");
        dftbBills1.addColumn("Địa chỉ");
        dftbBills1.addColumn("Giới tính");
        dftbBills1.addColumn("Người lập phiếu");
        dftbBills1.addColumn("Tình trạng");
    }

    private void loadData() {
        listBill = billDAO.getAll();
        Vector v;
        LocalDate nowDate = LocalDate.now();
        for (Bills bills1 : listBill) {
            if (bills1.getStatus() == 0) {
                v = new Vector();
                v.add(bills1.getBillsId());
                v.add(bills1.getCreatedDate());
                v.add(bills1.getPayDay());
                v.add(bills1.getReaderName());
                v.add(bills1.getPhone());
                v.add(bills1.getAddress());
                if (bills1.getGender() == 1) {
                    v.add("Nam");
                } else {
                    v.add("Nữ");
                }
                v.add(bills1.getLibrarianName());
                if (bills1.getPayDay().compareTo(nowDate) < 0) {
                    v.add("Đã quá hạn trả " + nowDate.compareTo(bills1.getPayDay()) + " ngày");
                } else if (bills1.getPayDay().compareTo(nowDate) > 0) {
                    v.add("Thời gian mượn còn " + bills1.getPayDay().compareTo(bills1.getCreatedDate()) + " ngày");
                }
                dftbBills.addRow(v);
            }
        }
        jTable2.setModel(dftbBills);
    }

    private void loadData1() {
        listBill = billDAO.getAll();
        Vector v;
        LocalDate nowDate = LocalDate.now();
        for (Bills bills1 : listBill) {

            v = new Vector();
            v.add(bills1.getBillsId());
            v.add(bills1.getCreatedDate());
            v.add(bills1.getPayDay());
            v.add(bills1.getReaderName());
            v.add(bills1.getPhone());
            v.add(bills1.getAddress());
            if (bills1.getGender() == 1) {
                v.add("Nam");
            } else {
                v.add("Nữ");
            }
            v.add(bills1.getLibrarianName());
            if (bills1.getStatus() == 0) {
                v.add("Chưa trả");
            } else if (bills1.getStatus() == 1) {
                v.add("Đã trả");
            }
            dftbBills1.addRow(v);

        }
        jTable3.setModel(dftbBills1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jmDetail = new javax.swing.JMenuItem();
        jmGiaHan = new javax.swing.JMenuItem();
        jmDelBill = new javax.swing.JMenuItem();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jmDelete = new javax.swing.JMenuItem();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        jmDetail1 = new javax.swing.JMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlAddBill = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btnAddDetailBills = new javax.swing.JButton();
        cbBook = new javax.swing.JComboBox<>();
        lbNameBook = new javax.swing.JLabel();
        lbNXB = new javax.swing.JLabel();
        spnQuantity = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnSaveBills = new javax.swing.JButton();
        lbReaderId = new javax.swing.JLabel();
        lbReaderName = new javax.swing.JLabel();
        cbReader = new javax.swing.JComboBox<>();
        dpEndDate = new org.jdesktop.swingx.JXDatePicker();
        dpStartDate = new org.jdesktop.swingx.JXDatePicker();
        lbIdBill = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jtSearch = new org.jdesktop.swingx.JXSearchField();
        jXButton1 = new org.jdesktop.swingx.JXButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jXSearchField1 = new org.jdesktop.swingx.JXSearchField();

        jmDetail.setText("Chi tiết");
        jmDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmDetailActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jmDetail);

        jmGiaHan.setText("Gia hạn");
        jmGiaHan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmGiaHanActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jmGiaHan);

        jmDelBill.setText("Xóa");
        jmDelBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmDelBillActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jmDelBill);

        jmDelete.setText("Xóa");
        jmDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmDeleteActionPerformed(evt);
            }
        });
        jPopupMenu2.add(jmDelete);

        jmDetail1.setText("Chi tiết");
        jmDetail1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmDetail1ActionPerformed(evt);
            }
        });
        jPopupMenu3.add(jmDetail1);

        setClosable(true);
        setIconifiable(true);
        setPreferredSize(new java.awt.Dimension(1400, 701));

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        pnlAddBill.setPreferredSize(new java.awt.Dimension(1500, 617));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin phiếu mượn"));

        jLabel1.setText("Số điện thoại");

        jLabel2.setText("Mã người mượn");

        jLabel3.setText("Tên người mượn");

        jLabel4.setText("Ngày mượn");

        jLabel5.setText("Ngày trả");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thêm sách mượn"));
        jPanel2.setPreferredSize(new java.awt.Dimension(700, 260));

        jLabel15.setText("Mã sách ");

        jLabel16.setText("Tên sách");

        jLabel17.setText("Nhà xuất bản");

        btnAddDetailBills.setText("Thêm");
        btnAddDetailBills.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDetailBillsActionPerformed(evt);
            }
        });

        cbBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBookActionPerformed(evt);
            }
        });

        spnQuantity.setPreferredSize(new java.awt.Dimension(15, 22));
        spnQuantity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                spnQuantityMouseClicked(evt);
            }
        });
        spnQuantity.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                spnQuantityInputMethodTextChanged(evt);
            }
        });
        spnQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                spnQuantityKeyReleased(evt);
            }
        });

        jLabel6.setText("Số lượng");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddDetailBills, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNXB)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(cbBook, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(63, 63, 63)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNameBook)
                            .addComponent(jLabel16)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(spnQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(305, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNameBook))
                .addGap(55, 55, 55)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel6)
                    .addComponent(spnQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(lbNXB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(btnAddDetailBills)
                .addGap(36, 36, 36))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Mã sách", "Tên sách", "Số lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnSaveBills.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_save_16px_1.png"))); // NOI18N
        btnSaveBills.setText("Lưu phiếu");
        btnSaveBills.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveBillsActionPerformed(evt);
            }
        });

        lbReaderId.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        lbReaderName.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        cbReader.setForeground(new java.awt.Color(255, 255, 255));
        cbReader.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbReaderMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cbReaderMouseReleased(evt);
            }
        });
        cbReader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbReaderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbReader, 0, 215, Short.MAX_VALUE)
                            .addComponent(dpStartDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dpEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lbReaderId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(109, 109, 109)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(75, 75, 75)
                                        .addComponent(lbIdBill, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lbReaderName)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveBills))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lbReaderName)
                                .addComponent(lbReaderId))
                            .addComponent(cbReader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(lbIdBill))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dpEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dpStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(21, 21, 21)
                .addComponent(btnSaveBills, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlAddBillLayout = new javax.swing.GroupLayout(pnlAddBill);
        pnlAddBill.setLayout(pnlAddBillLayout);
        pnlAddBillLayout.setHorizontalGroup(
            pnlAddBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddBillLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        pnlAddBillLayout.setVerticalGroup(
            pnlAddBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddBillLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thêm phiếu mượn", pnlAddBill);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phiếu", "Ngày mượn", "Ngày trả", "Tên độc giả", "Địa chỉ", "Số điện thoại", "Giới tính", "Tình trạng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable2MouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtSearchActionPerformed(evt);
            }
        });
        jtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtSearchKeyReleased(evt);
            }
        });

        jXButton1.setText("Tải lại");
        jXButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1251, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jXButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(jXButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Các phiếu đang mượn", jPanel3);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phiếu", "Ngày mượn", "Ngày trả", "Tên độc giả", "Địa chỉ", "Số điện thoại", "Giới tính", "Tình trạng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable3MouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jXSearchField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jXSearchField1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1251, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jXSearchField1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jXSearchField1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Danh sách phiếu", jPanel4);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbReaderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbReaderActionPerformed
        Reader selectReader = (Reader) cbReader.getSelectedItem();
        String readerId = String.valueOf(selectReader.getReaderId());
        lbReaderId.setText(readerId);
        lbReaderName.setText(selectReader.getReaderName());
//        System.out.println("" + selectReader.getReaderName());
    }//GEN-LAST:event_cbReaderActionPerformed

    private void cbReaderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbReaderMouseClicked

    }//GEN-LAST:event_cbReaderMouseClicked

    private void cbReaderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbReaderMouseReleased

    }//GEN-LAST:event_cbReaderMouseReleased

    private void cbBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBookActionPerformed
        Book selectBook = (Book) cbBook.getSelectedItem();
        String bookName = selectBook.getBooksName();
        String bookNXB = selectBook.getPublicserName();
        lbNameBook.setText(bookName);
        lbNXB.setText(bookNXB);
    }//GEN-LAST:event_cbBookActionPerformed

    private void btnAddDetailBillsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDetailBillsActionPerformed
        Book selectBook = (Book) cbBook.getSelectedItem();
        int quantity = (int) spnQuantity.getValue();
        if (quantity <= 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn số lượng > 0");
            return;
        } else if (quantity > selectBook.getQuantity()) {
            JOptionPane.showMessageDialog(this, "Số lượng sách không đủ");
            return;
        }
        defaultTableModel = (DefaultTableModel) jTable1.getModel();
        boolean flag = true;
        Vector dataDetail = defaultTableModel.getDataVector();
        if (dataDetail.size() <= 0) {
            Object[] row = {selectBook.getBookId(), selectBook.getBooksCode(), selectBook.getBooksName(), quantity};
            defaultTableModel.addRow(row);
        } else if (dataDetail.size() > 0) {
            for (int i = 0; i < dataDetail.size(); i++) {
                Object objBookId = ((Vector) dataDetail.elementAt(i)).elementAt(0);
                Object objBookName = ((Vector) dataDetail.elementAt(i)).elementAt(2);
                int dataId = (Integer) objBookId;
                if (selectBook.getBookId() == dataId) {
                    JOptionPane.showMessageDialog(this, "Đã có " + objBookName);
                    flag = false;
                }
            }
            if (flag == true) {
                Object[] row = {selectBook.getBookId(), selectBook.getBooksCode(), selectBook.getBooksName(), quantity};
                defaultTableModel.addRow(row);
            }
        }


    }//GEN-LAST:event_btnAddDetailBillsActionPerformed

    private void btnSaveBillsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveBillsActionPerformed
        billsDetailDAO = new BillsDetailDAO();
        List<BillsDetail> listBillsDetails = new ArrayList<>();
        Vector data = defaultTableModel.getDataVector();

        //Book
        IBooksDAO booksDAO = new BookDAO();

        billDAO = new BiilsDAO();
        LocalDate startDate = Myultis.convertDatetoLocalDate(dpStartDate.getDate());
        LocalDate endDate = Myultis.convertDatetoLocalDate(dpEndDate.getDate());
        if (endDate.compareTo(startDate) > 15) {
            JOptionPane.showMessageDialog(this, "Thời gian mượn không được quá 15 ngày");
            return;
        }
        int readerId = Integer.valueOf(lbReaderId.getText());
        bills = new Bills();
        bills.setReaderId(readerId);
        bills.setCreatedDate(startDate);
        bills.setPayDay(endDate);
        bills.setLibrarianId(Librarian.getLbId());
        int newId = billDAO.save(bills);
        bills = billDAO.findOne(newId);
        String bId = String.valueOf(bills.getBillsId());

        int billId = Integer.valueOf(bId);
        for (int i = 0; i < data.size(); i++) {
            Object objBookId = ((Vector) data.elementAt(i)).elementAt(0);
            Object objQuantity = ((Vector) data.elementAt(i)).elementAt(3);
            int bookId = (int) objBookId;
            int quantity = (int) objQuantity;
            Book bookU = new Book();
            bookU.setBookId(bookId);
            booksDAO.updateMinusQuantity(bookU, quantity);

            BillsDetail billsDetail = new BillsDetail(billId, bookId, quantity);
            billsDetailDAO.save(billsDetail);
        }
        int choose = JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn xuất phiếu ra Excel", "Xuất phiếu", JOptionPane.OK_CANCEL_OPTION);
        Myultis.clearTable(dftbBills);
        if (choose == JOptionPane.OK_OPTION) {
            try {
                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet spreadsheet = workbook.createSheet("Phiếu mượn trả");
                XSSFRow row = null;
                Cell cell = null;
                row = spreadsheet.createRow((short) 1);
                row.setHeight((short) 500);

                cell = row.createCell(0, CellType.STRING);
//                spreadsheet.autoSizeColumn(0);
                cell.setCellValue("Tên người mượn: " + lbReaderName.getText());
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue("Người lập phiếu: " + Librarian.getLbName());
                cell = row.createCell(4, CellType.STRING);
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                String formattedDate = endDate.format(myFormatObj);
                cell.setCellValue("Ngày trả sách: " + formattedDate);

                row = spreadsheet.createRow((short) 2);
                row.setHeight((short) 500);
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue("PHIẾU MƯỢN TRẢ");
                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue("Mã phiếu: " + lbIdBill.getText());

                row = spreadsheet.createRow((short) 3);
                row.setHeight((short) 500);
                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue("STT");
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue("Mã sách");
                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue("Tên sách");
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue("Số lượng");
                listBillsDetails = billsDetailDAO.getAll(billId);

                for (int i = 0; i < listBillsDetails.size(); i++) {
                    BillsDetail billsDetail = listBillsDetails.get(i);
                    row = spreadsheet.createRow((short) 4 + i);
                    row.setHeight((short) 400);
                    row.createCell(0).setCellValue(i + 1);
                    row.createCell(1).setCellValue(billsDetail.getBookCode());
                    row.createCell(2).setCellValue(billsDetail.getBookName());
                    row.createCell(3).setCellValue(billsDetail.getQuantity());
                }

                FileOutputStream out = new FileOutputStream(new File("D:/phieu.xlsx"));
                workbook.write(out);
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }//GEN-LAST:event_btnSaveBillsActionPerformed

    private void jtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtSearchActionPerformed

    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
        if (evt.isPopupTrigger()) {
            jPopupMenu1.show(jTable2, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_jTable2MouseReleased

    private void jtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtSearchKeyReleased
        String query = jtSearch.getText();
        Myultis.filter(query, dftbBills, jTable2);
    }//GEN-LAST:event_jtSearchKeyReleased

    private void jXButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXButton1ActionPerformed
        Myultis.clearTable(dftbBills);
        preapareGUI();
        loadData();
    }//GEN-LAST:event_jXButton1ActionPerformed

    private void jmDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmDetailActionPerformed
        int pos = jTable2.getSelectedRow();
        int billId = Integer.valueOf(dftbBills.getValueAt(pos, 0).toString());
        JLogBillsDetail dialog = new JLogBillsDetail(new javax.swing.JFrame(), true);
        dialog.loadData(billId);
        dialog.setVisible(true);

    }//GEN-LAST:event_jmDetailActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        billDAO = new BiilsDAO();
        preapareGUI();
        loadData();
        preapareGUI1();
        loadData1();
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        if (evt.isPopupTrigger()) {
            jPopupMenu2.show(jTable1, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_jTable1MouseReleased

    private void jmDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmDeleteActionPerformed
        if (jTable1.getSelectedRow() != -1) {
            // remove selected row from the model
            defaultTableModel.removeRow(jTable1.getSelectedRow());
            JOptionPane.showMessageDialog(null, "Xóa thành công");
        }
    }//GEN-LAST:event_jmDeleteActionPerformed

    private void jmGiaHanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmGiaHanActionPerformed
        if (jTable2.getSelectedRow() != -1) {
            int billId = Integer.valueOf(dftbBills.getValueAt(jTable2.getSelectedRow(), 0).toString());
            LocalDate payDay = LocalDate.parse(dftbBills.getValueAt(jTable2.getSelectedRow(), 2).toString());
            JLogGiaHan dialog = new JLogGiaHan(new javax.swing.JFrame(), true, billId, payDay);
            dialog.setVisible(true);
        }
    }//GEN-LAST:event_jmGiaHanActionPerformed

    private void jmDelBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmDelBillActionPerformed
        if (jTable2.getSelectedRow() != -1) {
            int billId = Integer.valueOf(dftbBills.getValueAt(jTable2.getSelectedRow(), 0).toString());
            billsDetailDAO = new BillsDetailDAO();
            billDAO = new BiilsDAO();
            BillsDetail billsDetail = new BillsDetail();
            billsDetail.setBillId(billId);
            billsDetailDAO.delete(billsDetail);

            Bills bills = new Bills();
            bills.setBillsId(billId);
            billDAO.delete(bills);
            JOptionPane.showMessageDialog(this, "Xóa thành công");
            Myultis.clearTable(dftbBills);
            preapareGUI();
            loadData();
        }
    }//GEN-LAST:event_jmDelBillActionPerformed

    private void jTable3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseReleased
        if (evt.isPopupTrigger()) {
            jPopupMenu3.show(jTable3, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_jTable3MouseReleased

    private void jXSearchField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jXSearchField1KeyReleased
        String search = jXSearchField1.getText();
        Myultis.filter(search, dftbBills1, jTable3);
    }//GEN-LAST:event_jXSearchField1KeyReleased

    private void spnQuantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spnQuantityKeyReleased


    }//GEN-LAST:event_spnQuantityKeyReleased

    private void spnQuantityInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_spnQuantityInputMethodTextChanged


    }//GEN-LAST:event_spnQuantityInputMethodTextChanged

    private void spnQuantityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spnQuantityMouseClicked

    }//GEN-LAST:event_spnQuantityMouseClicked

    private void jmDetail1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmDetail1ActionPerformed
        int pos = jTable3.getSelectedRow();
        int billId = Integer.valueOf(dftbBills1.getValueAt(pos, 0).toString());
        JLogBillsDetail dialog = new JLogBillsDetail(new javax.swing.JFrame(), true);
        dialog.loadData(billId);
        dialog.setVisible(true);
    }//GEN-LAST:event_jmDetail1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddDetailBills;
    private javax.swing.JButton btnSaveBills;
    private javax.swing.JComboBox<Book> cbBook;
    private javax.swing.JComboBox<Reader> cbReader;
    private org.jdesktop.swingx.JXDatePicker dpEndDate;
    private org.jdesktop.swingx.JXDatePicker dpStartDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private org.jdesktop.swingx.JXButton jXButton1;
    private org.jdesktop.swingx.JXSearchField jXSearchField1;
    private javax.swing.JMenuItem jmDelBill;
    private javax.swing.JMenuItem jmDelete;
    private javax.swing.JMenuItem jmDetail;
    private javax.swing.JMenuItem jmDetail1;
    private javax.swing.JMenuItem jmGiaHan;
    private org.jdesktop.swingx.JXSearchField jtSearch;
    private javax.swing.JLabel lbIdBill;
    private javax.swing.JLabel lbNXB;
    private javax.swing.JLabel lbNameBook;
    private javax.swing.JLabel lbReaderId;
    private javax.swing.JLabel lbReaderName;
    private javax.swing.JPanel pnlAddBill;
    private javax.swing.JSpinner spnQuantity;
    // End of variables declaration//GEN-END:variables

}
