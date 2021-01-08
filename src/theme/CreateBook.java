/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theme;

import dao.IAuthorDAO;
import dao.IBookAuthorDAO;
import dao.IBookCategoryDAO;
import dao.IBooksDAO;
import dao.ICategoryDAO;
import dao.ILocationDAO;
import dao.IPublicserDAO;
import dao.impl.AuthorDAO;
import dao.impl.BookAuthorDAO;
import dao.impl.BookCategoryDAO;
import dao.impl.BookDAO;
import dao.impl.CategoryDAO;
import dao.impl.LocationDAO;
import dao.impl.PublicserDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Author;
import models.Book;
import models.BookAuthor;
import models.BookCategory;
import models.Category;
import models.Location;
import models.Publicser;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
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

    //Author
    private List<Author> listAuthor = new ArrayList<>();
    private IAuthorDAO authorDAO;
    private Author author;
    private DefaultTableModel dftAuthor;

    //Category
    private List<Category> listCategory = new ArrayList<>();
    private ICategoryDAO categoryDAO;
    private Category category;
    private DefaultTableModel dftCategory;

    // Book-Author
    private List<BookAuthor> listAuthors = new ArrayList<>();
    private DefaultTableModel dftAuthors;
    private IBookAuthorDAO bookAuthorDAO;
    private BookAuthor bookAuthor;

    //Book-Category
    private List<BookCategory> listCateogry = new ArrayList<>();
    private DefaultTableModel dftCategorys;
    private IBookCategoryDAO bookCategoryDAO;
    private BookCategory bookCategory;

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
        listCategory.removeAll(listCategory);
        listAuthor.removeAll(listAuthor);

        locationDAO = new LocationDAO();
        publicserDAO = new PublicserDAO();
        authorDAO = new AuthorDAO();
        categoryDAO = new CategoryDAO();

        listPublicser = publicserDAO.getAll();
        listLocation = locationDAO.getAll();
        listAuthor = authorDAO.getAll();
        listCategory = categoryDAO.getAll();

        listLocation.forEach(cbLocation::addItem);
        listPublicser.forEach(cbPublicser::addItem);
        listLocation.forEach(cbLocation1::addItem);
        listPublicser.forEach(cbPublicser1::addItem);
        listAuthor.forEach(cbAuthor::addItem);
        listCategory.forEach(cbCategory::addItem);

        AutoCompleteDecorator.decorate(cbLocation);
        AutoCompleteDecorator.decorate(cbPublicser);
        AutoCompleteDecorator.decorate(cbAuthor);
        AutoCompleteDecorator.decorate(cbCategory);

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

    private void preapareAuthorCategory() {
        dftAuthors = new DefaultTableModel();
        dftCategorys = new DefaultTableModel();
        dftAuthors.addColumn("ID");
        dftAuthors.addColumn("Tên tác giả");
        dftCategorys.addColumn("ID");
        dftCategorys.addColumn("Thể loại");
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
        jmDetail = new javax.swing.JMenuItem();
        jmAddDetail = new javax.swing.JMenuItem();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jmDelAuthor = new javax.swing.JMenuItem();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        jmDelCate = new javax.swing.JMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jComboBox3 = new javax.swing.JComboBox<>();
        btnRefesh = new keeptoo.KButton();
        jXSearchField1 = new org.jdesktop.swingx.JXSearchField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        cbLocation = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cbPublicser = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jtYear = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jtBookCode = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jQuantity = new javax.swing.JTextField();
        jtBPrice = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        vldBYear = new javax.swing.JLabel();
        vldBCode = new javax.swing.JLabel();
        vldBQuantity = new javax.swing.JLabel();
        vldBPrice = new javax.swing.JLabel();
        vldBName = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jtBookName = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        cbAuthor = new javax.swing.JComboBox<>();
        btnAddAuthor = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        cbCategory = new javax.swing.JComboBox<>();
        btnAddCategory = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbAuthor = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbCategory = new javax.swing.JTable();
        btnAddBook = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        btnEdit = new keeptoo.KButton();
        jPanel10 = new javax.swing.JPanel();
        cbLocation1 = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        cbPublicser1 = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jtYear1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jtBookCode1 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jQuantity1 = new javax.swing.JTextField();
        jtBPrice1 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel22 = new javax.swing.JLabel();
        vldBYear1 = new javax.swing.JLabel();
        vldBCode1 = new javax.swing.JLabel();
        vldBQuantity1 = new javax.swing.JLabel();
        vldBPrice1 = new javax.swing.JLabel();
        vldBName1 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jtBookName1 = new javax.swing.JTextField();

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

        jmDetail.setText("Chi tiết");
        jmDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmDetailActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jmDetail);

        jmAddDetail.setText("Thêm tác giả ....");
        jmAddDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAddDetailActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jmAddDetail);

        jmDelAuthor.setText("Xóa");
        jmDelAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmDelAuthorActionPerformed(evt);
            }
        });
        jPopupMenu2.add(jmDelAuthor);

        jmDelCate.setText("Xóa");
        jmDelCate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmDelCateActionPerformed(evt);
            }
        });
        jPopupMenu3.add(jmDelCate);

        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(1200, 650));
        setVisible(true);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setPreferredSize(new java.awt.Dimension(544, 60));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sắp xếp", "A-Z", "Z-A" }));
        jComboBox3.setPreferredSize(new java.awt.Dimension(80, 30));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

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

        jXSearchField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jXSearchField1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(328, 328, 328)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRefesh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jXSearchField1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(340, 340, 340))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnRefesh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jXSearchField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1068, -1));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(452, 200));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1190, 390));

        jTabbedPane1.addTab("Danh sách", jPanel3);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thêm sách"));

        cbLocation.setPreferredSize(new java.awt.Dimension(100, 25));
        cbLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLocationActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Vị trí");

        cbPublicser.setPreferredSize(new java.awt.Dimension(100, 25));
        cbPublicser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPublicserActionPerformed(evt);
            }
        });

        jLabel16.setBackground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Nhà xuất bản");

        jtYear.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtYear.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jtYear.setCaretColor(new java.awt.Color(204, 0, 255));
        jtYear.setBackground(new java.awt.Color(0,0,0,0));
        jtYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtYearActionPerformed(evt);
            }
        });
        jtYear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtYearKeyReleased(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Năm xuất bản");

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

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Mã sách");

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Số lượng");

        jQuantity.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jQuantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jQuantity.setCaretColor(new java.awt.Color(204, 0, 255));
        jQuantity.setBackground(new java.awt.Color(0,0,0,0));
        jQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jQuantityActionPerformed(evt);
            }
        });
        jQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jQuantityKeyReleased(evt);
            }
        });

        jtBPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtBPrice.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jtBPrice.setCaretColor(new java.awt.Color(204, 0, 255));
        jtBPrice.setBackground(new java.awt.Color(0,0,0,0));
        jtBPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtBPriceKeyReleased(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Giá sách");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Còn sách");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Hết sách");

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Trạng thái");

        vldBYear.setForeground(new java.awt.Color(255, 0, 51));

        vldBCode.setForeground(new java.awt.Color(255, 0, 51));

        vldBQuantity.setForeground(new java.awt.Color(255, 0, 51));

        vldBPrice.setForeground(new java.awt.Color(255, 0, 51));

        vldBName.setForeground(new java.awt.Color(255, 0, 51));

        jLabel10.setText("Tên sách");

        jtBookName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtBookName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jtBookName.setCaretColor(new java.awt.Color(204, 0, 255));
        jtBPrice.setBackground(new java.awt.Color(0,0,0,0));
        jtBookName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtBookNameKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cbLocation, 0, 186, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel13)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(vldBYear))
                                .addComponent(jtYear))
                            .addComponent(cbPublicser, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(vldBName))
                            .addComponent(jLabel14)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jRadioButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(vldBPrice))
                            .addComponent(jtBPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtBookName, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtBookCode)
                    .addComponent(jQuantity)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vldBCode))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vldBQuantity)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel8))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(vldBName)
                        .addComponent(jLabel10)
                        .addComponent(jLabel9)
                        .addComponent(vldBCode)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtBookCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jtBookName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(vldBQuantity)
                            .addComponent(jLabel11)
                            .addComponent(vldBPrice))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPublicser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtBPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(vldBYear)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addGap(47, 47, 47))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Tác giả"));

        btnAddAuthor.setText("Thêm tác giả");
        btnAddAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAuthorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133)
                .addComponent(btnAddAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbAuthor)
                    .addComponent(btnAddAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Thể loại"));

        btnAddCategory.setText("Thêm thể loại");
        btnAddCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCategoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134)
                .addComponent(btnAddCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCategory, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(btnAddCategory, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Các tác giả"));

        tbAuthor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên tác giả"
            }
        ));
        tbAuthor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbAuthorMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tbAuthor);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Các thể loại"));

        tbCategory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Thể loại"
            }
        ));
        tbCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbCategoryMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tbCategory);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        btnAddBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_save_16px_1.png"))); // NOI18N
        btnAddBook.setText("Thêm sách");
        btnAddBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBookActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAddBook, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(58, 58, 58)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(55, 55, 55)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAddBook, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thêm mới", jPanel1);

        btnEdit.setBackground(new java.awt.Color(0, 0, 0));
        btnEdit.setForeground(new java.awt.Color(0, 0, 0));
        btnEdit.setText("Sửa");
        btnEdit.setkBorderRadius(40);
        btnEdit.setkEndColor(new java.awt.Color(0, 204, 204));
        btnEdit.setkFillButton(false);
        btnEdit.setkForeGround(new java.awt.Color(0, 0, 0));
        btnEdit.setkHoverEndColor(new java.awt.Color(0, 0, 0));
        btnEdit.setkHoverForeGround(new java.awt.Color(255, 204, 255));
        btnEdit.setkHoverStartColor(new java.awt.Color(0, 0, 0));
        btnEdit.setkSelectedColor(new java.awt.Color(0, 0, 0));
        btnEdit.setkStartColor(new java.awt.Color(0, 0, 0));
        btnEdit.setPreferredSize(new java.awt.Dimension(80, 30));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Thêm sách"));

        cbLocation1.setPreferredSize(new java.awt.Dimension(100, 25));
        cbLocation1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLocation1ActionPerformed(evt);
            }
        });

        jLabel15.setBackground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Vị trí");

        cbPublicser1.setPreferredSize(new java.awt.Dimension(100, 25));
        cbPublicser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPublicser1ActionPerformed(evt);
            }
        });

        jLabel17.setBackground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Nhà xuất bản");

        jtYear1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtYear1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jtYear1.setCaretColor(new java.awt.Color(204, 0, 255));
        jtYear.setBackground(new java.awt.Color(0,0,0,0));
        jtYear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtYear1ActionPerformed(evt);
            }
        });
        jtYear1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtYear1KeyReleased(evt);
            }
        });

        jLabel18.setBackground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Năm xuất bản");

        jtBookCode1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtBookCode1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jtBookCode1.setCaretColor(new java.awt.Color(204, 0, 255));
        jtBookCode.setBackground(new java.awt.Color(0,0,0,0));
        jtBookCode1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtBookCode1ActionPerformed(evt);
            }
        });
        jtBookCode1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtBookCode1KeyReleased(evt);
            }
        });

        jLabel19.setBackground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Mã sách");

        jLabel20.setBackground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Số lượng");

        jQuantity1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jQuantity1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jQuantity1.setCaretColor(new java.awt.Color(204, 0, 255));
        jQuantity.setBackground(new java.awt.Color(0,0,0,0));
        jQuantity1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jQuantity1ActionPerformed(evt);
            }
        });
        jQuantity1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jQuantity1KeyReleased(evt);
            }
        });

        jtBPrice1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtBPrice1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jtBPrice1.setCaretColor(new java.awt.Color(204, 0, 255));
        jtBPrice.setBackground(new java.awt.Color(0,0,0,0));
        jtBPrice1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtBPrice1KeyReleased(evt);
            }
        });

        jLabel21.setBackground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Giá sách");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Còn sách");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("Hết sách");

        jLabel22.setBackground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("Trạng thái");

        vldBYear1.setForeground(new java.awt.Color(255, 0, 51));

        vldBCode1.setForeground(new java.awt.Color(255, 0, 51));

        vldBQuantity1.setForeground(new java.awt.Color(255, 0, 51));

        vldBPrice1.setForeground(new java.awt.Color(255, 0, 51));

        vldBName1.setForeground(new java.awt.Color(255, 0, 51));

        jLabel23.setText("Tên sách");

        jtBookName1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtBookName1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jtBookName1.setCaretColor(new java.awt.Color(204, 0, 255));
        jtBPrice.setBackground(new java.awt.Color(0,0,0,0));
        jtBookName1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtBookName1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cbLocation1, 0, 186, Short.MAX_VALUE)
                                .addGroup(jPanel10Layout.createSequentialGroup()
                                    .addComponent(jLabel18)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(vldBYear1))
                                .addComponent(jtYear1))
                            .addComponent(cbPublicser1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(vldBName1))
                            .addComponent(jLabel22)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jRadioButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton4))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(18, 18, 18)
                                .addComponent(vldBPrice1))
                            .addComponent(jtBPrice1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtBookName1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtBookCode1)
                    .addComponent(jQuantity1)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vldBCode1))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vldBQuantity1)))
                        .addGap(0, 135, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel15))
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(vldBName1)
                        .addComponent(jLabel23)
                        .addComponent(jLabel19)
                        .addComponent(vldBCode1)))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbLocation1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtBookCode1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jtBookName1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(vldBQuantity1)
                            .addComponent(jLabel21)
                            .addComponent(vldBPrice1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPublicser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtBPrice1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jQuantity1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(vldBYear1)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtYear1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4))
                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(521, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(259, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Chỉnh sửa", jPanel9);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtBookCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtBookCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtBookCodeActionPerformed

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
        int inIdBook = Integer.valueOf(idBook);
        jtBookCode1.setText(dftbBook.getValueAt(pos, 1).toString());
        jtBookName1.setText(dftbBook.getValueAt(pos, 2).toString());
        jtBPrice1.setText(dftbBook.getValueAt(pos, 3).toString());
        jQuantity1.setText(dftbBook.getValueAt(pos, 4).toString());
        jtYear1.setText(dftbBook.getValueAt(pos, 5).toString());
        for (int i = 0; i < cbPublicser1.getItemCount(); i++) {
            if (dftbBook.getValueAt(pos, 7).toString().equals(cbPublicser1.getItemAt(i).getPublicserName())) {
                cbPublicser1.setSelectedIndex(i);
                break;
            }
        }

        for (int j = 0; j < cbLocation1.getItemCount(); j++) {
            if (dftbBook.getValueAt(pos, 8).toString().equals(cbLocation1.getItemAt(j).getLocationName())) {
                cbLocation1.setSelectedIndex(j);
                break;
            }
        }
        if (dftbBook.getValueAt(pos, 6).toString().equals(jRadioButton3.getActionCommand())) {
            jRadioButton3.setSelected(true);
        } else if (dftbBook.getValueAt(pos, 5).toString().equals(jRadioButton4.getActionCommand())) {
            jRadioButton4.setSelected(true);
        } else {
            jRadioButton3.setSelected(true);
        }
        // Chi tiêt của sách Author and Category
//        preapareAuthorCategory();
//        bookAuthorDAO = new BookAuthorDAO();
//        bookCategoryDAO = new BookCategoryDAO();
//        listAuthors = bookAuthorDAO.getAll(inIdBook);
//        listCateogry = bookCategoryDAO.getAll(inIdBook);
//
//        for (BookAuthor bookAuthor1 : listAuthors) {
//            Vector vA = new Vector();
//
//            vA.add(bookAuthor1.getAuthorId());
//
//            vA.add(bookAuthor1.getAuthorName());
//
//            dftAuthors.addRow(vA);
//        }
//
//        tbAuthor.setModel(dftAuthors);
//
//        for (BookCategory bookCategory1 : listCateogry) {
//            Vector vC = new Vector();
//            vC.add(bookCategory1.getCateogryId());
//
//            vC.add(bookCategory1.getCategoryName());
//
//            dftCategorys.addRow(vC);
//        }
//
//        tbCategory.setModel(dftCategorys);

        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_jmnEditActionPerformed

    private void jmnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnDeleteActionPerformed
        int pos = jTable1.getSelectedRow();
        String bookName = dftbBook.getValueAt(pos, 2).toString();
        int choose = JOptionPane.showConfirmDialog(rootPane, "Bạn chắc chắn muốn xóa " + bookName, "", JOptionPane.OK_CANCEL_OPTION);
        if (choose == JOptionPane.OK_OPTION) {
            idBook = dftbBook.getValueAt(pos, 0).toString();
            int id = Integer.valueOf(idBook);
            //del detail author
            IBookAuthorDAO bookAuthorDAO = new BookAuthorDAO();
            BookAuthor bookAuthor = new BookAuthor();
            bookAuthor.setBookId(id);
            bookAuthorDAO.delete(bookAuthor);

            //del detail category
            IBookCategoryDAO bookCategoryDAO = new BookCategoryDAO();
            BookCategory bookCategory = new BookCategory();
            bookCategory.setBookId(id);
            bookCategoryDAO.delete(bookCategory);

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
//        } else if (jtBookCode.getText().equals(dftbBook.getValueAt(jTable1.getSelectedRow(), 1).toString())) {
//            vldBCode.setText("Mã sách đã tồn tại");
        } else {
            vldBCode.setText("");
        }
    }//GEN-LAST:event_jtBookCodeKeyReleased

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
        } else if (Pattern.matches(regex, jQuantity.getText()) == false) {
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

    private void jQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jQuantityActionPerformed

    private void jtYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtYearActionPerformed

    private void jXSearchField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jXSearchField1KeyReleased
        String query = jXSearchField1.getText();
        Myultis.filter(query, dftbBook, jTable1);
    }//GEN-LAST:event_jXSearchField1KeyReleased

    private void btnAddBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBookActionPerformed
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
                books = new Book();
                books.setBooksCode(bookCode);
                books.setBooksName(bookName);
                books.setBooksPrice(price);
                books.setQuantity(quantity);
                books.setStatus(status);
                books.setYear(year);
                books.setLocationId(idLocaltion.getLocationId());
                books.setPublicserId(idpublicser.getPublicserId());

                int newId = bookDAO.save(books);
                books = bookDAO.findOne(newId);
                int booksNewId = books.getBookId();

                //add author
                IBookAuthorDAO bookAuthorDAO = new BookAuthorDAO();
                Vector dataAuthor = dftAuthor.getDataVector();

                for (int i = 0; i < dataAuthor.size(); i++) {
                    Object objAuthorId = ((Vector) dataAuthor.elementAt(i)).elementAt(0);
                    int authorId = (Integer) objAuthorId;
                    BookAuthor bookAuthor = new BookAuthor(booksNewId, authorId);
                    bookAuthorDAO.save(bookAuthor);
                }

                //add category
                IBookCategoryDAO bookCategoryDAO = new BookCategoryDAO();
                Vector dataCate = dftCategory.getDataVector();

                for (int i = 0; i < dataCate.size(); i++) {
                    Object objCategoryId = ((Vector) dataCate.elementAt(i)).elementAt(0);
                    int categoryId = (Integer) objCategoryId;
                    BookCategory bookCategory = new BookCategory(booksNewId, categoryId);
                    bookCategoryDAO.save(bookCategory);
                }

                Myultis.clearTable(dftbBook);
                Myultis.clearTable(dftCategory);
                Myultis.clearTable(dftAuthor);
                preapareGUI();
                loadData();
                JOptionPane.showMessageDialog(rootPane, "Thêm thành công");
                jtBPrice.setText("");
                jtBookCode.setText("");
                jtBookName.setText("");
                jtYear.setText("");
                jQuantity.setText("");

            } else {
                JOptionPane.showMessageDialog(rootPane, "Vui lòng xem lại các trường dữ liệu");
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "Hãy nhập đủ các trường trước khi thêm");
        }

    }//GEN-LAST:event_btnAddBookActionPerformed

    private void jtBookNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBookNameKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jtBookNameKeyReleased

    private void btnAddAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAuthorActionPerformed
        Author selectAuthor = (Author) cbAuthor.getSelectedItem();
        dftAuthor = (DefaultTableModel) tbAuthor.getModel();
        boolean flag = true;
        Vector dataAuthor = dftAuthor.getDataVector();
        if (dataAuthor.size() <= 0) {
            Object[] row = {selectAuthor.getAuthorId(), selectAuthor.getAuthorName()};
            dftAuthor.addRow(row);
        } else if (dataAuthor.size() > 0) {
            for (int i = 0; i < dataAuthor.size(); i++) {
                Object objAuthorId = ((Vector) dataAuthor.elementAt(i)).elementAt(0);
                Object objAuthorName = ((Vector) dataAuthor.elementAt(i)).elementAt(1);
                int dataId = (Integer) objAuthorId;
                if (selectAuthor.getAuthorId() == dataId) {
                    JOptionPane.showMessageDialog(this, "Đã có " + objAuthorName);
                    flag = false;
                }
            }
            if (flag == true) {
                Object[] row = {selectAuthor.getAuthorId(), selectAuthor.getAuthorName()};
                dftAuthor.addRow(row);
            }
        }


    }//GEN-LAST:event_btnAddAuthorActionPerformed

    private void btnAddCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCategoryActionPerformed
        Category selectCategory = (Category) cbCategory.getSelectedItem();
        dftCategory = (DefaultTableModel) tbCategory.getModel();

        boolean flag = true;
        Vector dataCategory = dftCategory.getDataVector();
        if (dataCategory.size() <= 0) {
            Object[] row = {selectCategory.getCategoryId(), selectCategory.getCategoryName()};
            dftCategory.addRow(row);
        } else if (dataCategory.size() > 0) {
            for (int i = 0; i < dataCategory.size(); i++) {
                Object objCategoryId = ((Vector) dataCategory.elementAt(i)).elementAt(0);
                Object objCategoryName = ((Vector) dataCategory.elementAt(i)).elementAt(1);
                int dataId = (Integer) objCategoryId;
                if (selectCategory.getCategoryId() == dataId) {
                    JOptionPane.showMessageDialog(this, "Đã có " + objCategoryName);
                    flag = false;
                }
            }
            if (flag == true) {
                Object[] row = {selectCategory.getCategoryId(), selectCategory.getCategoryName()};
                dftCategory.addRow(row);
            }
        }


    }//GEN-LAST:event_btnAddCategoryActionPerformed

    private void jmDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmDetailActionPerformed
        int pos = jTable1.getSelectedRow();
        int bookId = Integer.valueOf(dftbBook.getValueAt(pos, 0).toString());
        JLogAuthor jLogAuthor = new JLogAuthor(new javax.swing.JFrame(), true);
        jLogAuthor.loadData(bookId, dftbBook.getValueAt(pos, 2).toString(), dftbBook.getValueAt(pos, 1).toString());
        jLogAuthor.setVisible(true);

    }//GEN-LAST:event_jmDetailActionPerformed

    private void tbAuthorMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAuthorMouseReleased
        if (evt.isPopupTrigger()) {
            jPopupMenu2.show(tbAuthor, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tbAuthorMouseReleased

    private void jmDelAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmDelAuthorActionPerformed
        int id = Integer.valueOf(idBook);
        if (tbAuthor.getSelectedRow() != -1) {
            // remove selected row from the model
            if ((DefaultTableModel) tbAuthor.getModel() == dftAuthor) {
                dftAuthor.removeRow(tbAuthor.getSelectedRow());
                JOptionPane.showMessageDialog(null, "Xóa thành công");
            } else if ((DefaultTableModel) tbAuthor.getModel() == dftAuthors) {
                //del detail author
                IBookAuthorDAO bookAuthorDAO = new BookAuthorDAO();
                BookAuthor bookAuthor = new BookAuthor();
                bookAuthor.setBookId(id);
                bookAuthorDAO.delete(bookAuthor);
            }

        }
    }//GEN-LAST:event_jmDelAuthorActionPerformed

    private void jmDelCateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmDelCateActionPerformed
        int id = Integer.valueOf(idBook);
        if (tbCategory.getSelectedRow() != -1) {
            if ((DefaultTableModel) tbCategory.getModel() == dftCategory) {
                dftCategory.removeRow(tbCategory.getSelectedRow());
                JOptionPane.showMessageDialog(null, "Xóa thành công");
            } else if ((DefaultTableModel) tbCategory.getModel() == dftCategorys) {
                //del detail category
                IBookCategoryDAO bookCategoryDAO = new BookCategoryDAO();
                BookCategory bookCategory = new BookCategory();
                bookCategory.setBookId(id);
                bookCategoryDAO.delete(bookCategory);
            }

        }
    }//GEN-LAST:event_jmDelCateActionPerformed

    private void tbCategoryMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCategoryMouseReleased
        if (evt.isPopupTrigger()) {
            jPopupMenu3.show(tbCategory, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tbCategoryMouseReleased

    private void cbLocation1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLocation1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbLocation1ActionPerformed

    private void cbPublicser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPublicser1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbPublicser1ActionPerformed

    private void jtYear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtYear1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtYear1ActionPerformed

    private void jtYear1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtYear1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jtYear1KeyReleased

    private void jtBookCode1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtBookCode1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtBookCode1ActionPerformed

    private void jtBookCode1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBookCode1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jtBookCode1KeyReleased

    private void jQuantity1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jQuantity1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jQuantity1ActionPerformed

    private void jQuantity1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jQuantity1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jQuantity1KeyReleased

    private void jtBPrice1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBPrice1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jtBPrice1KeyReleased

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jtBookName1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBookName1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jtBookName1KeyReleased

    private void jmAddDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAddDetailActionPerformed
        if (jTable1.getSelectedRow() != -1) {
            int bookId = Integer.valueOf(dftbBook.getValueAt(jTable1.getSelectedRow(), 0).toString());
     
            JLogAddDeitalBook dialog = new JLogAddDeitalBook(new javax.swing.JFrame(), true, bookId,dftbBook.getValueAt(jTable1.getSelectedRow(), 2).toString());
            dialog.setVisible(true);
        }
    }//GEN-LAST:event_jmAddDetailActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddAuthor;
    private javax.swing.JButton btnAddBook;
    private javax.swing.JButton btnAddCategory;
    private keeptoo.KButton btnEdit;
    private keeptoo.KButton btnRefesh;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<Author> cbAuthor;
    private javax.swing.JComboBox<Category> cbCategory;
    private javax.swing.JComboBox<Location> cbLocation;
    private javax.swing.JComboBox<Location> cbLocation1;
    private javax.swing.JComboBox<Publicser> cbPublicser;
    private javax.swing.JComboBox<Publicser> cbPublicser1;
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
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JTextField jQuantity;
    private javax.swing.JTextField jQuantity1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private org.jdesktop.swingx.JXSearchField jXSearchField1;
    private javax.swing.JMenuItem jmAddDetail;
    private javax.swing.JMenuItem jmDelAuthor;
    private javax.swing.JMenuItem jmDelCate;
    private javax.swing.JMenuItem jmDetail;
    private javax.swing.JMenuItem jmnDelete;
    private javax.swing.JMenuItem jmnEdit;
    private javax.swing.JTextField jtBPrice;
    private javax.swing.JTextField jtBPrice1;
    private javax.swing.JTextField jtBookCode;
    private javax.swing.JTextField jtBookCode1;
    private javax.swing.JTextField jtBookName;
    private javax.swing.JTextField jtBookName1;
    private javax.swing.JTextField jtYear;
    private javax.swing.JTextField jtYear1;
    private javax.swing.JTable tbAuthor;
    private javax.swing.JTable tbCategory;
    private javax.swing.JLabel vldBCode;
    private javax.swing.JLabel vldBCode1;
    private javax.swing.JLabel vldBName;
    private javax.swing.JLabel vldBName1;
    private javax.swing.JLabel vldBPrice;
    private javax.swing.JLabel vldBPrice1;
    private javax.swing.JLabel vldBQuantity;
    private javax.swing.JLabel vldBQuantity1;
    private javax.swing.JLabel vldBYear;
    private javax.swing.JLabel vldBYear1;
    // End of variables declaration//GEN-END:variables
}
