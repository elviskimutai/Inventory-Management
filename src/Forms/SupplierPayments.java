/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import geniusapp.Constants;
import geniusapp.Security;
import geniusapp.SqlConnection;
import geniusapp.Supplier;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eng.Joseph Gitahi
 */
public class SupplierPayments extends javax.swing.JDialog {

    /**
     * Creates new form SupplierPayments
     */
    public SupplierPayments() {
        initComponents();
        fillSupliers();
        addPaymodes();
          setModal(true);
        setLocationRelativeTo(null);
        inventoryReceipt.setModel(model);
        inventoryReceipt.getTableHeader().setReorderingAllowed(false);
        jTextFieldDoCNo.setEditable(false); 
    }
public void addPaymodes(){
    jComPayMode.addItem("Cash at Hand");
    jComPayMode.addItem("Mpesa");
    jComPayMode.addItem("Bank");
}
    static SqlConnection _SqlConnection =new SqlConnection();
     Connection con=_SqlConnection.connect();
     Constants _Constants=new Constants();
      DefaultTableModel model = new DefaultTableModel(new String[]{ "Item", "ItemName","Quantity","UnitCost","TotalCost"}, 0);
   public void GeneratePAYCNO(){
    try {
        jTextFieldDoCNo.setText(null);
           Statement pst=con.createStatement();
            ResultSet rs= pst.executeQuery("{call GeneratePayNO}");
           
          
             while(rs.next()){
                  String id = rs.getString("DOCCode");
          jTextFieldDoCNo.setText(id);
                 
            }
         
        rs.close();
     pst.close();
            
         
      
        } catch (Exception e) {
            Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Initializing Suppliers");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
        }
}
public void fillSupliers(){
    try {
           Statement pst=con.createStatement();
            ResultSet rs= pst.executeQuery("{call SelectAllSuppliers}");
          
           jComSupliers1.addItem("SuppCode   /  Suppliernames");
             while(rs.next()){
                  String id = rs.getString("SuppCode");
            String nme = rs.getString("Suppliernames");
            String cmb = (id+ "  /  "+nme);
                
                 //Items.add(1, new ItemCombo(rs.getString("ItemName"),rs.getString("ItemName")));
                jComSupliers1.addItem(cmb);    
                 
            }
         
        rs.close();
     pst.close();
            
         
      
        } catch (Exception e) {
            Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Initializing Suppliers");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
        }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        inventoryReceipt = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jCominvoices = new javax.swing.JComboBox();
        TransDate1 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jComSupliers1 = new javax.swing.JComboBox();
        jTextFieldRemarks = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldDOCType = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldDoCNo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jComPayMode = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        AMNTPaid = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldInvoiceamnt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldbalance = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldAMNT = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButtonEdit = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SUPPLIER PAYMENTS");

        inventoryReceipt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        inventoryReceipt.setFont(new java.awt.Font("Californian FB", 0, 14)); // NOI18N
        inventoryReceipt.setModel(new javax.swing.table.DefaultTableModel(
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
        inventoryReceipt.setGridColor(new java.awt.Color(204, 255, 255));
        inventoryReceipt.setRowHeight(25);
        inventoryReceipt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inventoryReceiptKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(inventoryReceipt);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Receive items"));
        jPanel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel11.setText("OPEN INVOICES");

        jLabel13.setText("Select Suplier");

        jCominvoices.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCominvoices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCominvoicesActionPerformed(evt);
            }
        });

        TransDate1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setText("PAYMENT DATE");

