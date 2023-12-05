/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import controler.controler;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.GioHang;
import model.HoaDon;

/**
 *
 * @author Admin
 */
public class FormHoaDon extends javax.swing.JPanel {

    /**
     * Creates new form FormHoaDon
     */
    public FormHoaDon() {
        initComponents();
        ctl.getDataBill();
        fillDataBill(listAll);
    }
    private DefaultTableModel dtm;
    private final controler ctl = new controler();
    private final List<HoaDon> listDaTT = ctl.listHDDaThanhToan;
    private final List<HoaDon> listHuy = ctl.listHDHuy;
    private final List<HoaDon> listAll = ctl.listAll;
    private final List<GioHang> listGh = ctl.listGioHang;
    List<HoaDon> listSearch = ctl.listSearch;
   
    private void fillDataBill(List<HoaDon> list) {
        dtm = (DefaultTableModel) tblBillForm.getModel();
        dtm.setRowCount(0);

        for (HoaDon hd : list) {
            dtm.addRow(new Object[]{hd.getId(), hd.getMaHD(), hd.getNgayTao(), hd.getTenNV(), hd.getTinhTrang()});
        }
    }

    private void fillDataDetailedInvoice() {
        dtm = (DefaultTableModel) tblDetailedInvoice.getModel();
        dtm.setRowCount(0);

        for (GioHang gh : listGh) {
            dtm.addRow(new Object[]{gh.getId(), gh.getMaSp(), gh.getTenSp(), gh.getSoLuong(), gh.getDonGia(), gh.getThanhTien()});
        }
    }
    
    public void fill(){
        ctl.getDataBill();
        fillDataBill(listAll);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        txtSearchBox = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBillForm = new javax.swing.JTable();
        rdoAll = new javax.swing.JRadioButton();
        rdoCancelled = new javax.swing.JRadioButton();
        rdoPaid = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbxType = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtTo = new com.toedter.calendar.JDateChooser();
        txtSince = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDetailedInvoice = new javax.swing.JTable();

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        txtSearchBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchBoxKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchBoxKeyTyped(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa Đơn", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        tblBillForm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Hóa Đơn", "Ngày Tạo", "Tên Nhân Viên", "Tình Trạng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBillForm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBillFormMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBillForm);

        buttonGroup1.add(rdoAll);
        rdoAll.setSelected(true);
        rdoAll.setText("Tất cả");
        rdoAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoAllMouseClicked(evt);
            }
        });

        buttonGroup1.add(rdoCancelled);
        rdoCancelled.setText("Đã hủy");
        rdoCancelled.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoCancelledMouseClicked(evt);
            }
        });

        buttonGroup1.add(rdoPaid);
        rdoPaid.setText("Đã thanh toán");
        rdoPaid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoPaidMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rdoAll)
                        .addGap(60, 60, 60)
                        .addComponent(rdoCancelled)
                        .addGap(57, 57, 57)
                        .addComponent(rdoPaid, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoAll)
                    .addComponent(rdoCancelled)
                    .addComponent(rdoPaid))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Từ Ngày:");

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Đến:");

        cbxType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã Hóa Đơn", "Tên", "Số Điện Thoại", "Tình Trạng" }));

        jLabel3.setText("Tìm Theo:");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa Đơn Chi Tiết", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        tblDetailedInvoice.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tblDetailedInvoice);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtSearchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(cbxType, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(35, 35, 35)
                                .addComponent(txtTo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSince, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(60, 60, 60)
                        .addComponent(jButton1))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(61, 61, 61))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(txtSince, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtSearchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1)))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2))
                            .addComponent(txtTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchBoxKeyReleased
        listSearch.clear();
        if (txtSearchBox.getText().equalsIgnoreCase("")) {
            rdoAllMouseClicked(null);
        } else {
            for (HoaDon hd : listAll) {
                ctl.CbxIndex(cbxType.getSelectedIndex(), hd, txtSearchBox.getText());
                fillDataBill(listSearch);
            }
        }
    }//GEN-LAST:event_txtSearchBoxKeyReleased

    private void txtSearchBoxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchBoxKeyTyped

    }//GEN-LAST:event_txtSearchBoxKeyTyped

    private void tblBillFormMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBillFormMouseClicked
        int index = tblBillForm.getSelectedRow();
        dtm = (DefaultTableModel) tblBillForm.getModel();
        String tt = String.valueOf(dtm.getValueAt(index, 4));
        int id = (int) dtm.getValueAt(index, 0);
        if (tt.equalsIgnoreCase("Da Thanh Toan")) {
            for (HoaDon hddtt : listDaTT) {
                if (hddtt.getId() == id) {
                    ctl.detailedInvoice(id);
                }
            }
            fillDataDetailedInvoice();
        } else {
            dtm = (DefaultTableModel) tblDetailedInvoice.getModel();
            dtm.setRowCount(0);
            JOptionPane.showMessageDialog(this, "Hoa don da bi huy");
        }
    }//GEN-LAST:event_tblBillFormMouseClicked

    private void rdoAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoAllMouseClicked
        ctl.getDataBill();
        fillDataBill(listAll);
    }//GEN-LAST:event_rdoAllMouseClicked

    private void rdoCancelledMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoCancelledMouseClicked
        ctl.getDataBill();
        fillDataBill(listHuy);
    }//GEN-LAST:event_rdoCancelledMouseClicked

    private void rdoPaidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoPaidMouseClicked
        ctl.getDataBill();
        fillDataBill(listDaTT);
    }//GEN-LAST:event_rdoPaidMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss ");
        listSearch.clear();

        if (txtSince.getDate() == null && txtTo.getDate() == null && txtSearchBox.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Chua nhap du lieu de tim kiem");
        } else if (txtSince.getDate() == null || txtTo.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Nhap 2 ngay hoac khong nhap ngay nao");
        } else {
            if (!txtSearchBox.getText().isBlank() && (txtSince.getDate() == null && txtTo.getDate() == null)) {
                for (HoaDon hd : listAll) {
                    ctl.CbxIndex(cbxType.getSelectedIndex(), hd, txtSearchBox.getText());
                    fillDataBill(listSearch);
                }
            } else {
                Date firstDay = txtSince.getDate();
                Date lastDay = txtTo.getDate();
                Calendar f = Calendar.getInstance();
                f.setTime(firstDay);
                f.add(Calendar.DATE, -1);
                firstDay = f.getTime();

                Calendar l = Calendar.getInstance();
                l.setTime(lastDay);
                l.add(Calendar.DATE, 1);
                lastDay = l.getTime();
                try {
                    ctl.search(firstDay, lastDay, txtSearchBox.getText(), cbxType.getSelectedIndex());
                } catch (ParseException e) {
                }
                fillDataBill(listSearch);
            }

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved

    }//GEN-LAST:event_formMouseMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxType;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JRadioButton rdoAll;
    private javax.swing.JRadioButton rdoCancelled;
    private javax.swing.JRadioButton rdoPaid;
    private javax.swing.JTable tblBillForm;
    private javax.swing.JTable tblDetailedInvoice;
    private javax.swing.JTextField txtSearchBox;
    private com.toedter.calendar.JDateChooser txtSince;
    private com.toedter.calendar.JDateChooser txtTo;
    // End of variables declaration//GEN-END:variables
}
