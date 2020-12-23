/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theme;

import java.awt.Component;

/**
 *
 * @author admin
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setExtendedState(Home.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuleft = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        pnlquanlysach = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pnlquanlytacgia = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pnlquanlynhaxuatban = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pnlquanlydanhmuc = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        pnlquanlydocgia = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        pnlquanlythuthu = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        pnlquanlyphieumuontra = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        pnlquanlyxuphat = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);

        menuleft.setBackground(new java.awt.Color(255, 255, 255));
        menuleft.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(153, 153, 153)));
        menuleft.setPreferredSize(new java.awt.Dimension(165, 500));
        menuleft.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        jLabel1.setText("library");

        jLabel2.setFont(new java.awt.Font("Gabriola", 0, 24)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_waxing_crescent_30px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        menuleft.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlquanlysach.setBackground(new java.awt.Color(255, 255, 255));
        pnlquanlysach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlquanlysachMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Quản lý sách");
        jLabel3.setToolTipText("");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_book_20px.png"))); // NOI18N

        javax.swing.GroupLayout pnlquanlysachLayout = new javax.swing.GroupLayout(pnlquanlysach);
        pnlquanlysach.setLayout(pnlquanlysachLayout);
        pnlquanlysachLayout.setHorizontalGroup(
            pnlquanlysachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlquanlysachLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        pnlquanlysachLayout.setVerticalGroup(
            pnlquanlysachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlquanlysachLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlquanlysachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlquanlysachLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.add(pnlquanlysach, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        pnlquanlytacgia.setBackground(new java.awt.Color(255, 255, 255));
        pnlquanlytacgia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlquanlytacgiaMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Quản lý tác giả");
        jLabel5.setToolTipText("");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_male_user_20px.png"))); // NOI18N

        javax.swing.GroupLayout pnlquanlytacgiaLayout = new javax.swing.GroupLayout(pnlquanlytacgia);
        pnlquanlytacgia.setLayout(pnlquanlytacgiaLayout);
        pnlquanlytacgiaLayout.setHorizontalGroup(
            pnlquanlytacgiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlquanlytacgiaLayout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        pnlquanlytacgiaLayout.setVerticalGroup(
            pnlquanlytacgiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlquanlytacgiaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlquanlytacgiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlquanlytacgiaLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.add(pnlquanlytacgia, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 150, 40));

        pnlquanlynhaxuatban.setBackground(new java.awt.Color(255, 255, 255));
        pnlquanlynhaxuatban.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlquanlynhaxuatbanMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Quản lý nhà xuất bản");
        jLabel7.setToolTipText("");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_company_20px.png"))); // NOI18N

        javax.swing.GroupLayout pnlquanlynhaxuatbanLayout = new javax.swing.GroupLayout(pnlquanlynhaxuatban);
        pnlquanlynhaxuatban.setLayout(pnlquanlynhaxuatbanLayout);
        pnlquanlynhaxuatbanLayout.setHorizontalGroup(
            pnlquanlynhaxuatbanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlquanlynhaxuatbanLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlquanlynhaxuatbanLayout.setVerticalGroup(
            pnlquanlynhaxuatbanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlquanlynhaxuatbanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlquanlynhaxuatbanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlquanlynhaxuatbanLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.add(pnlquanlynhaxuatban, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 150, 40));

        pnlquanlydanhmuc.setBackground(new java.awt.Color(255, 255, 255));
        pnlquanlydanhmuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlquanlydanhmucMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Quản lý danh mục ");
        jLabel9.setToolTipText("");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_sorting_20px.png"))); // NOI18N

        javax.swing.GroupLayout pnlquanlydanhmucLayout = new javax.swing.GroupLayout(pnlquanlydanhmuc);
        pnlquanlydanhmuc.setLayout(pnlquanlydanhmucLayout);
        pnlquanlydanhmucLayout.setHorizontalGroup(
            pnlquanlydanhmucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlquanlydanhmucLayout.createSequentialGroup()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        pnlquanlydanhmucLayout.setVerticalGroup(
            pnlquanlydanhmucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlquanlydanhmucLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlquanlydanhmucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlquanlydanhmucLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.add(pnlquanlydanhmuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 150, 40));

        pnlquanlydocgia.setBackground(new java.awt.Color(255, 255, 255));
        pnlquanlydocgia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlquanlydocgiaMouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Quản lý độc giả");
        jLabel11.setToolTipText("");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_wattpad_20px.png"))); // NOI18N

        javax.swing.GroupLayout pnlquanlydocgiaLayout = new javax.swing.GroupLayout(pnlquanlydocgia);
        pnlquanlydocgia.setLayout(pnlquanlydocgiaLayout);
        pnlquanlydocgiaLayout.setHorizontalGroup(
            pnlquanlydocgiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlquanlydocgiaLayout.createSequentialGroup()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        pnlquanlydocgiaLayout.setVerticalGroup(
            pnlquanlydocgiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlquanlydocgiaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlquanlydocgiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlquanlydocgiaLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.add(pnlquanlydocgia, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 150, 40));

        pnlquanlythuthu.setBackground(new java.awt.Color(255, 255, 255));
        pnlquanlythuthu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlquanlythuthuMouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Quản lý thủ thư");
        jLabel13.setToolTipText("");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_male_user_20px.png"))); // NOI18N

        javax.swing.GroupLayout pnlquanlythuthuLayout = new javax.swing.GroupLayout(pnlquanlythuthu);
        pnlquanlythuthu.setLayout(pnlquanlythuthuLayout);
        pnlquanlythuthuLayout.setHorizontalGroup(
            pnlquanlythuthuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlquanlythuthuLayout.createSequentialGroup()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        pnlquanlythuthuLayout.setVerticalGroup(
            pnlquanlythuthuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlquanlythuthuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlquanlythuthuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlquanlythuthuLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.add(pnlquanlythuthu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 150, 40));

        pnlquanlyphieumuontra.setBackground(new java.awt.Color(255, 255, 255));
        pnlquanlyphieumuontra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlquanlyphieumuontraMouseClicked(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Quản lý phiếu mượn trả");
        jLabel15.setToolTipText("");

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_bill_20px.png"))); // NOI18N

        javax.swing.GroupLayout pnlquanlyphieumuontraLayout = new javax.swing.GroupLayout(pnlquanlyphieumuontra);
        pnlquanlyphieumuontra.setLayout(pnlquanlyphieumuontraLayout);
        pnlquanlyphieumuontraLayout.setHorizontalGroup(
            pnlquanlyphieumuontraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlquanlyphieumuontraLayout.createSequentialGroup()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlquanlyphieumuontraLayout.setVerticalGroup(
            pnlquanlyphieumuontraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlquanlyphieumuontraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlquanlyphieumuontraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlquanlyphieumuontraLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.add(pnlquanlyphieumuontra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 160, 40));

        pnlquanlyxuphat.setBackground(new java.awt.Color(255, 255, 255));
        pnlquanlyxuphat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlquanlyxuphatMouseClicked(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("Quản lý xử phạt");
        jLabel17.setToolTipText("");

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_soccer_yellow_card_20px.png"))); // NOI18N

        javax.swing.GroupLayout pnlquanlyxuphatLayout = new javax.swing.GroupLayout(pnlquanlyxuphat);
        pnlquanlyxuphat.setLayout(pnlquanlyxuphatLayout);
        pnlquanlyxuphatLayout.setHorizontalGroup(
            pnlquanlyxuphatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlquanlyxuphatLayout.createSequentialGroup()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        pnlquanlyxuphatLayout.setVerticalGroup(
            pnlquanlyxuphatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlquanlyxuphatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlquanlyxuphatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlquanlyxuphatLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.add(pnlquanlyxuphat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 150, 40));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 150, 40));

        menuleft.add(jPanel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(menuleft, java.awt.BorderLayout.LINE_START);

        jPanel3.setToolTipText("");
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel13.setPreferredSize(new java.awt.Dimension(691, 40));

        kGradientPanel1.setkBorderRadius(0);
        kGradientPanel1.setkEndColor(new java.awt.Color(153, 255, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(51, 255, 153));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_delete_30px.png"))); // NOI18N
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_screensharing_30px.png"))); // NOI18N
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(610, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addContainerGap())
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jLabel21))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );

        jPanel3.add(jPanel13, java.awt.BorderLayout.PAGE_START);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 686, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel4, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        // TODO add your handling code here:
        if (this.getExtendedState() != Home.MAXIMIZED_BOTH) {
            this.setExtendedState(Home.MAXIMIZED_BOTH);
        } else {
            this.setExtendedState(Home.NORMAL);
        }
    }//GEN-LAST:event_jLabel22MouseClicked

    private void pnlquanlysachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlquanlysachMouseClicked
 
        
          CreateBook createBook = new CreateBook();
//        boolean flag = false;
//        for (Component component : jPanel4.getComponents()) {
//            if (component instanceof CreateBook) {
//                flag = true;
//                break;
//            }
//        }
//        if (!flag) {
            jPanel4.add(createBook);
            createBook.setVisible(true);
//        }


    }//GEN-LAST:event_pnlquanlysachMouseClicked

    private void pnlquanlytacgiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlquanlytacgiaMouseClicked
        ManagerAuthor managerAuthor = new ManagerAuthor();

        jPanel4.add(managerAuthor);
        managerAuthor.setVisible(true);
    }//GEN-LAST:event_pnlquanlytacgiaMouseClicked

    private void pnlquanlynhaxuatbanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlquanlynhaxuatbanMouseClicked
        MangagerPublicser mangagerPublicser = new MangagerPublicser();
        jPanel4.add(mangagerPublicser);
        mangagerPublicser.setVisible(true);


    }//GEN-LAST:event_pnlquanlynhaxuatbanMouseClicked

    private void pnlquanlydanhmucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlquanlydanhmucMouseClicked
        ManagerCategory managerCategory = new ManagerCategory();
        jPanel4.add(managerCategory);
        managerCategory.setVisible(true);
    }//GEN-LAST:event_pnlquanlydanhmucMouseClicked

    private void pnlquanlydocgiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlquanlydocgiaMouseClicked
        ManagerReaders managerReaders = new ManagerReaders();
        jPanel4.add(managerReaders);
        managerReaders.setVisible(true);
    }//GEN-LAST:event_pnlquanlydocgiaMouseClicked

    private void pnlquanlythuthuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlquanlythuthuMouseClicked
        ManagerLibrarian managerLibrarian = new ManagerLibrarian();
        jPanel4.add(managerLibrarian);
        managerLibrarian.setVisible(true);
    }//GEN-LAST:event_pnlquanlythuthuMouseClicked

    private void pnlquanlyphieumuontraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlquanlyphieumuontraMouseClicked
        ManagerBiils managerBiils = new ManagerBiils();
        jPanel4.add(managerBiils);
        managerBiils.setVisible(true);
    }//GEN-LAST:event_pnlquanlyphieumuontraMouseClicked

    private void pnlquanlyxuphatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlquanlyxuphatMouseClicked
        ManagerPenalize managerPenalize = new ManagerPenalize();
        jPanel4.add(managerPenalize);
        managerPenalize.setVisible(true);
    }//GEN-LAST:event_pnlquanlyxuphatMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JPanel menuleft;
    private javax.swing.JPanel pnlquanlydanhmuc;
    private javax.swing.JPanel pnlquanlydocgia;
    private javax.swing.JPanel pnlquanlynhaxuatban;
    private javax.swing.JPanel pnlquanlyphieumuontra;
    private javax.swing.JPanel pnlquanlysach;
    private javax.swing.JPanel pnlquanlytacgia;
    private javax.swing.JPanel pnlquanlythuthu;
    private javax.swing.JPanel pnlquanlyxuphat;
    // End of variables declaration//GEN-END:variables
}
