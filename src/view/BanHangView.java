/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controler.controler;
import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.GioHang;
import model.HoaDon;
import model.SanPham;
import model.Voucher;

/**
 *
 * @author hoantp
 */
public class BanHangView extends javax.swing.JFrame {

    /**
     * Creates new form BanHangView
     */
    public BanHangView() {
        initComponents();
        setLocationRelativeTo(null);
        menu_bar.setBackground(new java.awt.Color(0, 0, 0, 1));
        logo.setBackground(new java.awt.Color(0, 0, 0, 1));
    }
    private final controler ctl = new controler();
    private final List<SanPham> listSp = ctl.getDataProducts();
    private final List<GioHang> listGioHang = ctl.listGioHang;
    private final List<HoaDon> listHDChuaThanhToan = ctl.listHoaDonChuaThanhToan;
    private final List<Voucher> listVoucher = ctl.listVoucher;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    DefaultTableModel dtm;
    int index = -1;
    int viTriHoaDon = -1;
    int chooseVoucher = -1;
    int voucherID = -1;
    double total;
    int check = 0;

    private void getData() {
        dtm = (DefaultTableModel) tblProducts.getModel();
        dtm.setRowCount(0);

        for (SanPham sp : listSp) {
            dtm.addRow(new Object[]{sp.getId(), sp.getIdSP(), sp.getTenSp(), sp.getNamBan(), sp.getTrongLuong(), sp.getMoTa(), sp.getSoLuong(), sp.getGiaNhap(), sp.getGiaBan()});
        }
    }

    private void fillDataCart() {
        dtm = (DefaultTableModel) tblCart.getModel();
        dtm.setRowCount(0);

        for (GioHang gh : listGioHang) {
            dtm.addRow(new Object[]{gh.getId(), gh.getMaSp(), gh.getTenSp(), gh.getSoLuong(), gh.getDonGia(), gh.getThanhTien()});
        }
    }

    private void fillDataBill(List<HoaDon> list) {
        dtm = (DefaultTableModel) tblBill.getModel();
        dtm.setRowCount(0);

        for (HoaDon hd : list) {
            dtm.addRow(new Object[]{hd.getId(), hd.getMaHD(), hd.getNgayTao(), hd.getTenNV(), hd.getTinhTrang()});
        }
    }

    private void fillDataVoucher(List<Voucher> list) {
        dtm = (DefaultTableModel) tblVoucher.getModel();
        dtm.setRowCount(0);
        Date now = new Date();
        for (Voucher v : list) {
            dtm.addRow(new Object[]{v.getMaVoucher(), v.getTieuDe(), v.getGiaTri() + v.getLoai(), v.getDieuKien(), v.getNgayBatDau(), v.getNgayKetThuc(), insertToTable(v, now)});
        }

        dtm = (DefaultTableModel) tblVoucher1.getModel();
        dtm.setRowCount(0);

        for (Voucher v : list) {
            dtm.addRow(new Object[]{v.getMaVoucher(), v.getTieuDe(), v.getGiaTri() + v.getLoai(), v.getDieuKien(), v.getNgayBatDau(), v.getNgayKetThuc(), insertToTable(v, now)});
        }
    }

    private String insertToTable(Voucher v, Date now) {
        try {
            if (sdf.parse(v.getNgayBatDau()).after(now)) {
                return "Chua duoc su dung";
            } else if (sdf.parse(v.getNgayKetThuc()).before(now)) {
                return "Het Han";
            } else {
                return "Con Han";
            }
        } catch (ParseException ex) {
            return "";
        }
    }