        jComSupliers1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComSupliers1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComSupliers1ActionPerformed(evt);
            }
        });

        jTextFieldRemarks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRemarksActionPerformed(evt);
            }
        });

        jLabel1.setText("Remarks");

        jLabel2.setText("DOC Type");

        jTextFieldDOCType.setEditable(false);
        jTextFieldDOCType.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldDOCType.setForeground(new java.awt.Color(0, 0, 255));
        jTextFieldDOCType.setText("PYT");

        jLabel3.setText("PAYMENT CODE");

        jTextFieldDoCNo.setForeground(new java.awt.Color(0, 0, 255));
        jTextFieldDoCNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDoCNoActionPerformed(evt);
            }
        });

        jLabel12.setText("PAYMENT MODE");

        jComPayMode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComPayMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComPayModeActionPerformed(evt);
            }
        });

        jLabel4.setText("AMOUNT PAID");

        AMNTPaid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AMNTPaid.setForeground(new java.awt.Color(255, 51, 51));
        AMNTPaid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AMNTPaidActionPerformed(evt);
            }
        });

        jLabel6.setText("INVOICE AMOUNT");

        jTextFieldInvoiceamnt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldInvoiceamnt.setForeground(new java.awt.Color(255, 51, 51));
        jTextFieldInvoiceamnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldInvoiceamntActionPerformed(evt);
            }
        });

        jLabel7.setText("BALANCE");

        jTextFieldbalance.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldbalance.setForeground(new java.awt.Color(255, 51, 51));
        jTextFieldbalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldbalanceActionPerformed(evt);
            }
        });

        jLabel8.setText("AMOUNT");

        jTextFieldAMNT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldAMNT.setForeground(new java.awt.Color(255, 51, 51));
        jTextFieldAMNT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAMNTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComSupliers1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComPayMode, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldAMNT, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldInvoiceamnt, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AMNTPaid))
                    .addComponent(jTextFieldbalance, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(182, 182, 182)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCominvoices, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TransDate1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                    .addComponent(jTextFieldDoCNo)
                    .addComponent(jTextFieldRemarks)
                    .addComponent(jTextFieldDOCType))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(12, 12, 12)
                        .addComponent(TransDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCominvoices, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldDOCType)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldRemarks, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComSupliers1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComPayMode, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldInvoiceamnt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addGap(3, 3, 3)
                        .addComponent(jTextFieldAMNT, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(AMNTPaid, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jTextFieldDoCNo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldbalance, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Search_35px.png"))); // NOI18N

        jButtonEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Compose_35px.png"))); // NOI18N
        jButtonEdit.setText("Edit");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });

        jButtonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Trash_Can_35px.png"))); // NOI18N
        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Data_Recovery_35px.png"))); // NOI18N
        jButtonSave.setText("Save");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 690, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonEdit)
                        .addComponent(jButtonDelete)
                        .addComponent(jButtonSave)))
                .addGap(708, 708, 708))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inventoryReceiptKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inventoryReceiptKeyPressed
        try {
            int columnTotal = 4;

            int row = inventoryReceipt.getSelectedRow();
            Double QTy=Double.parseDouble(inventoryReceipt.getModel().getValueAt(row, 2).toString());
            Double UnitCost=Double.parseDouble(inventoryReceipt.getModel().getValueAt(row, 3).toString());
            Double TotalCost=QTy*UnitCost;
            String s=TotalCost.toString();
            model.setValueAt(s, row, columnTotal);

            // POReTable.getModel().getValueAt(row_index, col_index);
        } catch (Exception e) {
            Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Selecting Supplier");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
        }
    }//GEN-LAST:event_inventoryReceiptKeyPressed

    private void jCominvoicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCominvoicesActionPerformed
        // TODO add your handling code here:
        try {
            GeneratePAYCNO();
            // String   Item=jComItems.getSelectedItem().toString();
            String   invoice=jCominvoices.getSelectedItem().toString();
            String[] parts = invoice.split("/");
            String inv = parts[0];
            
             String invamnt = parts[1];
             String amntpaid = parts[2];
              String bal = parts[3];
               String invdate = parts[4];
           AMNTPaid.setText(amntpaid);
           jTextFieldInvoiceamnt.setText(invamnt);
           jTextFieldbalance.setText(bal);
           AMNTPaid.setEditable(false); 
           jTextFieldInvoiceamnt.setEditable(false);
           jTextFieldbalance.setEditable(false);
        } catch (Exception e) {
            Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Initializing PO");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
        }
    }//GEN-LAST:event_jCominvoicesActionPerformed

    private void jComSupliers1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComSupliers1ActionPerformed
        try {

            // String   Item=jComItems.getSelectedItem().toString();
            String   Supplier=jComSupliers1.getSelectedItem().toString();
            String[] parts = Supplier.split("/");
            String Item = parts[0];
            PreparedStatement pst=con.prepareStatement("{call spGetSupplierOpenInvoices(?)}");
            pst.setString(1, Item);
            ResultSet rs=pst.executeQuery();
            jCominvoices.removeAllItems();
            jCominvoices.addItem("Select Invoice(Invoice / Invoice Amount / AmountPaid / Balance / InvoiceDate)");
            while(rs.next()){
                // JOptionPane.showMessageDialog(null,rs.getNString("UserName"));
                String id = rs.getString("InvoiceNo");
                Double invoiceAmt = rs.getDouble("InvoiceAmount");
                Double amntpaid = rs.getDouble("AmountPaid");
                Date invdate = rs.getDate("InvoiceDate");
                Double bal = rs.getDouble("OpenAmount");

                String cmb = (id+ "  /  "+invoiceAmt+"/"+amntpaid+"/"+bal+"/"+invdate);

                //Items.add(1, new ItemCombo(rs.getString("ItemName"),rs.getString("ItemName")));
                jCominvoices.addItem(cmb);
            }

            rs.close();
            pst.close();
        } catch (Exception e) {
            Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Initializing PO");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
        }
    }//GEN-LAST:event_jComSupliers1ActionPerformed

    private void jTextFieldRemarksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldRemarksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldRemarksActionPerformed

    private void jTextFieldDoCNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDoCNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDoCNoActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        // TODO add your handling code here:
        //EnableFields();
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
        try {

            //            Supplier _Supplier=new Supplier();
            //            _Supplier.setSuppCode(SuppCode);
            //            if(_Supplier.DeleteSupplier()){
                //                JOptionPane.showMessageDialog(null,"Supplier Deleted Successfully");
                //                LoadSupliers();
                //  }
        } catch (Exception e) {
            Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Deleting Items");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        try {
  
                 String   Supplier=jComSupliers1.getSelectedItem().toString();
                 String[] parts = Supplier.split("/");
                String Supp = parts[0];
                
                  String   invoice=jCominvoices.getSelectedItem().toString();
                String[] parts2 = invoice.split("/");
                String inv = parts2[0];
            
             Double invamnt = Double.parseDouble(String.valueOf(parts2[1]));
             Double amntpaid = Double.parseDouble(String.valueOf(parts2[2]));
              String bal = parts2[3];
               Date invdate = Date.valueOf(parts2[4]);


                Double Amount=Double.parseDouble(String.valueOf(jTextFieldAMNT.getText()));

                Supplier _Supplier=new Supplier();
                   _Supplier.setDocNo(jTextFieldDoCNo.getText());
                    _Supplier.setDocType(jTextFieldDOCType.getText());
                    _Supplier.setSuppCode(Supp);
                    _Supplier.setInvoiceNumber(inv);
                    _Supplier.setInvoiceAmount(invamnt);
                    _Supplier.setInvoiceDate(invdate);
                    _Supplier.setAmount(Amount);
                    _Supplier.setBatchNo(jTextFieldDoCNo.getText());
                    _Supplier.setRefNo(jTextFieldDoCNo.getText());
                    _Supplier.setPayMode(jComPayMode.getSelectedItem().toString());
                     _Supplier.setBankAccount("0");
                  _Supplier.setRemarks(jTextFieldRemarks.getText());
                  _Supplier.setPaymentStatus("Paid");
               _Supplier.SaveSupplierPayment();
           
            JOptionPane.showMessageDialog(null,"Supplier Payment Saved Successfully");
            model.setRowCount(0);
        } catch (Exception e) {
            e.printStackTrace();
            Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Initializing Suppliers payments ");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
        }
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jComPayModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComPayModeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComPayModeActionPerformed

    private void AMNTPaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AMNTPaidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AMNTPaidActionPerformed

    private void jTextFieldInvoiceamntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldInvoiceamntActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldInvoiceamntActionPerformed

    private void jTextFieldbalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldbalanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldbalanceActionPerformed

    private void jTextFieldAMNTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAMNTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAMNTActionPerformed

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
            java.util.logging.Logger.getLogger(SupplierPayments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SupplierPayments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SupplierPayments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SupplierPayments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SupplierPayments().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AMNTPaid;
    private com.toedter.calendar.JDateChooser TransDate1;
    public javax.swing.JTable inventoryReceipt;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JComboBox jComPayMode;
    private javax.swing.JComboBox jComSupliers1;
    private javax.swing.JComboBox jCominvoices;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextFieldAMNT;
    private javax.swing.JTextField jTextFieldDOCType;
    private javax.swing.JTextField jTextFieldDoCNo;
    private javax.swing.JTextField jTextFieldInvoiceamnt;
    private javax.swing.JTextField jTextFieldRemarks;
    private javax.swing.JTextField jTextFieldbalance;
    // End of variables declaration//GEN-END:variables
}
