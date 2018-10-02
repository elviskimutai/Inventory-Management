/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import geniusapp.Constants;
import geniusapp.Security;
import geniusapp.SqlConnection;
import geniusapp.SupplierInvoice;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eng.Joseph Gitahi
 */
public class InvoiceMatching extends javax.swing.JDialog {

     static SqlConnection _SqlConnection =new SqlConnection();
     Connection con=_SqlConnection.connect();
     Constants _Constants=new Constants();
      DefaultTableModel model = new DefaultTableModel(new String[]{ "Invoice No", "Supplier","SupplierNames","PONumber","InvoiceDate","Item","ItemDesc","Qty","UnitCost","ExtendedCost","Remarks"}, 0);
  
    public InvoiceMatching() {
        initComponents();
       
        fillSupliers();
         setModal(true);
        setLocationRelativeTo(null);
        inventoryReceipt.setModel(model);
        inventoryReceipt.getTableHeader().setReorderingAllowed(false);
        jTextFieldDoCNo.setEditable(false); 
       // LoadSupliersInvoices();
    }
    public void LoadSupliersInvoices(){
        try {
            model.setRowCount(0);
           Statement pst=con.createStatement();
            ResultSet rs= pst.executeQuery("{call SelectAllSupplierInvoices}");
            while(rs.next()){
                String SuppCode=rs.getNString("DocNo");
                String Suppliernames=rs.getNString("Supplier");
                String PostalAdress=rs.getNString("PONumber");
                Date PhysicalAdress=rs.getDate("InvoiceDate");
                String Mobile=rs.getNString("Qty");
                
                String Email=rs.getNString("UnitCost");
                
                String Telephone=rs.getNString("ExtendedCost");
                
                String Fax=rs.getNString("Remarks");
                 
                
                model.addRow(new Object[]{SuppCode, Suppliernames,PostalAdress,PhysicalAdress,Mobile,Email,Telephone,Fax});
                              
            }
          
            rs.close();
            pst.close();
            
           // UsersTable.setModel(DbUtils.resultSetToTableModel(rs));
      
        } catch (Exception e) {
              Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Load fields Suppliers");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
             
        }
    }
  public void GenerateINVONO(){
    try {
           //Statement pst=con.createStatement();
           // ResultSet rs= pst.executeQuery("{call GenerateINVOICENO}");
               String   PO1=jComPO.getSelectedItem().toString();
                String[] parts = PO1.split("/");
                String PO = parts[0];
            PreparedStatement pst=con.prepareStatement("{call GenerateINVOICENO(?)}");
            pst.setString(1, PO);
             
            ResultSet rs=pst.executeQuery();
          
             while(rs.next()){
                  String id = rs.getString("DOCCode");
          jTextFieldDoCNo.setText(id);
                 
            }
         
        rs.close();
     pst.close();
            
         
      
        } catch (Exception e) {
            Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Initializing Generating invoice no");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
        }
}
    public void LoadPO(String PO){
        try {
         
      
            PreparedStatement pst=con.prepareStatement("{call SelectPurchaseOrders(?,?,?)}");
            pst.setString(1, PO);
             pst.setString(2, _Constants.getUserId());
              pst.setString(3, _Constants.getRegSource());
            ResultSet rs=pst.executeQuery();
            
            while(rs.next()){
         String Invoice=jTextFieldDoCNo.getText();
         String Supplier=rs.getNString("SuppCode");
         String SupplierNames=rs.getNString("suppFullnames");
         String PONumber=rs.getNString("POCode");
          Date InvoiceDate =new Date(dptduedate.getDate().getTime());
           String Remarks=jTextFieldRemarks.getText(); 
                String Item=rs.getNString("Item");
                String ItemDesc=rs.getNString("ItemDesc");
                Float Qty=rs.getFloat("Qty");
                Float UnitCost=rs.getFloat("UnitCost");
                Float LineTotal=rs.getFloat("LineTotal");
                
                model.addRow(new Object[]{Invoice, Supplier,SupplierNames,PONumber,InvoiceDate,Item,ItemDesc,Qty,UnitCost,LineTotal,Remarks});
                              
            }
          
            rs.close();
            pst.close();
            
           // UsersTable.setModel(DbUtils.resultSetToTableModel(rs));
      
        } catch (Exception e) {
              Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Load fields Suppliers");
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        inventoryReceipt = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jComPO = new javax.swing.JComboBox();
        TransDate1 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jComSupliers1 = new javax.swing.JComboBox();
        jTextFieldRemarks = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldDOCType = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldDoCNo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        dptduedate = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldPaymentsterms = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButtonEdit = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("INVOICE MATCHING");

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
        jPanel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel11.setText("PURCHASE ORDER");

        jLabel13.setText("SELECT SUPPLIER");

        jComPO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComPOActionPerformed(evt);
            }
        });

        jLabel5.setText("INVOICE DUE DATE");

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

        jLabel1.setText("REMARKS");

        jLabel2.setText("DOC TYPE");

        jTextFieldDOCType.setText("SINV");
        jTextFieldDOCType.setEnabled(false);

        jLabel3.setText("INVOICE NO");

        jTextFieldDoCNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDoCNoActionPerformed(evt);
            }
        });

        jLabel6.setText("INVOICE DATE");

        jLabel4.setText("PAYMENT TERMS");

        jTextFieldPaymentsterms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPaymentstermsActionPerformed(evt);
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
                        .addComponent(jComSupliers1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldDoCNo)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(dptduedate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                        .addComponent(jTextFieldPaymentsterms)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TransDate1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addComponent(jTextFieldRemarks)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldDOCType)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComPO, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel13))
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TransDate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComSupliers1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(0, 0, 0)
                        .addComponent(jTextFieldDOCType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldRemarks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel6)
                        .addGap(12, 12, 12)
                        .addComponent(dptduedate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldDoCNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPaymentsterms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComPO, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
        jButtonDelete.setText("Remove");
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 261, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inventoryReceiptKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inventoryReceiptKeyPressed
        try {
   int row = inventoryReceipt.getSelectedRow();
            Double QTy=Double.parseDouble(inventoryReceipt.getModel().getValueAt(row, 7).toString());
            Double UnitCost=Double.parseDouble(inventoryReceipt.getModel().getValueAt(row, 8).toString());
            Double TotalCost=QTy*UnitCost;
            String s=TotalCost.toString();
            model.setValueAt(s, row, 9);

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

    private void jComPOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComPOActionPerformed
        // TODO add your handling code here:
        try {

            // String   Item=jComItems.getSelectedItem().toString();
            String   Supplier=jComPO.getSelectedItem().toString();
            String[] parts = Supplier.split("/");
            String Item = parts[0];
            model.setRowCount(0);
            LoadPO(Item);
             GenerateINVONO();
        } catch (Exception e) {
            Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Initializing PO");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
        }
    }//GEN-LAST:event_jComPOActionPerformed

    private void jComSupliers1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComSupliers1ActionPerformed
        try {
            jComPO.removeAll();
            // String   Item=jComItems.getSelectedItem().toString();
            String   Supplier=jComSupliers1.getSelectedItem().toString();
            String[] parts = Supplier.split("/");
            String Item = parts[0];
            PreparedStatement pst=con.prepareStatement("{call SelectPurchaseOrdersCombo(?)}");
            pst.setString(1, Item);
            ResultSet rs=pst.executeQuery();
            jComPO.removeAllItems();
            jComPO.addItem("Select Purchase order");
            while(rs.next()){
                // JOptionPane.showMessageDialog(null,rs.getNString("UserName"));
                String id = rs.getString("POCode");
                String nme = rs.getString("FullNames");

                String cmb = (id+ "  /  "+nme);

                //Items.add(1, new ItemCombo(rs.getString("ItemName"),rs.getString("ItemName")));
                jComPO.addItem(cmb);
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
        try {
        
        int row = inventoryReceipt.getSelectedRow();
        model.removeRow(row);
    } catch (Exception e) {
        Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Selecting Supplier");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
    }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        try {

            int rows=inventoryReceipt.getRowCount();
            for(int row = 0; row<rows; row++)
            {
                String   PO1=jComPO.getSelectedItem().toString();
                String[] parts = PO1.split("/");
                String PO = parts[0];

                 String   Supplier1=jComSupliers1.getSelectedItem().toString();
                String[] parts1 = Supplier1.split("/");
                String Supp = parts1[0];
                String Remarks=jTextFieldRemarks.getText(); 
                String Status="Invoiced"; 
                String ItemCode=(String)inventoryReceipt.getValueAt(row, 5);
                String DocNo=jTextFieldDoCNo.getText();
                String DocType=jTextFieldDOCType.getText();
                String Supplier=Supp; 
                String Ledger="Invoices";
                String PONumber=PO;
                String InvoiceNo=jTextFieldDoCNo.getText();
                String PaymentTerms=jTextFieldPaymentsterms.getText();
                Date InvoiceDate =new Date(dptduedate.getDate().getTime());
                Date DueDate=new Date(TransDate1.getDate().getTime());
                float Qty=Float.parseFloat(String.valueOf(inventoryReceipt.getValueAt(row, 7)));
                Double UnitCost=Double.parseDouble(String.valueOf(inventoryReceipt.getValueAt(row, 8)));
                Double ExtendedCost=Double.parseDouble(String.valueOf(inventoryReceipt.getValueAt(row, 9)));
                
                SupplierInvoice _SupplierInvoice=new SupplierInvoice( Remarks,  Status,  ItemCode,  DocNo,  DocType,  Supplier,  Ledger,  PONumber,  InvoiceNo,  PaymentTerms,  InvoiceDate,  DueDate,  Qty,  UnitCost,  ExtendedCost);
                _SupplierInvoice.SaveSupplierInvoices();
            }
            JOptionPane.showMessageDialog(null,"Supplier Invoice Saved Successfully");
            LoadSupliersInvoices();
        } catch (Exception e) {
            e.printStackTrace();
            Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Initializing Suppliers");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
        }
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jTextFieldPaymentstermsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPaymentstermsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPaymentstermsActionPerformed

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
            java.util.logging.Logger.getLogger(InvoiceMatching.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InvoiceMatching.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InvoiceMatching.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InvoiceMatching.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InvoiceMatching().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser TransDate1;
    private com.toedter.calendar.JDateChooser dptduedate;
    public javax.swing.JTable inventoryReceipt;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JComboBox jComPO;
    private javax.swing.JComboBox jComSupliers1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextFieldDOCType;
    private javax.swing.JTextField jTextFieldDoCNo;
    private javax.swing.JTextField jTextFieldPaymentsterms;
    private javax.swing.JTextField jTextFieldRemarks;
    // End of variables declaration//GEN-END:variables
}