    public void reset() {
        txtBillId.setText("");
        txtChange.setText("");
        txtDateCreate.setText("");
        txtMoneyPay.setText("");
        txtStaffName.setText("");
        txtTotal.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel10 = new javax.swing.JLabel();
        main_Panel = new javax.swing.JPanel();
        sell_panel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCart = new javax.swing.JTable();
        btnRemoveProductInCart = new javax.swing.JButton();
        btnUpdateProductInCart = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBill = new javax.swing.JTable();
        btnCancelledBill = new javax.swing.JButton();
        btnCreateBill = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtBillId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtStaffName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMoneyPay = new javax.swing.JTextField();
        txtChange = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnPay = new javax.swing.JButton();
        txtDateCreate = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lblReduce = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblVoucher1 = new javax.swing.JTable();
        Detail_Bill_Panel = new javax.swing.JPanel();
        formHoaDon2 = new view.FormHoaDon();
        voucher_panel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblVoucher = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btnCreateVoucher = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txtVoucherID = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        rdoVnd = new javax.swing.JRadioButton();
        txtVoucherValue = new javax.swing.JTextField();
        rdoPercent = new javax.swing.JRadioButton();
        jLabel19 = new javax.swing.JLabel();
        txtSince = new com.toedter.calendar.JDateChooser();
        jLabel20 = new javax.swing.JLabel();
        txtTo = new com.toedter.calendar.JDateChooser();
        btnResetForm = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        txtCondition = new javax.swing.JTextField();
        rdoTotalBill = new javax.swing.JRadioButton();
        rdoTotalProduct = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        btnSearhVoucher = new javax.swing.JButton();
        txtIdS = new javax.swing.JTextField();
        cbxTypeVoucher = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtSinceS = new com.toedter.calendar.JDateChooser();
        jLabel23 = new javax.swing.JLabel();
        txtToS = new com.toedter.calendar.JDateChooser();
        menu_Panel2 = new view.menu_Panel();
        logo = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        menu_bar = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon("F:\\JAVA3\\Asm_icon\\remove.png")); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        main_Panel.setLayout(new java.awt.CardLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Sản Phẩm", "Tên Sản Phẩm", "Số Lượng", "Đơn Giá", "Thành Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblCart);

        btnRemoveProductInCart.setText("Xóa");
        btnRemoveProductInCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveProductInCartActionPerformed(evt);
            }
        });

        btnUpdateProductInCart.setText("Sửa");
        btnUpdateProductInCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateProductInCartActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Giỏ Hàng");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRemoveProductInCart)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdateProductInCart))
                    .addComponent(jLabel8))
                .addContainerGap(294, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemoveProductInCart)
                    .addComponent(btnUpdateProductInCart))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblBill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã HD", "Ngày tạo", "Tên nhân viên", "Tình trạng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBillMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblBill);

        btnCancelledBill.setText("Hủy hóa đơn");
        btnCancelledBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelledBillActionPerformed(evt);
            }
        });

        btnCreateBill.setText("Tạo hóa đơn");
        btnCreateBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateBillActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Hóa Đơn");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnCreateBill)
                                .addGap(30, 30, 30)
                                .addComponent(btnCancelledBill)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreateBill)
                    .addComponent(btnCancelledBill))
                .addGap(7, 7, 7))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Mã Hd");

        txtBillId.setEnabled(false);

        jLabel3.setText("Ngày Tạo");

        jLabel4.setText("Tên Nv");

        txtStaffName.setEnabled(false);

        jLabel5.setText("Tổng Tiền");

        txtTotal.setEnabled(false);

        jLabel6.setText("Tiền Khách Đưa");

        txtMoneyPay.setEnabled(false);
        txtMoneyPay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMoneyPayKeyReleased(evt);
            }
        });

        txtChange.setEnabled(false);

        jLabel7.setText("Tiền Thừa");

        btnPay.setText("Thanh Toán");
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });

        txtDateCreate.setEnabled(false);

        jLabel25.setText("Mã Nv");

        jLabel26.setText("Mã KH");

        jTextField2.setText("jTextField2");

        jTextField3.setText("jTextField2");

        jLabel27.setText("Tên KH");

        jLabel28.setText("Số Điện Thoại");

        jTextField4.setText("jTextField2");

        jButton1.setText(". . .");

        lblReduce.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblReduce.setForeground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(jLabel27)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDateCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(txtBillId, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel25))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                            .addComponent(txtStaffName)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtChange, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMoneyPay, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblReduce))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTextField1, txtBillId, txtDateCreate, txtStaffName});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBillId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDateCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(txtStaffName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblReduce)
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtMoneyPay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtChange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(btnPay)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder()));

        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Sản Phẩm", "Tên Sản Phẩm", "Năm Bán", "Trọng Lượng", "Mô Tả", "SL SP", "Giá Nhập", "Giá Bán"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductsMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblProducts);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Sản Phẩm");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel24.setText("Voucher");

        tblVoucher1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Voucher", "Tiêu Đề", "Giá Trị", "Điều Kiện", "Ngày Bắt Đầu", "Ngày Kết Thúc", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVoucher1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVoucher1MouseClicked(evt);
            }
        });
        tblVoucher1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tblVoucher1KeyTyped(evt);
            }
        });
        jScrollPane6.setViewportView(tblVoucher1);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane6)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout sell_panelLayout = new javax.swing.GroupLayout(sell_panel);
        sell_panel.setLayout(sell_panelLayout);
        sell_panelLayout.setHorizontalGroup(
            sell_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sell_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sell_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(sell_panelLayout.createSequentialGroup()
                        .addGroup(sell_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(sell_panelLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        sell_panelLayout.setVerticalGroup(
            sell_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sell_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sell_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sell_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sell_panelLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(sell_panelLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(58, 58, 58)))
                .addContainerGap())
        );

        main_Panel.add(sell_panel, "card2");

        javax.swing.GroupLayout Detail_Bill_PanelLayout = new javax.swing.GroupLayout(Detail_Bill_Panel);
        Detail_Bill_Panel.setLayout(Detail_Bill_PanelLayout);
        Detail_Bill_PanelLayout.setHorizontalGroup(
            Detail_Bill_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Detail_Bill_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(formHoaDon2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(363, Short.MAX_VALUE))
        );
        Detail_Bill_PanelLayout.setVerticalGroup(
            Detail_Bill_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Detail_Bill_PanelLayout.createSequentialGroup()
                .addComponent(formHoaDon2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        main_Panel.add(Detail_Bill_Panel, "card3");

        tblVoucher.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Voucher", "Tiêu đề", "Giá Trị", "Điều Kiện", "Ngày Bắt Đầu", "Ngày Kết Thúc", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tblVoucher);

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnCreateVoucher.setText("Tạo Voucher");
        btnCreateVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateVoucherActionPerformed(evt);
            }
        });

        jLabel16.setText("Mã Voucher");

        jLabel17.setText("Tiêu đề");

        jLabel18.setText("Giảm theo");

        buttonGroup1.add(rdoVnd);
        rdoVnd.setSelected(true);
        rdoVnd.setText("VND");

        buttonGroup1.add(rdoPercent);
        rdoPercent.setText("%");

        jLabel19.setText("Từ ngày");

        jLabel20.setText("Đến ngày");

        btnResetForm.setText("Reset");

        jLabel29.setText("Điều kiện ");

        buttonGroup2.add(rdoTotalBill);
        rdoTotalBill.setSelected(true);
        rdoTotalBill.setText("Tổng Hóa Đơn Trên ... Tiền ");

        buttonGroup2.add(rdoTotalProduct);
        rdoTotalProduct.setText("Tổng Sản Phẩm Đã Mua Trên ... Sản Phẩm");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnCreateVoucher)
                        .addGap(18, 18, 18)
                        .addComponent(btnResetForm)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addGap(30, 30, 30)
                                .addComponent(txtCondition))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel20))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(rdoTotalBill)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdoTotalProduct))
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addComponent(rdoVnd)
                                            .addGap(18, 18, 18)
                                            .addComponent(rdoPercent))
                                        .addComponent(txtTo, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                                        .addComponent(txtSince, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtVoucherValue)
                                        .addComponent(txtTitle)
                                        .addComponent(txtVoucherID)))))
                        .addContainerGap(77, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtVoucherID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtVoucherValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoVnd)
                    .addComponent(rdoPercent))
                .addGap(11, 11, 11)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txtCondition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoTotalBill)
                    .addComponent(rdoTotalProduct))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSince, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20)
                    .addComponent(txtTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreateVoucher)
                    .addComponent(btnResetForm))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        btnSearhVoucher.setText("Search");

        cbxTypeVoucher.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã Voucher", "Tiêu Đề", " " }));

        jLabel22.setText("Tìm theo");

        jLabel21.setText("Từ ngày");

        jLabel23.setText("Đến ngày");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(btnSearhVoucher)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtIdS)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxTypeVoucher, 0, 252, Short.MAX_VALUE)
                            .addComponent(txtSinceS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtToS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(txtIdS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxTypeVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(txtSinceS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(txtToS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(btnSearhVoucher))
        );

        javax.swing.GroupLayout voucher_panelLayout = new javax.swing.GroupLayout(voucher_panel);
        voucher_panel.setLayout(voucher_panelLayout);
        voucher_panelLayout.setHorizontalGroup(
            voucher_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(voucher_panelLayout.createSequentialGroup()
                .addGroup(voucher_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(voucher_panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(voucher_panelLayout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        voucher_panelLayout.setVerticalGroup(
            voucher_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(voucher_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(voucher_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        main_Panel.add(voucher_panel, "card4");

        jLabel12.setFont(new java.awt.Font("VNI-Viettay", 3, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("enndiii Shop");

        jLabel11.setFont(new java.awt.Font("VNI-Viettay", 3, 48)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("C");

        javax.swing.GroupLayout logoLayout = new javax.swing.GroupLayout(logo);
        logo.setLayout(logoLayout);
        logoLayout.setHorizontalGroup(
            logoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(0, 0, 0)
                .addComponent(jLabel12)
                .addGap(25, 25, 25))
        );
        logoLayout.setVerticalGroup(
            logoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logoLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(logoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11))
                .addGap(25, 25, 25))
        );

        menu_bar.setLayout(new java.awt.GridLayout(3, 1, 10, 20));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Sell");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        menu_bar.add(jLabel13);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Detailed Invoice");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        menu_bar.add(jLabel14);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Voucher");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        menu_bar.add(jLabel15);

        javax.swing.GroupLayout menu_Panel2Layout = new javax.swing.GroupLayout(menu_Panel2);
        menu_Panel2.setLayout(menu_Panel2Layout);
        menu_Panel2Layout.setHorizontalGroup(
            menu_Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu_Panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menu_Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menu_bar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        menu_Panel2Layout.setVerticalGroup(
            menu_Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu_Panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(menu_bar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(371, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menu_Panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(main_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 1076, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu_Panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(main_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductsMouseClicked
        if (viTriHoaDon == -1) {
            JOptionPane.showMessageDialog(this, "Chua chon hoa don de mua hang");
        } else {
            try {
                index = tblProducts.getSelectedRow();
                ctl.getProduct(Integer.parseInt(JOptionPane.showInputDialog("Nhap so luong mua")), index);
                txtTotal.setText(String.valueOf(ctl.total));
                fillDataCart();
                getData();
            } catch (HeadlessException | NumberFormatException e) {
            }
        }
    }//GEN-LAST:event_tblProductsMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        getData();
        btnPay.setEnabled(false);
        fillDataCart();
        ctl.getDataBill();
        fillDataBill(listHDChuaThanhToan);
        ctl.getDataVoucher();
        fillDataVoucher(listVoucher);
    }//GEN-LAST:event_formWindowOpened

    private void btnCreateBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateBillActionPerformed
        ctl.createBill();
        fillDataBill(listHDChuaThanhToan);
    }//GEN-LAST:event_btnCreateBillActionPerformed

    private void tblBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBillMouseClicked
        viTriHoaDon = tblBill.getSelectedRow();
        dtm = (DefaultTableModel) tblBill.getModel();
        String tt = String.valueOf(dtm.getValueAt(viTriHoaDon, 4));
        if (tt.equalsIgnoreCase("Chua Thanh Toan")) {
            if (listGioHang.isEmpty()) {
                HoaDon hd = listHDChuaThanhToan.get(viTriHoaDon);
                txtBillId.setText(hd.getMaHD());
                txtDateCreate.setText(hd.getNgayTao());
                txtStaffName.setText(hd.getTenNV());
                txtTotal.setText("");
            }
        }
    }//GEN-LAST:event_tblBillMouseClicked

    private void txtMoneyPayKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMoneyPayKeyReleased
        double totalMoney = Double.parseDouble(txtTotal.getText());
        // tinh tong tien
        if (txtMoneyPay.getText().isBlank()) {
            txtChange.setText("");
        } else if (Double.parseDouble(txtMoneyPay.getText()) < totalMoney) {
            txtChange.setText("");
        } else {
            double moneyPay = Double.parseDouble(txtMoneyPay.getText());
            txtChange.setText(String.valueOf(moneyPay - totalMoney));
        }

        // nút thanh toán được enable
        if (txtChange.getText().isEmpty()) {
            btnPay.setEnabled(false);
        } else {
            btnPay.setEnabled(true);
        }


    }//GEN-LAST:event_txtMoneyPayKeyReleased

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        viTriHoaDon = tblBill.getSelectedRow();
        HoaDon hd = listHDChuaThanhToan.get(viTriHoaDon);
        ctl.btnPay(hd, check, voucherID);
        ctl.saveData();
        fillDataBill(listHDChuaThanhToan);
        fillDataCart();
        viTriHoaDon = -1;
        check = 0;
        reset();
    }//GEN-LAST:event_btnPayActionPerformed

    private void btnCancelledBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelledBillActionPerformed
        if (viTriHoaDon != -1) {
            viTriHoaDon = tblBill.getSelectedRow();
            HoaDon hd = listHDChuaThanhToan.get(viTriHoaDon);
            ctl.cancelBill(hd);
            getData();
            reset();
            fillDataCart();
            fillDataBill(listHDChuaThanhToan);
        } else {
            JOptionPane.showMessageDialog(this, "Chua chon hoa don de huy");
        }

    }//GEN-LAST:event_btnCancelledBillActionPerformed

    private void btnUpdateProductInCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateProductInCartActionPerformed
        try {
            if (index != -1) {
                index = tblCart.getSelectedRow();
                int value = Integer.parseInt(JOptionPane.showInputDialog("Nhap so luong mua can thiet"));
                ctl.updateProduct(value, index);
                total = ctl.total;
                txtTotal.setText(String.valueOf(total));
                fillDataCart();
                getData();
            } else {
                JOptionPane.showMessageDialog(this, "Chua chon dong de sua");
            }
        } catch (HeadlessException | NumberFormatException e) {
        }
    }//GEN-LAST:event_btnUpdateProductInCartActionPerformed

    private void btnRemoveProductInCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveProductInCartActionPerformed
        try {
            if (index != -1) {
                index = tblCart.getSelectedRow();
                ctl.removeProduct(index);
                total = ctl.total;
                txtTotal.setText(String.valueOf(total));
                fillDataCart();
                getData();
            } else {
                JOptionPane.showMessageDialog(this, "Chua chon dong de xoa");
            }
        } catch (HeadlessException e) {
        }
    }//GEN-LAST:event_btnRemoveProductInCartActionPerformed

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        sell_panel.setVisible(true);
        voucher_panel.setVisible(false);
        Detail_Bill_Panel.setVisible(false);
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        sell_panel.setVisible(false);
        voucher_panel.setVisible(false);
        Detail_Bill_Panel.setVisible(true);

    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        voucher_panel.setVisible(true);
        sell_panel.setVisible(false);
        Detail_Bill_Panel.setVisible(false);
    }//GEN-LAST:event_jLabel15MouseClicked

    private void tblVoucher1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblVoucher1KeyTyped
        //        System.out.println(tblVoucher.getValueAt(0, 0));
    }//GEN-LAST:event_tblVoucher1KeyTyped

    private void btnCreateVoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateVoucherActionPerformed
        String dieuKien = "";
        if (rdoTotalBill.isSelected()) {
            dieuKien = "T" + txtCondition.getText();
        } else {
            dieuKien = "S" + txtCondition.getText();
        }
        ctl.createVoucher(txtVoucherID.getText(), txtTitle.getText(), Double.valueOf(txtVoucherValue.getText()), dieuKien, rdoVnd.isSelected() ? "VND" : "%", txtSince.getDate(), txtTo.getDate());
        fillDataVoucher(listVoucher);
    }//GEN-LAST:event_btnCreateVoucherActionPerformed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        if (viTriHoaDon == -1 || listGioHang.isEmpty() || txtChange.getText().isEmpty()) {
            btnPay.setEnabled(false);
        } else {
            btnPay.setEnabled(true);
        }

        // ô tiền khách trả và sửa xóa sp được bật
        if (listGioHang.isEmpty()) {
            txtMoneyPay.setEnabled(false);
            btnRemoveProductInCart.setEnabled(false);
            btnUpdateProductInCart.setEnabled(false);
        } else {
            txtMoneyPay.setEnabled(true);
            btnRemoveProductInCart.setEnabled(true);
            btnUpdateProductInCart.setEnabled(true);
        }
    }//GEN-LAST:event_formMouseMoved

    private void tblVoucher1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVoucher1MouseClicked

        if (!txtTotal.getText().isBlank()) {
            Double getTien;
            chooseVoucher = tblVoucher1.getSelectedRow();
            if (chooseVoucher != -1) {
                Voucher v = listVoucher.get(chooseVoucher);
                if (v.getDieuKien().contains("T")) {
                    getTien = Double.valueOf(v.getDieuKien().substring(1));
                    if (ctl.total > getTien) {
                        if (v.getLoai().equals("%")) {
                            ctl.total -= ctl.total * v.getGiaTri() / 100;
                            txtTotal.setText("" + ctl.total);
                            voucherID = v.getId();
                            check = 1;
                        } else {
                            ctl.total -= v.getGiaTri();
                            txtTotal.setText("" + ctl.total);
                            voucherID = v.getId();
                            check = 1;
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Chua du dieu kien de dung voucher nay !");
                    }
                }
                if (v.getDieuKien().contains("S")) {
                    getTien = Double.valueOf(v.getDieuKien().substring(1));
                    int soLuongSp = 0;
                    for (GioHang gh : listGioHang) {
                        soLuongSp += gh.getSoLuong();
                    }
                    if (soLuongSp > getTien) {
                        if (ctl.total > getTien) {
                            if (v.getLoai().equals("%")) {
                                ctl.total -= ctl.total * v.getGiaTri() / 100;
                                txtTotal.setText("" + ctl.total);
                                voucherID = v.getId();
                                check = 1;
                            } else {
                                ctl.total -= v.getGiaTri();
                                txtTotal.setText("" + ctl.total);
                                voucherID = v.getId();
                                check = 1;
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Chua du dieu kien de dung voucher nay !");
                    }
                }
            }

        } else {
            JOptionPane.showMessageDialog(this, "Ban chua mua gi");
        }
    }//GEN-LAST:event_tblVoucher1MouseClicked

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BanHangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new BanHangView().setVisible(true);
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Detail_Bill_Panel;
    private javax.swing.JButton btnCancelledBill;
    private javax.swing.JButton btnCreateBill;
    private javax.swing.JButton btnCreateVoucher;
    private javax.swing.JButton btnPay;
    private javax.swing.JButton btnRemoveProductInCart;
    private javax.swing.JButton btnResetForm;
    private javax.swing.JButton btnSearhVoucher;
    private javax.swing.JButton btnUpdateProductInCart;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbxTypeVoucher;
    private view.FormHoaDon formHoaDon2;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JLabel lblReduce;
    private javax.swing.JPanel logo;
    private javax.swing.JPanel main_Panel;
    private view.menu_Panel menu_Panel2;
    private javax.swing.JPanel menu_bar;
    private javax.swing.JRadioButton rdoPercent;
    private javax.swing.JRadioButton rdoTotalBill;
    private javax.swing.JRadioButton rdoTotalProduct;
    private javax.swing.JRadioButton rdoVnd;
    private javax.swing.JPanel sell_panel;
    private javax.swing.JTable tblBill;
    private javax.swing.JTable tblCart;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTable tblVoucher;
    private javax.swing.JTable tblVoucher1;
    private javax.swing.JTextField txtBillId;
    private javax.swing.JTextField txtChange;
    private javax.swing.JTextField txtCondition;
    private javax.swing.JTextField txtDateCreate;
    private javax.swing.JTextField txtIdS;
    private javax.swing.JTextField txtMoneyPay;
    private com.toedter.calendar.JDateChooser txtSince;
    private com.toedter.calendar.JDateChooser txtSinceS;
    private javax.swing.JTextField txtStaffName;
    private javax.swing.JTextField txtTitle;
    private com.toedter.calendar.JDateChooser txtTo;
    private com.toedter.calendar.JDateChooser txtToS;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtVoucherID;
    private javax.swing.JTextField txtVoucherValue;
    private javax.swing.JPanel voucher_panel;
    // End of variables declaration//GEN-END:variables
}
